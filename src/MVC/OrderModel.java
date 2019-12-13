package MVC;


import Info.Order;
import SaveService.FileView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderModel implements Serializable {

    public List<Order> getRuntime() {
        return runtime;
    }

    private static List<Order> runtime = new ArrayList<Order>();

    public OrderModel() {}

    public OrderModel(FileView fileView) {
        runtime = fileView.getOrderList();
    }

    //

    public void add(Order forAdd) {
        runtime.add(forAdd);
    }

    public int searchById(UUID id) {
        for (int i = 0 ; i < runtime.size(); i++) {
            if (runtime.get(i).getIdOrder() == id)  {
                return i;
            }
        }
        return 0;
    }
    public Order get(UUID id) {
        return runtime.get(this.searchById(id));
    }

    public void set(Order forChange, UUID id)  {
        runtime.set(this.searchById(id), forChange);
    }

    public void remove(UUID id) {
        runtime.remove(this.searchById(id));
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

    public int getNumById(UUID id) {
        return runtime.get(this.searchById(id)).getNum();
    }

    public boolean numCheck(int num) {
        for (int i = 0; i < runtime.size(); i++) {
            if (runtime.get(i).getNum() == num) return true;
        }
        return false;
    }
}
