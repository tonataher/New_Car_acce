package today.edu;

public class car {
    public String car_name;
    public String categorie;
    public int price;
    public int availab;
    public String descr;

    public car(String N, String C, int P,int A, String D){
        car_name=N;
        categorie=C;
        price=P;
        availab=A;
        descr=D;
    }

    public int getPrice() {
        return price;
    }

    public int getAvailab() {
        return availab;
    }

    public String getCar_name() {
        return car_name;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getDescr() {
        return descr;
    }

    public void setAvailab(int availab) {
        this.availab = availab;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
