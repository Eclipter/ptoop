package by.bsuir.ptoop.controller.dialog;

import by.bsuir.ptoop.controller.editor.EditorChain;
import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.FigureList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class FiguresModifyingDialog extends AbstractDialog {

    public FiguresModifyingDialog(EditorChain editorChain, FigureList figureList) {

        this.setTitle("Edit figures");
        this.getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE);

        ObservableList<Figure> observableList = FXCollections.observableArrayList(figureList);

        TableView<Figure> view = new TableView<>(observableList);
        TableColumn<Figure, String> column = new TableColumn<>("Figure");
        column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().toString()));
        view.getColumns().add(column);

        Menu editMenu = new Menu("Edit");
        MenuItem editMenuItem = new MenuItem("Edit selected");
        MenuItem deleteMenuItem = new MenuItem("Delete selected");
        editMenu.getItems().addAll(editMenuItem, deleteMenuItem);
        MenuBar menuBar = new MenuBar(editMenu);

        deleteMenuItem.setOnAction(event ->
        {
            ObservableList<Figure> selectedItems = view.getSelectionModel().getSelectedItems();
            figureList.removeAll(selectedItems);
            observableList.removeAll(selectedItems);
        });

        editMenuItem.setOnAction(event ->
        {
            Figure selectedItem = view.getSelectionModel().getSelectedItem();
            Figure newFigure = editorChain.editFigure(selectedItem);
            figureList.remove(selectedItem);
            figureList.add(newFigure);
            observableList.remove(selectedItem);
            observableList.add(newFigure);
        });

        VBox box = new VBox();
        box.getChildren().addAll(menuBar, view);
        this.getDialogPane().setContent(box);
    }
}
