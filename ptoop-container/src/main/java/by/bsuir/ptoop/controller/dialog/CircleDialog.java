package by.bsuir.ptoop.controller.dialog;

import by.bsuir.ptoop.model.Circle;
import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Point;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CircleDialog extends AbstractDialog<Figure> {

    private TextField oX;
    private TextField oY;
    private TextField radius;

    public CircleDialog() {

        this.setTitle("Add Circle");
        ButtonType drawButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        setConfirmButton(drawButton);
        this.getDialogPane().getButtonTypes().addAll(drawButton, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        oX = new TextField();
        oX.setPromptText("x");
        oY = new TextField();
        oY.setPromptText("y");
        radius = new TextField();
        radius.setPromptText("radius");

        grid.add(oX, 0, 0);
        grid.add(oY, 0, 1);
        grid.add(radius, 1, 0);

        setResultConverter(button ->
        {
            if(button == drawButton)
            {
                return new Circle(new Point(Integer.parseInt(oX.getText()), Integer.parseInt(oY.getText())),
                        Integer.parseInt(radius.getText()));
            }
            return null;
        });

        this.getDialogPane().setContent(grid);
    }

    public CircleDialog(Figure figure)
    {
        Circle circle = (Circle) figure;
        oX.setText(String.valueOf(circle.getO().getX()));
        oY.setText(String.valueOf(circle.getO().getY()));
        radius.setText(String.valueOf(circle.getRadius()));
    }
}
