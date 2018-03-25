package by.bsuir.ptoop.controller.dialog;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CustomModuleLoadingDialog extends AbstractDialog<String> {

    public CustomModuleLoadingDialog() {

        this.setTitle("Load Custom Module");
        ButtonType loadButton = new ButtonType("Find and Load", ButtonBar.ButtonData.OK_DONE);
        this.getDialogPane().getButtonTypes().addAll(loadButton, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField figureNameField = new TextField();
        figureNameField.setPromptText("Module name");

        grid.add(figureNameField, 0, 0);

        this.getDialogPane().setContent(grid);

        this.setResultConverter(button ->
        {
            if (button == loadButton) {
                return figureNameField.getText();
            }
            return null;
        });
    }
}
