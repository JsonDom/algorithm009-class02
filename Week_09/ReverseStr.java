package com.example.algorithm;

/**
 * @author wangzj
 * @description 541.反转字符串II
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *  
 *
 * 提示：
 *
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 *
 * @date 2020/7/19 22:12
 */
public class ReverseStr {
    public static String reverseStr(String s, int k) {
        int i=0;
        char[] ch=s.toCharArray();
        while(i<ch.length){
            if (i%(2*k)==0){
                if (i+k-1<ch.length) {
                    for (int j = 0; j < k / 2; j++) {
                        char mid = ch[i + j];
                        ch[i + j]=ch[i+k-1-j];
                        ch[i+k-1-j]=mid;
                    }
                }
                else{
                    for (int j = 0; j < (ch.length-i)/2; j++) {
                        char mid = ch[i + j];
                        ch[i + j]=ch[ch.length-1-j];
                        ch[ch.length-1-j]=mid;
                    }
                }
            }
            i+=k;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        String s ="abcdefg";
        int k = 2;
        System.out.println(reverseStr(s,k));
    }

}
