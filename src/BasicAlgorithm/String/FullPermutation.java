package String;

import java.util.List;

import static net.mindview.util.Print.printf;

/**
 * 使用字典序实现全排列
 * Created by Geekie on 2017/3/15.
 */
public class FullPermutation {
    //交换list[a],list[b]
    void swap(int[] list, int a, int b) {
        int temp = 0;
        temp = list[a];
        list[a] = list[b];
        list[b] = temp;
        return;
    }

    //将list区间[a,n]之间的数据由小到大排序
    void sort(int[] list, int a, int n) {
        int temp = 0;
        for (int i = 1; i < n - a; i++) {
            for (int j = a + 1; j < n - 1; ++j) {
                if (list[j] > list[j + 1]) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        return;
    }

    //全排列
    void prim (int[] list, int n) {
        int num = 1, a = 0, b = 0;
        for (int i = n; i > 0; --i)     //计算有多少种情况，就循环多少次
            num *= i;
        while (num-- != 0 ) {
            for (int i = 0; i < n; ++i) //打印情况
                System.out.print(list[i]);
            System.out.println();
            for (int i = n - 1; i > 0; --i) //从右往左，找出第一个左边小于右边的数，设为list[a]
                if (list[i - 1] < list[i]) {
                    a = i - 1;
                    break;
                }
            for (int j = n - 1; j > a; --j) //从右往左，找出第一个大于list[a]的数，设为list[b]
                if (list[j] > list[a]) {
                    b = j;
                    break;
                }
            this.swap(list, a, b);         //交换list[a],list[b]
            this.sort(list, a, n);         //将list[a]后面的数据，由小往大排列
        }
        return;
    }

    public static void main(String[] args) {
        int list[] = {1,2,3,4};
        FullPermutation fullPermutation = new FullPermutation();
        fullPermutation.prim(list,3);
        return;
    }

}
