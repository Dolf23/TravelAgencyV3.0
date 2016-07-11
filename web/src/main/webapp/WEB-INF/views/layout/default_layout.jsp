<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns:jsp="http://java.sun.com/JSP/Page"
      xmlns:tiles="http://tiles.apache.org/tags-tiles">

<jsp:output doctype-public="-//W3C//DTD XHTML 1.1//EN"
            doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd"
            doctype-root-element="html"
            omit-xml-declaration="false"
        />
<head>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="assets/js/bootstrap.min.js"></script>

    <title>Travel Agency></title>
</head>

<body>
<div class="container">
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="sidebar"/>
    <tiles:insertAttribute name="body"/>
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>
