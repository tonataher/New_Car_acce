package today.edu;

public class order {
    public String Uname;
    public String Cname;
    public String date;

    public order(String uname, String cname, String datee){
        Uname = uname;
        Cname = cname;
        date = datee;
    }

    public String getCname() {
        return Cname;
    }

    public String getDate() {
        return date;
    }

    public String getUname() {
        return Uname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUname(String uname) {
        Uname = uname;
    }
}
