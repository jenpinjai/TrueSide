/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tot.bill.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jennarong Pinjai
 */
public class LinePrint {
    
    private int fontId;
    private int px;
    private int py;
    private List<WordPrint> words = new ArrayList<WordPrint>();
    private boolean blockHead=false;
    private boolean block=false;

    public int getFontId() {
        return fontId;
    }

    public void setFontId(int fontId) {
        this.fontId = fontId;
    }

    public int getPx() {
        return px;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public int getPy() {
        return py;
    }

    public void setPy(int py) {
        this.py = py;
    }

    public List<WordPrint> getWords() {
        return words;
    }

    public void setWords(List<WordPrint> words) {
        this.words = words;
    }

    public boolean isBlockHead() {
        return blockHead;
    }

    public void setBlockHead(boolean blockHead) {
        this.blockHead = blockHead;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

   
    

    
    
    
}
