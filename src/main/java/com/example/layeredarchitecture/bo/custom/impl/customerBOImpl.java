package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.customerBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class customerBOImpl implements customerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        //customer business logic example
        return customerDAO.save(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException{
        ArrayList<Customer> customers=customerDAO.getAll();
        ArrayList<CustomerDTO> customerDTOS=new ArrayList<>();
        for (Customer customer:customers) {
            customerDTOS.add(new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress()));
        }
        return customerDTOS;

    }
    @Override
    public boolean updateCustomer (CustomerDTO dto) throws SQLException, ClassNotFoundException{
        return customerDAO.update(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }
    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException{
        return customerDAO.exist(id);
    }
    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException{
        return customerDAO.delete(id);
    }
    @Override
    public ResultSet generateCustomerId() throws SQLException, ClassNotFoundException{
        return customerDAO.generateId();
    }

}