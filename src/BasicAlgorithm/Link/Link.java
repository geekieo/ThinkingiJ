package Link;

/**
 * 单向链表
 * Created by Geekie on 2017/3/26.
 */
public class Link<T> {

    /**
     * 节点类
     * @param <T>
     */
    protected class Node<T> {
        Node next = null;//下一个节点的引用，指向下一个节点
        T data;//节点对象

        //构造函数，赋予数据对象
        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * 头节点，指针节点
     */
    Node head = null;

    /**
     * 在链表结尾增加节点
     * @param data
     */
    public void addNode(T data) {
        Node node = new Node(data);//实例化一个节点
        if(head == null) {
            head = node;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    /**
     * 删除第 index 个节点
     * 节点数=下标
     * 区间[1,n]
     * @param index
     * @return
     */
    public boolean deleteNode(int index) {
        if(index < 1 || index>length()) {
            return false;
        }
        if(index==1) {
            head=head.next;
            return true;
        }else {//todo 对比
            for(int i=1; i<index; i++)
                head=head.next;
            head.next=head.next.next;
            return true;
        }
    }

    /**
     * 返回链表长度
     * @return
     */
    public int length() {
        int length = 0;
        while (head.next != null) {
            length++;
        }
        return length;
    }

    /**
     * 删除对象为 node 的节点
     * @param node
     * @return
     */
    public boolean deleteNode(Node node) {
        return true;
    }

    public void printList() {
        Node tmp = head;
        while (tmp !=null) {
            System.out.print(tmp.data);
            tmp = tmp.next;
        }
    }
}
