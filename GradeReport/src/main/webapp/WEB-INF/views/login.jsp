<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <!-- Add Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
<jsp:include page="./link.jsp"/>
</head>
<body>

<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <h2 class="text-center mb-4">Login</h2>
            <form action="/login" method="POST">
                <div class="mb-3">
                    <label for="username" class="form-label">Username:</label>
                    <input type="text" name="username" class="form-control" id="username">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password:</label>
                    <input type="password" name="password" class="form-control" id="password">
                </div>
                <div>
                    Remember me?
                    <input type="checkbox" id="remember-me" name="remember-me">
                </div>
                <%if (request.getAttribute("error") != null) {%>
                <div class="alert alert-danger" role="alert">
                    <%=request.getAttribute("error")%>
                </div>
                <%}%>
                <input type="hidden" name="action" value="login">
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>

<!-- Add Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
