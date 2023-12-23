package lk.ijse.layeredarchitecture.dao.custom;

import lk.ijse.layeredarchitecture.dao.CrudDAO;
import lk.ijse.layeredarchitecture.dto.OrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderDAO extends CrudDAO<OrderDTO> {
    ResultSet generateNewOrderId() throws SQLException, ClassNotFoundException;
    void selectOrderId(String orderId) throws SQLException, ClassNotFoundException;
    boolean save(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
}