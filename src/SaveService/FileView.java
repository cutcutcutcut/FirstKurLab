package SaveService;

import Info.Customer;
import Info.Info;
import Info.Order;

import java.util.ArrayList;
import java.util.List;

public class FileView {
    private List<Customer> customerList = new ArrayList<Customer>();
    private List<Order> orderList = new ArrayList<Order>();
    private List<Info> list;

    public FileView(List<Customer> customerList, List<Order> orderList) {
        this.customerList = customerList;
        this.orderList = orderList;
        list = new ArrayList<Info>();
        list.add((Info)customerList);
        list.add((Info)orderList);
    }

    public List<Info> getList() {
        return list;
    }

    public String getString() {
        String result = list.get(0).toString() + "\n";
        for (int i = 1; i < list.size(); i++) {
            result += list.get(i).toString() + "\n";
        }
        return result;
    }

    public void clear() {
        list.clear();
    }

    public Info getInfo(int index) {
        return list.get(index);
    }

    public void deleteInfo(int index) {
        list.remove(index);
    }

    public void addOrder(Order order) {
        list.add(order);
    }

    public void addCustomer(Customer customer) {
        list.add(customer);
    }

    public void setOrder(int index, Order order) {
        list.set(index, order) ;
    }

    public void setCustomer(int index, Customer customer) {
        list.set(index, customer);
    }
}
