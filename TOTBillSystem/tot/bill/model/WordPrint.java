/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tot.bill.model;

/**
 *
 * @author Jennarong Pinjai
 */
public class WordPrint {
    
    private int  fontId;
    private String text;
    private int  px;
    private boolean isNumber=false;
    private boolean isPullRight=false;
    private String format;

    public int getFontId() {
        return fontId;
    }

    public void setFontId(int fontId) {
        this.fontId = fontId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPx() {
        return px;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public boolean isIsNumber() {
        return isNumber;
    }

    public void setIsNumber(boolean isNumber) {
        this.isNumber = isNumber;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isIsPullRight() {
        return isPullRight;
    }

    public void setIsPullRight(boolean isPullRight) {
        this.isPullRight = isPullRight;
    }
    
    
    
}
