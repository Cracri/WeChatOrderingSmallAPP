<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css"  media="all">
<script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/jquery-v3.3.1.js"></script>
<body>
<table class="layui-table" lay-size="lg">
  <colgroup>
    <col width="30%">
    <col width="30%">
  </colgroup>
  
  <thead>
    <tr>
      <th>菜品名</th>
      <th>菜品数量</th>
    </tr> 
  </thead>
  
  <tbody class="message">
    <c:forEach items="${orderDetail }" var="od">
	    <tr >
	      <td>${od.productName }</td>
	      <td>× ${od.productCount }</td>
	    </tr>
    </c:forEach>
  </tbody>
</table>

</body>
</html>