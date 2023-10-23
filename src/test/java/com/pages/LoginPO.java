package com.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.Assert.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertEquals;


public class LoginPO {

    private final String loginPageURL = "http://feature.12688.builder.abmcloud.us/login";
    private final String adminPageURL = "http://feature.12688.builder.abmcloud.us/admin";
    private SelenideElement loginEmailInput = $(By.id("user_email"));
    private SelenideElement loginPasswordInput = $(By.id("user_password"));
    private SelenideElement loginBtn = $(By.name("commit"));
    private SelenideElement loginWarning = $(".text-danger");
    private SelenideElement loginSuccessAlert = $(By.id("alert_dialog"));
    private SelenideElement addCompanyBtn = $(By.xpath("//a[@title='Add']"));


    public LoginPO openLoginPage(){
        Selenide.open(loginPageURL);
        return this;
    }

    public void assertLoginPageURL(){
        String url = WebDriverRunner.url();
        assertEquals(url, loginPageURL, "http://feature.12688.builder.abmcloud.us/login");
    }

    public void setUserEmail (String userEmail){
        loginEmailInput.should(be(visible));
        loginEmailInput.clear();
        loginEmailInput.val(userEmail);
    }
    public void setUserPassword (String userPassword){
        loginPasswordInput.should(be(visible));
        loginPasswordInput.clear();
        loginPasswordInput.val(userPassword);
    }
    public void clickLogIn (){
        loginBtn.should(be(visible));
        loginBtn.click();
    }

    public void assertLogIn (){
        loginSuccessAlert.should(be(visible));
        String url = WebDriverRunner.url();
        assertEquals(url, adminPageURL, "http://feature.12688.builder.abmcloud.us/admin");
    }

    public void assertWrongLoginCredentials(){
        loginWarning.should(be(visible));
    }

    public CreateNewCompanyPO setAddCompany(){
        addCompanyBtn.should(be(visible));
        addCompanyBtn.click();
        return new CreateNewCompanyPO();
    }
}
