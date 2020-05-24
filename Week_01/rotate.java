package com.example.algorithm;

import java.util.Arrays;

/**
 * @author wangzj
 * @description 189.旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * @date 2020/5/24 11:54
 */
public class rotate {
    public static void rotate(int [] nums,int k){
        k %= nums.length;
        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k -1);
        reverse(nums, k, nums.length -1);
    }

    /**
     * 旋转思路：  首先将数组全部旋转，然后将前K位个数组复原，最后将剩余数组旋转
     * @param nums
     * @param start
     * @param end
     */
    private static void reverse(int[] nums, int start, int end) {
        while(start < end){
            int temp =nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int [] nums = {23,86,34,17,91,45};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }

}
