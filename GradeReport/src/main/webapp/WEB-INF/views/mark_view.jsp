<%@ page import="java.util.Vector" %>
<%@ page import="com.fasterxml.jackson.annotation.JsonTypeInfo" %>
<!DOCTYPE html>
<html>
<head>
    <title>Grades</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <jsp:include page="link.jsp"/>
</head>

<body>

<div class="container-fluid py-3">
    <div class="container">
        <hr>
        <div class="row justify-content-between">
            <a href="" class="btn-primary btn btn-default">Return to main page</a>  <!--TODO: add link-->
            <form class="form-inline my-2 my-lg-0" method="GET" action="">  <!--TODO: add action-->
                <input type="hidden" name="action" value="search-student">
                <label for="12"></label>
                <input class="form-control mr-sm-2" id="12" type="text" placeholder="Search" name="search">
                <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
            </form>

        </div>
    </div>

    <hr>

    <div class="container mt-3">
        <table class="table table-light table-hover">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Subject</th>
                <th scope="col">Student ID</th>
                <th scope="col">Type</th>
                <th scope="col">Mark</th>
            </tr>
            </thead>
            <tbody>
            <%for (int i = 0; i <= 5; i++) {%>
            <tr>
                <th scope="row"><%=i%></th>
                <td>Math</td>
                <td>1</td>
                <td>Assignment</td>
                <td>100
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>

<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/popper.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/main.js"></script>
</body>
</html>