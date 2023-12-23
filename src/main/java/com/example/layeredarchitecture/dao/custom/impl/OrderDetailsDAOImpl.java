package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.OrderDetailsDAO;
import com.example.layeredarchitecture.model.OrderDetailDTO;
import com.example.layeredarchitecture.util.TransactionConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    @Override
    public boolean save(String orderId, OrderDetailDTO detail) throws SQLException, ClassNotFoundException {
//        Connection connection = TransactionConnection.getConnection();
//
//        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
//
//        stm.setString(1, orderId);
//        stm.setString(2, detail.getItemCode());
//        stm.setBigDecimal(3, detail.getUnitPrice());
//        stm.setInt(4, detail.getQty());
//
//        if (stm.executeUpdate() != 1) {
//            connection.rollback();
//            TransactionConnection.setAutoCommitTrue();
//            return false;
//        }
//        return true;
        boolean isExecuted = SQLUtil.excute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",
                orderId,
                detail.getItemCode(),
                detail.getUnitPrice(),
                detail.getQty()
        );

        if (!isExecuted) {
            TransactionConnection.getConnection().rollback();
            TransactionConnection.getConnection().setAutoCommit(true);
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ResultSet generateId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public OrderDetailDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}