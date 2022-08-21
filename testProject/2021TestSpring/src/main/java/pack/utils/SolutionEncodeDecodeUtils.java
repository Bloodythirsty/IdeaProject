//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package pack.utils;


import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SolutionEncodeDecodeUtils {
    private static final Logger log = LogManager.getLogger(SolutionEncodeDecodeUtils.class);
    private static String DICT_ENCODE_STR = "";
    private static final int ENCODE_MSG_LENGTH = sizeof(4) + sizeof(4);
    private static final char[] DICT_ENCODE = new char[]{'6', 'R', 'B', '4', 'W', 'T', 'G', 'X', 'Y', '7', 'O', 'A', '2', '0', 'Q', 'F', '8', 'V', '3', '5', 'H', 'Z', 'N', 'L', 'D', 'P', 'S', '-', '_', '9', 'M', '1', 'J', 'C', 'E', 'I', 'U', 'K', 'v', 'w', 'x', 'y', 'z', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'a'};
    private static final int[] DICT_DECODE;

    public SolutionEncodeDecodeUtils() {
    }

    public static String encode(Long accountId, Long solutionId) {
        StringBuilder result = new StringBuilder();

        try {
            if (accountId == null) {
                accountId = 0L;
            }

            if (solutionId == null) {
                solutionId = 0L;
            }

            String aidEncode = to64(accountId, 4);
            result.append(aidEncode);
            String solutionIdEncode = to64(solutionId, 4);
            result.append(solutionIdEncode);
        } catch (Throwable var5) {
            log.error(String.format("encode error, aid: %s, sid: %s", accountId, solutionId), var5);
            return null;
        }

        return result.toString();
    }

    public static void decode(String encodeMsg) {

        try {
            if (StringUtils.isBlank(encodeMsg)) {
                throw new IllegalArgumentException("param invalid");
            } else {
                encodeMsg = handleAppKey(encodeMsg);
                if (!StringUtils.isBlank(encodeMsg) && encodeMsg.length() == ENCODE_MSG_LENGTH) {
                    BigInteger aid = from64BigInteger(encodeMsg, 4, 0);
                    BigInteger solutionId = from64BigInteger(encodeMsg, 4, 6);
                    System.out.println("aid = " + aid);
                    System.out.println("solutionId = " + solutionId);
                } else {
                    throw new IllegalArgumentException("param invalid");
                }
            }
        } catch (Throwable var4) {
            log.error(String.format("decode error, encodeMsg: %s", encodeMsg), var4);
        }
    }

    private static int sizeof(int size) {
        return (size * 8 + 5) / 6;
    }

    private static String to64(Long x, int sizeOf) throws ArrayIndexOutOfBoundsException {
        int bit = sizeOf * 8;

        StringBuilder result;
        for(result = new StringBuilder(); bit > 0; bit -= 6) {
            char ch = DICT_ENCODE[(int)(x & 63L)];
            result.append(ch);
            x = x >> 6;
        }

        return result.toString();
    }

    private static BigInteger from64BigInteger(String encodeMsg, int sizeOf, int idx) throws ArrayIndexOutOfBoundsException {
        int bit = sizeof(sizeOf);
        BigInteger id = BigInteger.ZERO;

        for(int i = 0; i < bit; ++i) {
            int x = DICT_DECODE[encodeMsg.charAt(idx++)];
            if (x == -1) {
                throw new RuntimeException("code error");
            }

            BigInteger xBigInteger = new BigInteger("" + x);
            xBigInteger = xBigInteger.shiftLeft(i * 6);
            id = id.or(xBigInteger);
        }

        return id;
    }

    private static String handleAppKey(String appKey) {
        if (StringUtils.isBlank(appKey)) {
            return null;
        } else {
            char[] arr = appKey.toCharArray();
            StringBuilder appkeyBuffer = new StringBuilder();
            boolean matchFlag = false;

            for(int index = 0; index < arr.length; ++index) {
                char ch = arr[index];
                if (DICT_ENCODE_STR.contains("" + ch)) {
                    appkeyBuffer.append(ch);
                    matchFlag = true;
                } else if (matchFlag) {
                    break;
                }
            }

            return appkeyBuffer.toString();
        }
    }


    static {
        StringBuffer buffer = new StringBuffer();

        for(int index = 0; index < DICT_ENCODE.length; ++index) {
            buffer.append(DICT_ENCODE[index]);
        }

        DICT_ENCODE_STR = buffer.toString();
        DICT_DECODE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1, 13, 31, 12, 18, 3, 19, 0, 9, 16, 29, -1, -1, -1, -1, -1, -1, -1, 11, 2, 33, 24, 34, 15, 6, 20, 35, 32, 37, 23, 30, 22, 10, 25, 14, 1, 26, 5, 36, 17, 4, 7, 8, 21, -1, -1, -1, -1, 28, -1, 63, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 38, 39, 40, 41, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }
}
