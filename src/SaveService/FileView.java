package SaveService;

import Info.Customer;
import Info.Order;

import java.io.Serializable;
import java.util.List;

public class FileView implements Serializable {
    private List<Customer> customerList;
    private List<Order> orderList;

    public FileView() {}

    public FileView(FileView fileView) {
        this.customerList = fileView.getCustomerList();
        this.orderList = fileView.getOrderList();
    }

    public FileView(List<Customer> customerList, List<Order> orderList) {
        this.customerList = customerList;
        this.orderList = orderList;
    }

    public List getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
