package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.drawer.AbstractDrawer;
import by.bsuir.ptoop.controller.editor.AbstractEditor;
import by.bsuir.ptoop.controller.editor.SerializingEditor;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Optional;

public class SerializingModule extends DrawingModule {

    private static final String MENU_TEXT = "Serialize drawn objects";

    public SerializingModule() {
        super(MENU_TEXT);

        menuItem.setOnAction(event ->
        {
            getEditor().newDialog().showAndWait().ifPresent(filename ->
            {
                try
                {
                    ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File((String) filename)));
                    stream.writeObject(getFigures());
                    stream.close();

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
        return new SerializingEditor();
    }

    @Override
    public Optional<AbstractDrawer> currentDrawer() {
        return Optional.empty();
    }
}
