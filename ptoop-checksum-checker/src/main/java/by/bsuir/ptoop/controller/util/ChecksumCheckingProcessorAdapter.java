package by.bsuir.ptoop.controller.util;

import by.bsuir.oop.processor.ChecksumCheckerProcessor;
import by.bsuir.ptoop.model.FigureList;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Adapter class that uses checksum checking logic from https://github.com/artvit/ptoop
 */
public class ChecksumCheckingProcessorAdapter extends ChecksumCheckerProcessor implements ChecksumChecker {

    @Override
    public void checkFiguresChecksum(FigureList figures) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutput objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(figures);
        objectOutputStream.flush();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        byte[] data = processData(bytes);
        objectOutputStream.close();
        byteArrayOutputStream.close();
    }
}
