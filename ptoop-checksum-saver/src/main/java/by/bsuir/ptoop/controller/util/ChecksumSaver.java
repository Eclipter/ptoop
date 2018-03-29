package by.bsuir.ptoop.controller.util;

import by.bsuir.ptoop.model.FigureList;

import java.io.IOException;

/**
 * Checksum checking interface used in corresponding functionality module
 */
public interface ChecksumSaver {
    boolean saveFiguresChecksum(FigureList figures) throws IOException;
}
