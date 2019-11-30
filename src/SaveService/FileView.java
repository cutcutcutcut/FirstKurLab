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


}
