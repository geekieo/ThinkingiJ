package AsyncCallbackCase;

/**
 * 小王
 * Created by Geekie on 2017/3/13 11:49.
 */
public class Wang implements Callback{

    /**
     * 丽丽对象的引用
     */
    private Lily lily;

    /**
     * 小王的构造方法，持有小李的引用
     * @param lily
     */
    public Wang(Lily lily){
        //将外部参数，赋予内部变量
        this.lily=lily;
    }

    /**
     * 小王问丽丽问题
     */
    public void askQusetion (final String question) {
        System.out.println("小王的问题是："+question);

        //创建一条线程，异步实现
        new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 小王调用丽丽的方法，并在丽丽那注入小王，获取答案的回调接口，
                 * 丽丽调用 Callback 接口即为调用这个小王wang；
                 */
                lily.executeMessage(Wang.this,question);
            }
        }).start();

        //小王问完问题，就去做别的该做的事
        //因为问问题是异步实现，所以不等答案就可执行 work()
        work();
    }

    public void work() {
        System.out.println("解答不在我的控制范围内，我做别的事了……");
    }

    /**
     * 告诉小王答案
     * @param result
     */
    @Override
    public void tellWangResult(String result) {
        System.out.println("小王得到的答案是："+result);
    }
}
