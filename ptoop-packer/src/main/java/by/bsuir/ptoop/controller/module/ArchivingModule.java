package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.AbstractDrawer;
import by.bsuir.ptoop.controller.editor.AbstractEditor;
import by.bsuir.ptoop.controller.editor.ArchivingEditor;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Optional;
import java.util.zip.GZIPOutputStream;

public class ArchivingModule extends DrawingModule {

    private static final String MENU_TEXT = "Archive figures";

    public ArchivingModule() {
        super(MENU_TEXT);

        menuItem.setOnAction(event ->
        {
            getEditor().newDialog().showAndWait().ifPresent(filename ->
            {
                try
                {
                    GZIPOutputStream outputStream = new GZIPOutputStream(new FileOutputStream(new File(filename + ".gz")));
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    objectOutputStream.writeObject(figures);
                    objectOutputStream.close();

                } catch (IOException e)
                {
                    e.printStackTrace();
                    Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                    alert.showAndWait();
                }
            });
        });
    }

    @Override
    public AbstractEditor getEditor() {
        return new ArchivingEditor();
    }

    @Override
    public Optional<AbstractDrawer> currentDrawer() {
        return Optional.empty();
    }
}
