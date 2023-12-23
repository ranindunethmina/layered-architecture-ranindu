package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.entity.Customer;

import java.sql.*;
import java.util.ArrayList;

public class customerDAOImpl implements CustomerDAO {

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.excute("SELECT * FROM Customer");

        ArrayList<Customer> allCustomer = new ArrayList<>();

        while (rst.next()){
            Customer entity = new Customer(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"));
            allCustomer.add(entity);
        }
        return allCustomer;
    }

    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
       return SQLUtil.excute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",entity.getId(),entity.getName(),entity.getAddress());
    }

    @Override
    public boolean update (Customer entity) throws SQLException, ClassNotFoundException {
       return SQLUtil.excute("UPDATE Customer SET name=?, address=? WHERE id=?",entity.getName(),entity.getAddress(),entity.getId());
    }
    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
       ResultSet resultSet = SQLUtil.excute("SELECT id FROM Customer WHERE id=?",id);
       return  resultSet.next();
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
       return SQLUtil.excute("DELETE FROM Customer WHERE id=?",id);
    }
    @Override
    public ResultSet generateId() throws SQLException, ClassNotFoundException {
       return SQLUtil.excute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
    }
    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.excute("SELECT * FROM Customer WHERE id=?",id);
        rst.next();
        return new Customer(id + "", rst.getString("name"), rst.getString("address"));
    }
}