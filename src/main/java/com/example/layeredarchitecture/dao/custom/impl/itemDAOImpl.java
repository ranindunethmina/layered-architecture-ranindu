package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class itemDAOImpl implements ItemDAO {

    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
//
        ResultSet rst = SQLUtil.excute("SELECT * FROM Item");

        ArrayList<ItemDTO> allItem = new ArrayList<>();

        while (rst.next()) {
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand"));
            allItem.add(itemDTO);
        }
        return allItem;
    }

    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
//        pstm.setString(1, itemDTO.getCode());
//        pstm.setString(2, itemDTO.getDescription());
//        pstm.setBigDecimal(3, itemDTO.getUnitPrice());
//        pstm.setInt(4, itemDTO.getQtyOnHand());
//
//        return pstm.executeUpdate() > 0;
        return SQLUtil.excute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
    }

    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
//        pstm.setString(1, itemDTO.getDescription());
//        pstm.setBigDecimal(2, itemDTO.getUnitPrice());
//        pstm.setInt(3, itemDTO.getQtyOnHand());
//        pstm.setString(4, itemDTO.getCode());
//
//        return pstm.executeUpdate() > 0;
        return SQLUtil.excute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand(),itemDTO.getCode());
    }

    public boolean exist(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
//        pstm.setString(1, code);
//
//        return pstm.executeQuery().next();

        ResultSet resultSet = SQLUtil.excute("SELECT code FROM Item WHERE code=?",code);
        return  resultSet.next();
    }

    public boolean delete(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
//        pstm.setString(1, code);
//        pstm.executeUpdate();
       return SQLUtil.excute("DELETE FROM Item WHERE code=?",code);
    }

    public ResultSet generateId() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
//
//        return rst;
        return SQLUtil.excute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
    }
    @Override
    public ItemDTO search(String newItemCode) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
//        pstm.setString(1, newItemCode + "");
//        ResultSet rst = pstm.executeQuery();

     /*   return new ItemDTO(
                rst.getString(1),
                rst.getString(2),
                rst.getBigDecimal(3),
                rst.getInt(4)
        );*/
        ResultSet rst =SQLUtil.excute("SELECT * FROM Item WHERE code=?",newItemCode);
        rst.next();
        return new ItemDTO (newItemCode+"", rst.getString("description"),rst.getBigDecimal("unitPrice"),rst.getInt("qtyOnHand"));
//      return item;
    }

}