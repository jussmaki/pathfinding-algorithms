package pathfinding.ui;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import pathfinding.pathfinder.PathFinder;

public class UI extends Application {

    int[][] maze = new int[512][512];
    ArrayList<Integer> path;

    @Override
    public void start(Stage primaryStage) {
        
        PathFinder pathFinder = new PathFinder();
        
        primaryStage.setTitle("Pathfinding app");
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);
        gridPane.setPadding(new Insets(1, 1, 1, 1));
        gridPane.setGridLinesVisible(true);
        
        drawEmptyMaze(gridPane);
        
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(10, 10, 10, 10));
        flow.setHgap(5);
        TextField fileNameTextField = new TextField();
        fileNameTextField.setText("16room_000.map");
        Button readAndSearchButton = new Button();
        readAndSearchButton.setText("Djikstra!");
        TextField startXTF = new TextField("2");
        TextField startYTF = new TextField("40");
        TextField endXTF = new TextField("300");
        TextField endYTF = new TextField("233");
        flow.getChildren().addAll(fileNameTextField, startXTF, startYTF, endXTF, endYTF, readAndSearchButton);        
        
       BorderPane pane = new BorderPane();
       pane.setCenter(gridPane);
       pane.setTop(flow);

       Scene scene = new Scene(pane, 800, 600);        
        
       primaryStage.setScene(scene);
        
       primaryStage.show();
       
       readAndSearchButton.setOnAction((event) -> {
            try {
                pathFinder.openMapFile(fileNameTextField.getText());
            } catch (Exception ex) {
                Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
            }
           pathFinder.searchDjikstra(Integer.valueOf(startXTF.getText()), Integer.valueOf(startYTF.getText()), Integer.valueOf(endXTF.getText()), Integer.valueOf(endYTF.getText()));
           //drawMaze(pathFinder.getAsArray(), gridPane);
       });
        
    }
    
    public void drawMaze(int[][] maze, GridPane gridPane) {
        
        for (int x=0; x<maze.length; x++) {

            for (int y=0; y<maze[x].length; y++) {
                Rectangle rect = new Rectangle(2,2);
                if (maze[x][y] == 1) {
                    rect.setStroke(Color.WHITE);
                    rect.setFill(Color.WHITE);
                } else {
                    rect.setStroke(Color.BLACK);
                    rect.setFill(Color.BLACK);
                }
                gridPane.add(rect, x, y);
            }
        }
    }

    private void drawEmptyMaze(GridPane gridPane) {
        for (int x=0; x<maze.length; x++) {

            for (int y=0; y<maze[x].length; y++) {
                Rectangle rect = new Rectangle(2,2);
                    rect.setStroke(Color.WHITE);
                    rect.setFill(Color.WHITE);
                gridPane.add(rect, x, y);
            }
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
        
}
