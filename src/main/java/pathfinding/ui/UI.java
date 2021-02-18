package pathfinding.ui;

import java.awt.Color;
import pathfinding.domain.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import pathfinding.pathfinder.PathFinder;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Label;
import pathfinding.domain.Result;

public class UI extends Application {

    Result result;
    PathFinder pathFinder = new PathFinder();    
    int startX = -1;
    int startY = -1;
    int endX = -1;
    int endY = -1;
    boolean startPointSelected = false;    
    //boolean endPointSelected = false;
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Pathfinding app");
        
        ImageView imageView = new ImageView();
        
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(10, 10, 10, 10));
        flow.setHgap(5);
        TextField fileNameTextField = new TextField("AR0017SR.map");
        Button loadButton = new Button("Load");
        Button searchDjikstraButton = new Button("Djikstra!");
        searchDjikstraButton.setDisable(true);
        Button searchAStarButton = new Button("AStar!");
        searchAStarButton.setDisable(true);
        flow.getChildren().addAll(fileNameTextField, loadButton, searchDjikstraButton, searchAStarButton);        
        Label infoLabel = new Label("Click start point with mouse");
        BorderPane pane = new BorderPane();
        pane.setTop(flow);
        pane.setCenter(imageView);
        pane.setBottom(infoLabel);
        
        Scene scene = new Scene(pane, 800, 600);        

        primaryStage.setScene(scene);

        primaryStage.show();
        
        loadButton.setOnAction((event) -> {
            try {
                pathFinder.openMapFile("AR0017SR.map");
            } catch (Exception ex) {
                Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageView.setImage(SwingFXUtils.toFXImage(drawMaze(pathFinder.getGrid()), null));
            startPointSelected = false;
            //endPointSelected = false;
            infoLabel.setText("Click start point with mouse");
        });

        imageView.setOnMouseClicked((event) -> {
            System.out.println("x: " + event.getX() + ", y: " + event.getY());
            if (!startPointSelected) {
                startX = (int) event.getX();
                startY = (int) event.getY();
                infoLabel.setText("Click end point with mouse");
                startPointSelected = true;
            //} else if (!endPointSelected) {
            } else {
                endX = (int) event.getX();
                endY = (int) event.getY();
                infoLabel.setText("Ready to search path!");
                //endPointSelected = true;
                searchDjikstraButton.setDisable(false);
                searchAStarButton.setDisable(false);
            }
        });
        
        searchDjikstraButton.setOnAction((event) -> {
            result = pathFinder.searchDjikstra(startX, startY, endX, endY);
            printResults();
            imageView.setImage(SwingFXUtils.toFXImage(drawRouteInMaze(pathFinder.getGrid(), result.getPath(), result.getVisited(), 16711680), null));
        });
        
        searchAStarButton.setOnAction((event) -> {
            result = pathFinder.searchAStar(startX, startY, endX, endY);
            printResults();
            imageView.setImage(SwingFXUtils.toFXImage(drawRouteInMaze(pathFinder.getGrid(), result.getPath(), result.getVisited(), Color.GREEN.getRGB()), null));
        });        

    }
    
    private void printResults() {
        System.out.println(this.result);
    }
    
    /**
     *
     * @param maze
     * @return grid as BufferedImage
     */
    private BufferedImage drawMaze(int[][] maze) {
        BufferedImage bufferedImage = new BufferedImage(maze.length, maze[0].length, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < maze.length; x++) {

            for (int y = 0; y < maze[x].length; y++) {
                if (maze[x][y] == 1) {
                    bufferedImage.setRGB(x, y, 16777215);
                } else {
                    bufferedImage.setRGB(x, y, 0);
                }
            }
        }
        //bufferedImage.getScaledInstance(endX, endX, endX)
        return bufferedImage;
    }

    /**
     *
     * @param maze
     * @param route
     * @return grid as BufferedImage
     */
    private BufferedImage drawRouteInMaze(int[][] maze, ArrayList<Point> route, boolean[][] visited, int rgb) {
        BufferedImage bufferedImage = drawMaze(maze);
        drawVisitedNodesInMaze(bufferedImage, visited);
        for (Point p : route) {
            bufferedImage.setRGB(p.getLocationX(), p.getLocationY(), rgb);
        }

        return bufferedImage;
    }
    
    private BufferedImage drawVisitedNodesInMaze(BufferedImage bufferedImage, boolean[][] visited) {
        for (int x = 0; x < visited.length; x++) {
            for (int y = 0; y < visited[0].length; y++) {
                if (visited[x][y]) {
                    bufferedImage.setRGB(x, y, Color.LIGHT_GRAY.getRGB());
                }
            }
        }
        return bufferedImage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
        
}
