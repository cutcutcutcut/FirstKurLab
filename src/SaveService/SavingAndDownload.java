package SaveService;

import Info.Info;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SavingAndDownload {

    private static final File DATA_BASE = new File("C://Users", "database.txt");

    public static void save(FileView fileView) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(DATA_BASE));
        objectOutputStream.writeObject(fileView);
        objectOutputStream.close();
    }

    public static List<Info> download() throws IOException, ClassNotFoundException {
        List<Info> info = new ArrayList<Info>();
        if (DATA_BASE.length() != 0) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DATA_BASE));
            info = (ArrayList<Info>) objectInputStream.readObject();
            objectInputStream.close();
        }
        else return null;
        return info;
    }
}
