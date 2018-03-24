package by.bsuir.ptoop.controller.module;

import javafx.geometry.Insets;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CustomModuleLoadingModule extends DrawingModule {

    private static final String MENU_TEXT = "Load Custom Module";
    private static final String MODULE_PACKAGE = "by.bsuir.ptoop.controller.module.";
    private static final String MODULE_NAME_SUFFIX = "Module";

    public CustomModuleLoadingModule(DrawingModuleContainer container, GraphicsContext context) {
        super(MENU_TEXT);

        menuItem.setOnAction(event ->
        {
            Dialog<String> dialog = new Dialog<>();

            dialog.setTitle(MENU_TEXT);
            ButtonType loadButton = new ButtonType("Find and Load", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(loadButton, ButtonType.CANCEL);

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            TextField figureNameField = new TextField();
            figureNameField.setPromptText("Module name");

            grid.add(figureNameField, 0, 0);

            dialog.getDialogPane().setContent(grid);

            dialog.setResultConverter(button ->
            {
                if (button == loadButton) {
                    return figureNameField.getText();
                }
                return null;
            });

            dialog.showAndWait().ifPresent(module ->
            {
                try
                {
                    Class<?> figureModuleClass = Class.forName(MODULE_PACKAGE + module + MODULE_NAME_SUFFIX);
                    DrawingModule instance =  (DrawingModule) figureModuleClass.newInstance();
                    container.addModule(instance);
                    instance.getDrawer().ifPresent(moduleDrawer -> moduleDrawer.setGraphicsContext(context));
                } catch (ClassNotFoundException e)
                {
                    e.printStackTrace();
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Module " + module + " not found", ButtonType.OK);
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
