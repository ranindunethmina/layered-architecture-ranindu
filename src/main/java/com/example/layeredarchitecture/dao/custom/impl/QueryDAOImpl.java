package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.CustomerOrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<CustomerOrderDTO> customerOrderDetails() throws SQLException, ClassNotFoundException {
        //join Query
        ResultSet resultSet = SQLUtil.excute(
                "SELECT o.oid as ID, c.name as CUSTOMER, o.date as DATE FROM Customer c  JOIN Orders o ON c.id = o.customerID;"
        );

        List<CustomerOrderDTO> queryOutput = new ArrayList<>();

        while (resultSet.next()) {
            CustomerOrderDTO dto = new CustomerOrderDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );

            queryOutput.add(dto);
        }
        return queryOutput;
    }

}