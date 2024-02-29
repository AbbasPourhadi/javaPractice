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
            <a href="/books/store" class="btn btn-success">
                <i>Add Book</i>
            </a>
        </div>
    </div>
</header>

<main>
    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">Explore in Books</h1>
            </div>
        </div>
    </section>
    <div class="album py-5 bg-body-tertiary">
        <div class="container">
            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                <%
                    List<Book> books = (List<Book>) request.getAttribute("books");
                    for (int i = 0; i < books.size(); i++) {
                        long id = books.get(i).getId();
                        String title = books.get(i).getTitle();
                %>
                <div class="col">
                    <div class="card shadow-sm">
                        <%--                        <img src="" alt="book image">--%>
                        <div class="card-body">
                            <h5 class="card-title"><%= title %>
                            </h5>
                            <p class="card-text">Book ID: <%= id %>
                            </p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">Borrow</button>
                                </div>
                                <small class="text-body-secondary">9 mins</small>
                            </div>
                        </div>
                    </div>
                </div>
                <% } %>
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





