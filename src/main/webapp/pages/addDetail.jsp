<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2018/11/16
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/easyui/include.jsp"%>
    <%@include file="/pages/include2.jsp"%>
    <script>
        alert(1111);
    </script>
</head>
<body>
<form id="emp-form"  method="post">
    <table style="margin: 20px auto" cellpadding="15px">

     <%--   // 1.房间编号”使用下拉列表展示，选项为“房间信息”表中的房间号，需要注意已预订（未退宿）的房间不能被选中。（只显示退宿的)
        // 2.“客户姓名”不能为空。
        // 3.“身份证号”必填，需要验证数据位数为18位；必填。
        // 4.“入住时间”、“退宿时间”使用日期控件展示，精确到日，“退宿时间”不得早于“入住时间”；必填。
        // 5.“入住天数”根据上述2个字段计算得到（不足1天的算1天）。
        // 6.“总价”根据选中选中房间的“住宿单价”以及“入住天数”自动计算得到。
        // 7.“登记时间”默认当前时间，精确到秒，不可修改。
        // 8.“是否退宿”默认为“否”，不可修改。
        // 9.预定添加信息成功后，变更“房间信息表”中的“房间状态”为“已预订”。--%>

        <tr>
        <%--<tr>--%>
            <%--<td>房间号</td>&lt;%&ndash;需要自动生成&ndash;%&gt;--%>
            <%--<td>${id}<input type="hidden" name="did" class="easyui-textbox" data-options="required:true,width:180"  /></td>--%>

        <%--</tr>--%>

        <tr>
            <td>房间号</td>
            <td><input id="rdnum" name="rdnum" class="easyui-combobox" data-options="required:true,width:180,url:'${pageContext.request.contextPath}/rdetail/getroom',valueField:'rnum',textField:'rnum'
                                                                   " ></td>
        <%--valueField:'bid',textField:'bno'--%>
        </tr>

        <tr>
            <td>客户姓名</td>
            <td><input name="rdname" class="easyui-textbox" data-options="required:true,width:180" /></td>
        </tr>
        <tr>
            <td>身份证</td>
            <td><input name="rdidcard" class="easyui-textbox" data-options="required:true,width:180,validType:'sfz'"/></td>
        </tr>
        <tr>
            <td>入住时间</td>
            <td>
                <input id="intime" name="intime" class="easyui-datebox" data-options="width:180,required:true,validType:['in_out','today'],onChange:function(){change1()}"/>
            </td>
        </tr>
         <tr>
             <td>退宿时间</td>
             <td>
                 <input id="outtime" name="outtime" class="easyui-datebox" data-options="width:180,required:true,validType:['in_out','today'],onChange:function(){change1()}"/>
             </td>
         </tr>
        <tr>
            <td>入住天数</td>
            <td> <input id="days" name="days" class="easyui-textbox" data-options="required:true,width:180" /></td>
        </tr>
         <tr>
             <td>总价</td>
             <td><input id="sum" name="sum" class="easyui-textbox" data-options="required:true,width:180" /></td>
         </tr>
        <tr>
            <td>登记时间</td>
            <td><input id="logintime" value="${logintime}" name="logintime"  class="easyui-datetimebox" data-options="width:180,required:true"/></td>
        </tr>
        <tr>
            <td>是否退宿：</td>
            <td>否</td>
        </tr>

    </table>

</form>
</body>
</html>
