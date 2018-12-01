<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2018/11/26
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/easyui-1.5/jquery.easyui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/easyui-1.5/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/easyui-1.5/themes/default/easyui.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/easyui-1.5/themes/icon.css"/>

<script>
$(function () {
    alert(123213213);

    formatterDate = function (date) {
        var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
        var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0"
            + (date.getMonth() + 1);
        var hor = date.getHours();
        var min = date.getMinutes();
        var sec = date.getSeconds();
        return date.getFullYear() + '-' + month + '-' + day+" "+hor+":"+min+":"+sec;
    };

    $('#logintime').datetimebox('setValue', formatterDate(new Date()));
})

</script>
