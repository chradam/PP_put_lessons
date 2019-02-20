/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_zad2;

import static java.lang.Math.pow;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author Adam Ch
 */
public class ScatterChartApp{
    
    private ScatterChart chart;
    private NumberAxis xAxis = new NumberAxis("X-Axis", -30, 30, 2);
    private NumberAxis yAxis = new NumberAxis("Y-Axis", -300, 300, 50);
        
    public ScatterChart createContent() {
//        xAxis = new NumberAxis("X-Axis", 0d, 8.0d, 1.0d);
//        yAxis = new NumberAxis("Y-Axis", 0.0d, 5.0d, 1.0d);
        ScatterChart.Series series1 = new ScatterChart.Series();
        series1.setName("f(x) = 0");
        first_function(series1);
        
        ScatterChart.Series series2 = new ScatterChart.Series();
        series2.setName("f(x) = −𝑥^2");
        second_function(series2);
        
        ScatterChart.Series series3 = new ScatterChart.Series();
        series3.setName("f(x) = 𝑥^2 − 𝑥 + 3");
        third_function(series3);
        
        ObservableList<XYChart.Series> data = observableArrayList(
            series1,
            series2,
            series3
        );
        
        chart = new ScatterChart(xAxis, yAxis, data);
        
        return chart;
    }
    
    public void first_function(ScatterChart.Series series)
    {
       for (int x = (int)xAxis.getLowerBound();x < xAxis.getUpperBound(); x++) {
           series.getData().add(new XYChart.Data(x, 0));
       }
    }
    
    public void second_function(ScatterChart.Series series)
    {
        for (int x = (int)xAxis.getLowerBound();x < (int)xAxis.getUpperBound(); x++) {
           series.getData().add(new XYChart.Data(x, -pow(x,2)));
       }
    }
    
    public void third_function(ScatterChart.Series series)
    {
        for (int x = (int)xAxis.getLowerBound(); x < (int)xAxis.getUpperBound(); x++) {
           series.getData().add(new XYChart.Data(x, pow(x,2)-x+3));
       }
    }
    
    public XYChart.Series fourth_function(int A, int B, int C)
    {
        ScatterChart.Series series4 = new ScatterChart.Series();
        series4.setName("f(𝑥) = A𝑥^2 + B𝑥 + C");
        
        for (int x = (int)xAxis.getLowerBound(); x < (int)xAxis.getUpperBound(); x++) {
           series4.getData().add(new XYChart.Data(x, A*pow(x,2)+B*x+C));
       }
       
       return series4;
    }
}
