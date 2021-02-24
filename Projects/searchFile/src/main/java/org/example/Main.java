package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.service.DBService;

import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //获取资源路径
        URL url = Main.class.getClassLoader().getResource("app.fxml");
        if (url == null){
            throw new RuntimeException("app.fxml没有找到");
        }
        //加载fxml文件
        Parent root = FXMLLoader.load(url);
        //设置标题
        primaryStage.setTitle("本地文件搜索工具");
        Scene scene = new Scene(root,1000,655);
        primaryStage.setScene(scene);
        //图片路径
        String path = new String(String.valueOf(Main.class.getClassLoader().getResource("icon.jpg")));
        primaryStage.getIcons().add(new Image(path));//设置图标
        primaryStage.show();
    }
    public static void main(String[] args) {
        DBService dbService = new DBService();
        dbService.Init();
        launch(args);
    }
}
