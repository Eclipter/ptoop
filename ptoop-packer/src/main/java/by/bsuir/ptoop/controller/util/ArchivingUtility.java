package by.bsuir.ptoop.controller.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPOutputStream;

public final class ArchivingUtility {

    public static void archiveObject(String filename, Object object) throws IOException
    {
        GZIPOutputStream outputStream = new GZIPOutputStream(new FileOutputStream(new File(filename + ".gz")));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }

    private ArchivingUtility() {
    }
}
