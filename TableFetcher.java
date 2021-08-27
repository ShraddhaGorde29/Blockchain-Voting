/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package castvote;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author pratiksha
 */
public class TableFetcher {
    
    public ArrayList getDetails()
    {
       
        ArrayList ar= new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st=conn.createStatement();

            String query="Select * from allboothinfo";
            ResultSet rs=st.executeQuery(query);

           while(rs.next())
            {
                String boothnum=rs.getString(4);
                      
                ar.add(boothnum);
               
            }
            System.out.println("ar is  "+ar);
    
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
