package MVC;

import Info.Customer;
import SaveService.FileView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel implements Serializable {
    private static List<Customer> runtime = new ArrayList<Customer>();

    public CustomerModel() {}

    public CustomerModel(FileView fileView) {
        runtime = fileView.getCustomerList();
    }

    public List<Customer> getRuntime() {
        return runtime;
    }

    public void add(Customer forAdd) {
        runtime.add(forAdd);
    }

    public void set(Customer forChange, int index) {
        runtime.set(index, forChange);
    }

    public void remove(int index) {
        runtime.remove(index);
    }

    public void clear() {
        runtime.clear();
    }
}
