package Info;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @author Alexey B
 * @version 1.0
 *
 * This is one of the info classes, that contains information about order
 *
 */

public class Order implements Serializable {
    private int num;
    private double orderSum;
    private Calendar date;
    private Customer customer;
    private UUID idOrder;
    /**
     * Constructor that takes all field and create object
     *
     * @param num
     * @param customer
     * @param date
     * @param orderSum
     */

    public Order(int num, Customer customer, Calendar date, double orderSum) {
        idOrder = UUID.randomUUID();
        this.num = num;
        this.customer = customer;
        this.date = date;
        this.orderSum = orderSum;
    }

    public UUID getIdOrder() {
        return idOrder;
    }

    /**
     * Getter field date
     *
     * @return string date of an order
     */

    public Calendar getDate() {
        return date;
    }

    /**
     * Setter for field date
     *
     * @param date string
     */

    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * Getter field orderer
     *
     * @return object of orderer class
     */

    public Customer getCustomer() {
        return customer;
    }

    /**
     * Setter for field orderer
     *
     * @param customer orderer
     */

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Getter field sum of an order
     *
     * @return double value sum
     */

    public double getOrderSum() {
        return orderSum;
    }

    /**
     * Setter for field orderSum
     *
     * @param orderSum double
     */

    public void setOrderSum(double orderSum) {
        this.orderSum = orderSum;
    }

    /**
     * Getter field number of an order
     *
     * @return int value num
     */

    public int getNum() {
        return num;
    }

    /**
     * Setter for field num of an order
     *
     * @param num int
     */

    public void setNum(int num) {
        this.num = num;
    }

    /**
     * Method realizes the conversion object in string
     *
     * @return string
     */
    @Override
    public String toString() {
        return "\nOrder:\nNumber - " + num + "\n\t" + customer.toString() + "\nDate - " + date + "\nTotal price - " + orderSum + "\n";
    }

}
