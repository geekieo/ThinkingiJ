package String;

/**
 * 最长公共子序列 LCS
 * 使用二维矩阵记录相等字符长度或最长子子串长度，最后倒序查找即可
 * Created by Geekie on 2017/3/17.
 */
public class LongestCommonSequence {

    public static void main(String[] args){
        char[] strA = new String("noapplewa").toCharArray();
        char[] strB = new String("apthepapilewa").toCharArray();
//        char[] strA = new String("app").toCharArray();
//        char[] strB = new String("caple").toCharArray();
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
        //增加初始化行列
        str1 = (" "+String.valueOf(str1)).toCharArray();
        str2 = (" "+String.valueOf(str2)).toCharArray();
        SequencePoint[][] mat = new SequencePoint[str1.length][str2.length];
        SequencePoint startPoint = new SequencePoint();
        startPoint.sequence = 0;
        startPoint.direction = Direction.START;
        //边界初始化，序号(长度)为0，无搜索方向，置为回溯终点的状态
        for (int i =0;i<str1.length;i++) {
            mat[i][0] = startPoint;
        }
        for (int j =0;j<str2.length;j++) {
            mat[0][j] = startPoint;
        }
        //开始遍历
        for(int i = 1; i<str1.length; i++) {
            for(int j = 1; j<str2.length; j++) {
                SequencePoint point = new SequencePoint();
                if(str1[i] == str2[j]) {
                    //java 的数组存的是对象的引用，故只可以传对象，不可对其引用赋值，只可以从引用取值。
                    point.sequence=mat[i-1][j-1].sequence+1;
                    point.direction= Direction.UL;
                    mat[i][j]=point;
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
            dstPoint.direction=Direction.UP;
        } else if (upPoint.sequence < leftPoint.sequence) {
            dstPoint.sequence = leftPoint.sequence;
            dstPoint.direction = Direction.LEFT;
        } else if (upPoint.sequence == leftPoint.sequence) {
            dstPoint.sequence = leftPoint.sequence;//这儿的序号取上取左都一样
            if(dstPoint.sequence != 0)
                dstPoint.direction = Direction.UPorLEFT;
            else
                dstPoint.direction = Direction.START;
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
        if(sequenceMat==null || str1.length==0 || str2.length==0)
            return;
        System.out.println("字符串1："+ String.valueOf(str1));
        System.out.println("字符串2："+ String.valueOf(str2));
        //===========中间数据展示=============
        System.out.println("路径：");
        for(int i =0; i< sequenceMat.length;i++) {
            for (int j = 0; j < sequenceMat[i].length; j++) {
                System.out.print(sequenceMat[i][j].direction.getName());
            }
            System.out.println();
        }
        System.out.println("次序（公共子串长度）：");
        for(int i =0; i< sequenceMat.length;i++) {
            for (int j = 0; j < sequenceMat[i].length; j++) {
                System.out.print(sequenceMat[i][j].sequence+" ");
            }
            System.out.println();
        }
        //===========最长公共子串=============
        System.out.println("最长公共子串是：");
        print(sequenceMat,str1, str1.length,str2.length);
    }

    /**
     * 回溯mat，递归从 str1 中打印
     * @param mat
     * @param str1
     * @param i
     * @param j
     */
    public static void print(SequencePoint[][] mat, char[] str1, int i, int j) {
        //注意 mat 左边和上边多了一行一列，mat 对应的记录下标为str的下标+1
        //递归收敛条件
        if(mat[i][j].sequence == 0) {
            System.out.println();
            return;
        }
        SequencePoint point = mat[i][j];
        //java case 后面只支持常量，不支持变量。如想使用枚举，则switch必须是枚举类型。
        switch (point.direction) {
            case UL:
                System.out.print(str1[i-1]);//记录公共字符。因为是回溯，字符是倒序的，需要存入堆栈后打印可把 LCS 调整为正序
                print(mat, str1, --i, --j);//往左上
                break;
            case UP:
                print(mat, str1, --i, j);//往左
                break;
            case LEFT:
                print(mat, str1, i, --j);//往上
                break;
            case UPorLEFT:
                print(mat, str1, --i, j);//往左
                print(mat, str1, i, --j);//往上
                break;
            default:
                return;
        }
    }
}

/**
 * 子串次序对象
 * 记录子串长度或最长子子串长度，以及子串回溯方向
 * 次序即长度
 */
class SequencePoint {
    Integer sequence;//次序
    Direction direction;//在二维数组中,如果横纵俩值相等，则记录邻接斜向的次序，否则记录次序较大的子串方向

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}


/**
 * 回溯方向，如果不记录这个值，可通过比较领域次序获得回溯方向，再通过对比横纵值确定是否为公共字符，比较繁琐
 * 只有 UL("↖",0) 为公共子串有效字符
 */
enum  Direction {
    //初始化
    //字符相等，公共子串字符
    //字符不等,上边序号>左边序号
    //字符不等,左边序号>上边序号
    //字符不等,上边序号=左边序号
    START("O ",-1),
    UL("↖",0),
    UP("↑",1),
    LEFT("←",2),
    UPorLEFT("+ ",3);

    // 成员变量
    private String name;
    private Integer code;
    // 构造方法
    private Direction(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public Integer getCode() {
        return this.code;
    }

    public static Direction valueOf(Integer code) {
        if(code != null) {
            for(Direction d: values()) {
                if (d.getCode()== code) {
                    return d;
                }
            }
        }
        return null;
    }

}