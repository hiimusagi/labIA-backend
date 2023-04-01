<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Import Student Grade Details</title>

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
        <!-- Import Grade Modal -->

        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="gradeModalLabel">Import Grades for ${subjectCode}</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Import File Modal -->
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="importModalLabel">Import Grades File</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="fileUpload">Choose File:</label>
                                <input type="file" class="form-control-file" id="fileUpload">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Import</button>
                    </div>
                </div>
                <table class="table mt-3">
                    <thead>
                        <tr>
                            <th>Student ID</th>
                            <th>Student Name</th>
                            <th>PT1</th>
                            <th>PT2</th>
                            <th>FE</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var = "s" begin="0" end="${studentsOfSubjectTermPT1List.size()-1}">
                        <tr>
                            <td>${studentsOfSubjectTermPT1List.get(s).getStudentId()}</td>
                            <td>${studentsOfSubjectTermPT1List.get(s).getStudentName()}</td>
                            <td><input type="text" value="${studentsOfSubjectTermPT1List.get(s).getAssessmentGrade()}" class="form-control"></td>
                            <td><input type="text" value="${studentsOfSubjectTermPT2List.get(s).getAssessmentGrade()}" class="form-control"></td>
                            <td><input type="text" value="${studentsOfSubjectTermFEList.get(s).getAssessmentGrade()}" class="form-control"></td>
                        </tr>
                    </c:forEach>  
                    <!-- Add more rows for additional students -->
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>

    </body>
</html>
