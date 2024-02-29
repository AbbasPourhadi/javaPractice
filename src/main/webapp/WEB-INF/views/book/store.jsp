<%@ page import="com.example.lib.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lib.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lib.model.Book" %>
<!doctype html>
<html lang="en" data-bs-theme="auto">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>library</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="../../assets/css/style.css" rel="stylesheet">
</head>
<body>

<header data-bs-theme="dark">
    <div class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container">
            <a href="/" class="navbar-brand d-flex align-items-center">
                <strong>library Books</strong>
            </a>
        </div>
    </div>
</header>

<main>
    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">Store Book Form</h1>
                <%
                    Object msg = request.getAttribute("msg");
                    if (msg != null){
                %>
                <div class="alert alert-success">
                    <h3> <%= msg %></h3>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    </section>
    <div class="album py-5 bg-body-tertiary">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-6 text-center">
                    <form action="/books/store" method="post" class="form-control py-5 text-center justify-content-center">
                        <label for="title">Title:</label>
                        <input id="title" class="form-control w-75 my-3" type="text" name="title">
                        <button type="submit" class="btn btn-outline-success my-3">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>

<footer class="text-white py-5 bg-dark">
    <div class="container">
        <p class="mb-1">book library footer</p>
    </div>
</footer>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>





