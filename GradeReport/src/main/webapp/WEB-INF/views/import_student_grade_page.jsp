<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Import Student Grade</title>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">

        <!-- Custom CSS -->
        <style>
            .btn {
                margin-right: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container mt-5">
            <h3>List of Subjects for This Term of ${lectureName}:</h3>
            <div class="container">
                <hr>
                <div class="row justify-content-between">
                    <a href="/hello" class="btn-primary btn btn-default">Return</a>  <!--TODO: add link-->
                </div>
            </div>
            <ul class="list-group mt-3">
                <c:forEach items="${subjectsOfLectureList}" var = "s">
                    <a href ="/importGradeDetailPage?subjectCode=${s.subjectCode}"><li class="list-group-item">${s.subjectCode}</li></a>
                        </c:forEach>      
            </ul>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>

    </body>
</html>

