package com.epam.uitest;

import com.controls.pages.surrounding.entities.CFType;
import com.epam.uitest.surrounding.DataProviders;
import com.epam.uitest.surrounding.InitTests;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.controls.JDITestSite.datesPage;
import static com.controls.pages.surrounding.enums.Preconditions.LOGIN;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;

public class DatesPageTest extends InitTests {
    private final String DEFAULT_TIME = "10:30 AM";
    private final String CHANGED_TIME = "11:45 PM";


    @BeforeTest
    public static void setUpBeforeTests() {
        isInState(LOGIN);
        datesPage.open();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "DatepickerFieldDatesPageTest")
    public void datepickerEnteringDataTest(String inputDate, String actualDate) {
        datesPage.datepicker.clear();
        datesPage.datepicker.sendKeys(inputDate);
        datesPage.contactForm.submit.click();
        Assert.areEquals(datesPage.calendarField.getText().
                substring(8, datesPage.calendarField.getText().length()), actualDate,
                "Unexpected result in result panel(\"period field\")");
    }

    @Test
    public void timepickerButtonsTest() {
        datesPage.datesPageClock.timepicker.clear();
        datesPage.datesPageClock.timepicker.sendKeys(DEFAULT_TIME);
        datesPage.contactForm.submit.click();
        datesPage.datesPageClock.clockButton.click();
        datesPage.datesPageClock.incrementHour.click();
        datesPage.datesPageClock.incrementMinute.click();
        datesPage.datesPageClock.toggleUpTimeSlot.click();
        datesPage.contactForm.submit.click();
        Assert.areEquals(datesPage.timeField.getText().
                substring(6, datesPage.timeField.getText().length()), CHANGED_TIME,
                "Unexpected result in result panel(\"time field\")");
        datesPage.datesPageClock.clockButton.click();
        datesPage.datesPageClock.decrementHour.click();
        datesPage.datesPageClock.decrementMinute.click();
        datesPage.datesPageClock.toggleDownTimeSlot.click();
        datesPage.contactForm.submit.click();
        Assert.areEquals(datesPage.timeField.getText().
                substring(6, datesPage.timeField.getText().length()), DEFAULT_TIME,
                "Unexpected result in result panel(\"time field\")");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "TimepickerFieldDatesPageTest")
    public void timepickerEnteringDataTest(String inputTime, String actualTime) {
        datesPage.datesPageClock.timepicker.clear();
        datesPage.datesPageClock.timepicker.sendKeys(inputTime);
        datesPage.contactForm.submit.click();
        Assert.areEquals(datesPage.timeField.getText().
                substring(6, datesPage.timeField.getText().length()), actualTime,
                "Unexpected result in result panel(\"time field\")");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "RangeFieldsDatesPageTest")
    public void rangeFieldsTest(String x, String y) {
        datesPage.range1From.input(x);
        datesPage.range1To.input(y);
        datesPage.contactForm.submit.click();
        datesPage.range1From.clear();
        datesPage.range1To.clear();
        Assert.areEquals(datesPage.range1Field.getText().substring(14, 14+String.valueOf(x).length()), String.valueOf(x),
                "Unexpected result in result panel(\"range1 field\")");
        Assert.areEquals(datesPage.range1Field.getText().substring(14+String.valueOf(x).length()+4,
                datesPage.range1Field.getText().length()), String.valueOf(y),
                "Unexpected result in result panel(\"range1 field\")");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "RollersDatesPageTest")
    public void rollersTest(int x, int y) {
        //Не работает в FF
        datesPage.setLeftRollerPosition(x);
        datesPage.setRightRollerPosition(y);
        datesPage.contactForm.submit.click();
        Assert.areEquals(datesPage.range2Field.getText().substring(14, 14+String.valueOf(x).length()), String.valueOf(x));
        Assert.areEquals(datesPage.range2Field.getText().substring(14+String.valueOf(x).length()+4,
                datesPage.range2Field.getText().length()), String.valueOf(y));
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "ContactFormTest")
    public void contactFormTest(CFType cFType) {
        datesPage.contactForm.submit(cFType);
        Assert.contains(datesPage.nameField.getText().substring(6, datesPage.nameField.getText().length()),
                cFType.nameField, "Unexpected result in result panel(\"name field\")");
        Assert.contains(datesPage.lastNameField.getText().substring(11, datesPage.lastNameField.getText().length()),
                cFType.lastNameField, "Unexpected result in result panel(\"last name field\")");
        Assert.contains(datesPage.descriptionField.getText().substring(13, datesPage.descriptionField.getText().length()),
                cFType.description, "Unexpected result in result panel(\"description field\")");
    }

    /*@Test
    public void inputFileLoadedTest() {
        datesPage.imageInput.input(getFPath());
        checkFileLoaded(datesPage.uploadedFileName.getText(), fileName());
    }

    @Test
    public void sendKeysFileLoadedTest() {
        datesPage.imageInput.sendKeys(getFPath());
        checkFileLoaded(datesPage.uploadedFileName.getText(), fileName());
    }

    @Test
    public void newInputFileLoadedTest() throws Exception {
        datesPage.imageInput.newInput(getFPath());
        checkFileLoaded(datesPage.uploadedFileName.getText(), fileName());
    }*/
}
