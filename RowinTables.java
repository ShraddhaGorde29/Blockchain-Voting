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

/**
 *
 * @author 2491
 */
public class RowinTables {
    
    public int countTheRows ( String btname )
    {
        int count=0;
    try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st=conn.createStatement();

            String query="select count(*) from "+btname;
            ResultSet rs=st.executeQuery(query);
            
                rs.next();
              count = rs.getInt(1);
            

            
            conn.close();
           
    
        }
         
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
    return count;
    }
}
