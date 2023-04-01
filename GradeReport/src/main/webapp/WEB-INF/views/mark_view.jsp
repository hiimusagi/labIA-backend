<%@ page import="java.util.Vector" %>
<%@ page import="com.fasterxml.jackson.annotation.JsonTypeInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Grades</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <jsp:include page="link.jsp"/>
</head>

<body>
<h3 style="text-align: center; font-weight: bold">Grade Report Of Subject ${subjectCode} Of Student ${studentId}</h3>
<div class="container-fluid py-3">
    <div class="container">
        <hr>
        <div class="row justify-content-between">
            <a href="/student/subjects" class="btn-primary btn btn-default">Return</a>  <!--TODO: add link-->
        </div>
    </div>
    <hr>
    <div class="container mt-3">
        <table class="table table-light table-hover">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">assessmentType</th>
                <th scope="col">assessmentGrade</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Assessments}" var="a">
                <tr>
                    <td>${a.assessmentId}</td>
                    <td>${a.assessmentType}</td>
                    <td>${a.assessmentGrade}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/main.js"></script>
</body>
</html>