package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.SuperBO;
import com.example.layeredarchitecture.dto.ItemDTO;
import com.example.layeredarchitecture.dto.OrderDetailDTO;
import com.example.layeredarchitecture.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface placeOrderBO extends SuperBO {

    boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException ;
    Customer searchCustomer(String id) throws SQLException, ClassNotFoundException;
    ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException;
    boolean existItem(String code)throws SQLException, ClassNotFoundException;
    boolean existCustomer(String id)throws SQLException, ClassNotFoundException;
    ResultSet generateOrderID()throws SQLException, ClassNotFoundException;
    ArrayList<Customer> getAllCustomer()throws SQLException, ClassNotFoundException;
    ArrayList<ItemDTO> getAllItems()throws SQLException, ClassNotFoundException;
}
