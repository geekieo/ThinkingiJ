package String;

import net.mindview.util.CountingGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长公共子序列 LCS
 * 使用二维矩阵记录相同字符邻接次序法，最后倒序查找即可
 * Created by Geekie on 2017/3/17.
 */
public class LongestCommonSequence {

    /**
     * 用二维数组矩阵记录二维空间次序，决定搜索的方向
     * @param str1
     * @param str2
     * @return
     */
    public static int[][] getSequenceMat(char[] str1, char[] str2) {
        return null;
    }

    /**
     * 从二维矩阵中倒序搜索出最长公共子序列，并展示
     * @param sequenceMat
     * @param str1
     * @param str2
     * @return
     */
    public static void showLCSequence(int[][]sequenceMat, char[] str1, char[] str2) {

    }

    public static void main(String[] args){
        char[] strA = new String("noapplewa").toCharArray();
        char[] strB = new String("apthepapilewa").toCharArray();
        /**
         * 注意！这次的程序结构是顺序树型的，不是嵌套型的。
         * 先整理出多个顺序的枝干，再加分别叶子，代码结构更清晰。
         * 树形结构的函数，可以用最低的嵌套换最多的代码。
         * 我以前写代码习惯一个问题就一个函数，然后嵌套很多子函数，结构很差，容易思路翻车。
         * 请多多思考这种多枝多叶的编程思路， 在同样的思维复杂度下，有利于开发出更大的系统。
         * 先按大概的步骤，写出方法和参数，然后分别实现子方法，如此递归。
         * 这主要需要程序员的基元概括能力
         *
         * 注意！最终结果不一定要写在 main 函数里，可以写在子函数里。
         * 枝干函数间用参数传递信息，如此保证枝干函数的次序性和关联性。
         */
        int[][] sequenceMat = getSequenceMat(strA,strB);
        showLCSequence(sequenceMat,strA,strB);
    }
}
