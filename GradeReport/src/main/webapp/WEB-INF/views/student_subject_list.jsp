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
<h3 style="text-align: center">Curriculums Of Student ${studentId}</h3>
<div class="container">
    <hr>
    <div class="row justify-content-between">
        <a href="/hello" class="btn-primary btn btn-default">Return</a>  <!--TODO: add link-->
    </div>
</div>
<div class="container mt-5">
    <form class="form-inline my-2 my-lg-0">
        <button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
    </form>
    <table class="table mt-5">
        <thead>
        <tr>
            <th scope="col" class="term-col">curriculumId</th>
            <th scope="col" class="course-col">curriculumCode</th>
            <th scope="col" class="detail-col">curriculumName</th>
            <th scope="col" class="detail-col">termId</th>
            <th scope="col" class="detail-col">termNo</th>
            <th scope="col" class="detail-col">subjectCode</th>
            <th scope="col" class="detail-col">subjectName</th>
            <th scope="col" class="detail-col">credits</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${studentSubjects}" var = "s">
            <tr>
                <td>${s.curriculumId}</td>
                <td>${s.curriculumCode}</td>
                <td>${s.curriculumName}</td>
                <td>${s.termId}</td>
                <td>${s.termNo}</td>
                <td><a href="/assessment/student?subjectCode=${s.subjectCode}">${s.subjectCode}</a></td>
                <td>${s.subjectName}</td>
                <td>${s.credits}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>

