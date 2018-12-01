<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2018/11/7
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <table style="margin: 20px auto" cellpadding="15px">
            <tr>
                <td>房间号</td>
                <td><input id="ename" name="ename" class="easyui-textbox" data-options="width:180" /></td>
            </tr>
            <tr>
                <td>最低价</td>
                <td><input id="startprice" type="text" name="startprice" class="easyui-numberbox"  data-options="min:0"></input></td>
            </tr>
            <tr>
                <td>最高价</td>
                <td><input id="endprice" type="text" name="endprice" class="easyui-numberbox"  data-options="min:0"></input></td>
            </tr>

        </table>

</body>
</html>
