package String;
/**
 * 滑动串方法
 * Created by wangxin on 2017/3/17.
 */
public class LongestCommonStringByWX {


    static int[] find(char[] a,char[] b){
        char[] min=a.length<=b.length?a:b;
        char[] max=a.length>b.length?a:b;
        int lastZeroSize=0;
        int lastStart=-1;
        int currentZeroSize=0;
        int currentStart=-1;
        for(int i=0; i<max.length-min.length+1; i++){
            boolean isFirstPlace=true;
            for(int j=i;j<min.length;j++){
                int current=min[j]-max[i+j];
                if(current==0){
                    if(isFirstPlace){
                        if(currentZeroSize<1){
                            currentStart=j;
                        }
                        isFirstPlace=false;
                    }
                    currentZeroSize++;
                    System.out.println("min["+j+"] = "+min[j]+",max["+i+"+"+j+"] = "+max[i+j]);
                    System.out.println(currentStart+","+currentZeroSize);
                }else{
                    if(currentStart!=-1){
                        if(currentZeroSize>lastZeroSize){
                            lastZeroSize=currentZeroSize;
                            lastStart=currentStart;
                        }
                        currentStart=-1;
                        currentZeroSize=0;
                        isFirstPlace=true;
                    }
                }
            }
        }
        if(currentZeroSize>lastZeroSize){
            lastZeroSize=currentZeroSize;
            lastStart=currentStart;
            currentStart=-1;
            currentZeroSize=0;
        }
        return new int[]{lastStart,lastZeroSize};
    }

    public static void main(String[] args){
        char[] a=new String("bcabbbc").toCharArray();
        char[] b=new String("bcabbbc").toCharArray();
        int[] r=find(a,b);
        System.out.println("起始位置：长度较短的字符串的第"+r[0]+"个字符开始:长度"+r[1]);
    }

}