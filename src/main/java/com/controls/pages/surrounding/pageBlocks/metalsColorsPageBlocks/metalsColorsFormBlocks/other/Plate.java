package com.controls.pages.surrounding.pageBlocks.metalsColorsPageBlocks.metalsColorsFormBlocks.other;

public class Plate {
    public static final Plate DEFAULT = new Plate();

    public String odds = "7";
    public String even = "8";
    public String[] elementsCheckList = new String[]{"Water", "Earth", "Wind", "Fire"};
    public String color = "Green";
    public String metalsComboBox = "Selen";
    public String[] saladDroplist = new String[]{"Cucumber", "Tomato", "Onion"};

    public Plate() {
    }

    public Plate(String odds, String even, String[] elementsCheckList,
                 String color, String metalsComboBox, String[] saladDroplist) {
        this.odds = odds;
        this.even = even;
        this.elementsCheckList = elementsCheckList;
        this.color = color;
        this.metalsComboBox = metalsComboBox;
        this.saladDroplist = saladDroplist;
    }
}
