package com.epam.ta.test;

import com.epam.ta.model.Engine;
import com.epam.ta.model.Search;
import com.epam.ta.page.CloudHomePage;
import com.epam.ta.service.EngineCreator;
import com.epam.ta.service.SearchCreator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GoogleCloudEmailTest extends CommonConditions {

    @Test
    public void testTotalEstimatedCostFromEmail() {
        Search testSearch = SearchCreator.withSearchFromProperty();
        Engine testEngine = EngineCreator.withEngineFromProperty();
        new CloudHomePage(driver)
                .openPage()
                .enterTermInTneSearchBox(testSearch)
                .submitSearchBoxRequest()
                .openGoogleCloudCalculatorLink()
                .switchFrame()
                .addNumberOfInstances(testEngine)
                .chooseOperatingSystem()
                .chooseVMClass()
                .chooseInstanceType()
                .chooseAddGPUs()
                .chooseNumberOfGPUs()
                .chooseGPUType()
                .chooseLocalSSD()
                .chooseDatacenterLocation()
                .chooseCommitedUsage()
                .clickAddToEstimate()
                .clickOnEmailEstimate()
                .openTenMinuteMailHomePage();
        String email = tenMinuteMailHomePage.getEmailAddress();
        cloudPricingCalculatorPage
                .swithToFirstOpenedWindow()
                .switchFrame()
                .pasteEmailFromTenMinuteMail(email)
                .clickOnSendEmail()
                .swithchToNewOpenedWindow()
                .clickToOpenMail();
        String totalEstimatedCostFromEmail = tenMinuteMailHomePage.getTotalEstimatedCostFromMail();
        cloudPricingCalculatorPage
                .swithToFirstOpenedWindow()
                .switchFrame()
                .getTotalEstimatedCost();
        String totalEstimatedCost = cloudPricingCalculatorPage.getTotalEstimatedCost();

        assertTrue(totalEstimatedCost.contains(totalEstimatedCostFromEmail));
    }
}
