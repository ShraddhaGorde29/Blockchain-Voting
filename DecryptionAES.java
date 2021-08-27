package aes;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.NoSuchAlgorithmException;


public class DecryptionAES
{


  public String decrypt(String text) throws Exception
  {
  	Key256Generation kg=new Key256Generation();
	SecretKeySpec spec = kg.getKeySpec();
	Cipher cipher = Cipher.getInstance("AES");
	cipher.init(Cipher.DECRYPT_MODE, spec);
	BASE64Decoder dec = new BASE64Decoder();
	String result=new String(cipher.doFinal(dec.decodeBuffer(text)));
	//System.out.println(result);
	return result;

  }


}
