package MVC;

import Info.Customer;
import Info.Order;

import java.util.HashMap;

/**
 * @author Alexey B
 * @version 1.0
 *
 * This class is a part of MVC, that realize output in console some information that user are asking for
 *
 */

public class View {

//    private HashMap<Integer, Order> orderMap = new HashMap<>();
//    private HashMap<Integer, Customer> customerMap = new HashMap<>();
//    private int orderNum = 0, customerNum = 0;

    public void orderViewer(Order order) {
//        orderMap.put(orderNum, order);
//        orderNum++;
        System.out.println(order.toString());
    }

    public void customerViewer(Customer customer) {
//        customerMap.put(customerNum, customer);
//        customerNum++;
        System.out.println(customer.toString());
    }

    public void outInfo(String message) {
        System.out.print(message + '\n');
    }

}
