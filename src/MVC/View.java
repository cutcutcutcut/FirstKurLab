package MVC;

import Info.Customer;
import Info.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Alexey B
 * @version 1.4.2
 *
 * This class is a part of MVC, that realize output in console some information that user are asking for
 *
 */

public class View {


    private Map<Integer, UUID> orderNumToId = new HashMap<>();
    private Map<Integer, UUID> customerNumToId = new HashMap<>();
    private OrderModel orderModel;
    private CustomerModel customerModel;

    /**
     * Constructor takes Models OrderModel and CustomerModel objects
     * @param orderModel OrderModel
     * @param customerModel CustomerModel
     */
    public View(OrderModel orderModel, CustomerModel customerModel) {
        this.orderModel = orderModel;
        this.customerModel = customerModel;
    }

    /**
     * getter for size of Order hashMap
     * @return int
     */
    public int getOrderMapSize() {
        return orderNumToId.size();
    }

    /**
     * getter for size of Customer hashMap
     * @return int
     */
    public int getCustomerMapSize() {
        return customerNumToId.size();
    }

    /**
     * getter for Order id by index in hashMap
     * @param num index
     * @return UUID object
     */
    public UUID getOrderId(int num) {
        return orderNumToId.get(num);
    }

    /**
     * getter for Customer id by index in hashMap
     * @param num index
     * @return UUID object
     */
    public UUID getCustomerId(int num) {
        return customerNumToId.get(num);
    }

    /**
     * Method uses for each and output Order objects
     * also fill the map by temp number and id
     */
    public void orderViewer() {
        int num = 0;
        System.out.println("Orders:\n");
        for(Order order : orderModel.getRuntime())
        {
            System.out.println("" + num++ + ")" +  order);
            orderNumToId.put(num, order.getIdOrder());
        }

    }

    /**
     * Method uses for each and output Customer objects
     * also fill the map by temp number and id
     */
    public void customerViewer() {
        int num = 0;
        System.out.println("Customers:\n");
        for (Customer customer: customerModel.getRuntime())
        {
            System.out.println("" + num++ + ")" +  customer);
            customerNumToId.put(num, customer.getIdCustomer());
        }
    }

    /**
     * Method for output in console string
     * @param message string to output
     */
    public void outInfo(String message) {
        System.out.print(message + '\n');
    }

}
