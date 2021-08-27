


package managecandidate;
import java.sql.*;


public class ViewCandidate {

   public void viewData() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting", "root", "root");
            Statement st1 = conn.createStatement();
            Statement st2 = conn.createStatement();

            String query = "Select *from candidateinfo ";
            ResultSet rs1 = st1.executeQuery(query);
            ResultSet rs2 = st2.executeQuery(query);
            //name, Dob, address, emailid, mobile, subject, class, staffid, password
            int row = 0;

            while (rs1.next()) {
              
               {
                    row++;
                }
            }
            
  //candidatename, age, sex, educationqualification, worth, profession, symbolname, partyname         
            String data[][] = new String[row][8];
            int i = 0;
            while (rs2.next()) {
                String candidatename = rs2.getString("candidatename");
                String age = rs2.getString("age");
                String sex = rs2.getString("sex");
                String educationqualification = rs2.getString("educationqualification");
                 String worth = rs2.getString("worth");
              
                String profession = rs2.getString("profession");
                
                 String symbolname = rs2.getString("symbolname");
                 String partyname = rs2.getString("partyname");



 //name, Dob, address, emailid, mobile, class, studentid, password
                {
                data[i][0] = candidatename;
                data[i][1] = age;
                data[i][2] = sex;
                data[i][3] = educationqualification;
                data[i][4] = worth;
                data[i][5] = profession;
                data[i][6] = symbolname;
                  data[i][7] = partyname;
                i++;


            }
            ViewCandidateFrame.alldata = data;

            }
            conn.close();

        }
        catch (Exception e) {
            System.out.println("Exception in datafetcher" + e);
        }

    }


   

}
