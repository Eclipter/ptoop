package by.bsuir.ptoop.controller.dialog;

import by.bsuir.ptoop.model.Ellipse;
import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Point;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EllipseDialog extends AbstractDialog<Figure> {

    private TextField oX;
    private TextField oY;
    private TextField width;
    private TextField height;

    public EllipseDialog() {

        this.setTitle("Add Ellipse");
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

        grid.add(oX, 0, 0);
        grid.add(oY, 0, 1);
        grid.add(width, 1, 0);
        grid.add(height, 1, 1);

        this.getDialogPane().setContent(grid);

        this.setResultConverter(button ->
        {
            if(button == drawButton)
            {
                return new Ellipse(new Point(Integer.parseInt(oX.getText()), Integer.parseInt(oY.getText())),
                        Integer.parseInt(width.getText()), Integer.parseInt(height.getText()));
            }
            return null;
        });
    }

    public EllipseDialog(Figure figure) {
        Ellipse ellipse = (Ellipse) figure;
        oX.setText(String.valueOf(ellipse.getO().getX()));
        oY.setText(String.valueOf(ellipse.getO().getY()));
        width.setText(String.valueOf(ellipse.getWidth()));
        height.setText(String.valueOf(ellipse.getHeight()));
    }
}
