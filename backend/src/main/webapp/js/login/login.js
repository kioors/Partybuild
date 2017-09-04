$(function () {
    $("#loginBtn").click(function(){loginSub()});
})

function loginSub(){
    if(checkLogin()){
        $.ajax({
            type: "POST",
            url:"/loading",
            dataType:"json",
            data:$('#loginForm').serialize(),
            success: function(data) {
                if(data.status == "yes"){
                    window.location.href = $("#basePath").val()+"logout";
                }else{
                    Modal.error("系统消息",data.msg)
                }
            }
        })
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

