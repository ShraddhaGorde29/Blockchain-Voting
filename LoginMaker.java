/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package blockchainvoting;

import java.sql.*;

/**
 *
 * @author DELL
 */
public class LoginMaker {

    public boolean doLogin(String username,String Password)
    {
boolean flag=true;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st=conn.createStatement();

            String query="Select *from admininfo  where username='"+username+"'and Password='"+Password+"'";
            ResultSet rs=st.executeQuery(query);
        //aid, username, Password
            if(rs.next())
            {
                flag=true;
            }
 else
            {
                flag=false;
 }
            
                conn.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception in loginmaker"+e);
            flag=false;
        }

return flag;

    }
}
