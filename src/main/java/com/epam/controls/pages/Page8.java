package com.epam.controls.pages;

import com.epam.controls.pages.surrounding.BasePage;
import com.epam.controls.pages.surrounding.pageBlocks.Checkbox;
import com.epam.controls.pages.surrounding.pageBlocks.Radiobutton;
import org.openqa.selenium.WebDriver;

public class Page8 extends BasePage {
    private static final String URL_PAGE = "https://jdi-framework.github.io/tests/page8.htm";

    public Checkbox waterCheckbox;
    public Checkbox earthCheckbox;
    public Checkbox windCheckbox;
    public Checkbox fireCheckbox;
    public Radiobutton goldRadiobutton;
    public Radiobutton silverRadiobutton;
    public Radiobutton bronzeRadiobutton;
    public Radiobutton selenRadiobutton;

    public Page8(WebDriver driver) {
        super(driver);

        waterCheckbox = new Checkbox(driver, "Water");
        earthCheckbox = new Checkbox(driver, "Earth");
        windCheckbox = new Checkbox(driver, "Wind");
        fireCheckbox = new Checkbox(driver, "Fire");
        goldRadiobutton = new Radiobutton(driver, "Gold");
        silverRadiobutton = new Radiobutton(driver, "Silver");
        bronzeRadiobutton = new Radiobutton(driver, "Bronze");
        selenRadiobutton = new Radiobutton(driver, "Selen");
    }

    public void open(){
        driverS.navigate().to(URL_PAGE);
    }

    public void setAllCheckboxesStates(boolean water, boolean earth, boolean wind, boolean fire){
        waterCheckbox.setState(water);
        earthCheckbox.setState(earth);
        windCheckbox.setState(wind);
        fireCheckbox.setState(fire);
    }

    public void setAllRadiobuttonsStates(boolean gold, boolean silver, boolean bronze, boolean selen){
        goldRadiobutton.setState(gold);
        silverRadiobutton.setState(silver);
        bronzeRadiobutton.setState(bronze);
        selenRadiobutton.setState(selen);
    }
}
