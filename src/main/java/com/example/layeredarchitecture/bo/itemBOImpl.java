package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.impl.itemDAOImpl;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class itemBOImpl implements itemBO{
    ItemDAO itemDAO=new itemDAOImpl();

    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException{
        return itemDAO.getAll();
    }
    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException{
        return itemDAO.save(itemDTO);
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(code);
    }

    @Override
    public ResultSet generateItemId() throws SQLException, ClassNotFoundException {
        return itemDAO.generateId();
    }

    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException{
        return itemDAO.update(itemDTO);
    }

}
