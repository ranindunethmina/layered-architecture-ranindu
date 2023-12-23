package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface placeOrderBO extends SuperBO{

    boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException ;
    CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;
    ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException;
    boolean existItem(String code)throws SQLException, ClassNotFoundException;
    boolean existCustomer(String id)throws SQLException, ClassNotFoundException;
    ResultSet generateOrderID()throws SQLException, ClassNotFoundException;
    ArrayList<CustomerDTO> getAllCustomer()throws SQLException, ClassNotFoundException;
    ArrayList<ItemDTO> getAllItems()throws SQLException, ClassNotFoundException;
}
