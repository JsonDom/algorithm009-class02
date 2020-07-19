package com.example.algorithm;

/**
 * @author wangzj
 * @description 680.验证回文字符串Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * @date 2020/7/19 22:17
 */
public class ValidPalindrome {
    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j && chars[i] == chars[j]) {
            i++;
            j--;
        }
        if (isValid(chars,i + 1,j)) return true;
        if (isValid(chars,i,j - 1)) return true;
        return false;
    }
    private static boolean isValid(char[] chars,int i,int j) {
        while (i < j) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(validPalindrome(s));
    }
}
