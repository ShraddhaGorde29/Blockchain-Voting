package aes;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import sun.misc.*;

public class EncryptionAES
{

  public String encrypt(String text) throws Exception
   {
   	Key256Generation kg=new Key256Generation();
	SecretKeySpec spec = kg.getKeySpec();

	Cipher cipher = Cipher.getInstance("AES");
	cipher.init(Cipher.ENCRYPT_MODE, spec);
	BASE64Encoder enc = new BASE64Encoder();
	String result=enc.encode(cipher.doFinal(text.getBytes()));
//	System.out.println(result);
	return result;
  }



}
