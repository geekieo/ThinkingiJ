package String;

import javax.sound.midi.Sequence;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * 最长公共子序列 LCS
 * 使用二维矩阵记录相等字符长度或最长子子串长度，最后倒序查找即可
 * Created by Geekie on 2017/3/17.
 */
public class LongestCommonSequence {

    public static void main(String[] args){
        char[] strA = new String("noapplewa").toCharArray();
        char[] strB = new String("apthepapilewa").toCharArray();
        /**
         * 注意！这次的程序结构是顺序树型的，不是嵌套型的。
         * 先整理出多个顺序的枝干，再加分别叶子，代码结构更清晰。
         * 树形结构的函数，可以用最低的嵌套换最多的代码。
         * 我以前写代码习惯一个问题就一个函数，然后嵌套很多子函数，结构很差，容易思路翻车。
         * 请多多思考这种多枝多叶的编程思路， 在同样的思维复杂度下，有利于开发出更大的系统。
         * 先按大概的步骤，写出方法和参数，然后分别实现子方法，如此递归。
         * 这主要需要程序员的基元概括能力
         *
         * 注意！最终结果不一定要写在 main 函数里，可以写在子函数里。
         * 枝干函数间用参数传递信息，如此保证枝干函数的次序性和关联性。
         */
        SequencePoint[][] sequenceMat = getSequenceMat(strA,strB);
        showLCSequence(sequenceMat,strA,strB);
    }

    /**
     * 如果 str1[i] == str2[j],
     * 那么 mat[i][j] = mat[i-1][j-1]+1
     * 如果 str1[i] != str2[j]
     * 那么 mat[i][j] = max(mat[i-1][j],mat[i][j-1])
     *
     * 使用二维矩阵 mat 记录当前子串长度或最长子子串长度，以及子串方向。
     *
     * @param str1
     * @param str2
     * @return
     */
    public static SequencePoint[][] getSequenceMat(char[] str1, char[] str2) {
        SequencePoint[][] mat = new SequencePoint[str1.length][str2.length];
        SequencePoint startPoint = new SequencePoint();
        startPoint.sequence = 0;
        startPoint.direction = Direction.START.getCode();
        //边界初始化，序号(长度)为0，无搜索方向，置为回溯终点的状态
        for (int i =0;i<str1.length;i++) {
            mat[i][0] = startPoint;
        }
        for (int j =0;j<str2.length;j++) {
            mat[0][j] = startPoint;
        }

        for(int i = 1; i<str1.length; i++) {
            for(int j = 1; j<str2.length; j++) {
                if(str1[i] == str2[j]) {
                    mat[i][j].sequence=mat[i-1][j-1].sequence+1;
                    mat[i][j].direction= Direction.UL.getCode();
                }
                if(str1[i] != str2[j]) {
                    mat[i][j] = max(mat[i-1][j],mat[i][j-1]);
                }
            }
        }
        return mat;
    }

    /**
     * 获得i，j两个子串中较大的子串序号，并记录来源方向。
     */
    public static SequencePoint max(SequencePoint upPoint, SequencePoint leftPoint) {
        SequencePoint dstPoint = new SequencePoint();
        if (upPoint.sequence > leftPoint.sequence) {
            dstPoint.sequence = upPoint.sequence;
            dstPoint.direction=Direction.UP.getCode();
        } else if (upPoint.sequence < leftPoint.sequence) {
            dstPoint.sequence = leftPoint.sequence;
            dstPoint.direction = Direction.LEFT.getCode();
        } else if (upPoint.sequence == leftPoint.sequence) {
            dstPoint.sequence = leftPoint.sequence;//这儿的序号取上取左都一样
            dstPoint.direction = Direction.UPorLEFT.getCode();
        }
        return dstPoint;
    }

    /**
     * 从 sequenceMat 的direction参数中倒序搜索出最长公共子序列，并展示
     * 递归调用打印子串
     * @param sequenceMat
     * @param str1
     * @param str2
     * @return
     */
    public static void showLCSequence(SequencePoint[][] sequenceMat, char[] str1, char[] str2) {
        System.out.print("keep shipping");
    }
}

/**
 * 子串次序对象
 * 记录子串长度或最长子子串长度，以及子串回溯方向
 * 次序即长度
 */
class SequencePoint {
    int sequence;//次序
    int direction;//在二维数组中,如果横纵俩值相等，则记录邻接斜向的次序，否则记录次序较大的子串方向

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}


/**
 * 回溯方向，如果不记录这个值，可通过邻域比较获得回溯方向
 */
enum  Direction {
    //初始化
    //字符相等
    //字符不等,上边序号>左边序号
    //字符不等,左边序号>上边序号
    //字符不等,上边序号=左边序号
    START("O",-1),
    UL("↖",0),
    UP("↑",1),
    LEFT("←",2),
    UPorLEFT("+",3);

    // 成员变量
    private String name;
    private int code;
    // 构造方法
    private Direction(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public int getCode() {
        return this.code;
    }

    public void print() {
        System.out.println(this.code+":"+this.name);
    }

}
