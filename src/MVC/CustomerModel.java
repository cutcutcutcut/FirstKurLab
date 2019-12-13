package MVC;

import Info.Customer;
import SaveService.FileView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerModel implements Serializable {
    private static List<Customer> runtime = new ArrayList<Customer>();

    public CustomerModel() {}

    public CustomerModel(FileView fileView) {
        runtime = fileView.getCustomerList();
    }

    public List<Customer> getRuntime() {
        return runtime;
    }

    private int searchById(UUID id) {
        for (int i = 0; i < runtime.size(); i++) {
            if (runtime.get(i).getIdCustomer() == id) {
                return i;
            }
        }
        throw new IllegalArgumentException("Id is not found.");
    }

    public void add(Customer forAdd) {
        runtime.add(forAdd);
    }

    public Customer get(UUID id) {
        return runtime.get(this.searchById(id));
    }

    public void set(Customer forChange, UUID id) {
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

    public int getNumById(UUID id) {
        return runtime.get(searchById(id)).getNumOrder();
    }

    public boolean numCheck(int num) {
        for (int i = 0; i < runtime.size(); i++) {
            if (runtime.get(i).getNumOrder() == num) return true;
        }
        return false;
    }
}
