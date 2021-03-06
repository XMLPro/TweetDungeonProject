//ソケットで迷路のマップデータを取得しaryへ代入後init()処理を実行
var ary = [
    [1, 0, 1, 0, 1], //1が黒、0が白
    [0, 2, 0, 0, 0], //2はプレーヤ
    [1, 0, 1, 0, 1],
];

var position = {x: -1, y: -1};
function init() {
    var map = document.getElementById('map');

    map.innerHTML = "";
    console.log(ary);
    for (var i = 0; i < ary.length; i++) {
        for (var j = 0; j < ary[i].length; j++) {
            block = document.createElement('div');

            if (ary[i][j] == 1) {
                var black = document.createElement('div');
                black.className = 'block';
                map.appendChild(black);
            } else if (ary[i][j] == 0) {
                var white = document.createElement('div');
                white.className = 'block white';
                map.appendChild(white);
            } else if (ary[i][j] == 4) {
                var character = document.createElement('img');
                character.className = "block";
                character.src = '/img/human.png';
                map.appendChild(character);
            } else if (ary[i][j] == 2) {
                var white = document.createElement('div');
                white.className = 'block white';
                map.appendChild(white);
            } else if (ary[i][j] == 3) {
                var black = document.createElement('div');
                black.className = 'block black';
                map.appendChild(black);
            } else {
                console.log("blockError");
            }

        }
        var rn = document.createElement('div');
        rn.className = 'clr';
        map.appendChild(rn);
    }
}

function move_up() {
    if ((ary[position[0] - 1][position[1]]) == 0) {
        ary[position[0]][position[1]] = 0;
        ary[position[0] - 1][position[1]] = 4;
        position = [position[0] - 1, position[1]];
    }
    init();
}

function move_down() {
    if ((ary[position[0] + 1][position[1]]) == 0) {
        ary[position[0]][position[1]] = 0;
        ary[position[0] + 1][position[1]] = 4;
        position = [position[0] + 1, position[1]];
    }
    init();
}

function move_right() {
    if ((ary[position[0]][position[1] + 1]) == 0) {
        ary[position[0]][position[1]] = 0;
        ary[position[0]][position[1] + 1] = 4;
        position = [position[0], position[1] + 1];
    }
    init();
}

function move_left() {
    if ((ary[position[0]][position[1] - 1]) == 0) {
        ary[position[0]][position[1]] = 0;
        ary[position[0]][position[1] - 1] = 4;
        position = [position[0], position[1] - 1];
    }
    init();
}
