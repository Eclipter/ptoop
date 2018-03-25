package by.bsuir.ptoop.controller.dialog;

import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Point;
import by.bsuir.ptoop.model.RoundRectangle;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;



public class RoundRectangleDialog extends AbstractDialog<Figure> {

    private TextField oX;
    private TextField oY;
    private TextField width;
    private TextField height;
    private TextField arcWidth;
    private TextField arcHeight;

    public RoundRectangleDialog() {

        this.setTitle("Add Round Rectangle");
        ButtonType drawButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        this.getDialogPane().getButtonTypes().addAll(drawButton, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        oX = new TextField();
        oX.setPromptText("x");
        oY = new TextField();
        oY.setPromptText("y");
        width = new TextField();
        width.setPromptText("width");
        height = new TextField();
        height.setPromptText("height");
        arcWidth = new TextField();
        arcWidth.setPromptText("arc width");
        arcHeight = new TextField();
        arcHeight.setPromptText("arc height");

        grid.add(oX, 0, 0);
        grid.add(oY, 0, 1);
        grid.add(width, 1, 0);
        grid.add(height, 1, 1);
        grid.add(arcWidth, 2, 0);
        grid.add(arcHeight, 2, 1);

        this.getDialogPane().setContent(grid);

        this.setResultConverter(button ->
        {
            if(button == drawButton)
            {
                return new RoundRectangle(new Point(Integer.parseInt(oX.getText()), Integer.parseInt(oY.getText())),
                        Integer.parseInt(width.getText()), Integer.parseInt(height.getText()),
                        Integer.parseInt(arcWidth.getText()), Integer.parseInt(arcHeight.getText()));
            }
            return null;
        });
    }

    public RoundRectangleDialog(Figure figure) {
        this();
        RoundRectangle roundRectangle = (RoundRectangle) figure;
        oX.setText(String.valueOf(roundRectangle.getA().getX()));
        oY.setText(String.valueOf(roundRectangle.getA().getY()));
        width.setText(String.valueOf(roundRectangle.getWidth()));
        height.setText(String.valueOf(roundRectangle.getHeight()));
        arcWidth.setText(String.valueOf(roundRectangle.getArcWidth()));
        arcHeight.setText(String.valueOf(roundRectangle.getHeight()));
    }
}
