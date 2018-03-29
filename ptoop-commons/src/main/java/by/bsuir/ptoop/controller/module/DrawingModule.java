package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.drawer.AbstractDrawer;
import by.bsuir.ptoop.controller.drawer.DrawerChain;
import by.bsuir.ptoop.controller.editor.AbstractEditor;
import by.bsuir.ptoop.controller.editor.EditorChain;
import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.FigureList;
import javafx.scene.control.MenuItem;

import java.util.Optional;

/**
 * Module class responsible for creation and maintaining MenuItem
 * that provides access to module functionality by pressing on it
 */
public abstract class DrawingModule {

    protected DrawerChain drawerChain;
    protected MenuItem menuItem;
    protected FigureList figures;
    protected EditorChain editorChain;

    public DrawingModule() {
    }

    public DrawingModule(String menuText) {
        this.menuItem = new MenuItem(menuText);
    }

    /**
     * Method that draws figures and ads them to a global list
     */
    public void draw(Figure figure)
    {
        drawerChain.draw(figure);
        figures.add(figure);
    }

    public DrawerChain getDrawerChain() {
        return drawerChain;
    }

    public void setDrawerChain(DrawerChain drawerChain) {
        this.drawerChain = drawerChain;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public FigureList getFigures() {
        return figures;
    }

    public void setFigures(FigureList figures) {
        this.figures = figures;
    }

    public EditorChain getEditorChain() {
        return editorChain;
    }

    public void setEditorChain(EditorChain editorChain) {
        this.editorChain = editorChain;
    }

    public abstract AbstractEditor getEditor();

    public abstract Optional<AbstractDrawer> currentDrawer();
}
