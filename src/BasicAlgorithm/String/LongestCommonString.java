package String;

/**
 * 最长公共子串 滑动解法
 * 该方法丢失了不同滑动间的次序，所以不能拿来算公共子序列
 * Created by Geekie on 2017/3/17.
 */
public class LongestCommonString {

    /**
     * 以 strLong 为参考系观察 strShort
     * @param strA
     * @param strB
     * @return
     */
    public static String[] getLCString(String strA,String strB){
        String strShort = strA.length() > strB.length() ? strB :strA;
        String strLong= strA.length() > strB.length() ? strA :strB;
        int shortLen = strShort.length();
        int longLen = strLong.length();
        int maxLClen=0;//最长子串长度
        int[] index=new int[shortLen];//最长子串起始点，起始点位于 strShort
        for(int i=0;i<index.length;i++){
            index[i]=0;
        }
        /**
         * strShort ==========
         * strLong           ---------------------
         * 第一阶段 strShort 未全部进入 strLong 的参考范围
         * 最长未进入长度为 shortLen-1
         * i 为进入长度，j为 strlong 相减下标
         */
        for(int i=1; i<shortLen; i++){
            int preResult=1;
            int maxLClenTemp=0;//最长子串长度
            int IndexTemp=-1;//最长子串起始点
            for(int j = 0; j<i; j++){
                int result =strShort.charAt(shortLen-i+j)-strLong.charAt(j);
                if (result==0){
                    maxLClenTemp++;
                    if(preResult !=0 ){
                        IndexTemp=shortLen-i+j;
                    }
                    if(maxLClenTemp>maxLClen) {
                        for(int k=0;k<index.length;k++){
                            index[k]=0;
                        }
                        maxLClen=maxLClenTemp;
                        index[IndexTemp]=1;
                    }else if(maxLClenTemp == maxLClen){
                        index[IndexTemp]=1;
                    }
                    preResult=0;
                }else{
                    maxLClenTemp=0;
                    IndexTemp=-1;
                }
            }
        }

        /**
         * strShort     ==========
         * strLong  ---------------------
         * 第二阶段
         * i 为 strLong 起始下标，j 为 strShrot 对应相减下标
         */
        for(int i=0; i<longLen-shortLen+1; i++ ){
            int preResult=1;
            int maxLClenTemp=0;//最长子串长度
            int IndexTemp=-1;//最长子串起始点
            for(int j=0; j<shortLen;j++){
                int result =strShort.charAt(j)-strLong.charAt(i+j);
                if (result==0){
                    maxLClenTemp++;
                    if(preResult !=0 ){
                        IndexTemp=j;
                    }
                    if(maxLClenTemp>maxLClen) {
                        for(int k=0;k<index.length;k++){
                            index[k]=0;
                        }
                        maxLClen=maxLClenTemp;
                        index[IndexTemp]=1;
                    }else if(maxLClenTemp == maxLClen){
                        index[IndexTemp]=1;
                    }
                    preResult=0;
                }else{
                    maxLClenTemp=0;
                    IndexTemp=-1;
                }
            }
        }

        /**
         * strShort             ==========
         * strLong  ---------------------
         * 第三阶段
         * i 为进入长度，j 为 strShrot 对应相减下标
         */
        for(int i=shortLen-1; i>0; i-- ){
            int preResult=1;
            int maxLClenTemp=0;//最长子串长度
            int IndexTemp=-1;//最长子串起始点
            for(int j=0; j<i;j++){
                int result =strShort.charAt(j)-strLong.charAt(longLen-i+j);
                if (result==0){
                    maxLClenTemp++;
                    if(preResult !=0 ){
                        IndexTemp=j;
                    }
                    if(maxLClenTemp>maxLClen) {
                        for(int k=0;k<index.length;k++){
                            index[k]=0;
                        }
                        maxLClen=maxLClenTemp;
                        index[IndexTemp]=1;
                    }else if(maxLClenTemp == maxLClen){
                        index[IndexTemp]=1;
                    }
                    preResult=0;
                }else{
                    maxLClenTemp=0;
                    IndexTemp=-1;
                }
            }
        }

        int count = 0;
        for(int i=0; i<index.length; i++){
            if(index[i]==1) count++;
        }
        String[] LCS = new String[count];
        int LCSindex = 0;
        if(maxLClen !=0){
            for(int i=0; i<index.length; i++){
                if (index[i] == 1)
                    LCS[LCSindex] = strShort.substring(i,i+maxLClen);
            }
        }
        return LCS;
    }

    public static void main(String[] args){
//        String a=new String("aaabbbcccabbdddeee");
//        String b=new String("bcabbbc");
        String a=new String("bcde");
        String b=new String("bcde");
        String[] LCS = getLCString(a,b);
        if (LCS != null){
            System.out.println("最长公共子串为：");
            for(int i=0; i<LCS.length; i++){
                System.out.println(LCS[i]);
            }
        }
    }
}
