package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.RoundRectangleDrawer;
import by.bsuir.ptoop.model.Point;
import by.bsuir.ptoop.model.RoundRectangle;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class RoundRectangleModule extends DrawingModule {

    private static final String MENU_TEXT = "Draw Round Rectangle";

    public RoundRectangleModule() {
        super(MENU_TEXT);

        setDrawer(new RoundRectangleDrawer());

        menuItem.setOnAction(event -> {
            Dialog<RoundRectangle> dialog = new Dialog<>();
            dialog.setTitle(MENU_TEXT);
            ButtonType drawButton = new ButtonType("Draw", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(drawButton, ButtonType.CANCEL);

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            TextField oX = new TextField();
            oX.setPromptText("x");
            TextField oY = new TextField();
            oY.setPromptText("y");
            TextField width = new TextField();
            width.setPromptText("width");
            TextField height = new TextField();
            height.setPromptText("height");
            TextField arcWidth = new TextField();
            arcWidth.setPromptText("arc width");
            TextField arcHeight = new TextField();
            arcHeight.setPromptText("arc height");

            grid.add(oX, 0, 0);
            grid.add(oY, 0, 1);
            grid.add(width, 1, 0);
            grid.add(height, 1, 1);
            grid.add(arcWidth, 2, 0);
            grid.add(arcHeight, 2, 1);

            dialog.getDialogPane().setContent(grid);

            dialog.setResultConverter(button ->
            {
                if(button == drawButton)
                {
                    return new RoundRectangle(new Point(Integer.parseInt(oX.getText()), Integer.parseInt(oY.getText())),
                            Integer.parseInt(width.getText()), Integer.parseInt(height.getText()),
                            Integer.parseInt(arcWidth.getText()), Integer.parseInt(arcHeight.getText()));
                }
                return null;
            });

            dialog.showAndWait().ifPresent(this::draw);
        });
    }
}
