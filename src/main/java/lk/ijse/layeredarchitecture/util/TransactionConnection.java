package lk.ijse.layeredarchitecture.util;

import lk.ijse.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionConnection {
    private static Connection connection;

    static {
        try {
            connection = DBConnection.getDbConnection().getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollBack() throws SQLException {
        connection.rollback();
    }

    public static Connection getConnection() {
        return connection;
    }

}