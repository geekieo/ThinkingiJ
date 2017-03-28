package Array;

/**
 * 有序整数数组二分查找
 * Created by Geekie on 2017/3/28.
 */
public class BinarySearch {

    public int BinarySearch(int[] array, int target) {
        int low,high,mid;
        low=0;
        high=array.length-1;
        while(low<=high) {
            mid=(low+high)/2;
            if(array[mid]<target)  {
                low=mid+1;
            } else if(array[mid]>target) {
                high=mid-1;
            } else {
                return mid;
            }
        }
        return-1;
    }

    /**
     * 查找最小绝对值
     * @param array
     * @param target
     * @return 位置，差值（正为右边，负为左边，0为本身）
     */
    public int[] BinarySearchAbs(int[] array, int target) {
        int low,high,mid;
        low=0;
        high=array.length-1;
        mid=(low+high)/2;
        int delta = 0;

        while(low<=high) {
            mid=(low+high)/2;
            delta = target-array[mid];
            if(delta>0)  {
                low=mid+1;
            } else if(delta<0) {
                high=mid-1;
            } else {
                return new int[]{mid,0};
            }
        }

        return new int[]{mid,delta};
    }

}
class Test {
    public static void main(String[] args) {
        int[] a={-1,1,3,7,8};
        int target = 4;
        for (int i = 0; i < a.length -1;i++)
        {
            System.out.print(a[i]+",");
        }
        System.out.print(a[a.length-1]);
        System.out.println(target);

        BinarySearch binarySearch = new BinarySearch();
        int[] midAndDelta = binarySearch.BinarySearchAbs(a,target);//结果为{索引，和target的差值}
        //midAndDelta[0] 为中间坐标
        //midAndDelta[1] 为差值
        if (midAndDelta[1]==0){
            System.out.println(midAndDelta[0]);
        }else if(midAndDelta[1]>0){
            if(midAndDelta[1]==a.length-1)
                System.out.println(midAndDelta[0]);
            else {
                int deltaMid =  java.lang.Math.abs(a[midAndDelta[0]]-target);
                int deltaMidPlus1 = java.lang.Math.abs(a[midAndDelta[0]+1]-target);
                System.out.println(deltaMid<deltaMidPlus1?midAndDelta[0]:midAndDelta[0]+1);
            }
        }else {
            if(midAndDelta[1]==0)
                System.out.println(midAndDelta[0]);
            else {
                int deltaMid =  java.lang.Math.abs(a[midAndDelta[0]]-target);
                int deltaMidMinus1 = java.lang.Math.abs(a[midAndDelta[0]-1]-target);
                System.out.println(deltaMid<deltaMidMinus1?midAndDelta[0]:midAndDelta[0]-1);
            }
        }

    }
}
