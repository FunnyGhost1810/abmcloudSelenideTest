package com.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.pages.CompanyPO;
import com.pages.CreateNewCompanyPO;
import com.pages.LoginPO;
import org.testng.annotations.*;

public class ambCloudTests {

    private final String userEmail = "kda.zemtsy@gmail.com";
    private final String userPass = "123456qwerty";

    private final String wrongUserEmail = "email";
    private final String wrongUserPass = "pass";

    private final String companyName = "companyName" + System.currentTimeMillis();
    private final String systemCompanyName = "systemCompanyName" + System.currentTimeMillis();

    private final String exchangeHost = "builder.abmcloud.us";
    private final String exchangePort = "21";
    private final String exchangeLogin = "test";
    private final String exchangePassword = "test";
    private final String exchangeThreshold = "0";
    LoginPO loginPO = new LoginPO();

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
    }

    @Test(priority = 1)
    public void loginPositiveCheck() {
        loginPO
                .openLoginPage()
                .assertLoginPageURL();

        loginPO.setUserEmail(userEmail);
        loginPO.setUserPassword(userPass);
        loginPO.clickLogIn();
        loginPO.assertLogIn();
    }

    @Test(priority = 2)
    public void loginNegativeCheck() {
        loginPO
                .openLoginPage()
                .assertLoginPageURL();

        loginPO.setUserEmail(wrongUserEmail);
        loginPO.setUserPassword(wrongUserPass);
        loginPO.clickLogIn();
        loginPO.assertWrongLoginCredentials();
    }

    @Test(priority = 3)
    public void companyExchangeSetUp() {
        loginPO
                .openLoginPage()
                .assertLoginPageURL();

        loginPO.setUserEmail(userEmail);
        loginPO.setUserPassword(userPass);
        loginPO.clickLogIn();
        loginPO.assertLogIn();
        CreateNewCompanyPO createNewCompanyPO = loginPO.setAddCompany();
        createNewCompanyPO.assertCreateNewCompanyURL();
        createNewCompanyPO.setCompanyName(companyName);
        createNewCompanyPO.setCompanySystemName(systemCompanyName);
        CompanyPO companyPO = createNewCompanyPO.createNewCompany();
        companyPO.setExchangeSelector();
        companyPO.setExchangeHost(exchangeHost);
        companyPO.setExchangePort(exchangePort);
        companyPO.setExchangeLogin(exchangeLogin);
        companyPO.setExchangePassword(exchangePassword);
        companyPO.setExchangeThreshold(exchangeThreshold);
        companyPO.assertExchange(exchangeHost, exchangePort, exchangeLogin, exchangePassword, exchangeThreshold);
        companyPO.deleteCompany();

    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
