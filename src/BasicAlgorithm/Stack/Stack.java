package Stack;

/**
 * 堆栈 数组实现
 * Created by Geekie on 2017/3/24.
 */
public  class Stack<T>  {
    private Object[] stack = null;//数组栈，Objext[0] 为栈底
    private int size = 0;//当前栈高

    //构造函数
    public Stack() {
        stack = new Object[10];
    }
    //带参构造函数，参数为堆栈数组长度
    public Stack(int initialSize){
        stack = new Object[initialSize];
    }

    //判断堆栈是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //向堆栈外弹出一个数据
    public T pop() {
        T element = peek();//暂存，用于return
        stack[size-1]=null;//数组最后一个元素赋null
        size--;
        return element;
    }

    //向堆栈里压入一个数据
    public void push(T element){
        expand(size+1);
        stack[size++]=element;//数组下标从0开始，实际下标为容量-1。先入栈，再自增。
    }

    //数组容量增加，不够数组长度翻倍
    private void expand(int size) {
        int len = stack.length;//数组长度，即为栈的空间
        while(size > len) {
            Object[] temp = stack;
            stack = new Object[2*len];
            System.arraycopy(temp,0,stack,0,temp.length);
        }
    }

    //返回当前堆栈长度（即内部数据个数）
    public int size(){
        return this.size;
    }

    //得到栈顶元素,但不弹出
    public T peek()
    {
        if(this.isEmpty())
            return null;
        return (T) stack[size-1];//返回栈顶元素
    }

    //自顶向下搜索，返回元素在堆栈出现的第一个位置
    public int search(Object o) {
        int index = lastIndexOf(o);
        return index == -1 ? index : size-index;
    }

    //查找下标
    private int lastIndexOf(Object o) {
        //数组为空就抛出自定义异常
        if(isEmpty()){
            throw new EmptyStackException();
        }
        for(int i=size-1; i>=0; i--) {
            if(stack[i]==null) {
                return i;
            }
        }
        return -1;//未找到
    }

    //空栈异常，自定义异常
    private static class EmptyStackException extends RuntimeException {
        public EmptyStackException() {
            super("Stack is empty!");
        }
    }
}
