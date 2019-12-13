package MVC;

import Info.Customer;
import Info.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Alexey B
 * @version 1.0
 *
 * This class is a part of MVC, that realize output in console some information that user are asking for
 *
 */

public class View {


    private Map<Integer, UUID> orderNumToId = new HashMap<>();
    private Map<Integer, UUID> customerNumToId = new HashMap<>();
    private OrderModel orderModel;
    private CustomerModel customerModel;

    public View(OrderModel orderModel, CustomerModel customerModel) {
        this.orderModel = orderModel;
        this.customerModel = customerModel;
    }

    public int getOrderMapSize() {
        return orderNumToId.size();
    }

    public int getCustomerMapSize() {
        return customerNumToId.size();
    }

    public UUID getOrderId(int num) {
        return orderNumToId.get(num);
    }

    public UUID getCustomerId(int num) {
        return customerNumToId.get(num);
    }

    public void orderViewer() {
        int num = 0;
        for(Order order : orderModel.getRuntime())
        {
            System.out.println("Number order = " + num++ + order);
            orderNumToId.put(num, order.getIdOrder());
        }

    }

    public void customerViewer() {
        int num = 0;
        for (Customer customer: customerModel.getRuntime())
        {
            System.out.println("Number customer = " + num++ + "\n" + customer);
            customerNumToId.put(num, customer.getIdCustomer());
        }
    }

    public void outInfo(String message) {
        System.out.print(message + '\n');
    }

}
