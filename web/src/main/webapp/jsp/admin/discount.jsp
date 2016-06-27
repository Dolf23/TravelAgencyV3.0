<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="top.jsp" %>

<form class="form-horizontal" action="controller" method="post">
    <input type="hidden" name="command" value="set_discount">
    <fieldset>

        <!-- Select Multiple -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="discountingTour">Tours</label>

            <div class="col-md-4">
                <select id="discountingTour" name="discountingTour" class="form-control" multiple="multiple"
                        style="width: 450px; height: 450px;">
                    <c:forEach var="Tour" items="${toursMap}">
                        <option value="${Tour.key}">${Tour.value}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="form-group" align="center">
            <%@ include file="../pagination/pagination.jsp" %>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="amountDiscount">Amount of discount</label>

            <div class="col-md-4">
                <input id="amountDiscount" name="amountDiscount" type="text" placeholder=""
                       class="form-control input-md">
                <span class="help-block">Enter amount of discount</span>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebuttonReserv"></label>

            <div class="col-md-4">
                <button id="singlebuttonReserv" name="singlebuttonReserv" class="btn btn-success">Set discount</button>
            </div>
        </div>

        <div align="center">
            <h3>${operationMessage}<br></h3>
        </div>

    </fieldset>
</form>

<%@ include file="bottom.jsp" %>