package com.example.algorithm;

/**
 * @author wangzj
 * @description 387.字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 * @date 2020/7/19 22:06
 */
public class FirstUniqChar {
    public static int firstUniqChar(String s) {
        int[] letter=new int[26];
        for (char c:s.toCharArray())
            letter[c-'a']++;
        for (int i = 0; i <s.length() ; i++) {
            if(letter[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}
