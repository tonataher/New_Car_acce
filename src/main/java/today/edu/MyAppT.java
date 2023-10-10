package today.edu;
import java.util.ArrayList;
import java.lang.*;

public class MyAppT {

    public boolean isLogedin;
    public ArrayList<User> up=new ArrayList<User>();


    public MyAppT() {

        User u1= new User("haya","123");
        up.add(u1);
        this.isLogedin = false;
    }

}
