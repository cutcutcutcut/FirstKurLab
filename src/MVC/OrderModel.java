package MVC;


import Info.Info;
import Info.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderModel {

    public static List<Order> getRuntime() {
        return runtime;
    }

    private static List<Order> runtime = new ArrayList<Order>();

    public OrderModel(List<Info> info) {
        for (int i = 0; i < info.size(); i++)
            if (info.get(i) instanceof Order) runtime.add((Order)info.get(i));

    }

    protected void add(Order forAdd) {
        runtime.add(forAdd);
    }

    protected void set(Order forChange, int index) {
        runtime.set(index, forChange);
    }

    protected void remove(int index) {
        runtime.remove(index);
    }
}
