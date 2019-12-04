package SaveService;

import java.io.*;

public class SavingAndDownload {

    private static final File DATA_BASE = new File("C://Users", "database.txt");

    public static void save(FileView fileView) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(DATA_BASE));
        objectOutputStream.writeObject(fileView);
        objectOutputStream.close();
    }

    public static FileView download() throws IOException, ClassNotFoundException {
        FileView info = new FileView();
        if (DATA_BASE.length() != 0) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DATA_BASE));
            info = (FileView) objectInputStream.readObject();
            objectInputStream.close();
        }
        else return null;
        return info;
    }
}
