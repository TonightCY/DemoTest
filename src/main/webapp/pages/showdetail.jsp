<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2018/11/16
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/easyui/include.jsp"%>
</head>
<body>
        <input id="day" name="starttime" class="easyui-datebox" data-options="width:180,required:true"/>
        <button onclick="day()">查询</button>
        <table id="d" border="1px">

        </table>


    <script>
        function day() {
            $.post("/detail/getdetail?day="+$("#day").datebox("getValue"),"",function (msg) {
                var ap = "";
                $.each(msg,function(i,n){
                    ap=ap+"<tr><td>"+n.btype+"</td><td>"+n.count+"</td></tr>";
                })

                $("#d").html(ap);
            },"json")
        }




    </script>
</body>
</html>
