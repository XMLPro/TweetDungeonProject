//以下のそれぞれにソケット送信処理を追加
    // Create a socket
    var WS = window['MozWebSocket'] ? MozWebSocket : WebSocket;
    //var socket = new WS('@@{WebSocket.sendms()}')
    //要書き換え必要、サーバー側だと動かない可能性
    var socket = new WS('ws://localhost:9000/twi_st')


    function push_button(btn) {
      socket.send(btn);
    }
//    // Message received on the socket
//    socket.onmessage = function(event) {
//        var parts = /^([^:]+):([^:]+)(:(.*))?$/.exec(event.data)
//        display({
//            type: parts[1],
//            user: parts[2],
//            text: parts[4]
//        })
//    }
//
//    $('#send').click(function(e) {
//        var message = $('#message').val()
//        $('#message').val('')
//        socket.send(message)
//    });
//
//    $('#message').keypress(function(e) {
//        if(e.charCode == 13 || e.keyCode == 13) {
//            $('#send').click()
//            e.preventDefault()
//        }
//    })
function move_up() {
    push_button('up');
}

function move_down() {
    push_button('down');
}

function move_left() {
    push_button('left');
}

function move_right() {
    push_button('left');
}
