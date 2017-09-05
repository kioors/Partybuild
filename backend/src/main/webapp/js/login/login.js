$(function () {
    $("#loginBtn").click(function(){loginSub()});
})

function loginSub(){
    if(checkLogin()){
        $("#loginForm").submit();
    }
}
function checkLogin() {
    $("#usernameWarn").hide();
    $("#passwordWarn").hide();
    if($("#username").val()==""){
        $("#usernameWarn").show();
        return false;
    }else if($("#password").val()==""){
        $("#passwordWarn").show();
        return false;
    }
    return true;
}

