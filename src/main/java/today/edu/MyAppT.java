package today.edu;
import java.util.ArrayList;
import java.lang.*;

public class MyAppT {

    public boolean isLogedin;
    public boolean isSucceed;
    public ArrayList<User> up=new ArrayList<User>();
    public ArrayList<car> cp = new ArrayList<car>();
    public ArrayList<order> op = new ArrayList<order>();

    public MyAppT() {

        User u1= new User("haya","123");
        up.add(u1);
        this.isLogedin = false;
        this.isSucceed = false;
        car c1 = new car("motor","Interior",5000,1,"essintial part");
        cp.add(c1);
    }

}
