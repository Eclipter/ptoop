package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.PointDrawer;
import by.bsuir.ptoop.model.Point;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PointModule extends DrawingModule {

    private static final String MENU_TEXT = "Draw Point";

    public PointModule() {
        super(MENU_TEXT);

        this.drawer = new PointDrawer();

        menuItem.setOnAction(event -> {
            Dialog<Point> dialog = new Dialog<>();
            dialog.setTitle(MENU_TEXT);
            ButtonType drawButton = new ButtonType("Draw", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(drawButton, ButtonType.CANCEL);

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            TextField x = new TextField();
            x.setPromptText("x");
            TextField y = new TextField();
            y.setPromptText("y");

            grid.add(x, 0, 0);
            grid.add(y, 0, 1);

            dialog.getDialogPane().setContent(grid);

            dialog.setResultConverter(button ->
            {
                if(button == drawButton)
                {
                    return new Point(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()));
                }
                return null;
            });

            dialog.showAndWait().ifPresent(this::draw);
        });
    }
}
