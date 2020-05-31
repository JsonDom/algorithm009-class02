package com.example.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzj
 * @description 1.两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @date 2020/5/20 12:28
 */
public class twoSum {
    /**
     * 通过看思路后自己实现的方法
     * @param num
     * @param target
     * @return
     */
    /*public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> element = new HashMap(); //通过hash来记录数组元素和对应下标
        int [] result = new int [2]; //两数之和
        for(int i=0 ; i< nums.length ; i++){
            element.put(nums[i],i); //先填充hash
        }
        for(int i=0 ; i< nums.length ; i++){
            //如果map中有值等于目标值减数组中的数
            //并且满足所存的下标不为当前遍历的下标，为了去重
            if(element.containsKey(target-nums[i]) && element.get(target - nums[i]) != i){
                //放入目标数组中
                result[0] = i;
                result[1] = element.get(target - nums[i]);
            }
        }
        //最后排序
        Arrays.sort(result);
        return result;
    }*/

    /**
     * 遍历一次来实现，在遍历的同时，对map进行填充
     * @param nums
     * @param target
     * @return
     */
    public static int [] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            int result = target - nums[i]; //计算目标值减去循环数的差值
            if(map.containsKey(result)){ //如果map中存在这个值即返回
                return new int[]{map.get(result),i};
            }
            map.put(nums[i],i);//没有就填充map
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int [] a = {2, 7, 11, 15};
        int target = 9;
        int [] result = twoSum(a,target);
        System.out.println(Arrays.toString(result));
    }
}
