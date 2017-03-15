/**
 * Created by Geekie on 2017/2/17 11:36.
 */
import java.util.ArrayList;
import java.util.List;


public class ListContainsOverride {
    public static void main(String[] args){
        List users =  new ArrayList();
        User user1 = new User("001");
        User user2 = new User("002");
        users.add(user1);
        users.add(user2);
        System.out.println(users.contains(new User("001")));
    }
}

class User{
    private String userID;
    private String userName;

    public User(String userID){
        this.userID = userID;
    }

    public String getUserID(){
        return this.userID;
    }
    public void setUserID(String userID){
        this.userID = userID;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!userID.equals(user.userID)) return false;
        return userName.equals(user.userName);

    }

    @Override
    public int hashCode() {
        int result = userID.hashCode();
        result = 31 * result + userName.hashCode();
        return result;
    }

}