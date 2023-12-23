package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.*;
import com.example.layeredarchitecture.dao.custom.impl.*;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;
import com.example.layeredarchitecture.util.TransactionConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class placeOrderBOImpl implements placeOrderBO{
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    OrderDetailsDAO orderDetailDAO = (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAIL);
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        boolean isOrderSaved;
        boolean isOrderDetailSaved = false;
        boolean isItemUpdated = false;

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(orderId);
        orderDTO.setOrderDate(orderDate);
        orderDTO.setCustomerId(customerId);
//        try {
            orderDAO.selectOrderId(orderId);

            TransactionConnection.getConnection().setAutoCommit(false);
            isOrderSaved = orderDAO.save(orderDTO);

            for (OrderDetailDTO detail : orderDetails) {
                isOrderDetailSaved = orderDetailDAO.save(orderId, detail);

                //                //Search & Update Item
                ItemDTO item = findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                isItemUpdated = itemDAO.update(item);
            }

            if (isOrderSaved && isOrderDetailSaved && isItemUpdated) {
                TransactionConnection.getConnection().commit();
                TransactionConnection.getConnection().setAutoCommit(true);
                return true;
            }

//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        return false;
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search(id);
    }

    @Override
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.search(code);
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    @Override
    public ResultSet generateOrderID() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewOrderId();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    public ItemDTO findItem(String code) {
        try {

            ItemDTO dto = itemDAO.search(code);

            return new ItemDTO(code,
                    dto.getDescription(),
                    dto.getUnitPrice(),
                    dto.getQtyOnHand()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
