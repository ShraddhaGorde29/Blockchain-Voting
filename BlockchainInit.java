/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockchain;

import boothutility.BoothNumberFetcher;
import java.util.ArrayList;

/**
 *
 * @author 2491
 */
public class BlockchainInit {
    
    public String  initilizeKey(String key)
    {
        String firstkey=key;
        String prevkey=key;
        
        ArrayList boothtable=new BoothNumberFetcher().getDetails();
        
        System.out.println("Boooth Tables are "+boothtable);
        
        ArrayList sortednbooth= new BoothSorter().getSortedBooth(boothtable);
        
        System.out.println("After Sorting Boooth Tables are /n "+sortednbooth);
        ///Blockchain stared 
        
        System.out.println("\n \n Initial key :"+prevkey);
        for (int i = 0; i < sortednbooth.size(); i++) 
        {
            String btname=(String) sortednbooth.get(i);
            
            String pass=new BoothPassFetcher().getDetails(btname);
         //   System.out.println(" "+pass);
            
            String headkey=new BlockBody().getbodyHaskey(btname,prevkey,pass);
            
            System.out.println("Head key of "+btname+" is : "+headkey);
            
            prevkey=headkey;
            
        }
      
        return prevkey;

    }
    
    
}
