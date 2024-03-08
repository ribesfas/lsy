package com.sopromadze.blogapi.utils;

import org.bouncycastle.jce.provider;
/*Bouncy Castle : 보안 기능 프레임워크 */


import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
/*javax.crypto 패키지에서 제공되는 Cipher 클래스 : 데이터를 암호화한다.  */
import javax.crypto.spec.IvParameterSpec;
/*초기화 백터를 지정하기 위한 클래스, 초기화 벡터를 생성하고 관리하는데 사용됨, 대칭 암호화*/

import javax.crypto.spec.SecretKeySpec;
/*SecretKeySpec : 암호화 알고리즘에 사용될 비밀 키를 지정하기 위한 클래스 */
import java.nio.charset.StandardCharsets; 
/*StandardCharsets 문자 인코딩으로 되어 있다,  */
import java.security.SecureRandom;
/*java.util 패키지에서 제공, 보안 랜덤 바이트 생성.  */
import java.security.Security;
import java.util.Base64;
/*java.util 패키지에서 제공되는 Base64 클래스 : 바이너리 데이터를 텍스트 형식으로 인코딩하거나 디코딩한다.  */

public class AESUtils {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "YOUR_KEY";

    public static String decrypt(String encryptedPayload) {
        try {
            String iv = encryptedPayload.substring(0, 24);
            String encryptedData = encryptedPayload.substring(24);

            byte[] keyBytes = KEY.getBytes(StandardCharsets.UTF_8);
            byte[] ciphertextBytes = encryptedData.getBytes();
            byte[] ivBytes = Base64.getDecoder().decode(iv);

            Security.addProvider(new BouncyCastleProvider());

            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            IvParameterSpec ivParams = new IvParameterSpec(ivBytes);

            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParams);

            byte[] decodedData = Base64.getDecoder().decode(ciphertextBytes);
            byte[] decryptedBytes = cipher.doFinal(decodedData);
            return new String(decryptedBytes, StandardCharsets.UTF_8).trim();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String message) {
        try {
            byte[] keyBytes = KEY.getBytes(StandardCharsets.UTF_8);
            byte[] plaintextBytes = message.getBytes(StandardCharsets.UTF_8);
            byte[] ivBytes = new byte[16];

            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(ivBytes);

            Security.addProvider(new BouncyCastleProvider());

            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            IvParameterSpec ivParams = new IvParameterSpec(ivBytes);

            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParams);

            byte[] encryptedBytes = cipher.doFinal(plaintextBytes);
            byte[] encodedData = Base64.getEncoder().encode(encryptedBytes);
            byte[] encodedIV = Base64.getEncoder().encode(ivBytes);

            String encryptedData = new String(encodedData, StandardCharsets.UTF_8);
            String encodedIVString = new String(encodedIV, StandardCharsets.UTF_8);

            return encodedIVString + encryptedData;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
