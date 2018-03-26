package by.bsuir.ptoop.controller.util;

import by.bsuir.ptoop.model.FigureList;

import java.io.IOException;

public interface ChecksumChecker {
    void checkFiguresChecksum (FigureList figures) throws IOException;
}
