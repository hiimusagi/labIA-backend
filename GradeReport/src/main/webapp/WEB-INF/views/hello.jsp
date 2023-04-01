<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Student Grade</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <style>
        .btn {
            margin-right: 10px;
        }
        /* Set column widths */
        .term-col {
            width: 20%;
        }
        .course-col {
            width: 30%;
        }
        .detail-col {
            width: 50%;
        }
    </style>
</head>
<body>
<h3 style="text-align: center">Welcome ${users.email}</h3>
<div>
    <a style="text-align: center" class="btn-primary btn btn-default" href="/logout">Logout</a>
    <c:if test="${users.roles == 3}">
        <a style="text-align: center"  class="btn-primary btn btn-default" href="/student/subjects">My Subject</a>
    </c:if>
</div>
<!-- Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>

