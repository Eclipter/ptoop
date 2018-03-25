package by.bsuir.ptoop.controller.dialog;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SerializingDialog extends AbstractDialog<String> {

    public SerializingDialog() {

        this.setTitle("Serialize drawn objects");
        ButtonType serializeButton = new ButtonType("Serialize", ButtonBar.ButtonData.OK_DONE);
        this.getDialogPane().getButtonTypes().addAll(serializeButton, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField filenameField = new TextField();
        filenameField.setPromptText("Filename");

        grid.add(filenameField, 0, 0);

        this.getDialogPane().setContent(grid);

        this.setResultConverter(button ->
        {
            if(button == serializeButton)
            {
                return filenameField.getText();
            }
            return null;
        });
    }
}
