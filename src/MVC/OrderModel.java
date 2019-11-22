package MVC;

import Info.Order;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexey B, Nikita K
 *  * @version 1.0
 *
 * This class is a part of MVC, that contains treatment of info classes
 */
public class OrderModel {

    /**
     * First field is the data base file to keep info
     * Second one is variable container for time while program are working
     *
     */

    private static List runtime = new ArrayList<Order>();
    /**
     * Method adds some new object in system
     * @param forAdd object that user wants to add in data base
     */

    static void add(Order forAdd) {
        runtime.add(forAdd);
    }

    /**
     * Method deletes object from container by index
     * @param index index of object that user wants to delete
     * @throws IndexOutOfBoundsException if index that enter user is negative or more than count object in container
     */

    static void delete(int index) throws IndexOutOfBoundsException {
        runtime.remove(index);
    }

    /**
     * @param index index of object that user wants to change
     * @param forChange new object that place on place by index
     * @throws IndexOutOfBoundsException if index that enter user is negative or more than count object in container
     */

    static void change(int index, Order forChange) throws IndexOutOfBoundsException {
        runtime.set(index, forChange);
    }
}
