package AsyncCallbackCase;

/**
 * 回调接口
 * Created by Geekie on 2017/3/13 11:41.
 */
public interface Callback {
    //丽丽得出了答案，调用“告诉小王答案”函数告诉小王，这是小王的回调函数
    public void tellWangResult(String result);
}
