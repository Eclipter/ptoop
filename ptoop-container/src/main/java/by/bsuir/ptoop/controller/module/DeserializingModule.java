package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.model.FigureList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializingModule extends DrawingModule {

    private static final String MENU_TEXT = "Deserialize objects";

    public DeserializingModule() {
        super(MENU_TEXT);

        menuItem.setOnAction(event ->
        {
            Dialog<String> dialog = new Dialog<>();

            dialog.setTitle(MENU_TEXT);
            ButtonType serializeButton = new ButtonType("Deserialize", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(serializeButton, ButtonType.CANCEL);

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            TextField filenameField = new TextField();
            filenameField.setPromptText("Filename");

            grid.add(filenameField, 0, 0);

            dialog.getDialogPane().setContent(grid);

            dialog.setResultConverter(button ->
            {
                if(button == serializeButton)
                {
                    return filenameField.getText();
                }
                return null;
            });

            dialog.showAndWait().ifPresent(filename ->
            {
                try
                {
                    ObjectInputStream stream = new ObjectInputStream(new FileInputStream(new File(filename)));
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
}
