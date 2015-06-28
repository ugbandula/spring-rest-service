package com.test.springrest.shared;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Bandula Gamage on 28/06/2015.
 */
public class EncriptUtils {

    private static BASE64Encoder base64Encoder = new BASE64Encoder();
    private static BASE64Decoder base64Decoder = new BASE64Decoder();
    private static String characterEncode = "UTF-8";

    public static String toMD5String(String message) {

        MessageDigest md5				= null;
        byte[] 			digestMsgByte	= null;
        StringBuilder 	verifyMsg		= null;
        String 			result 			= null;
        String 			hexString		= null;
        int 			hexChar;

        try {
            md5 = MessageDigest.getInstance("MD5");
            digestMsgByte = md5.digest(message.getBytes());
            verifyMsg = new StringBuilder();
            for (int i = 0; i < digestMsgByte.length; i++) {
                hexChar = 0xFF & digestMsgByte[i];
                hexString = Integer.toHexString(hexChar);
                if (hexString.length() == 1) {
                    verifyMsg.append("0");
                    verifyMsg.append(hexString);
                }
                else {
                    verifyMsg.append(hexString);
                }
                hexString = null;
            }
            result = verifyMsg.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            result = null;
        }

        md5 = null;
        digestMsgByte = null;
        verifyMsg = null;
        hexString = null;

        return result;
    }

    public static String encodeURL(String dataString) throws Exception {
        return java.net.URLEncoder.encode(base64Encoder.encode(dataString.getBytes(characterEncode)));
    }

    public static String encode(String dataString) throws Exception {
        return base64Encoder.encode(dataString.getBytes(characterEncode));
    }

    public static String decode(String encodedDataString) {
        return decrypt(encodedDataString);
    }

    public static String decrypt(String encodedEncryptedDataString) {
        try {
            byte[] encryptedDataStringBytes = base64Decoder.decodeBuffer(encodedEncryptedDataString);
            return new String(encryptedDataStringBytes, characterEncode);
        } catch (IOException e) {
            return null;
        }
    }

    public static String reverseEncription(String encodedString) {
        String result = "";
        result = encodedString.replaceAll("9572", "=");
        result = result.replaceAll("3687", "&");
        result = decode(result.substring(7));

        return result;
    }

    public static String encodeString(String myString) {
        byte[] KEY = "ahfaewry8q37894yrfegfjkBDJbhdFGQ3YRUgddbBFDFGSETN4ETIQ7RQYEFsavbsdcndkvndksniowuryqytE8GShdyr94wryqwdhjbfawfjh[qsrpefsafnawur4w8yr8qwgfsbcdsnc'aJD[w8eyrfsdcbascae3rpweyffgsdbvkzbvasueryeaifdhsjbc/s;kfdhgptpwrewhdbscS:oiruehfsbvCba;sehyriehfefdjbskFchse".getBytes();
        int KEY_LEN = KEY.length;
        String output = null;
        try {
            int START = 0;

            byte[] data;
            data = myString.getBytes();
            for (int i = START; i < data.length; ++i) {
                int tmp46_44 = i;
                byte[] tmp46_43 = data;
                tmp46_43[tmp46_44] = (byte) (tmp46_43[tmp46_44] ^ KEY[((i - START) % KEY_LEN)]);
            }
            output = new String(data);
            return output;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

}
