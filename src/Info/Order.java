package Info;

public class Order {
    private int num;
    private double orderSum;
    private String date;
    private Orderer orderer;

    public Order(int num, Orderer orderer, String date, double orderSum) {
        this.num = num;
        this.orderer = orderer;
        this.date = date;
        this.orderSum = orderSum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Orderer getOrderer() {
        return orderer;
    }

    public void setOrderer(Orderer orderer) {
        this.orderer = orderer;
    }

    public double getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(double orderSum) {
        this.orderSum = orderSum;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "\nOrder:\nNumber - " + num + "\n\t" + orderer.toString() + "\nDate - " + date + "\nTotal price - " + orderSum + "\n";
    }
}
