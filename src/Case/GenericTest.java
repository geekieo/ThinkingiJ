import java.util.ArrayList;
import java.util.List;

/**
 * 泛型测试
 */
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
        Box<Number> number = new Box<Number>(99);
        Box<Integer> age = new Box<Integer>(23);

        getData(name);
        getData(number);
        getData(age);

        //getUpperNumberData(name); // String 不是 Number 的子类，编译报错
        getUpperNumberData(age);
        getUpperNumberData(number);

        System.out.println("name:" + name.getData());
        System.out.println("name class:" + name.getClass());
        System.out.println("age class:" + age.getClass());
        System.out.println(name.getClass() == age.getClass());
    }

    public static void getData(Box<?> data){    // ?为泛型的类型实参，称为通配符，Box<?>在逻辑上是Box<Integer>、Box<Number>...等
        System.out.println("data :" + data.getData());
    }

    // 类型通配符上限形如 Box<? extends Number>；上限为 Number；?只能是 Number 及其子类
    // 类型通配符下限形如 Box<? super Number>，? 只能是 Number 的父类
    public static void getUpperNumberData(Box<? extends Number> data){
            System.out.println("data :" + data.getData());
    }
}

class Box<T> {  // T为泛型的类型形参

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