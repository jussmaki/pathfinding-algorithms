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
import javafx.scene.input.KeyCode;
import javafx.stage.FileChooser;
import pathfinding.domain.Result;
import pathfinding.struct.StackQueue;

public class UI extends Application {

    ArrayList<Result> results;
    PathFinder pathFinder = new PathFinder();    
    int startX = -1;
    int startY = -1;
    int endX = -1;
    int endY = -1;
    int times = 1;
    boolean startPointSelected = false;    
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Pathfinding app");
        
        ImageView imageView = new ImageView();
        
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(10, 10, 10, 10));
        flow.setHgap(5);
        TextField fileNameTextField = new TextField("resources/AR0017SR.map");
        Button loadButton = new Button("Load");
        Button searchDjikstraButton = new Button("Djikstra!");
        searchDjikstraButton.setDisable(true);
        Button searchAStarButton = new Button("AStar!");
        searchAStarButton.setDisable(true);
        Button searchIDAStarButton = new Button("IDAStar!");
        searchIDAStarButton.setDisable(true);
        TextField runXTimes = new TextField("1");
        FlowPane coordinatesFlowPanel = new FlowPane();
        TextField startXTF = new TextField("");
        TextField startYTF = new TextField("");
        TextField endXTF = new TextField("");
        TextField endYTF = new TextField("");
        Button setCoordinatesButton = new Button("set!");
        coordinatesFlowPanel.getChildren().addAll(new Label("start x:"), startXTF,
                new Label("start y:"), startYTF, new Label("end x:"), endXTF,
                new Label("end y:"), endYTF, setCoordinatesButton);
        Label coordinates = new Label("start: " + startX + "," + startY + " end: " + endX + "," + endY);
        flow.getChildren().addAll(fileNameTextField, loadButton, searchDjikstraButton,
                searchAStarButton, searchIDAStarButton, runXTimes, coordinates);        
        Label infoLabel = new Label("Click start point with mouse");
        BorderPane pane = new BorderPane();
        pane.setTop(flow);
        pane.setCenter(imageView);
        pane.setBottom(infoLabel);
        
        Scene scene = new Scene(pane, 800, 600);        

        primaryStage.setScene(scene);

        primaryStage.show();
        fileNameTextField.setOnMouseClicked((event) -> {
            fileNameTextField.setText(new FileChooser().showOpenDialog(primaryStage).getAbsolutePath());
            loadButton.getOnAction().handle(null);
        });
        
        loadButton.setOnAction((event) -> {
            try {
                pathFinder.openMapFile(fileNameTextField.getText());
            } catch (Exception ex) {
                Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageView.setImage(SwingFXUtils.toFXImage(drawMaze(pathFinder.getGrid()), null));
            startPointSelected = false;
            infoLabel.setText("Click start point with mouse");
        });

        imageView.setOnMouseClicked((event) -> {
            System.out.println("x: " + event.getX() + ", y: " + event.getY());
            if (!startPointSelected) {
                startX = (int) event.getX();
                startY = (int) event.getY();
                infoLabel.setText("Click end point with mouse");
                startPointSelected = true;
            } else {
                endX = (int) event.getX();
                endY = (int) event.getY();
                infoLabel.setText("Ready to search path!");
                searchDjikstraButton.setDisable(false);
                searchAStarButton.setDisable(false);
                searchIDAStarButton.setDisable(false);
            }
            coordinates.setText("start: " + startX + "," + startY + " end: " + endX + "," + endY);
        });
        

        searchDjikstraButton.setOnAction((event) -> {
            results = new ArrayList<>();
            for (int i = 0; i < times; i++) {
                results.add(pathFinder.searchDjikstra(startX, startY, endX, endY));
            }
            printResults("Djikstra");
            Result result = results.get(0);
            //System.out.println(result);
            imageView.setImage(SwingFXUtils.toFXImage(drawRouteInMaze(
                    pathFinder.getGrid(), convertSQToArrayList(result.getPath()),
                    convertSQToArrayList(result.getPointsInHeap()), result.getVisited(), Color.GREEN.getRGB()), null));
        });
        
        searchAStarButton.setOnAction((event) -> {
            results = new ArrayList<>();
            for (int i = 0; i < times; i++) {
                results.add(pathFinder.searchAStar(startX, startY, endX, endY));
            }
            printResults("AStar");
            Result result = results.get(0);
            imageView.setImage(SwingFXUtils.toFXImage(drawRouteInMaze(
                    pathFinder.getGrid(), convertSQToArrayList(result.getPath()),
                    convertSQToArrayList(result.getPointsInHeap()), result.getVisited(), Color.GREEN.getRGB()), null));
        });  
        
        searchIDAStarButton.setOnAction((event) -> {
            results = new ArrayList<>();
            for (int i = 0; i < times; i++) {
                results.add(pathFinder.searchIDAStar(startX, startY, endX, endY));
            }
            printResults("IDAStar");
            Result result = results.get(0);
            imageView.setImage(SwingFXUtils.toFXImage(drawRouteInMaze(
                    pathFinder.getGrid(), convertSQToArrayList(result.getPath()),
                    convertSQToArrayList(result.getPointsInHeap()), result.getVisited(), Color.GREEN.getRGB()), null));
        });
        
        runXTimes.setOnKeyReleased((event) -> {
            if ((!"0123456789".contains(event.getText()) && !event.getCode().equals(KeyCode.BACK_SPACE)) ||
                    runXTimes.getText().equals("") || runXTimes.getText().startsWith("0")) {
                runXTimes.setText(String.valueOf(times));
            } 
            times = Integer.valueOf(runXTimes.getText());
        });
        
        coordinates.setOnMouseClicked((event) -> {
            startXTF.setText("" + startX);
            startYTF.setText("" + startY);
            endXTF.setText("" + endX);
            endYTF.setText("" + endY);
            pane.setTop(coordinatesFlowPanel);
        });
        
        setCoordinatesButton.setOnAction((event) -> {
            startX = Integer.valueOf(startXTF.getText());
            startY = Integer.valueOf(startYTF.getText());
            endX = Integer.valueOf(endXTF.getText());
            endY = Integer.valueOf(endYTF.getText());
            coordinates.setText("start: " + startX + "," + startY + " end: " + endX + "," + endY);
            pane.setTop(flow);
            infoLabel.setText("Ready to search path!");
            searchDjikstraButton.setDisable(false);
            searchAStarButton.setDisable(false);
            searchIDAStarButton.setDisable(false);
        });
        
    }
    
    private ArrayList<Point> convertSQToArrayList(StackQueue<Point> ps) {
        ArrayList<Point> ret = new ArrayList<>();
        while (!ps.isEmpty()) {
            ret.add(ps.pop());
        }
        return ret;
    }
    
    private void printResults(String algorithm) {
        System.out.println(algorithm + " algorithm ran " + times + " times");
        long all = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (Result r : results) {
            all += r.getRunTime();
            if (min > r.getRunTime()) {
                min = r.getRunTime();
            }
            if (max < r.getRunTime()) {
                max = r.getRunTime();
            }
        }
        long avg = all / times;
        System.out.println("min runtime: " + min / 1e9 + " s.");
        System.out.println("max runtime: " + max / 1e9 + " s.");
        System.out.println("avg runtime: " + avg / 1e9 + " s.");
        System.out.println(results.get(0));
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
        return bufferedImage;
    }

    /**
     *
     * @param maze
     * @param route
     * @return grid as BufferedImage
     */
    private BufferedImage drawRouteInMaze(int[][] maze, ArrayList<Point> route, ArrayList<Point> pointsInHeap,
            boolean[][] visited, int rgb) {
        BufferedImage bufferedImage = drawMaze(maze);
        drawVisitedNodesInMaze(bufferedImage, visited);
        drawPointsInHeapInMaze(bufferedImage, pointsInHeap);
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
    
    private void drawPointsInHeapInMaze(BufferedImage bufferedImage, ArrayList<Point> pointsInHeap) {
        for (Point p : pointsInHeap) {
            bufferedImage.setRGB(p.getLocationX(), p.getLocationY(), Color.YELLOW.getRGB());
        }
    }
        
    
    public static void main(String[] args) {
        launch(args);
    }
}
