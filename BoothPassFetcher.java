/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package blockchain;
import boothutility.*;
import blockchainvoting.*;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author pratiksha
 */
public class BoothPassFetcher {
    
    public String getDetails(String btname)
    {
       //boothnum, boothoffname, offpassword, tablename
      String pass="";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st=conn.createStatement();

            String query="Select * from allboothinfo where tablename='"+btname+"'";
            ResultSet rs=st.executeQuery(query);

           if(rs.next())
            {
                 pass=rs.getString(3);
            
            }
       //     System.out.println("ar is  "+ar);
    conn.close();
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
      return pass;
    }

}
