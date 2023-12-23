package lk.ijse.layeredarchitecture.dao.custom.impl;

import lk.ijse.layeredarchitecture.dao.SQLUtil;
import lk.ijse.layeredarchitecture.dao.custom.OrderDAO;
import lk.ijse.layeredarchitecture.dto.OrderDTO;
import lk.ijse.layeredarchitecture.util.TransactionConnection;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public ResultSet generateNewOrderId() throws SQLException, ClassNotFoundException {
        return SQLUtil.excute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
    }
    @Override
    public void selectOrderId(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.excute("SELECT oid FROM `Orders` WHERE oid=?", orderId);
        resultSet.next();
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        boolean isExecuted = SQLUtil.excute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",
                orderDTO.getOrderId(),
                orderDTO.getOrderDate(),
                orderDTO.getCustomerId()
        );

        if (!isExecuted) {
            TransactionConnection.rollBack();
            TransactionConnection.getConnection().setAutoCommit(true);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
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
    public OrderDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

}