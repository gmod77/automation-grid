package org.urbandaddy.helpers;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HMacHelper {
    private static final String ALGORITHM = "HMACMD5";

    public static String tokenGenerate(String message, String jobId) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
//        String message = "example_user:123456-1234-4268-asdf-8dcf81f1fc71";
//        String jobId = "5f9fef27854ca50a3c132ce331cb6034";
        SecretKeySpec secretKey = new SecretKeySpec(message.getBytes(), ALGORITHM);

        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        byte[] result = mac.doFinal(jobId.getBytes());

        System.out.println("I generated Token: " + toHexString(result));
        return toHexString(result);
    }

    public static String toHexString(byte[] bytes) {
        StringBuffer hash = new StringBuffer();
        for (int i=0; i<bytes.length; i++) {
            String hex = Integer.toHexString(0xFF &  bytes[i]);
            if (hex.length() == 1) {
                hash.append('0');
            }
            hash.append(hex);
        }
        return hash.toString();
    }
}
