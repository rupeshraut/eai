<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html ng-app="store">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body ng-controller="StoreCtrl as store">
    <div ng-repeat="employees in store.employeeList">
        <h1>Name: {{employees.name}}</h1>
        <h1>Age: {{employees.age}}</h1>
        <button ng-show="employees.show">Click Me</button>
    </div>
    <script type="text/javascript" src="resources/js/angular.min.js"></script>
    <script type="text/javascript" src="resources/js/app/app.js"></script>
</body>
</html>