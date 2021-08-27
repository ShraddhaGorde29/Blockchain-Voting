/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package castvote;

import aes.EncryptionAES;
import boothutility.BoothNumberFetcher;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utility.RandomNumGenerator;

/**
 *
 * @author 2491
 */
public class VoteInitializer {
    
    public void initializedVote() throws Exception
    {
        
         ArrayList boothinfo= new BoothNumberFetcher().getDetails();
         System.out.println("Booth table name "+boothinfo);
         
         ArrayList sn=new SymbolNameFetcher().getDetails();
         System.out.println("Symbol Name "+sn);
         
         int minvote=25,maxvote=100;
       
         for (int i = 0; i < boothinfo.size(); i++) 
         {
            String btname=(String) boothinfo.get(i);
            String bn[]=btname.split("_");
            String boothnum=bn[2];
            
          CastVoteMaker cvm=  new  CastVoteMaker();
            int nosvote=  new RandomNumGenerator().getRandomNumber(minvote, maxvote);
           
            
             for (int j = 0; j < nosvote; j++) 
             {
              int symnum=  new RandomNumGenerator().getRandomNumber(1, sn.size());
                 String syname=(String) sn.get(symnum-1);
              
                 int x=j+1;
                 String serialno=Integer.toString(x);
                String vote="yes";
                
               //  System.out.println("boothnum is "+boothnum+" serialno is "+serialno+" syname is "+syname+" btname is "+btname);
                
                 EncryptionAES eaes=new EncryptionAES();
              String  boothnumaes=eaes.encrypt(boothnum);
               String serialnoaes=eaes.encrypt(serialno);
               String synameaes=eaes.encrypt(syname);
              String  voteaes=eaes.encrypt(vote);
                                
                cvm.castYourVote(boothnumaes,serialnoaes, synameaes, voteaes, btname);
             }
             
             System.out.println("Voting for "+btname+" has finished");
       
         }
    
        
        JOptionPane.showMessageDialog(null, "Voting has been sucessfuly casted for all booths");
    }
    
}
