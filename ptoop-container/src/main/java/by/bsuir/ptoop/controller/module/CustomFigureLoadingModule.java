package by.bsuir.ptoop.controller.module;

import javafx.geometry.Insets;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CustomFigureLoadingModule extends DrawingModule {

    private static final String MENU_TEXT = "Load Custom Figure";
    private static final String MODULE_PACKAGE = "by.bsuir.ptoop.controller.module.";
    private static final String MODULE_NAME_SUFFIX = "Module";

    public CustomFigureLoadingModule(DrawingModuleContainer container, GraphicsContext context) {
        super(MENU_TEXT);

        menuItem.setOnAction(event ->
        {
            Dialog<String> dialog = new Dialog<>();

            dialog.setTitle(MENU_TEXT);
            ButtonType drawButton = new ButtonType("Find and Load", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(drawButton, ButtonType.CANCEL);

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            TextField figureNameField = new TextField();
            figureNameField.setPromptText("Figure name");

            grid.add(figureNameField, 0, 0);

            dialog.getDialogPane().setContent(grid);

            dialog.setResultConverter(button ->
            {
                if (button == drawButton) {
                    return figureNameField.getText();
                }
                return null;
            });

            dialog.showAndWait().ifPresent(figureName ->
            {
                try
                {
                    Class<?> figureModuleClass = Class.forName(MODULE_PACKAGE + figureName + MODULE_NAME_SUFFIX);
                    DrawingModule module =  (DrawingModule) figureModuleClass.newInstance();
                    container.addModule(module);
                    module.getDrawer().ifPresent(moduleDrawer -> moduleDrawer.setGraphicsContext(context));
                } catch (ClassNotFoundException e)
                {
                    e.printStackTrace();
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Figure " + figureName + " not found", ButtonType.OK);
                    alert.showAndWait();
                } catch (IllegalAccessException | InstantiationException e)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                    alert.showAndWait();
                }
            });
        });
    }
}
