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
import java.util.ArrayList;

/**
 *
 * @author 2491
 */
public class MobileNumberFetcher {
    
    
    public ArrayList   getMobkey()
    {
       ArrayList mo=new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st=conn.createStatement();

            String query="Select * from bureaucratsinfo ";
            ResultSet rs=st.executeQuery(query);
             
           while(rs.next())
            {
                

                  String mob=rs.getString(4);
                  
                  
                  mo.add(mob);
              
            }
      
    conn.close();
        }
           
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return mo;
    }
        
        
        
        
        
        
        
        
    }
