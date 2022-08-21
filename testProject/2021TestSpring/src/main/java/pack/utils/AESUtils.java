package pack.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;

/**AESUtils加密（仅用于名片加密）
 * @author guoliyong
 *
 */
@Slf4j
public class AESUtils {

    private static final String ALGORITHM = "AES";
    private static final String PASSWORD = "88e4dfb8fbf147b2be115c01ca29672c";
    private static final SecretKey SECRET_KEY = AESUtils.createKey(PASSWORD);
    
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    private AESUtils() {

    }

    public static SecretKey createKey(String password) {
        try {
            byte[] key = password.getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit

            return new SecretKeySpec(key, ALGORITHM);
        } catch (Exception ex) {
            log.error("failed to createKey, passport=" + password, ex);
        }
        return null;
    }

    public static SecretKey createKey(byte[] salt, String password) {
        try {
            byte[] key = (salt + password).getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit
            return new SecretKeySpec(key, ALGORITHM);
        } catch (Exception ex) {
            log.error("failed to createKey, passport=" + password, ex);
        }

        return null;
    }

    public static byte[] encrypt(SecretKey secretKey, byte[] data) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(data);
        } catch (Exception ex) {
            log.error("failed to encrypt, data=" + data, ex);
        }
        return null;
    }

    public static String encryptString(String input) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, SECRET_KEY);
            byte[] result = cipher.doFinal(input.getBytes("UTF-8"));
            return Hex.encodeHexString(result);
        } catch (Exception ex) {
            log.error("failed to encryptString, input=" + input, ex);
        }
        return null;
    }


    public static byte[] decrypt(SecretKey secretKey, byte[] encrypted) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(encrypted);
        } catch (Exception ex) {
            log.error("failed to decrypt, encrypted=" + encrypted, ex);
        }
        return null;
    }


    public static void main(String[] args) {
        /*
         获取线索加密的微信openid
         */
        String data = "oqTri6Gb5BepBPOks9oLL0vZ-1eQ,"+System.currentTimeMillis();
        String s = AESUtils.encryptString(data);
        System.out.println("s = " + s);
    }

    public static String decryptString(String encrypted) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, SECRET_KEY);
            byte[] decrypted = cipher.doFinal(Hex.decodeHex(encrypted.toCharArray()));
            return new String(decrypted);
        } catch (Exception ex) {
            log.error("failed to decryptString, encrypted=" + encrypted, ex);
        }
        return null;
    }
    
    /**
     * 加密/解密算法 / 工作模式 / 填充方式
     * Java 6支持PKCS5Padding填充方式
     * Bouncy Castle支持PKCS7Padding填充方式
     *
     * @param source
     * @param secret
     * @return
     * @throws Exception
     */
    public static String cipherEncrypt(String source, String secret) throws Exception {
        byte[] sourceBytes = source.getBytes("UTF-8");
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(secret.getBytes(), ALGORITHM));
        byte[] decrypted = cipher.doFinal(sourceBytes);
        return Base64.encodeBase64String(decrypted);
    }
    
}