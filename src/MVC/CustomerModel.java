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
        runtime = fileView.getCustomerList().getRuntime();
    }

    public List<Customer> getRuntime() {
        return runtime;
    }

    public void add(Customer forAdd) {
        runtime.add(forAdd);
    }

    public Customer get(int index) {
        if (index < 0 || index > runtime.size()) throw new BadInputExсeption("Incorrect index");
        return runtime.get(index);
    }

    public void set(Customer forChange, int index) {
        if (index < 0 || index > runtime.size()) throw new BadInputExсeption("Incorrect index");
        runtime.set(index, forChange);
    }

    public void remove(int index) {
        if (index < 0 || index > runtime.size()) throw new BadInputExсeption("Incorrect index");
        runtime.remove(index);
    }

    public void clear() {
        runtime.clear();
    }

    @Override
    public String toString() {
        String result = "Costumers:\n";
        for (Customer c: runtime) {
            result += c.toString();
            result+="\n";
        }
        return result;
    }

    public boolean isEmpty() {
        return runtime.size() <= 0;
    }
}
