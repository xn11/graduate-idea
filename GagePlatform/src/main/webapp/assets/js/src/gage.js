/**
 * Created by xn on 2017/4/4.
 */

function modifyPassword() {
    $("#submit").click(function() {
        modifyPwd();
    });

    function checkPwd() {
        var oldPwd = $("#oldPassword").val();
        var actualPwd = "<c:out value='${user.password}'/>";
        console.log("oldpwd: " + oldPwd);
        console.log("actualPwd: " + actualPwd);
        if (oldPwd != actualPwd) {
            alert("旧密码错误， 请重新输入");
            $("#oldPassword").val("");
            return false;
        }
        var newPwd = $("#newPassword").val();
        var newPwd2 = $("#newPassword2").val();

        if (newPwd != newPwd2) {
            alert("两次输入的密码不一致，请重新输入");
            $("#newPassword").val("");
            $("#newPassword2").val("");
            return false;
        }
        return true;
    }

    function modifyPwd() {
        if (!checkPwd()) return;
        var newPwd = $("#newPassword").val();
        $.ajax({
            url : "/user/modifyPassword",
            method : "post",
            data : {
                newPwd : newPwd
            },
            success : function(result) {
                if (result.resultCode == "NORMAL") {
                    alert("密码修改成功");
                } else {
                    alert("未知错误，请稍后重试");
                }
            }
        });
    }
}

function accountInfo(){
    //保存用户信息按钮
    $('#saveBtn').click(() => {
        var telephone = $('#telephone').val();
        $.ajax({
            url:"/user/accountInfo",
            method:"post",
            data:{
                telephone: telephone
            },
            success(result){
                if (result.resultCode == "NORMAL") {
                    alert("保存成功！");
                } else {
                    alert(result.resultCode.name);
                }
            },
            error(e){
                alert(e);
            }
        });
    })
}