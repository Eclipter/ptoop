package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.CircleDrawer;
import by.bsuir.ptoop.model.Circle;
import by.bsuir.ptoop.model.Point;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CircleModule extends DrawingModule {

    private static final String MENU_TEXT = "Draw Circle";

    public CircleModule() {
        super(MENU_TEXT);

        this.drawer = new CircleDrawer();

        menuItem.setOnAction(event -> {
            Dialog<Circle> dialog = new Dialog<>();
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
            TextField radius = new TextField();
            radius.setPromptText("radius");

            grid.add(oX, 0, 0);
            grid.add(oY, 0, 1);
            grid.add(radius, 1, 0);

            dialog.getDialogPane().setContent(grid);

            dialog.setResultConverter(button ->
            {
                if(button == drawButton)
                {
                    return new Circle(new Point(Integer.parseInt(oX.getText()), Integer.parseInt(oY.getText())),
                            Integer.parseInt(radius.getText()));
                }
                return null;
            });

            dialog.showAndWait().ifPresent(this::draw);
        });
    }
}
