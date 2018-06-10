/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.test;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Jennarong Pinjai
 */
public class TimeDurationTest {
    
    
    private  int count=0;
    public static void main(String[] args) throws Exception{
        
    double test = 78.32;
    
    System.out.println(String.format("%014.2f", 0f));
        
    }
    public static void printSubString(List list,int head,int tail){
    
            List subList = list.subList(head, tail);
            for(String str:(List<String>)subList){
            
                System.out.print(str+" ");
            }
            System.out.println();
        
    }
    public static boolean isPrintSeqBusy = false;
    public synchronized void increCount() throws Exception{
            
            this.setCount(this.getCount()+1);
        
    }

    public synchronized int getCount() {
        return count;
    }

    public synchronized void setCount(int count) {
        this.count = count;
    }
    
    public static void println(String text){
        System.out.println(text);
    }

}