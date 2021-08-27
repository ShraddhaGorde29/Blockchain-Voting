


package bureaucrats;
import managecandidate.*;
import java.sql.*;


public class ViewBureaucrats {

   public void viewData() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting", "root", "root");
            Statement st1 = conn.createStatement();
            Statement st2 = conn.createStatement();

            String query = "Select *from bureaucratsinfo ";
            ResultSet rs1 = st1.executeQuery(query);
            ResultSet rs2 = st2.executeQuery(query);
            //name, Dob, address, emailid, mobile, subject, class, staffid, password
            int row = 0;

            while (rs1.next()) {
              
               {
                    row++;
                }
            }
            
  //name, desgination, emailid, mobile       
            String data[][] = new String[row][4];
            int i = 0;
            while (rs2.next()) {
                String name = rs2.getString("name");
                String desgination = rs2.getString("desgination");
                String emailid = rs2.getString("emailid");
                String mobile = rs2.getString("mobile");
 
                {
                data[i][0] = name;
                data[i][1] = desgination;
                data[i][2] = emailid;
                data[i][3] = mobile;
            
                i++;


            }
            ViewBureaucratsFrame.alldata = data;

            }
            conn.close();

        }
        catch (Exception e) {
            System.out.println("Exception in datafetcher" + e);
        }

    }


   

}
