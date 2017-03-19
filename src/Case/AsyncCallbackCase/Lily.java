package AsyncCallbackCase;

/**
 * Created by Geekie on 2017/3/13 13:03.
 */
public class Lily {
    /**
     * 解答问题
     * @param callback 小王的接口，给小王传答案的方法
     * @param question 小王的问题
     */
    public void executeMessage(Callback callback, String question) {
        System.out.println("丽丽得到的小王的问题是："+question);

        //模拟丽丽解答问题,需要一段时间
        try{
            Thread thread = Thread.currentThread();
            thread.sleep(3000);//暂停3秒
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        //丽丽得出了答案
        String result = "等于“我爱你”";
        System.out.println("丽丽得出答案是："+result);

        /**
         * 调用小王的方法，传给小王答案
         */
        callback.tellWangResult(result);
    }
}
