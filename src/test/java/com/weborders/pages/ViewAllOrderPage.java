package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewAllOrderPage extends Menu{
    public ViewAllOrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);//this is current object
    }

    @FindBy(linkText = "View all orders")
    public WebElement ViewAllOrders;

    @FindBy(xpath = "//h2")
    public WebElement title;

    @FindBy(linkText = "Check All")
    public WebElement CheckAll;

    @FindBy(linkText = "Uncheck All")
    public WebElement  UncheckAll;

    @FindBy(xpath="//table//tbody//td[2]//tr[2]")
    public WebElement firstTable;

    @FindAll(@FindBy(xpath="//table[@id='ctl00_MainContent_orderGrid']//th"))
    public List<WebElement> headers;

    @FindAll(@FindBy(xpath="//table[@id='ctl00_MainContent_orderGrid']//tr"))
    public List<WebElement> rows;








}
