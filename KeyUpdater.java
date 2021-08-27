/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import bureaucrats.*;
import managecandidate.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class KeyUpdater {
    public  boolean updatekey(String sr,String key,String datetime,String finalkey)
    {
     boolean flag=false;
     
     //Srno, openkey, date/time
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st=conn.createStatement();
           //name, desgination, emailid, mobile
            String query=" update keyinfo set openkey='"+key+"',datetime='"+datetime+"' ,finalkey='"+finalkey+"' where srno='"+sr+"'";
           int x=st.executeUpdate(query);
           if(x>0)
               flag=true;
           else
               flag=false;
           
           
           
           
           conn.close();
           
           
        }
        catch(Exception e)
        {
            System.out.println("Exception in Updater"+e);
        flag=false;
        }
       return flag;
    }
    
}
