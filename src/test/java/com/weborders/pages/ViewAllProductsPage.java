package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAllProductsPage extends Menu {

    public ViewAllProductsPage(){
        PageFactory.initElements(Driver.getDriver(),this);//this is current object
    }


    @FindBy(xpath = "//h2")
    public WebElement title;
}
