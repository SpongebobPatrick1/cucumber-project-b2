package com.loop.step_definitions;

import com.loop.pages.HomePage;
import com.loop.pages.LeadsPage;
import com.loop.pages.LoginPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.DocuportConstants;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

public class DocuportStepDefs {


    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    LeadsPage leadsPage = new LeadsPage();

    @Then("rows per page shows by default {int}")
    public void rows_per_page_shows_by_default(Integer defaultRowsPerPage) {

        defaultRowsPerPage = 10;
        assertEquals(defaultRowsPerPage,leadsPage.getRowsPerPageAmount()); //Gets current amount
    }
    @Then("change rows per page to {int}")
    public void change_rows_per_page_to(Integer expectedRowsPerPage) {
        expectedRowsPerPage = 5;
        BrowserUtils.waitForClickable(leadsPage.rowsPerPageAmount, DocuportConstants.large).click();
        BrowserUtils.waitForVisibility(leadsPage.rowsPerPageList.get(0),DocuportConstants.large);
        leadsPage.changeRowsPerPageAmount(expectedRowsPerPage);
        assertEquals(expectedRowsPerPage,leadsPage.getRowsPerPageAmount()); //Validate rows per page was changed
    }
}
