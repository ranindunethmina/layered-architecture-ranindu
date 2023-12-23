package com.example.layeredarchitecture.bo;


import com.example.layeredarchitecture.bo.custom.impl.customerBOImpl;
import com.example.layeredarchitecture.bo.custom.impl.itemBOImpl;
import com.example.layeredarchitecture.bo.custom.impl.placeOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory (){

    }
    public static BOFactory getBoFactory(){
        return (boFactory==null) ? boFactory = new BOFactory():boFactory;
    }

    public enum BOTypes{
        CUSTOMER,ITEM,PLACEORDER
    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new customerBOImpl();
            case ITEM:
                return new itemBOImpl();
            case PLACEORDER:
                return new placeOrderBOImpl();
            default:
                return null;
        }
    }
}
