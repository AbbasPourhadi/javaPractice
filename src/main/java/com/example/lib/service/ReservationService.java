package com.example.lib.service;

import com.example.lib.dao.ReservationDao;
import com.example.lib.model.Book;
import com.example.lib.model.Reservation;
import com.example.lib.model.User;

import java.sql.SQLException;
import java.time.LocalDate;

public class ReservationService {
    private UserService userService;
    private BookService bookService;
    private ReservationDao reservationDao;
    public static final long RESERVE_DURATION_IN_WEEK = 1;
    public ReservationService(){
        bookService = new BookService();
        userService = new UserService();
        reservationDao = new ReservationDao();
    }
    public Reservation reserve(Long bookId, Long userId) throws SQLException {
        if (isReservable(bookId, userId)) {
            Reservation reservation = new Reservation();

            Book book = new Book();
            book.setId(bookId);
            reservation.setBook(book);

            User user = new User();
            user.setId(userId);
            reservation.setUser(user);

            reservation.setStartDate(LocalDate.now());
            reservation.setEndDate(LocalDate.now().plusWeeks(RESERVE_DURATION_IN_WEEK));
           return save(reservation);
        }
        return null;
    }

    private Reservation save(Reservation reservation) throws SQLException {
        reservationDao.save(reservation);
        return reservation;
    }

    private boolean isReservable(Long bookId, Long userId) {
        return isUserExists(userId) && isBookExists(bookId);
    }

    private boolean isUserExists(Long userId) {
        return userService.findById(userId).isPresent();
    }

    private boolean isBookExists(Long bookId) {
        return bookService.findById(bookId).isPresent();
    }

}
