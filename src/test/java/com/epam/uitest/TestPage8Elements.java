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
        startPage.menu.clickMenu().typeUsername("epam").typePassword("1234").submitLogin();
        openSite("https://jdi-framework.github.io/tests/page8.htm");
        page8 = new Page8(driver);
    }

    @Test(groups = "page8", dataProviderClass = DataProviders.class, dataProvider = "forPage8Checkboxes")
    public void testPage8Checkboxes(boolean water, boolean earth, boolean wind, boolean fire){
        if (water == true)
            page8.waterCheckbox.check();
        if (earth == true)
            page8.earthCheckbox.check();
        if (wind == true)
            page8.windCheckbox.check();
        if (fire == true)
            page8.fireCheckbox.check();
        verify(page8.waterCheckbox.isChecked(), water);
        verify(page8.waterCheckbox.isChecked(), water);
        verify(page8.earthCheckbox.isChecked(), earth);
        verify(page8.windCheckbox.isChecked(), wind);
        verify(page8.fireCheckbox.isChecked(), fire);
    }

    @Test(groups = "page8", dataProviderClass = DataProviders.class, dataProvider = "forPage8Radiobuttons")
    public void testPage8Radiobuttons(boolean gold, boolean silver, boolean bronze, boolean selen){
        if (gold == true)
            page8.goldRadiobutton.check();
        if (silver == true)
            page8.silverRadiobutton.check();
        if (bronze == true)
            page8.bronzeRadiobutton.check();
        if (selen == true)
            page8.selenRadiobutton.check();
        verify(page8.goldRadiobutton.isChecked(), gold);
        verify(page8.silverRadiobutton.isChecked(), silver);
        verify(page8.bronzeRadiobutton.isChecked(), bronze);
        verify(page8.selenRadiobutton.isChecked(), selen);
    }
}
