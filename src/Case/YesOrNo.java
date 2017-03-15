/**
 * 作者：司巴骏
 * 链接：https://www.zhihu.com/question/20784522/answer/88400501
 * 来源：知乎
 * Created by Geekie on 2017/2/7 13:56.
 */
public class YesOrNo {

    public static void main(String[] args) {
        Integer I1=1;
        Integer I1_=1;
        if(I1==I1_){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

        Integer I1000=1000;
        Integer I1000_=1000;
        if(I1000==I1000_){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

        if(I1000.equals(I1000_)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
