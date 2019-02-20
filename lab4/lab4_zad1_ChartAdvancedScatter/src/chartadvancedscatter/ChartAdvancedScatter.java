package chartadvancedscatter;

import static java.lang.Math.pow;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class ChartAdvancedScatter extends Application {
 
    public static void first_function(double lowerBound, double upperBound, XYChart.Series series)
    {
       for (int x = (int)lowerBound;x < upperBound; x++) {
           series.getData().add(new XYChart.Data(x, 0));
       }
    }
    
    public static void second_unction(double lowerBound, double upperBound, XYChart.Series series)
    {
        for (int x = (int)lowerBound;x < (int)upperBound; x++) {
           series.getData().add(new XYChart.Data(x, -pow(x,2)));
       }
    }
    
    public static void third_function(double lowerBound, double upperBound, XYChart.Series series)
    {
        for (int x = (int)lowerBound; x < (int)upperBound; x++) {
           series.getData().add(new XYChart.Data(x, pow(x,2)-x+3));
       }
    }
    
    @Override 
    public void start(Stage stage) {
        stage.setTitle("Zad1");
        
        final NumberAxis xAxis = new NumberAxis(-50, 50, 1);
        final NumberAxis yAxis = new NumberAxis(-500, 500, 100);
        
        final ScatterChart<Number,Number> sc = new
            ScatterChart<Number,Number>(xAxis,yAxis);
        
        xAxis.setLabel("X axis");                
        yAxis.setLabel("Y axis");
        sc.setTitle("Function");
        
       //while (true) {
            System.out.println("\n"
                              + "Choose an action\n"
                              + "(a) f(x) = 0\n"
                              + "(b) f(x) = -x^2,\n"
                              + "(c) f(x) = x^2-x+3,\n");
            
            Scanner in = new Scanner(System.in);
            
            switch (in.nextLine()) {
                case "a": {
                    XYChart.Series series1 = new XYChart.Series();
                    series1.setName("f(x) = 0");
                    first_function(xAxis.getLowerBound(),xAxis.getUpperBound(), series1);
                    sc.getData().addAll(series1);
                    Scene scene  = new Scene(sc, 1000, 600);
                    
                    stage.setScene(scene);
                    stage.show();
                    break;
                }
                case "b": {
                    XYChart.Series series1 = new XYChart.Series();
                    series1.setName("f(x) = 0");
                    second_unction(xAxis.getLowerBound(),xAxis.getUpperBound(), series1);
                    sc.getData().addAll(series1);
                    Scene scene  = new Scene(sc, 1000, 600);
                    
                    stage.setScene(scene);
                    stage.show();
                    break;
                }
                case "c": {
                    XYChart.Series series1 = new XYChart.Series();
                    series1.setName("f(x) = 0");
                    third_function(xAxis.getLowerBound(),xAxis.getUpperBound(), series1);
                    sc.getData().addAll(series1);
                    Scene scene  = new Scene(sc, 1000, 600);
                    
                    stage.setScene(scene);
                    stage.show();
                    break;
                }
            }
        //}
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
