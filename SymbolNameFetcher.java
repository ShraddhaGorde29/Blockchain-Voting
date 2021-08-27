/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package castvote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 2491
 */
class SymbolNameFetcher {

  public ArrayList getDetails()
  {
        
         ArrayList ar= new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st=conn.createStatement();

            String query="Select * from candidateinfo";
            ResultSet rs=st.executeQuery(query);

           while(rs.next())
            {
                String boothnum=rs.getString(7);
                      
                ar.add(boothnum);
               
            }
       //     System.out.println("ar is  "+ar);
    conn.close();
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
         return ar;
      
    }
  
    }
    

