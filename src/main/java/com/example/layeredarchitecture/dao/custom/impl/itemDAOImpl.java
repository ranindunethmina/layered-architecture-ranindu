package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dto.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class itemDAOImpl implements ItemDAO {

    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
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
        return SQLUtil.excute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
    }

    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.excute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand(),itemDTO.getCode());
    }

    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.excute("SELECT code FROM Item WHERE code=?",code);
        return  resultSet.next();
    }

    public boolean delete(String code) throws SQLException, ClassNotFoundException {
       return SQLUtil.excute("DELETE FROM Item WHERE code=?",code);
    }

    public ResultSet generateId() throws SQLException, ClassNotFoundException {
        return SQLUtil.excute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
    }
    @Override
    public ItemDTO search(String newItemCode) throws SQLException, ClassNotFoundException {
        ResultSet rst =SQLUtil.excute("SELECT * FROM Item WHERE code=?",newItemCode);
        rst.next();
        return new ItemDTO (newItemCode+"", rst.getString("description"),rst.getBigDecimal("unitPrice"),rst.getInt("qtyOnHand"));
    }
}