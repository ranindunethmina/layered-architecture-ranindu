package lk.ijse.layeredarchitecture.dao.custom.impl;

import lk.ijse.layeredarchitecture.dao.SQLUtil;
import lk.ijse.layeredarchitecture.dao.custom.ItemDAO;
import lk.ijse.layeredarchitecture.entity.Item;

import java.sql.*;
import java.util.ArrayList;

public class itemDAOImpl implements ItemDAO {

    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.excute("SELECT * FROM Item");

        ArrayList<Item> allItem = new ArrayList<>();

        while (rst.next()) {
            Item item = new Item(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand"));
            allItem.add(item);
        }
        return allItem;
    }

    public boolean save(Item item) throws SQLException, ClassNotFoundException {
        return SQLUtil.excute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());
    }

    public boolean update(Item item) throws SQLException, ClassNotFoundException {
        return SQLUtil.excute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",item.getDescription(),item.getUnitPrice(),item.getQtyOnHand(),item.getCode());
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
    public Item search(String newItemCode) throws SQLException, ClassNotFoundException {
        ResultSet rst =SQLUtil.excute("SELECT * FROM Item WHERE code=?",newItemCode);
        rst.next();
        return new Item (newItemCode+"", rst.getString("description"),rst.getBigDecimal("unitPrice"),rst.getInt("qtyOnHand"));
    }
}