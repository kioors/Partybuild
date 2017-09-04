$('#getCode').click(function () {
    time();
})

function time() {
    $('#getCode').attr('disabled', 'disabled');
    var i = 59;
    var int = setInterval(function gettime() {
        if (i < 0) {
            clearInterval(int);
            $('#getCode').val('获取验证码');
            $('#getCode').attr('disabled', false);
        } else {
            $('#getCode').val('重新发送' + i + 'S');
            i = i - 1;
        }
    }, 1000);
}

