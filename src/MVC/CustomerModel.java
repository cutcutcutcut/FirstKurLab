package MVC;

import Info.Customer;
import Info.Info;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {
    private static List<Customer> runtime = new ArrayList<Customer>();

    public static List<Customer> getRuntime() {
        return runtime;
    }
//
//    public CustomerModel(List<Info> info) throws IOException, ClassNotFoundException {
//        for (int i = 0; i < info.size(); i++)
//            if (info.get(i) instanceof Customer) runtime.add((Customer)info.get(i));
//    }

    public void add(Customer forAdd) {
        runtime.add(forAdd);
    }

    public void set(Customer forChange, int index) {
        runtime.set(index, forChange);
    }

    public void remove(int index) {
        runtime.remove(index);
    }
}
