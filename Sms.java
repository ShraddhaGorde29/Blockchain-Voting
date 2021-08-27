/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sms;

/**
 *
 * @author 1450
 */
public class Sms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        String msg="hii bachhan";
        String number="919545945590";
        
       String str= new sendSMS().sendText(msg, number);
        System.out.println(str);
    }
    
}
