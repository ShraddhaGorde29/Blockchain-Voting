/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castvote;

import aes.DecryptionAES;
import boothutility.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class ViewBoothVotes {
    
    
    public void getVoteDetails(String btname )
    {

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st1=(Statement) conn.createStatement();
            Statement st2=(Statement) conn.createStatement();

            String query="Select * from "+btname;

            ResultSet rs1=st1.executeQuery(query);
            ResultSet rs2=st2.executeQuery(query);
            int row=0;
            while(rs1.next())
            {
                row++;
            }

            int i=0;

            String[][] data=new String [row][4];
//boothnumber, serial_no, symbol_name, vote
            while(rs2.next())
            {
                String boothnum=rs2.getString(1);
                String serial_no=rs2.getString(2);
                String symbol_name=rs2.getString(3);
                String vote=rs2.getString(4);
         String boothnum1=new DecryptionAES().decrypt(boothnum);
           String serial_no1=new DecryptionAES().decrypt(serial_no);
             String symbol_name1=new DecryptionAES().decrypt(symbol_name);
               String vote1=new DecryptionAES().decrypt(vote);
                data[i][0]=boothnum1;
                data[i][1]=serial_no1;
                data[i][2]=symbol_name1;
                data[i][3]=vote1;
                

                i++;
            }
            ViewVotesFrame.data=data;
            conn.close();
        }
           // int x=st.executeUpdate(query);

        catch(Exception e)
        {
            System.out.println("Exception at DataFetcher"+e);

        }

      //return data;
    }
    
}
