package SaveService;

import Info.Customer;
import Info.Order;
import MVC.CustomerModel;
import MVC.OrderModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FileView implements Serializable {
    private CustomerModel customerList = new CustomerModel();
    private OrderModel orderList = new OrderModel();

    public FileView() {}

    public FileView(FileView fileView) {
        this.customerList = fileView.getCustomerList();
        this.orderList = fileView.getOrderList();
    }

    public FileView(CustomerModel customerList, OrderModel orderList) {
        this.customerList = customerList;
        this.orderList = orderList;
    }

    public CustomerModel getCustomerList() {
        return customerList;
    }

    public void setCustomerList(CustomerModel customerList) {
        this.customerList = customerList;
    }

    public OrderModel getOrderList() {
        return orderList;
    }

    public void setOrderList(OrderModel orderList) {
        this.orderList = orderList;
    }
}
