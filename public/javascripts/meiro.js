//ソケットで迷路のマップデータを取得しaryへ代入後init()処理を実行
//あるいは、ソケットで動いた方向を送信、各種移動関数を実行して反映させる。
// Create a socket
var WS = window['MozWebSocket'] ? MozWebSocket : WebSocket;
//var socket = new WS('@@{WebSocket.sendms()}')
//要書き換え必要、サーバー側だと動かない可能性
var socket = new WS('ws://localhost:9000/twi_st')
socket.onmessage = function(event) {
    console.log(event);
    console.log(event);
    if(event.btn = 'up')move_up();
    else if(event.btn = 'down')down_up();
    else if(event.btn = 'left')left_up();
    else if(event.btn = 'right')right_up();
    else if(event.map){
        ary = event.map;
        init();
    }
}
var ary = [
    [1, 0, 1, 0, 1], //1が黒、0が白
    [0, 2, 0, 0, 0], //2はプレーヤ
    [1, 0, 1, 0, 1],
];


var loop = function () {
    setTimeout(function () {
      socket.send("update");
        loop();
    }, 500);
}

//function posting() {
//    jQuery.ajax(
//            "/map_st", {
//                type: "WS",
//                dataType: 'text',
//                data: {
//                    "update": "update",
//                },
//                success: function (post) {
//                    ary = post.map;
//                    init();
//                }
//            }
//            );
//
//    console.log("post");
//}

loop();

var position = [1, 1];

function init() {
    var map = document.getElementById('map');

    map.innerHTML = "";
    for (var i = 0; i < ary.length; i++) {

        for (var j = 0; j < ary[i].length; j++) {
            block = document.createElement('div');

            if (ary[i][j] == 1) {
                var black = document.createElement('div');
                black.className = 'block black';
                map.appendChild(black);
            } else if (ary[i][j] == 0) {
                var white = document.createElement('div');
                white.className = 'block white';
                map.appendChild(white);
            } else if (ary[i][j] == 2) {
                var character = document.createElement('img');
                character.className = "block";
                character.src = '../../../public/images/human.png';
                map.appendChild(character);
            } else {
                alert("blockError");
            }

        }
        var rn = document.createElement('div');
        rn.className = 'clr';
        map.appendChild(rn);
    }
}

function test() {
    alert();
}

function move_up() {
    if ((ary[position[0] - 1][position[1]]) == 0) {
        ary[position[0]][position[1]] = 0;
        ary[position[0] - 1][position[1]] = 2;
        position = [position[0] - 1, position[1]];
    }
    init();
}

function move_down() {
    if ((ary[position[0] + 1][position[1]]) == 0) {
        ary[position[0]][position[1]] = 0;
        ary[position[0] + 1][position[1]] = 2;
        position = [position[0] + 1, position[1]];
    }
    init();
}

function move_right() {
    if ((ary[position[0]][position[1] + 1]) == 0) {
        ary[position[0]][position[1]] = 0;
        ary[position[0]][position[1] + 1] = 2;
        position = [position[0], position[1] + 1];
    }
    init();
}

function move_left() {
    if ((ary[position[0]][position[1] - 1]) == 0) {
        ary[position[0]][position[1]] = 0;
        ary[position[0]][position[1] - 1] = 2;
        position = [position[0], position[1] - 1];
    }
    init();
}
