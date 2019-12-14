package SaveService;

import Info.Customer;
import Info.Order;

import java.io.Serializable;
import java.util.List;

/**
 * Class for combination List of the Orders and Costumers
 * @author Alexey B
 * @version 1.4.2
 */
public class FileView implements Serializable {
    private List<Customer> customerList;
    private List<Order> orderList;

    /**
     * Default constructor
     */
    public FileView() {}

    /**
     * Constructor that takes fileView object in parameters and gets from him lists
     * @param fileView FileView object
     */
    public FileView(FileView fileView) {
        this.customerList = fileView.getCustomerList();
        this.orderList = fileView.getOrderList();
    }

    /**
     * Constructor that takes List of the Customers and Orders
     * @param customerList Customer list
     * @param orderList Order list
     */
    public FileView(List<Customer> customerList, List<Order> orderList) {
        this.customerList = customerList;
        this.orderList = orderList;
    }

    /**
     * getter for list of the Customers
     * @return List
     */
    public List getCustomerList() {
        return customerList;
    }

    /**
     * setter for list of the Customers
     * @param customerList List of Customers
     */
    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    /**
     * getter for list of the Orders
     * @return List
     */
    public List getOrderList() {
        return orderList;
    }


    /**
     * setter for list of the Orders
     * @param orderList List of Orders
     */
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
