package Info;

/**
 * @author Alexey B, Nikita K
 * @version 1.0
 *
 * This is one of the info classes, that contains information about order
 *
 */

public class Order {
    private int num;
    private double orderSum;
    private String date;
    private Orderer orderer;

    /**
     * Constructor that takes all field and create object
     * @param num
     * @param orderer
     * @param date
     * @param orderSum
     */

    public Order(int num, Orderer orderer, String date, double orderSum) {
        this.num = num;
        this.orderer = orderer;
        this.date = date;
        this.orderSum = orderSum;
    }

    /**
     * Getter field date
     * @return string date of an order
     */

    public String getDate() {
        return date;
    }

    /**
     *
     * Setter for field date
     * @param date string
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Getter field orderer
     * @return object of orderer class
     */

    public Orderer getOrderer() {
        return orderer;
    }

    /**
     *
     * Setter for field orderer
     * @param orderer orderer
     */

    public void setOrderer(Orderer orderer) {
        this.orderer = orderer;
    }

    /**
     * Getter field sum of an order
     * @return double value sum
     */

    public double getOrderSum() {
        return orderSum;
    }

    /**
     *
     * Setter for field orderSum
     * @param orderSum double
     */

    public void setOrderSum(double orderSum) {
        this.orderSum = orderSum;
    }

    /**
     * Getter field number of an order
     * @return int value num
     */

    public int getNum() {
        return num;
    }

    /**
     *
     * Setter for field num of an order
     * @param num int
     */

    public void setNum(int num) {
        this.num = num;
    }

    /**
     * Method realizes the conversion object in string
     * @return string
     */
    @Override
    public String toString() {
        return "\nOrder:\nNumber - " + num + "\n\t" + orderer.toString() + "\nDate - " + date + "\nTotal price - " + orderSum + "\n";
    }
}
