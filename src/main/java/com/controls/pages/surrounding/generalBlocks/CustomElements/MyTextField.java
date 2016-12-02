package com.controls.pages.surrounding.generalBlocks.CustomElements;

import com.epam.jdi.uitests.web.selenium.elements.common.TextField;

public class MyTextField extends TextField {
    public static int count;
    public static double timeSec;

    @Override
    protected String getTextAction() {
        long start = System.nanoTime();
        String result = super.getTextAction();
        timeSec += (System.nanoTime() - start) / 1000000000.0;
        count++;
        return result;
    }
}
