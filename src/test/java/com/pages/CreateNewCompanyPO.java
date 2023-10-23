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

public class CreateNewCompanyPO {
    private final String createNewCompanyURL = "http://feature.12688.builder.abmcloud.us/admin/companies/new";
    private SelenideElement companyNameInput = $(By.id("company_name"));
    private SelenideElement companySystemNameInput = $(By.id("company_system_name"));
    private SelenideElement createCompanyBtn = $(By.name("commit"));

    public void assertCreateNewCompanyURL(){
        String url = WebDriverRunner.url();
        assertEquals(url, createNewCompanyURL, "http://feature.12688.builder.abmcloud.us/admin/companies/new");
    }
    public void setCompanyName (String companyName){
        companyNameInput.should(be(visible));
        companyNameInput.clear();
        companyNameInput.val(companyName);
    }
    public void setCompanySystemName (String companySystemName) {
        companySystemNameInput.should(be(visible));
        companySystemNameInput.clear();
        companySystemNameInput.val(companySystemName);
    }

    public CompanyPO createNewCompany (){
       createCompanyBtn.should(be(visible));
       createCompanyBtn.click();
       return new CompanyPO();
    }
}
