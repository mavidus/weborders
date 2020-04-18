package com.weborders.utilities;



import com.weborders.pages.*;

//this class is alos singleton design we want to use same object class
public class Pages {

    private LoginPage loginPage;
    private ViewAllOrderPage viewAllOrderPage;
    private ViewAllProductsPage viewAllProductsPage;
    private OrderPage orderPage;
    private Menu menupage;


    public LoginPage login(){
        if(loginPage==null){
            loginPage=new LoginPage();
        }
        return loginPage;
    }


    public ViewAllOrderPage viewAllOrders(){
        if(viewAllOrderPage==null){
            viewAllOrderPage=new ViewAllOrderPage();
        }
        return viewAllOrderPage;
    }


    public ViewAllProductsPage viewAllProducts(){
        if(viewAllProductsPage==null){
            viewAllProductsPage=new ViewAllProductsPage();
        }
        return viewAllProductsPage;
    }


    public OrderPage order(){
        if(orderPage==null){
            orderPage=new OrderPage();
        }
        return orderPage;
    }

}
