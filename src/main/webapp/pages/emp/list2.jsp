
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/easyui/include.jsp"%>
    <script src="${pageContext.request.contextPath}/js/list2.js"></script>
</head>
<body>
    <table id="dg"></table>

    <div id="dg-toolbar">
        <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="add()">租赁</a>

    </div>

    <div id="emp-dialog">

    </div>

</body>
</html>
