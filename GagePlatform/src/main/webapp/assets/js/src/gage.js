/**
 * Created by xn on 2017/4/4.
 */

//按钮失效
function disButtons(btnIds) {
    for (var i = 0; i < btnIds.length; i++) {
        var btn = $("#" + btnIds[i]);
        btn.attr("disabled", true);
        btn.addClass("btn-disabled");
    }
}

//激活按钮
function activeButtons(btnIds) {
    for (var i = 0; i < btnIds.length; i++) {
        var btn = $("#" + btnIds[i]);
        btn.attr("disabled", false);
        btn.removeClass("btn-disabled");
    }
}

//清空modal
function clear() {
    $('#addModal .form-control').val("");
}

//空字符串则输出“无”
function printNull(str) {
    if (null == str || '' == str) {
        return '无';
    }else{
        return str;
    }
}

function handleAjaxError(XMLHttpRequest, textStatus, errorThrown) {
    console.log(XMLHttpRequest.status);
    console.log(XMLHttpRequest.readyState);
    console.log(textStatus);
}

function modifyPassword() {
    $("#submit").click(function () {
        modifyPwd();
    });

    function checkPwd() {
        var oldPwd = $("#oldPassword").val();
        var actualPwd = $("#password").val();
        if (oldPwd != actualPwd) {
            alert("原密码错误， 请重新输入");
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
            url: "/user/modifyPassword",
            method: "post",
            data: {
                newPwd: newPwd
            },
            success: function (result) {
                if (result.resultCode == "NORMAL") {
                    alert("密码修改成功");
                } else {
                    alert("未知错误，请稍后重试");
                }
            },
            error(XMLHttpRequest, textStatus, errorThrown){
                handleAjaxError(XMLHttpRequest, textStatus, errorThrown);
            }
        });
    }
}

function accountInfo() {
    //保存用户信息按钮
    $('#saveBtn').click(() => {
        var telephone = $('#telephone').val();
        $.ajax({
            url: "/user/accountInfo",
            method: "post",
            data: {
                telephone: telephone
            },
            success(result){
                if (result.resultCode == "NORMAL") {
                    alert("保存成功！");
                } else {
                    alert(result.resultCode.name);
                }
            },
            error(XMLHttpRequest, textStatus, errorThrown){
                handleAjaxError(XMLHttpRequest, textStatus, errorThrown);
            }
        });
    })
}