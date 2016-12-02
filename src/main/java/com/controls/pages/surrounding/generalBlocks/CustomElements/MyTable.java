package com.controls.pages.surrounding.generalBlocks.CustomElements;

import com.epam.jdi.uitests.web.selenium.elements.complex.table.Column;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Row;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.interfaces.ICell;

public class MyTable extends Table {
    public static int count;
    public static double timeSec;

    @Override
    public ICell cell(Column column, Row row) {
        long start = System.nanoTime();
        ICell result = super.cell(column,row);
        timeSec += (System.nanoTime() - start) / 1000000000.0;
        count++;
        return result;
    }
}
