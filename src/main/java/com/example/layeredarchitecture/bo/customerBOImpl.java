package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.impl.customerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class customerBOImpl implements customerBO{
    CustomerDAO customerDAO=new customerDAOImpl();

    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        //customer business logic example
        return customerDAO.save(dto);
    }
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException{
        return customerDAO.getAll();
    }
    @Override
    public boolean update (CustomerDTO customerDTO) throws SQLException, ClassNotFoundException{
        return customerDAO.update(customerDTO);
    }
    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException{
        return customerDAO.exist(id);
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException{
        return customerDAO.delete(id);
    }
    @Override
    public ResultSet generateId() throws SQLException, ClassNotFoundException{
        return customerDAO.generateId();
    }
}
