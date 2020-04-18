package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrderPage extends Menu {
    public OrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);//this is current object
    }

    @FindBy(linkText = "Order")
    public WebElement ordertab;

    @FindBy(xpath = "//h2")
    public WebElement title;

    @FindBy(id="ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement product;

    @FindBy(id="ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;

    @FindBy(id="ctl00_MainContent_fmwOrder_txtDiscount")
    public WebElement discount;

    @FindBy(xpath="//input[@value='Calculate']")
    public WebElement calculate;

    @FindBy(id="ctl00_MainContent_fmwOrder_RegularExpressionValidator1")
    public WebElement errMsg;


    @FindBy(id="ctl00_MainContent_fmwOrder_txtName")
    public WebElement CustomerName;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement Street;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement city;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement state;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zip;

    @FindBy(id="ctl00_MainContent_fmwOrder_cardList_1")
    public WebElement card;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNmbr;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expire;

    @FindBy(id="ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement process;





}

