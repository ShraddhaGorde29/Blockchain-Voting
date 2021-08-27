
package blockchainvoting;

import java.awt.Dimension;
import java.awt.Toolkit;


public class BlockchainVoting {

 
    public static void main(String[] args) {
               Dimension d=Toolkit.getDefaultToolkit().getScreenSize();

    LoginFrame l=new LoginFrame();
    l.setVisible(true);
    l.setSize(d);
    
        
    }
    
}
