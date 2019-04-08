package top.godder.usermodule.infrastructure.util;

import org.springframework.util.DigestUtils;

/**
 * @author: godder
 * @date: 2019/4/3
 */
public class MD5 {
    /**
     * 实现MD5加密
     * @param text 加密内容
     * @return 32位加密内容
     */
    public static String md5(String text) {
        String encodeStr = DigestUtils.md5DigestAsHex(text.getBytes());
        return encodeStr;
    }

    /**
     * 验证内容与md5加密内容
     * @param text 验证内容
     * @param md5Text md5加密内容
     * @return 是否text为md5加密内容原文
     */
    public static boolean md5Verify(String text, String md5Text) {
        String encodeStr = md5(text);
        if (md5Text.equalsIgnoreCase(encodeStr)) {
            return true;
        }
        return false;
    }

}
