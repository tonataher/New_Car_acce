package today.edu;
import java.util.ArrayList;
import java.util.Scanner;

public class MyAppT
{

    public boolean isLogged=false;
    public boolean f=false;
    public  boolean isInstallation=false;
    public boolean submit = false;
    public boolean available1 = false;
    public boolean available2 = false;
    public  ArrayList<User> up=new ArrayList<User>();
    public ArrayList<car> cp = new ArrayList<car>();
    public ArrayList<order> op = new ArrayList<order>();
    public ArrayList<String>date = new ArrayList<String>();

    public MyAppT()
    {
        User u1= new User("haya","123","7\3\2004");
        up.add(u1);
        User u2= new User("Asma@gmail.com","1234","7\3\2004");
        up.add(u2);
        this.isLogged = false;
        this.f = false;
        car c1 = new car("motor","Interior",5000,1,"essintial part");
        cp.add(c1);
        car c2 = new car("motor-v2","Interior",5000,100,"essintial part");
        cp.add(c2);
        User u3= new User("Fatina","1234","2\4\2004");
        up.add(u3);
        order o1 = new order(u3.getUser_name(), c2.getCar_name(), "20-10-2023");
        op.add(o1);
        date.add("20-10-2023");
        date.add("22-10-2023");
        date.add("5-11-2023");
    }

    public void setUsernameAndPassAndPassFromSystem(String user_name, String pass) {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        for (User u: up) {

            if (user_name.equals(u.getUser_name()) && u.getPass().equals(pass)) {
                f = true;
                System.out.println("hi");
                break;
            }
        }
    }
    public void setInvalidUsernameAndPass(String user_name, String pass) {
        // Write code here that turns the phrase above into concrete actions
        for (User u: up) {

            if (user_name.equals(u.getUser_name()) && u.getPass().equals(pass)) {
                f = true;
                break;
            }
        }
    }
    public void setValidUsernameAndInvalidPass(String user_name, String pass) {
        for (User u: up) {

            if (user_name.equals(u.getUser_name()) && u.getPass().equals(pass)) {
                f = true;
                break;
            }
        }

    }
    public void setEmptyUsernameAndPass(String user_name, String pass) {

        if (user_name.isEmpty())
            f = false;

    }
    public void setValidUsernameAndEmptyPass(String user_name, String pass) {

        if (pass.isEmpty())
            f = false;

    }
    public void iAmNotInSystem(MyAppT obj)
    {
        obj.isLogged=false;

    }
    public void adding(String u,String p,String bd)
    {
        if(u.isEmpty())
            System.out.println("You can't creat account while your name is empty");
        if(p.isEmpty())
            System.out.println("You can't creat account while your password is empty");
        up.add(new User(u,p,bd));
        System.out.println("Your account created successfully ...");
    }
    public int exf(String ku,String p)
    {
        int l=0;
        for (User u: up)
        {
            if(ku.equals("-")||p.equals("-"))
                l=3;

            else if (ku.equals(u.getUser_name()) && u.getPass().equals(p)) {
                l=1;
            }
        }
        return l;
    }
    public void theNameIsAndCategorieIsAndPriceIsAndAvailabilityIsAndDescriptionsIs(String name, String categorie, int price, int ava, String desc) {
        cp.add(new car(name, categorie, price, ava, desc));
        System.out.println("You have added this product in a successfully way");
    }
    public void listting()
    {
        for(car c:cp)
        {
            String forp=String.valueOf(c.price);
            String forp2=String.valueOf(c.availab);
            System.out.println("Name:- "+c.car_name+" || Category:- "+c.categorie+" || Price:- "+forp+" || The num of available pieces:- "+forp2+" || Discribtion about it:- "+c.descr);
        }
    }
    public void iRequestInformationAboutSpecificProductByEnteringItsName(String name) {
        for(car c: cp ){
            if(name.equals(c.car_name)){
                String k=String.valueOf(c.price);
                String f=String.valueOf(c.availab);
                System.out.println("Category:- "+c.categorie+" || Price:- "+k+" || The num of available pieces:- "+f+" || Discribtion about it:- "+c.descr);
            }
        }
    }
    public void iRequestInformationAboutSpecificProductByEnteringItsName2(String name) {

        for(car c: cp ){
            if(name.equals(c.categorie)){
                String k=String.valueOf(c.price);
                String f=String.valueOf(c.availab);
                System.out.println("Name:- "+c.car_name+" || Price:- "+k+" || The num of available pieces:- "+f+" || Discribtion about it:- "+c.descr);

            }
        }
    }
    public int iRequestInformationAboutSpecificProductByEnteringItsName22(int p) {
        int l=0;
        for(car c: cp ){
            if(p==c.price){
                String f=String.valueOf(c.availab);
                System.out.println("Name:- "+c.car_name+" || Category:- "+c.categorie+" || The num of available pieces:- "+f+" || Discribtion about it:- "+c.descr);
                l=1;
            }
            if(l==0)
                System.out.println("No product with this price in our company");
        }
        return l;
    }
    public int changeInfo(String g,String np)
    {
        int f=0;
        for(User c:up)
        {
            if(c.user_name.equals(g)) {
                c.setPass(np);
                f=1;
            }
        }
        return f;
    }
    public void seeUser()
    {
        for(User c:up)
        {
            System.out.println("Gmail:- "+c.user_name+"\t"+"Password:- "+c.pass+"\t"+"BirthDate:- "+c.BD);
        }
    }
    public boolean a1=false;
    public boolean a2=false;
    public void buying(String cn,String d,int r)
    {
        for(String dd: date) {
            if (dd.equals(d)) {
                a1 = true;
                break;
            }
        }
        int indexm=0;
        int counterte=0;
        for(car c : cp){
            if (cn.equals(c.car_name)){
                a2=true;
                indexm=counterte;
                break;
            }
            counterte++;
        }
        int fd=cp.get(indexm).availab;
        if(a1==false) {

            System.out.println("cant buy this product in this day sorry...");
        }
        else if (a2==false) {

            System.out.println("There is no product with this name in our company sorry...");
        }
        else if (fd<r) {

            System.out.println("We dont have the amount that you need from this product sorry...");
        }
        else {

            int y=cp.get(indexm).availab;
            y-=r;
            cp.get(indexm).setAvailab(y);
            System.out.println("Your installation has done in a successfully way...");
        }

    }
    Scanner input=new Scanner(System.in);
    public boolean corn()
    {
        boolean cm=true;
        String res = input.next();
        if (res.equals("No"))
            cm = false;
        return cm;
    }
    int yuy=0;
    public int yourInformationUpdatesSuccessfully(String name,String pass) {
        for (User u : up) {
            if (name.equals(u.getUser_name())) {
                u.setPass(pass);
                yuy=1;
                break;
            }
        }
        return yuy;
    }
    int a=0;
    public int theInformationShouldAppear(String name) {
        for(order o : op){
            if(name.equals(o.Uname)){
                System.out.println(o.Cname+"\t"+o.date);
                //System.out.println(o.date);
                a=1;
            }
        }
        return a;
    }
}
