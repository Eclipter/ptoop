package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.drawer.AbstractDrawer;
import by.bsuir.ptoop.controller.editor.AbstractEditor;
import by.bsuir.ptoop.controller.editor.ChecksumSavingEditor;
import by.bsuir.ptoop.controller.util.ChecksumSaver;
import by.bsuir.ptoop.controller.util.ChecksumSaverProcessorAdapter;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.util.Optional;

public class ChecksumSavingModule extends DrawingModule {

    private static final String MENU_TEXT = "Save checksum for figures";

    public ChecksumSavingModule() {
        super(MENU_TEXT);

        menuItem.setOnAction(event -> {
            try {
                ChecksumSaver saver = new ChecksumSaverProcessorAdapter();
                boolean saved = saver.saveFiguresChecksum(figures);
                if (saved) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Checksum has been saved", ButtonType.OK);
                    alert.showAndWait();
                }
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                alert.showAndWait();
            }
        });
    }

    @Override
    public AbstractEditor getEditor() {
        return new ChecksumSavingEditor();
    }

    @Override
    public Optional<AbstractDrawer> currentDrawer() {
        return Optional.empty();
    }
}
