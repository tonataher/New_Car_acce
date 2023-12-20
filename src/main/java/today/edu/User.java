package today.edu;
public class User
{
    public  String user_name;
    public  String pass;
    public String BD;

    public User(String un, String pa,String bd) {
        // TODO Auto-generated constructor stub
        user_name=un;
        pass=pa;
        BD=bd;
    }
    public String getUser_name() {
        return user_name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
}
