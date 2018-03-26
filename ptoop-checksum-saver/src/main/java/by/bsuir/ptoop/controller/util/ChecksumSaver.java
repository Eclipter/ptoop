package by.bsuir.ptoop.controller.util;

import by.bsuir.ptoop.model.FigureList;

import java.io.IOException;

public interface ChecksumSaver {
    boolean saveFiguresChecksum(FigureList figures) throws IOException;
}
