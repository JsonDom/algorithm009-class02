package com.example.algorithm;

import java.util.Arrays;

/**
 * @author wangzj
 * @description 283.移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例：
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * @date 2020/5/19 8:51
 */
public class moveZeroes {
    public static void moveZeroes(int[] nums){
        int index = 0; //用于记录数组中的非0个数
        for(int num:nums){
            if(num != 0){
                nums[index++] = num;  //这里思路很精妙，等于0的话就跳过，到下一个元素，而index数值没变，还是上轮的++后的数
                                      //即当遇到0时，下标不走，判断下一元素，不为零就往前移至之前记录的最后下标位置，实现将不为零前移
            }
        }
        while(index<nums.length){ //将剩余为零的数补0
            nums[index++] = 0;
        }
    }

    public static void main(String[] args) {
        int [] a = {0,5,4,2,0,3,0};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }
}
