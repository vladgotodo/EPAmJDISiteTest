package com.epam.uitest;

import com.epam.controls.pages.Page8;
import com.epam.controls.pages.StartPage;
import com.epam.uitest.surrounding.BaseTest;
import com.epam.uitest.surrounding.DataProviders;
import org.testng.annotations.*;

public class TestPage8Elements extends BaseTest{
    private StartPage startPage;
    private Page8 page8;

    @BeforeMethod
    public void thisPageSetup(){
        startPage = new StartPage(driver);
        startPage.open();
        startPage.menu.clickMenu().
                typeUsername("epam").
                typePassword("1234").
                submitLogin();
        page8 = new Page8(driver);
        page8.open();
    }

    @Test(groups = "page8", dataProviderClass = DataProviders.class, dataProvider = "forPage8Checkboxes")
    public void testPage8Checkboxes(boolean water, boolean earth, boolean wind, boolean fire){
        page8.setAllCheckboxesStates(water, earth, wind, fire);
        verify(page8.waterCheckbox.isChecked(), water);
        verify(page8.earthCheckbox.isChecked(), earth);
        verify(page8.windCheckbox.isChecked(), wind);
        verify(page8.fireCheckbox.isChecked(), fire);
    }

    @Test(groups = "Page8", dataProviderClass = DataProviders.class, dataProvider = "forPage8Radiobuttons")
    public void testPage8Radiobuttons(boolean gold, boolean silver, boolean bronze, boolean selen){
        page8.setAllRadiobuttonsStates(gold, silver, bronze, selen);
        verify(page8.goldRadiobutton.isChecked(), gold);
        verify(page8.silverRadiobutton.isChecked(), silver);
        verify(page8.bronzeRadiobutton.isChecked(), bronze);
        verify(page8.selenRadiobutton.isChecked(), selen);
    }
}
