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
<h3 style="text-align: center">
  Welcome ${users.email}
  <a href="/logout" class="btn btn-danger" style="border-radius: 25px; padding: 5px 15px; margin-left: 10px;">
    Logout
  </a>
</h3>
<div class="container">
    <div class="row justify-content-center">
        <c:if test="${users.roles == 3}">
        <div class="col-md-6">
        <div class="card">
          <h5 class="card-header">My Subject</h5>
          <div class="card-body">
            <p class="card-text">Click the button below to view your curriculum.</p>
            <a href="/student/subjects" class="btn btn-primary">View Grades</a>
          </div>
        </div>
      </div>
        </c:if>
        <c:if test="${users.roles == 2}">
      <div class="col-md-6">
        <div class="card">
          <h5 class="card-header">View Student Grade</h5>
          <div class="card-body">
            <p class="card-text">Click the button below to view student grades.</p>
            <a href="/studentGradePage" class="btn btn-primary">View Grades</a>
          </div>
        </div>
      </div>
      <div class="col-md-6">
        <div class="card">
          <h5 class="card-header">Import Student Grade</h5>
          <div class="card-body">
            <p class="card-text">Click the button below to import student grades.</p>
            <a href="/importStudentGradePage" class="btn btn-primary">Import Grades</a>
          </div>
        </div>
      </div>
      </c:if>
    </div>
  </div>
<div>
<!-- Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>

