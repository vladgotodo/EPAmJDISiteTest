package com.controls.pages.surrounding.pageBlocks;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class DatesPageClock extends Section {
    @FindBy(css = ".fa.fa-clock-o")
    public IButton clockButton;
    @FindBy(id = "timepicker")
    public ITextField timepicker;
    @FindBy(css = "a[data-action=incrementHour]")
    public IButton incrementHour;
    @FindBy(css = "a[data-action=decrementHour]")
    public IButton decrementHour;
    @FindBy(css = "a[data-action=incrementMinute]")
    public IButton incrementMinute;
    @FindBy(css = "a[data-action=decrementMinute]")
    public IButton decrementMinute;
    @FindBy(css = "a[data-action=toggleMeridian]>.fa.fa-chevron-up")
    public IButton toggleUpTimeSlot;
    @FindBy(css = "a[data-action=toggleMeridian]>.fa.fa-chevron-down")
    public IButton toggleDownTimeSlot;

    public String changeDaytime(String daytime) {
        if(daytime.equals("AM"))
            daytime = "PM";
        else
            daytime = "AM";
        return daytime;
    }
}
