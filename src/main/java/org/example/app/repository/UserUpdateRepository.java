package org.example.app.repository;

import org.example.app.database.DBConn;
import org.example.app.entity.User;
import org.example.app.utils.Constants;
import org.example.app.utils.IdChecker;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserUpdateRepository {
    public String updateUser(User user) {
        if (IdChecker.isIdExists(user.getId())) {
            return updateUserById(user);
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }

    private String updateUserById(User user) {
        String sql = "UPDATE " + Constants.TABLE_USERS + " SET email = ? WHERE id = ?";
        try (PreparedStatement pmt = DBConn.connect().prepareStatement(sql)) {
            pmt.setString(1, user.getEmail());
            pmt.setInt(2, user.getId());
            pmt.executeUpdate();
            return Constants.DATA_UPDATE_MSG;

        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
