package com.xaltius.be.model;

import java.awt.Color;

public enum Colors {
    LIGHTBLUE(	173, 216, 230),
    LIGHTRED(230, 187, 173),
    GREY(198, 198, 198);

    private final int red;
    private final int green;
    private final int blue;

    private Colors(final int r,final int g,final int b) {
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    private Color getColor(){
        return new Color(red, green, blue);
    }

    public String getHexCode(){
       return "#"+Integer.toHexString(getColor().getRGB()).substring(2);
    }
}
