package org.example.app.utils;

import org.example.app.database.DBConn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class IdChecker {
    public static boolean isIdExists(int id) {
        try {
            String query = "SELECT COUNT(id) FROM " + Constants.TABLE_USERS + " WHERE id = ?";
            PreparedStatement preparedStatement = DBConn.connect().prepareStatement(query);
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}








