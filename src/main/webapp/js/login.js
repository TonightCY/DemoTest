


$.extend($.fn.validatebox.defaults.rules, {
    phone: {
        validator: function(value,param){
            var reg = /^1[3|4|5|7|8][0-9]{9}$/;
            // return value.length <= param[0];
            return reg.test(value);
        },
        message: '手机格式不匹配'
    }
});


$.extend($.fn.validatebox.defaults.rules, {
    length: {
        validator: function(value,param){
            if(!(value.length>= param[0]&&value.length <= param[1])){
                $.fn.validatebox.defaults.rules.length.message ="格式要求"+param[0]+"-"+param[1]+"位！";
                return false;
            }
            return true;
        },
        message: ''
    }
});






$(function () {
    //初始化登入窗口
    $("#login-dialog").dialog({
        title: '登录',
        width: 400,
        height: 200,
        closed: false,
        closable: false,
        draggable:false,
        modal: true,
        buttons:[{
            text:'登录',
            iconCls:"icon-ok",
            handler:function(){
                $("#login-form").form("submit",{
                    url:contextPath+'/login/login',
                    onSubmit:function () {
                        return $(this).form("validate");
                    },
                    success :function (msg) {
                        var data = $.parseJSON(msg);
                        if(data.code === 200){
                            window.location.href=contextPath+"/login/index";
                        }else {
                            $.messager.show({
                                title:'我的消息',
                                msg:data.msg,
                                timeout:5000,
                                showType:'slide'
                            });
                        }

                    }
                })
            }
        },{
            text:'注册',
            iconCls:"icon-add",
            handler:function(){
                $("#register-dialog").dialog({
                    title: '注册',
                    width: 550,
                    height: 400,
                    closed: false,
                    cache: false,
                    href: contextPath+'/emp/empAddAndUpdate',
                    modal: true,
                    buttons:[{
                        text:'注册',
                        iconCls:'icon-ok',
                        handler:function(){
                            $("#emp-form").form("submit",{
                                url:contextPath+'/emp/add',
                                onSubmit:function (p) {
                                    p.etoak = "tonight";
                                    //验证emp-form表单项是否非空
                                    return $("#emp-form").form("validate");
                                },
                                //参数不处理json
                                success:function (msg) {
                                    var data = $.parseJSON(msg);
                                    if(data.code === 200){
                                        $("#register-dialog").dialog("close");
                                        $("#register-dialog").dialog("clear");
                                    }
                                    $.messager.show({
                                        title:'我的消息',
                                        msg:data.msg,
                                        timeout:5000,
                                        showType:'slide'
                                    });
                                }
                            });
                        }
                    }]
                })
            }
        }]

    })


    $("#username").textbox({
        width:180,
        required:true,
        missingMessage:"请输入用户名",
        iconCls:'icon-man',
        validType:'length[3,8]',
    })

    $("#password").textbox({
        width:180,
        required:true,
        type:"password",
        missingMessage:"请输入密码",
        iconCls:'icon-lock'
    })
})