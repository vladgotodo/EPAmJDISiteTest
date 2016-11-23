package com.controls.pages.surrounding.fillingTypes;

public class DEType {
    public static final DEType DEFAULT = new DEType();

    public String[] elements = new String[]{"Water", "Fire"};
    public String metals = "Selen";
    public String colors = "Yellow";

    private DEType() {
    }


    public DEType(String[] elements, String metals, String colors) {
        this.elements = elements;
        this.metals = metals;
        this.colors = colors;
    }
}
