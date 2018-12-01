<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2018/11/7
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <%@include file="/easyui/include.jsp"%>
    <title>Title</title>
</head>
<body>
    <form id="emp-form"  method="post">
        <table style="margin: 20px auto" cellpadding="15px">
            <input type="hidden" name="rid" value="${r.rid}"/>

            <tr>
                <td>房间号</td>
                <c:choose>
                    <c:when test="${empty r}">
                        <td><input name="rnum" class="easyui-textbox" data-options="required:true,width:180,validType:'num'" /></td>
                    </c:when>
                    <c:otherwise>
                        <td><input name="no" class="easyui-textbox" data-options="required:true,width:180"  value="${r.rnum}" disabled/></td>
                        <input type="hidden" name="bno"   value="${r.rnum}" />
                    </c:otherwise>
                </c:choose>

            </tr>

            <tr>
                <td>房间种类</td>
                <c:choose>
                    <c:when test="${empty r}">
                        <td><input id="rtype" name="rtype" panelHeight="80px"  class="easyui-combobox" data-options="
                                        required:true,
                                        width:180,
                                        valueField: 'label',
                                        textField: 'value',
                                        data: [{
                                            label: '单人间',
                                            value: '单人间'
                                        },{
                                            label: '双人间',
                                            value: '双人间'
                                        },{
                                            label: '大床间',
                                            value: '大床间'
                                        }],
                                        onChange:function(){changetype()}

" />

                        </td>
                    </c:when>
                    <c:otherwise>
                        <td>${r.rtype}</td>

                    </c:otherwise>
                </c:choose>

            </tr>
            <tr>
                <td>住宿单价</td>
                <td>

                <c:choose>
                    <c:when test="${empty r}">
                        <input id="price" name="num" class="easyui-numberbox" data-options="required:true,width:120,min:0" disabled/>
                    </c:when>
                    <c:otherwise>
                        <input  name="rprice" class="easyui-numberbox" data-options="required:true,width:120,min:0" value="${r.rprice}" disabled/>
                    </c:otherwise>
                </c:choose>


                </td>
            </tr>
            <tr>
                <td>
                    房间设备
                </td>
                <td>




                <c:choose>
                    <c:when test="${empty r}">
                        <label><input name="rtool" type="checkbox" value="网络" />网络</label>
                        <label><input name="rtool" type="checkbox" value="电脑" />电脑</label>
                        <label><input name="rtool" type="checkbox" value="书桌" />书桌</label>
                        <label><input name="rtool" type="checkbox" value="电视" />电视</label>
                    </c:when>

                    <c:otherwise>
                        <c:if test="${!fn:contains(r.rtool,'网络')}">
                            <label><input name="rtool" type="checkbox" value="网络" />网络</label>
                        </c:if>
                        <c:if test="${fn:contains(r.rtool,'网络')}">
                            <label><input name="rtool" type="checkbox" value="网络" checked/>网络</label>
                        </c:if>

                        <c:if test="${!fn:contains(r.rtool,'电脑')}">
                            <label><input name="rtool" type="checkbox" value="电脑" />电脑</label>
                        </c:if>
                        <c:if test="${fn:contains(r.rtool,'电脑')}">
                            <label><input name="rtool" type="checkbox" value="电脑" checked/>电脑</label>
                        </c:if>

                        <c:if test="${!fn:contains(r.rtool,'书桌')}">
                            <label><input name="rtool" type="checkbox" value="书桌" />书桌</label>
                        </c:if>
                        <c:if test="${fn:contains(r.rtool,'书桌')}">
                            <label><input name="rtool" type="checkbox" value="书桌" checked/>书桌</label>
                        </c:if>

                        <c:if test="${!fn:contains(r.rtool,'电视')}">
                            <label><input name="rtool" type="checkbox" value="电视" />电视</label>
                        </c:if>
                        <c:if test="${fn:contains(r.rtool,'电视')}">
                            <label><input name="rtool" type="checkbox" value="电视" checked/>电视</label>
                        </c:if>
                    </c:otherwise>
                </c:choose>

                </td>
            </tr>
            <tr>
                <td>
                    状态
                </td>
                <td>
                    <c:choose>
                        <c:when test="${empty r}">
                            <input name="status" type="textbox" value="空闲" disabled>
                        </c:when>
                        <c:when test="${r.status=='0'}">
                            <input name="status" type="textbox" value="空闲" disabled>
                        </c:when>
                        <c:when test="${r.status=='1'}">
                            <input name="status" type="textbox" value="已租" disabled>
                        </c:when>
                        <%--<c:otherwise>--%>
                            <%--<input name="status" type="textbox" value="${r.status}=='0'?'空闲':'已租'"  disabled>--%>
                        <%--</c:otherwise>--%>
                    </c:choose>

                </td>
            </tr>
        </table>
    </form>
</body>
</html>
