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
    <div class="container mt-5">
      <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="search" placeholder="Enter student ID" aria-label="Search">
        <button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
      </form>
      <table class="table mt-5"> 
        <thead>
          <tr>
            <th scope="col" class="term-col">Term</th>
            <th scope="col" class="course-col">Course</th>
            <th scope="col" class="detail-col">Detail</th>
          </tr>
        </thead>
        <tbody>
          <%for (int i = 0; i < 5; i++) {%> 
          <tr>
            <td class="term-col">Fall 2022</td>
            <td class="course-col">CSE101</td>
            <td class="detail-col">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla volutpat vestibulum ipsum vitae commodo. Donec quis viverra est, et consectetur urna. Suspendisse ac magna sapien. Vivamus luctus euismod eros, sed ullamcorper velit feugiat vel.</td>
          </tr>
          <%}%>
        </tbody>
      </table>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>
  </body>
</html>

