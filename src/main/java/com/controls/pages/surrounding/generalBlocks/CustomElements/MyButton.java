package com.controls.pages.surrounding.generalBlocks.CustomElements;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;


public class MyButton extends Button{
    public static int count;
    public static double timeSec;

    @Override
    public void clickAction() {
        long start = System.nanoTime();
        getWebElement().click();
        timeSec += (System.nanoTime() - start) / 1000000000.0;
        count++;
    }
}
