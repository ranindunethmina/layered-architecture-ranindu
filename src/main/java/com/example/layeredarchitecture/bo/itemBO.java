package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface itemBO extends SuperBO{
    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;
    boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    boolean existItem(String code) throws SQLException, ClassNotFoundException;
    boolean deleteItem(String code) throws SQLException, ClassNotFoundException;
    ResultSet generateItemId() throws SQLException, ClassNotFoundException;
    boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

}