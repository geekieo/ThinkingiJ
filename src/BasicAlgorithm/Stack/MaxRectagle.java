package Stack;

/**
 * 直方图最大内接矩形
 * Created by Geekie on 2017/3/23.
 */
public class MaxRectagle {

    public static void main(String args[]){
        int height[] = {2,1,5,6,2,3};
        int ans = getMaxRectangle(height);
        System.out.println(ans);
    }

    public static int getMaxRectangle (int heights[]){
        int ans = 0;
        int n = heights.length;
        int left[] = new int[n+1];//保存每个区间的左边界
        int right[] = new int[n+1];//保存每个区间的右边界
        //java 基本类型当参数，自带引用特性
        processLR(heights, left, right);
        for(int i=1; i<=n; i++){
            int tmp = (right[i]-left[i]+1) * heights[i-1];
            if( ans < tmp)
            ans = tmp;
        }
        return ans;
    }

    public static void processLR(int heights[], int left[], int right[]){
        int n = heights.length;
        //创建临时数组，在直方图两端增加两个极小值，-1。
        int tempArr[] = new int[n+2];
        tempArr[0] = -1;
        for(int i=1; i<=n; i++) tempArr[i] = heights[i-1];
        tempArr[tempArr.length-1] = -1;

        //从左往右寻找左边界
        for(int i=1; i<=n; i++){
            int k = i;//维护游标k，left[k]迭代记录从i往左第一个最小值的下标。
            //tempArr[i]为当前遍历的区间值，如果左柱比他高，或一样高，left[k]取左柱的左边界，如此循环。
            //如果左柱比他矮，自己的下标就是左边界。
            while( tempArr[i] <= tempArr[k-1])
                k = left[k-1];//如果前一个值比你大，取它的边界。因为程序从左到右执行，左边的left[i]已经算好
            left[i] = k;//最后停止迭代，取哪个边界保存。
        }

        //从右往左寻找右边界
        for(int i=n; i>0; i--){
            int k = i;
            while(  tempArr[i] <= tempArr[k+1])
            k = right[k+1];
            right[i] = k;
        }
    }
}

