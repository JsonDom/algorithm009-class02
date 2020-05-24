package com.example.algorithm;

import java.util.Arrays;

/**
 * @author wangzj
 * @description 66.加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例：
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。

 * @date 2020/5/19 16:22
 */
public class plusOne {
    public static int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i >= 0; i--){  //从个位数开始向前循环
            digits[i]++;    //个位数+1
            digits[i] = digits[i] % 10; //判断是不是9+1 = 10
            if(digits[i] != 0) return digits; //如果不涉及到进位，直接返回
        }
        digits = new int[digits.length + 1]; //整个数组遍历完，说明是999类型，需要扩充
        digits[0] = 1;  //首位为1
        return  digits;
    }

    public static void main(String[] args) {
        int [] a = {9,9,9};
        int [] result = plusOne(a);
        System.out.println(Arrays.toString(result));
    }

}
