package Link;

import java.util.Random;

/**
 * Created by Geekie on 2017/3/28.
 */
public class MyLink extends Link {

    /**
     * 链表翻转
     * 当成两个对象考虑，用三个节点变量转换
     *
     * @param head
     * @return this.head
     */
    public Node ReverseLink(Node head) {
        Node reversedHead = head;//翻转后的表头节点
        Node curNode = head;//当前节点
        Node preNode = null;//原链表节点的前一个节点
        while (curNode != null) {
            Node nextNode = curNode.next;//原链表节点的后一个节点
            if (nextNode == null) {
                reversedHead = curNode;
            }
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        this.head = reversedHead;
        return this.head;
    }

    /**
     * 查找单链表的中间节点
     * 双倍步长遍历
     *
     * @param head
     * @return Node in the middle
     */
    public Node SearchMid(Node head) {
        Node p = this.head, q = this.head;
        while (p != null && p.next != null && p.next.next != null) {
            p = p.next.next;
            q = q.next;
        }
        System.out.println("Mid:" + q.data);
        return q;
    }

    /**
     * 查找第k个元素
     *
     * @param head
     * @param k
     * @return
     */
    public Node findElem(Node head, int k) {
        if (k < 1 || k > this.length()) {
            return null;
        }
        Node p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        return p;
    }

    /**
     * 查找倒数第k个元素
     *
     * @param head
     * @param k
     * @return
     */
    public Node findElemBackForward(Node head, int k) {
        if (k < 1 || k > this.length()) {
            return null;
        }
        Node p = head;
        for (int i = 0; i < this.length() - k; i++) {
            p = p.next;
        }
        return p;
    }

    /**
     * 链表排序
     * 排序算法为选择排序
     * 申请两个指针节点，一个遍历全表，一个遍历全部元素做对比
     * 当data为数字时可用
     * @return
     */
    public Node orderList() {
        Node nextNode = null;
        Node curNode = head;
        int temp = 0;
        while (curNode.next != null) {
            nextNode = curNode.next;
            while (nextNode != null) {
                if((Integer)curNode.data > (Integer) nextNode.data) {
                    temp = (Integer) curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }

    /**
     * 删除重复节点
     * 同选择排序，申请两个指针节点，一个遍历全表，一个遍历全部元素做对比
     * @param head
     */
    public void deleteDuplecate(Node head) {
        Node p = head;
        while (p != null) {
            Node q = p;
            while (q.next != null) {
                if (p.data == q.next.data) {
                    q.next = q.next.next;
                } else
                    q = q.next;
            }
            p = p.next;
        }
    }

    /**
     * 倒序输出单链表
     * 递归方式实现
     *
     * @param pNode
     */
    public void printListReversely(Node pNode) {
        System.out.println("printListReversely:");
        if (pNode != null) {
            printListReversely(pNode.next);
            System.out.println( pNode.data);
        }
    }

    /**
     * 判断链表是否有环
     * 注意这里的环并非是全表成环，环可以从 head 后面某个节点开始
     * 如 1,2,3,4,5,6 其中6的下个节点为3，形成环，这就叫链表有环
     * 单向链表有环时，尾节点将和某个节点相同
     *
     * @param head
     * @return
     */
    public boolean IsLoop(Node head) {
        Node fast = head, slow = head;
        if (fast == null) {
            return false;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                System.out.println("该链表有环");
                return true;
            }
        }
        return !(fast == null || fast.next == null);
    }

    /**
     * 找出链表环的入口
     *
     * @param head
     * @return
     */
    public Node FindLoopPort(Node head) {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (fast == null || fast.next == null)
            return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
class test{
    public static void main(String[] args) {
        MyLink myLink = new MyLink();

        int max=20;
        int min=10;
        Random random = new Random();

        for(int i=0; i<4; i++) {
            //首先生成0-20的随机数，然后对(20-10+1)取模得到[0-10]之间的随机数，
            // 然后加上min=10，最后生成的是10-20的随机数
            int s = random.nextInt(max)%(max-min+1) + min;
            myLink.addNode(s);
        }

        Link.Node tmp = myLink.head;
        while(tmp != null) {
            System.out.print(tmp.data);
            tmp = tmp.next;
        }

        System.out.println();
        myLink.orderList();
        tmp = myLink.head;
        while(tmp != null) {
            System.out.print(tmp.data);
            tmp = tmp.next;
        }

    }
}