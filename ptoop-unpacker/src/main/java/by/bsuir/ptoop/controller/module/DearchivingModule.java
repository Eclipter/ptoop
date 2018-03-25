package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.AbstractDrawer;
import by.bsuir.ptoop.controller.editor.AbstractEditor;
import by.bsuir.ptoop.controller.editor.DearchivingEditor;
import by.bsuir.ptoop.model.FigureList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Optional;
import java.util.zip.GZIPInputStream;

public class DearchivingModule extends DrawingModule {

    private static final String MENU_TEXT = "Unpack figures";

    public DearchivingModule() {
        super(MENU_TEXT);

        menuItem.setOnAction(event ->
        {
            getEditor().newDialog().showAndWait().ifPresent(filename ->
            {
                try
                {
                    ObjectInputStream stream = new ObjectInputStream(
                            new GZIPInputStream(new FileInputStream(new File(filename + ".gz"))));
                    FigureList figures = (FigureList) stream.readObject();
                    stream.close();

                    figures.forEach(this::draw);

                } catch (IOException | ClassNotFoundException e)
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
        return new DearchivingEditor();
    }

    @Override
    public Optional<AbstractDrawer> currentDrawer() {
        return Optional.empty();
    }
}
