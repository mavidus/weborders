package com.weborders.pages;

import com.weborders.utilities.Config;
import com.weborders.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Menu{


        public LoginPage(){
            PageFactory.initElements(Driver.getDriver(),this);//this is current object
        }

        @FindBy(id="ctl00_MainContent_username")
        public WebElement username;

        @FindBy(id="ctl00_MainContent_password")
        public WebElement password;

        @FindBy(id="ctl00_MainContent_login_button")
        public WebElement lgn_Btn;

        @FindBy(id="ctl00_MainContent_status")
        public WebElement status;

        public void login(String usr, String psw){
            this.username.sendKeys(usr);
            this.password.sendKeys(psw);
            this.lgn_Btn.click();
        }

        public void open(){
            Driver.getDriver().get(Config.getProperty("url"));
        }


}
