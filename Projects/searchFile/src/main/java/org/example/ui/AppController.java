package org.example.ui;

import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import org.example.model.FileMeta;
import org.example.service.FileService;
import org.example.task.FileScanner;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML
    public Label srcDirectory;//表现文本
    @FXML
    public TextField searchField;//文本框
    @FXML
    public TableView fileTable;//表格
    @FXML
    public TableColumn nameColumn;//名称列
    @FXML
    public TableColumn sizeColumn;//大小列
    @FXML
    public TableColumn lastModifiedColumn;//最后修改时间列
    @FXML
    public GridPane rootPane;//网格布局

    private FileScanner fileScanner = new FileScanner();

    private FileService fileService = new FileService();

    @FXML
    //按钮点击事件
    public void choose(MouseEvent mouseEvent) {
        DirectoryChooser chooser = new DirectoryChooser();//文件夹操作
        File root = chooser.showDialog(rootPane.getScene().getWindow());
        if (root == null){
            return;
        }
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fileScanner.scan(root);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //会在FXML执行时实例化好AppController后调用
        StringProperty stringProperty = searchField.textProperty();
        stringProperty.addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                List<FileMeta> queryList = fileService.query(newValue.trim());
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        fileTable.getItems().clear();
                        fileTable.getItems().addAll(queryList);
                    }
                });
            }
        });
        fileTable.setRowFactory(new Callback<TableView, TableRow>() {
            @Override
            public TableRow call(TableView param) {
                return new  TableRowClick();
            }
        });
    }
    private class TableRowClick extends TableRow<FileMeta>{
        public TableRowClick(){
            super();
            this.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1 && TableRowClick.this.getIndex() < fileTable.getItems().size()){
                        FileMeta file = TableRowClick.this.getItem();
                        FileChooser chooser = new FileChooser();//文件筛选器
                        chooser.setInitialDirectory(new File(file.getPath()));//设置打开路径
                        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("全部文件","*"));//设置文件类型
                        chooser.showOpenDialog(rootPane.getScene().getWindow());
                    }
                }
            });
        }
    }
}
