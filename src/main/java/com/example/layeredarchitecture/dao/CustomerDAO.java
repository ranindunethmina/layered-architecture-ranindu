package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
     ArrayList<CustomerDTO> gellAllCustomer() throws SQLException, ClassNotFoundException ;
     boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;
     boolean updateCustomer (CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;
     boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;
     void deleteCustomer(String id) throws SQLException, ClassNotFoundException ;
     ResultSet generateId() throws SQLException, ClassNotFoundException ;
     String searchCustomer(String id) throws SQLException, ClassNotFoundException ;
}