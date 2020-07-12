package com.example.algorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wangzj
 * @description 1122.数组的相对排序
 *
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * @date 2020/7/12 21:33
 */
public class RelativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> record;
        record = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            record.put(arr2[i], i);
        }
        List<Integer> res = Arrays.stream(arr1).boxed().collect(Collectors.toList());

        Collections.sort(res, (num1, num2) -> {
            if (record.containsKey(num1) || record.containsKey(num2)) {
                return record.getOrDefault(num1, 1000) - record.getOrDefault(num2, 1000);
            } else {
                return num1 - num2;
            }
        });
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int [] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int [] arr2 = {2,1,4,3,9,6};
        System.out.println(relativeSortArray(arr1,arr2));
    }
}
