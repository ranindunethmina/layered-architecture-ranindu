package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.impl.itemDAOImpl;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class itemBOImpl implements itemBO{
    ItemDAO itemDAO=new itemDAOImpl();

    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException{
        return itemDAO.getAll();
    }
    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException{
        return itemDAO.save(itemDTO);
    }

    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(code);
    }

    @Override
    public ResultSet generateId() throws SQLException, ClassNotFoundException {
        return itemDAO.generateId();
    }

    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException{
        return itemDAO.update(itemDTO);
    }

}
