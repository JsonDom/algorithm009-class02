package com.example.algorithm;

import java.util.TreeSet;

/**
 * @author wangzj
 * @description 363. 矩形区域不超过 K 的最大数值和
 *
 * 给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
 *
 * 示例:
 *
 * 输入: matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出: 2
 * 解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 说明：
 *
 * 矩阵内的矩形区域面积必须大于 0。
 * 如果行数远大于列数，你将如何解答呢？
 *
 * @date 2020/6/28 22:38
 */
public class maxSumSubmatrix {

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, result = Integer.MIN_VALUE;
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            sum[i][0] = matrix[i][0];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + matrix[i][j];
            }
        }
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                int curSum = 0, curMax = Integer.MIN_VALUE;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int i = 0; i < m; i++) {
                    curSum += sum[i][right];
                    if (left > 0) {
                        curSum -= sum[i][left - 1];
                    }
                    Integer another = set.ceiling(curSum - k);
                    if (null != another) {
                        curMax = Math.max(curMax, curSum - another);
                    }
                    set.add(curSum);
                }
                result = Math.max(result, curMax);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,0,1},{0,-2,3}};
        System.out.println(maxSumSubmatrix(matrix,2));
    }
}
