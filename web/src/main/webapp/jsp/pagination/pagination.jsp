<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>
    <c:forEach var="item" items="${paginationMenu}">
        <a style="margin-right: 10px" href="controller?command=update_pagination&page=${item}">${item}</a>
    </c:forEach>
</div>
<div>
    <a style="margin-right: 20px" href="controller?command=update_pagination&quantityPerPage=10">10</a>
    <a style="margin-right: 20px" href="controller?command=update_pagination&quantityPerPage=20">20</a>
    <a style="margin-right: 20px" href="controller?command=update_pagination&quantityPerPage=50">50</a>
    <a style="margin-right: 20px" href="controller?command=update_pagination&quantityPerPage=100">100</a>
</div>