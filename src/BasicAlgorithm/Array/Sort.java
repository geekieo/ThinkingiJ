package Array;

/**
 * 排序算法
 * Created by Geekie on 2017/3/30.
 */
public class Sort {

    /**
     * 打印数组
     * @param a
     * @param n
     */
    private static void print(int a[],int n){
        for(int i= 0; i<n; i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }

    /**
     * Java 参数传递中
     * 1.对象就是传引用
     * 2.原始类型就是传值
     * 3.String类型因为没有提供自身修改的函数，每次操作都是新生成一个String对象，
     * 所以要特殊对待。可以认为是传值。
     * @param a
     * @param b
     */
    private static int[] swap(int a, int b)
    {
        int tmp = a;
        a = b;
        b = tmp;;
        return new int[]{a,b};//需要构造返回数组
    }


    /**
     * 快速排序
     * 一次比较 - 分段交换
     * 和基准元素比较，把数组分成两段，左边小，右边大
     * 基准可任取，取段首元素 a[low] 比较方便
     * @param a
     * @param left
     * @param right
     */
    private static int partition(int[] a, int left, int right) {
        int pivotValue = a[left];       //获取基准元素
        //从数组两段往中间遍历比较，一左一右交换比较，每次swap交换遍历位置，保证基准元素和比较元素位于两边
        while (left < right) {
            //基准元素在左边
            while (left < right &&  pivotValue <= a[right])  //基准在左，先和右边的元素比
                --right;        //从 right 所指位置向左搜索，至多到 left+1 位置。将比基准元素小的交换到左端
            int[]sl = swap(a[left],a[right]);a[left]=sl[0];a[right]=sl[1];
            //基准元素在右边
            while (left < right && a[left] <= pivotValue)
                ++left;
            int[]sr = swap(a[left],a[right]);a[left]=sr[0];a[right]=sr[1];
        }
        return left;//返回分界点索引，即一次遍历交换结束后的基准元素下标。
    }

    public static void quickSort(int[] a, int low, int high) {
        if(low < high) {
            int pivotKey = partition(a, low, high);//获取分界点索引
            quickSort(a,low,pivotKey-1);
            quickSort(a,pivotKey+1,high);
        }
    }



    public static void main(String[] args) {
        int[] a = {2,5,8,9,6,3,12,1,47,8,8,6};
   //     int[] a = {3,2,5,8,7};
        int length = a.length;
        quickSort(a,0,length-1);
        for(int i=0; i<length; i++){
            System.out.print(a[i]);
            System.out.print(",");
        }
    }

}
