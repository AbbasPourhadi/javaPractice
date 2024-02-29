package com.example.lib.servlet.genre;

import com.example.lib.model.Genre;
import com.example.lib.service.GenreService;
import com.example.lib.util.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(loadOnStartup = 1, name = "genreIndexServlet", urlPatterns = "/genres")
public class GenreServlet extends HttpServlet {
    GenreService genreService = new GenreService();

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        HibernateUtil.getSessionFactory();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            /*List<Genre> Genres = GenreService.getAll();
            req.setAttribute("Genres", Genres);
            req.getRequestDispatcher("/WEB-INF/views/genre/index.jsp").forward(req, resp);*/
            resp.getWriter().print(genreService.getAll().toString());

        } catch (SQLException e) {
            throw new ServletException("Error", e);
        }

    }
}
