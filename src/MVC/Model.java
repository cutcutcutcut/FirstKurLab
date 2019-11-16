package MVC;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Alexey B, Nikita K
 *  * @version 1.0
 *
 * This class is a part of MVC, that contains treatment of info classes
 */
public class Model {

    /**
     * First field is the data base file to keep info
     * Second one is variable container for time while program are working
     *
     */

    private static final File DATA_BASE = new File("C://Users", "database.txt");
    private static ArrayList<Object> runtime = new ArrayList<Object>();

    /**
     * Method fill variable container when program starts
     * @throws IOException when something goes wrong in reading info from file
     * @throws ClassNotFoundException if input stream does not found object of our class
     */

    static void rewrite() throws IOException, ClassNotFoundException {
        if (DATA_BASE.length() != 0) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DATA_BASE));
            runtime = (ArrayList<Object>) objectInputStream.readObject();
            objectInputStream.close();
        }
    }

    /**
     *
     * Putting all information from array to data base(when program stops)
     * @throws IOException exception arises when smth goes wrong in output stream
     */

    static void writeEnd() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(DATA_BASE));
        objectOutputStream.writeObject(runtime);
        objectOutputStream.close();
    }

    /**
     * Method adds some new object in system
     * @param forAdd object that user wants to add in data base
     */

    static void add(Object forAdd) {
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

    static void change(int index, Object forChange) throws IndexOutOfBoundsException {
        runtime.set(index, forChange);
    }
}
