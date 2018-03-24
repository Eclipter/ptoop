package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.LineDrawer;
import by.bsuir.ptoop.model.Line;
import by.bsuir.ptoop.model.Point;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LineModule extends DrawingModule {

    private static final String MENU_TEXT = "Draw Line";

    public LineModule() {
        super(MENU_TEXT);

        setDrawer(new LineDrawer());

        menuItem.setOnAction(event -> {
            Dialog<Line> dialog = new Dialog<>();
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

            grid.add(aX, 0, 0);
            grid.add(aY, 0, 1);
            grid.add(bX, 1, 0);
            grid.add(bY, 1, 1);

            dialog.getDialogPane().setContent(grid);

            dialog.setResultConverter(button ->
            {
                if(button == drawButton)
                {
                    return new Line(new Point(Integer.parseInt(aX.getText()), Integer.parseInt(aY.getText())),
                            new Point(Integer.parseInt(bX.getText()), Integer.parseInt(bY.getText())));
                }
                return null;
            });

            dialog.showAndWait().ifPresent(this::draw);
        });
    }
}
