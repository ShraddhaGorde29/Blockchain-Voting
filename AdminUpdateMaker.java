

package blockchainvoting;
import java.sql.*;


public class AdminUpdateMaker {

     public boolean UpdateAdminInfo(String username,String Password)
    {
boolean flag=true;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st=conn.createStatement();
            
            String query="update admininfo set  password='"+Password+"' where username='"+username+"' " ;
            int x=st.executeUpdate(query);
        //aid, username, password  admininfo
            if(x>0)
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
            System.out.println("Exception in AdminUpdateMaker"+e);
            flag=false;
        }

return flag;

    }

}
