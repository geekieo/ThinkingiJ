package AsyncCallbackCase;

/**
 * Created by Geekie on 2017/3/13 13:04.
 */
public class Test {
    public static void main(String[]args){
        /**
         * new 一个丽丽
         */
        Lily lily = new Lily();

        /**
         * new 一个小王，带上丽丽的引用，
         * 丽丽最后会用小王的方法告诉小王答案
         */
        Wang wang = new Wang(lily);

        /**
         * 小王问丽丽问题
         */
        wang.askQusetion("1 到 10 = ?");
    }
}
