package com.example.algorithm;

import java.util.Arrays;

/**
 * @author wangzj
 * @description 242.有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @date 2020/5/30 13:56
 */
public class isAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] alphas = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //charAt用来循环字符串中的数，取出的类型为char，-'a'是为了放入长度为26的数组中，a的字符码为79，之后26个字母依次累加
            //同时加减是为了计数，当一个字母出现两次或者不出现时，该位置即为0，即为字母异位词
            alphas[s.charAt(i) - 'a']++;
            alphas[t.charAt(i) - 'a']--;
        }
        return Arrays.stream(alphas).noneMatch(num -> num != 0);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean isAnagram = isAnagram(s,t);
        System.out.println(isAnagram);
    }

}
