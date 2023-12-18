package com.example.layeredarchitecture.dao.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO {
    ResultSet generateNewOrderId() throws SQLException, ClassNotFoundException;
    void selectOrderId(String orderId) throws SQLException, ClassNotFoundException;
    boolean saveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException;
}