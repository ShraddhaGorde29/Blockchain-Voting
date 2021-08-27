/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureaucrats;

import managecandidate.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class EditBureacratsMaker {
    public  boolean updateBureacats(String name,String des,String email,String mob)
    {
     boolean flag=false;
     
     //candidatename, age, sex, educationqualification, worth, profession, symbolname, partyname
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st=conn.createStatement();
           //name, desgination, emailid, mobile
            String query=" update bureaucratsinfo set desgination='"+des+"',emailid='"+email+"',mobile='"+mob+"' where name='"+name+"'";
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
