<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Lecture Page</title>

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
  <div class="container">
    <div class="row justify-content-center">
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
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>

</body>
</html>

