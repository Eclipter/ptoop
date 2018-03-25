package by.bsuir.ptoop.controller.dialog;

import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Point;
import by.bsuir.ptoop.model.Triangle;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TriangleDialog extends AbstractDialog<Figure> {

    private TextField aX;
    private TextField aY;
    private TextField bX;
    private TextField bY;
    private TextField cX;
    private TextField cY;

    public TriangleDialog() {

        this.setTitle("Add Triangle");
        ButtonType drawButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        this.getDialogPane().getButtonTypes().addAll(drawButton, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        aX = new TextField();
        aX.setPromptText("x1");
        aY = new TextField();
        aY.setPromptText("y1");
        bX = new TextField();
        bX.setPromptText("x2");
        bY = new TextField();
        bY.setPromptText("y2");
        cX = new TextField();
        cX.setPromptText("x3");
        cY = new TextField();
        cY.setPromptText("y3");

        grid.add(aX, 0, 0);
        grid.add(aY, 0, 1);
        grid.add(bX, 1, 0);
        grid.add(bY, 1, 1);
        grid.add(cX, 2, 0);
        grid.add(cY, 2, 1);

        this.getDialogPane().setContent(grid);

        this.setResultConverter(button ->
        {
            if(button == drawButton)
            {
                return new Triangle(new Point(Integer.parseInt(aX.getText()), Integer.parseInt(aY.getText())),
                        new Point(Integer.parseInt(bX.getText()), Integer.parseInt(bY.getText())),
                        new Point(Integer.parseInt(cX.getText()), Integer.parseInt(cY.getText())));
            }
            return null;
        });
    }

    public TriangleDialog(Figure figure) {
        Triangle triangle = (Triangle) figure;
        aX.setText(String.valueOf(triangle.getA().getX()));
        aY.setText(String.valueOf(triangle.getA().getY()));
        bX.setText(String.valueOf(triangle.getB().getX()));
        bY.setText(String.valueOf(triangle.getB().getY()));
        cX.setText(String.valueOf(triangle.getC().getX()));
        cY.setText(String.valueOf(triangle.getC().getY()));
    }
}
