package com.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertEquals;

public class CompanyPO {
    private SelenideElement availableTabs = $(".dropdown-toggle");
    private SelenideElement exchangeSelector = $(By.xpath("//a[text()='Exchange']"));
    private SelenideElement exchangeHostInput = $(By.id("exchange_storage_host"));
    private SelenideElement exchangePortInput = $(By.id("exchange_storage_port"));
    private SelenideElement exchangeLoginInput = $(By.id("exchange_storage_login"));
    private SelenideElement exchangePasswordInput = $(By.id("exchange_storage_password"));
    private SelenideElement exchangeThresholdInput = $(By.id("exchange_storage_threshold"));
    private SelenideElement exchangeUpdateBtn = $(".btn-success");
    private SelenideElement exchangeSuccessUpdate = $(".alert-success");
    private SelenideElement generalSelector = $(By.xpath("//a[text()='General']"));
    private SelenideElement deleteBtn = $(By.id("company_settings_delete_btn"));
    private SelenideElement submitDeleteBtn = $(By.id("submit-mass-delete"));
    private SelenideElement companySuccessDelete = $(".alert-success");
    private SelenideElement companyListNoData = $("h1");
    private SelenideElement companyContainer = $(".dhtmlx-grid-container");

    public void setExchangeSelector(){
        availableTabs.should(be(visible));
        availableTabs.hover();
        exchangeSelector.should(be(visible));
        exchangeSelector.click();
    }

    public void setExchangeHost(String host){
        exchangeHostInput.should(be(visible));
        exchangeHostInput.clear();
        exchangeHostInput.val(host);
    }

    public void setExchangePort(String port){
        exchangePortInput.should(be(visible));
        exchangePortInput.clear();
        exchangePortInput.val(port);
    }

    public void setExchangeLogin(String login){
        exchangeLoginInput.should(be(visible));
        exchangeLoginInput.clear();
        exchangeLoginInput.val(login);
    }

    public void setExchangePassword(String password){
        exchangePasswordInput.should(be(visible));
        exchangePasswordInput.clear();
        exchangePasswordInput.val(password);
    }

    public void setExchangeThreshold(String threshold){
        exchangeThresholdInput.should(be(visible));
        exchangeThresholdInput.clear();
        exchangeThresholdInput.val(threshold);
    }

    public void assertExchange(String host,String port,String login, String password, String threshold  ){
        exchangeUpdateBtn.should(be(visible));
        exchangeUpdateBtn.click();
        exchangeSuccessUpdate.should(be(visible));
        exchangeHostInput.shouldHave(value(host));
        exchangePortInput.shouldHave(value(port));
        exchangeLoginInput.shouldHave(value(login));
        exchangePasswordInput.shouldHave(value(password));
        exchangeThresholdInput.shouldHave(value(threshold));
    }

    // Workaround due to the lack of time this check is usable only if there are no companies left
    public void deleteCompany(){
        availableTabs.should(be(visible));
        availableTabs.hover();
        generalSelector.should(be(visible));
        generalSelector.click();
        deleteBtn.should(be(visible));
        deleteBtn.click();
        submitDeleteBtn.should(be(visible));
        submitDeleteBtn.click();
        companySuccessDelete.should(be(visible));
        companyListNoData.should(be(visible));
        companyContainer.shouldNotBe(Condition.exist);

     //   Selenide.switchTo().alert().accept();
    }




}
