package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderDAO {
    ResultSet generateNewOrderId() throws SQLException, ClassNotFoundException;
    void selectOrderId(String orderId) throws SQLException, ClassNotFoundException;
    boolean save(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
}