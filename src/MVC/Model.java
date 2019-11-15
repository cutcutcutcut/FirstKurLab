package MVC;

import java.io.*;
import java.util.ArrayList;

public class Model {


    private static final File database = new File("C://Users", "database.txt");
    private static ArrayList<Object> runtime = new ArrayList<Object>();

    //write data from previous runs program

    static void rewrite() throws IOException, ClassNotFoundException {
        if (database.length() != 0) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(database));
            runtime = (ArrayList<Object>) objectInputStream.readObject();
            objectInputStream.close();
        }
    }

    //putting all information from array to data base(when program stops)

    static void writeEnd() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(database));
        objectOutputStream.writeObject(runtime);
        objectOutputStream.close();
    }

    //adding new element

    static void add(Object forAdd) {
        runtime.add(forAdd);
    }

    //deleting element by index

    static void delete(int index) throws IndexOutOfBoundsException {
        runtime.remove(index);
    }

    //changing element by index

    static void change(int index, Object forChange) throws IndexOutOfBoundsException {
        runtime.set(index, forChange);
    }
}
