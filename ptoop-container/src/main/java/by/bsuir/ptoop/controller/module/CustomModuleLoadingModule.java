package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.drawer.AbstractDrawer;
import by.bsuir.ptoop.controller.editor.AbstractEditor;
import by.bsuir.ptoop.controller.editor.CustomModuleLoadingEditor;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class CustomModuleLoadingModule extends DrawingModule {

    private static final String MENU_TEXT = "Load Custom Module";
    private static final String MODULE_PACKAGE = "by.bsuir.ptoop.controller.module.";
    private static final String MODULE_NAME_SUFFIX = "Module";

    /**
     * Module retrieves the module name from dialog and loads it by creating a new instance of corresponding class.
     * Module name should be a part of corresponding {@link DrawingModule} implementing class (without word "Module")
     */
    public CustomModuleLoadingModule(DrawingModuleContainer container, GraphicsContext context) {
        super(MENU_TEXT);

        menuItem.setOnAction(event ->
        {
            getEditor().newDialog().showAndWait().ifPresent(module ->
            {
                try
                {
                    Class<?> figureModuleClass = Class.forName(MODULE_PACKAGE + module + MODULE_NAME_SUFFIX);
                    DrawingModule instance =  (DrawingModule) figureModuleClass.newInstance();
                    container.addModule(instance);
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

    @Override
    public AbstractEditor getEditor() {
        return new CustomModuleLoadingEditor();
    }

    @Override
    public Optional<AbstractDrawer> currentDrawer() {
        return Optional.empty();
    }
}
