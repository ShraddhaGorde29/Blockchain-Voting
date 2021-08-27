package aes;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.NoSuchAlgorithmException;


public class Key256Generation
{
	 public static SecretKeySpec getKeySpec() throws Exception
	 {
	byte[] bytes = new byte[16];
	File f = new File("aes_key");
	SecretKey key = null;
	SecretKeySpec sks = null;
	if (f.exists())
	{
	  new FileInputStream(f).read(bytes);
	}
	else
	{
	   KeyGenerator kgen = KeyGenerator.getInstance("AES");
	   kgen.init(256);
	   key = kgen.generateKey();
	   bytes = key.getEncoded();
	   new FileOutputStream(f).write(bytes);
	}
	sks = new SecretKeySpec(bytes,"AES");
	return sks;
  }


}
