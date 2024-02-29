package com.example.lib.dao;

import com.example.lib.model.Reservation;

import java.sql.*;
import java.util.Optional;

public class ReservationDao {
    public void save(Reservation reservation) throws SQLException {
        ;
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "aa", "aa")){
//            String query = "INSERT INTO reservations (user_id, book_id, start_date, end_date) VALUES(?,?,?,?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setLong(reservation.getUser().getId());

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
