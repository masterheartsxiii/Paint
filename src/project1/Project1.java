/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author acole3
 */
public class Project1 extends Application {
    ImageView picture;
    Image img;
    @Override
    public void start(Stage stage) {
        
        stage.setTitle("Iteration 1");
        
        BorderPane borderPane = new BorderPane();
        MenuBar menuBar = new MenuBar();
 
        // --- Menu File
        Menu menuFile = new Menu("File");
        
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
        
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });
        MenuItem open = new MenuItem("Open");
        open.setOnAction(new EventHandler<ActionEvent>() {
        
            public void handle(ActionEvent t) {
                FileChooser chooser = new FileChooser();
                chooser.setTitle("Open File");
                File chosen = chooser.showOpenDialog(null);
                
                if (chosen != null){
                    img = new Image(chosen.toURI().toString());
                    picture = new ImageView(img);
                    borderPane.setCenter(picture);
                }
            }
        });
  
        MenuItem save = new MenuItem("Save");
        save.setOnAction(new EventHandler<ActionEvent>() {
        
            public void handle(ActionEvent t) {
                FileChooser chooser = new FileChooser();
                chooser.setTitle("Save File");
                File chosen = chooser.showSaveDialog(null);
                
                if (chosen != null){
                    try{
                        BufferedImage pic;
                        pic = SwingFXUtils.fromFXImage(img, null);
                        ImageIO.write(pic,"png",chosen);
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });
        
        menuFile.getItems().addAll(open, save, new SeparatorMenuItem(), exit);

        // --- Menu Edit
        Menu menuEdit = new Menu("Edit");
 
        // --- Menu View
        Menu menuView = new Menu("View");
 
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
        // ((VBox) scene.getRoot()).getChildren().addAll(menuBar);
        borderPane.setTop(menuBar);
        Scene scene = new Scene(borderPane, 400, 350);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
