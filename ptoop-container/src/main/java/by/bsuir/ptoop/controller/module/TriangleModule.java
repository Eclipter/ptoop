package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.TriangleDrawer;
import by.bsuir.ptoop.model.Point;
import by.bsuir.ptoop.model.Triangle;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TriangleModule extends DrawingModule {

    private static final String MENU_TEXT = "Draw Triangle";

    public TriangleModule() {
        super(MENU_TEXT);

        setDrawer(new TriangleDrawer());

        menuItem.setOnAction(event -> {
            Dialog<Triangle> dialog = new Dialog<>();
            dialog.setTitle(MENU_TEXT);
            ButtonType drawButton = new ButtonType("Draw", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(drawButton, ButtonType.CANCEL);

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            TextField aX = new TextField();
            aX.setPromptText("x1");
            TextField aY = new TextField();
            aY.setPromptText("y1");
            TextField bX = new TextField();
            bX.setPromptText("x2");
            TextField bY = new TextField();
            bY.setPromptText("y2");
            TextField cX = new TextField();
            cX.setPromptText("x3");
            TextField cY = new TextField();
            cY.setPromptText("y3");

            grid.add(aX, 0, 0);
            grid.add(aY, 0, 1);
            grid.add(bX, 1, 0);
            grid.add(bY, 1, 1);
            grid.add(cX, 2, 0);
            grid.add(cY, 2, 1);

            dialog.getDialogPane().setContent(grid);

            dialog.setResultConverter(button ->
            {
                if(button == drawButton)
                {
                    return new Triangle(new Point(Integer.parseInt(aX.getText()), Integer.parseInt(aY.getText())),
                            new Point(Integer.parseInt(bX.getText()), Integer.parseInt(bY.getText())),
                            new Point(Integer.parseInt(cX.getText()), Integer.parseInt(cY.getText())));
                }
                return null;
            });

            dialog.showAndWait().ifPresent(this::draw);
        });
    }
}
