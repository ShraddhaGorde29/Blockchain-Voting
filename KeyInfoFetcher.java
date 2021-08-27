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
public class KeyInfoFetcher {
    
    
    public ArrayList   getInfo()
    {
        ArrayList ar=new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st=conn.createStatement();

            String query="Select * from keyinfo ";
            ResultSet rs=st.executeQuery(query);
                String data="";
           while(rs.next())
            {
                 String  firstkey=rs.getString(2);
                 String  datetime=rs.getString(3);
                  String  finalkey=rs.getString(4);
                  
                  ar.add(firstkey);
                  ar.add(datetime);
                  ar.add(finalkey);
              
            }
          
           
           
    conn.close();
        }
           
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return ar;
    }
        
        
        
        
        
        
        
        
    }
