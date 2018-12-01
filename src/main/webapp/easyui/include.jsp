<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2018/11/6
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/easyui-1.5/jquery.easyui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/easyui-1.5/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/easyui-1.5/themes/default/easyui.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/easyui-1.5/themes/icon.css"/>

<script>
    var contextPath='${pageContext.request.contextPath}';
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
        num: {
            validator: function(value,param){
                var reg = /^[A-Z]{1}[0-9]{3}$/;
                // return value.len]gth <= param[0];
                return reg.test(value);
            },
            message: '房间号格式不对'
        }
    });

    $.extend($.fn.validatebox.defaults.rules, {
        sfz: {
            validator: function(value,param){
                var reg = /^[0-9]{18}$/;
                // return value.len]gth <= param[0];
                return reg.test(value);
            },
            message: '身份证格式不匹配'
        }
    });

    $.extend($.fn.validatebox.defaults.rules, {
        in_out: {
            validator: function(value,param){
                a = $("#intime").textbox("getValue");
                b = $("#outtime").textbox("getValue");
                var days = daysBetween(a,b);
                if(days<0){
                    return false;
                }else {
                    return true;
                }
            },
            message: '退宿必须大于之前的时间'
        }
    });
    $.extend($.fn.validatebox.defaults.rules, {
        today: {
            validator: function(value,param){
                a = $("#intime").textbox("getValue");
                b = $("#outtime").textbox("getValue");
                var c = $("#logintime").textbox("getValue");
                var days = daysBetween(a,b);
                var days2 = daysBetween(a,c);
                var days3 = daysBetween(b,c);
                if(days2>0||days3>0){
                    return false;
                }else {
                    return true;
                }
            },
            message: '时间不得早于今天'
        }
    });
    
    function changetype() {
        var  a ;
        setTimeout(" a= $('#rtype').combobox('getValue');changeprice(a)",200)
    }
    function changeprice(price){
        if (price=="单人间"){
            $("#price").numberbox("setValue",100);
            return;
        }
        if (price=="双人间"){
            $("#price").numberbox("setValue",150);
            return;
        }
        if (price=="大床间"){
            $("#price").numberbox("setValue",200);
            return;
        }


    }

</script>
<script>


function change1() {
    a = $("#intime").textbox("getValue");
    b = $("#outtime").textbox("getValue");
    if (a!=null && b!= null && a!="" && b!=""){
        var days = daysBetween(a,b);
        if(days==0){
            days=1;
        }
        $("#days").textbox("setValue",days);

        var rnum = $("#rdnum").combobox("getValue");
        $.post("../room/getByRnum?rnum="+rnum,"",function (room) {
            $("#sum").textbox("setValue",room.rprice*days);
        },"json")


    }
}


function daysBetween(sDate1,sDate2){
//Date.parse() 解析一个日期时间字符串，并返回1970/1/1 午夜距离该日期时间的毫秒数
    var time1 = Date.parse(new Date(sDate1));
    var time2 = Date.parse(new Date(sDate2));
    var nDays = parseInt((time2 - time1)/1000/3600/24);
    return nDays;
};
</script>
