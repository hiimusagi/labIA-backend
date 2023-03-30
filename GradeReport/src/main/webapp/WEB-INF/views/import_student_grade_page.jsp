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
    <h3>List of Classes and Subjects for This Term:</h3>
    <ul class="list-group mt-3">
      <%for (int i = 0; i < 9; i++) {%> 
      <a href ="/importGradeDetailPage"><li class="list-group-item">CSE101 - Computer Programming I</li></a>
      <%}%>
    </ul>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>

</body>
</html>

