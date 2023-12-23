package lk.ijse.layeredarchitecture.dao.custom;

import lk.ijse.layeredarchitecture.dao.CrudDAO;
import lk.ijse.layeredarchitecture.dto.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailsDAO extends CrudDAO<OrderDetailDTO> {
    boolean save(String orderId, OrderDetailDTO detail) throws SQLException, ClassNotFoundException;

}