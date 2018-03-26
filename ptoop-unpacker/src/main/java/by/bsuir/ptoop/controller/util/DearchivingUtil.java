package by.bsuir.ptoop.controller.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.zip.GZIPInputStream;

public final class DearchivingUtil {

    public static Object dearchiveObject(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(
                new GZIPInputStream(new FileInputStream(new File(filename + ".gz"))));
        Object object = stream.readObject();
        stream.close();
        return object;
    }

    private DearchivingUtil() {
    }
}
