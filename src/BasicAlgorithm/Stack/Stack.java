package Stack;

/**
 * 堆栈 数组实现 接口
 * Created by Geekie on 2017/3/24.
 */
public  class Stack<T>  {
    private Object[] element = null;//栈内元素
    private int maxSize = 0;//栈容量
    private int top = -1;//栈顶标识，为空时为-1

    Stack() {

    }

    Stack(int initialSize){

    }

    //判断堆栈是否为空
    boolean isEmpty(){
        return false;
    }

    //向堆栈外弹出一个数据
    void pop() {

    }

    //向堆栈里压入一个数据
    void push(T element){

    }

    //返回当前堆栈长度（即内部数据个数）
    void size(){

    }

    //得到栈顶元素
    T top()
    {
        return null;
    }

}
