package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.drawer.AbstractDrawer;
import by.bsuir.ptoop.controller.editor.AbstractEditor;
import by.bsuir.ptoop.controller.editor.ChecksumCheckingEditor;
import by.bsuir.ptoop.controller.util.ChecksumChecker;
import by.bsuir.ptoop.controller.util.ChecksumCheckingProcessorAdapter;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.util.Optional;

public class ChecksumCheckingModule extends DrawingModule {

    private static final String MENU_TEXT = "Check figures checksum";

    public ChecksumCheckingModule() {
        super(MENU_TEXT);

        menuItem.setOnAction(event -> {
            try {
                ChecksumChecker checker = new ChecksumCheckingProcessorAdapter();
                checker.checkFiguresChecksum(figures);
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                alert.showAndWait();
            }
        });
    }

    @Override
    public AbstractEditor getEditor() {
        return new ChecksumCheckingEditor();
    }

    @Override
    public Optional<AbstractDrawer> currentDrawer() {
        return Optional.empty();
    }
}
