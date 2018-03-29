package by.bsuir.ptoop.controller.util;

import by.bsuir.oop.processor.ChecksumSaverProcessor;
import by.bsuir.ptoop.model.FigureList;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Adapter class that uses checksum calculating and saving logic from https://github.com/artvit/ptoop
 */
public class ChecksumSaverProcessorAdapter extends ChecksumSaverProcessor implements ChecksumSaver {

    public boolean saveFiguresChecksum(FigureList figures) throws IOException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutput objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(figures);
        objectOutputStream.flush();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        byte[] checksum = processData(bytes);
        objectOutputStream.close();
        byteArrayOutputStream.close();
        return checksum != null;
    }
}
