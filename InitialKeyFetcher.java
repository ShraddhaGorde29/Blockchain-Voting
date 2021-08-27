/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockchain;

import boothutility.MD5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author 2491
 */
public class InitialKeyFetcher {
    
    
    public String   getInkey()
    {
         String inkey="";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st=conn.createStatement();

            String query="Select * from keyinfo ";
            ResultSet rs=st.executeQuery(query);
                String data="";
           if(rs.next())
            {
                

                   inkey=rs.getString(2);
              
            }
          
           
           
    conn.close();
        }
           
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return inkey;
    }
        
        
        
        
        
        
        
        
    }
