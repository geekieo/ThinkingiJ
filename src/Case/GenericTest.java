import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    public static void main_(String[] args) {
        /*
        List list = new ArrayList();
        list.add("qqyumidi");
        list.add("corn");
        list.add(100); //不提示编译错误，运行异常
        */
        List<String> list = new ArrayList<String>(); // 指定元素类型
        list.add("qqyumidi");
        list.add("corn");
        //list.add(100);   // 1  提示类型对象编译错误

        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i); // 2
            System.out.println("name:" + name);
        }
    }

    public static void main(String[] args) {
        Box<String> name = new Box<String>("corn");
        System.out.println("name:" + name.getData());
    }
}

class Box<T> {

    private T data;

    public Box() {

    }

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

}