package MVC;


import Info.Order;
import SaveService.FileView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderModel implements Serializable {

    public List<Order> getRuntime() {
        return runtime;
    }

    private static List<Order> runtime = new ArrayList<Order>();

    public OrderModel() {}

    public OrderModel(FileView fileView) {
        runtime = fileView.getOrderList().getRuntime();
    }

    //

    public void add(Order forAdd) {
        runtime.add(forAdd);
    }

    public Order get(int index) { return runtime.get(index);}

    public void set(Order forChange, int index) {
        runtime.set(index, forChange);
    }

    public void remove(int index) {
        runtime.remove(index);
    }

    public void clear() {
        runtime.clear();
    }

    @Override
    public String toString() {
        String result = "Orders:\n";
        for (Order c: runtime) {
            result += c.toString();
        }
        return result;
    }


    public boolean isEmpty() {
        return runtime.size() <= 0;
    }


    public boolean numCheck(int num) {
        boolean result = false;
        for (int i = 0; i < runtime.size(); i++) {
            if (runtime.get(i).getNum() == num) result = true;
        }
        return result;
    }
}
