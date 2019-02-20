/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_zad2;

import static java.lang.Math.pow;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Adam Ch
 */
public class AreaChartApp {
    private AreaChart chart;
    private NumberAxis xAxis = new NumberAxis("X-Axis", -30, 30, 2);
    private NumberAxis yAxis = new NumberAxis("Y-Axis", -300, 300, 50);
    
     public AreaChart createContent() {
//        xAxis = new NumberAxis();
        xAxis.setLabel("X Values");
//        yAxis = new NumberAxis();
        yAxis.setLabel("Y Values");
        
        AreaChart.Series series1 = new AreaChart.Series();
        series1.setName("f(x) = 0");
        first_function(series1);
        
        AreaChart.Series series2 = new AreaChart.Series();
        series2.setName("f(x) = −𝑥^2");
        second_function(series2);
        
        AreaChart.Series series3 = new AreaChart.Series();
        series3.setName("f(x) = 𝑥^2 − 𝑥 + 3");
        third_function(series3);
        
        ObservableList<AreaChart.Series> data = observableArrayList(
            series1,
            series2,
            series3
        );
        
//        ObservableList<AreaChart.Series> areaChartData = FXCollections.observableArrayList(
//                new AreaChart.Series("Series 1",FXCollections.observableArrayList(
//                    new AreaChart.Data(0,4),
//                    new AreaChart.Data(2,5),
//                    new AreaChart.Data(4,4),
//                    new AreaChart.Data(6,2),
//                    new AreaChart.Data(8,6),
//                    new AreaChart.Data(10,8)
//                )),
//                new AreaChart.Series("Series 2", FXCollections.observableArrayList(
//                    new AreaChart.Data(0,8),
//                    new AreaChart.Data(2,2),
//                    new AreaChart.Data(4,9),
//                    new AreaChart.Data(6,7),
//                    new AreaChart.Data(8,5),
//                    new AreaChart.Data(10,7)
//                )),
//                new AreaChart.Series("Series 3", FXCollections.observableArrayList(
//                    new AreaChart.Data(0,2),
//                    new AreaChart.Data(2,5),
//                    new AreaChart.Data(4,8),
//                    new AreaChart.Data(6,6),
//                    new AreaChart.Data(8,9),
//                    new AreaChart.Data(10,7)
//                ))
//        );
        chart = new AreaChart(xAxis, yAxis, data);
        return chart;
    }
     
     public void first_function(AreaChart.Series series)
    {
       for (int x = (int)xAxis.getLowerBound();x < xAxis.getUpperBound(); x++) {
           series.getData().add(new XYChart.Data<>(x, 0));
       }
    }
    
    public void second_function(AreaChart.Series series)
    {
        for (int x = (int)xAxis.getLowerBound();x < (int)xAxis.getUpperBound(); x++) {
           series.getData().add(new XYChart.Data<>(x, -pow(x,2)));
       }
    }
    
    public void third_function(AreaChart.Series series)
    {
        for (int x = (int)xAxis.getLowerBound(); x < (int)xAxis.getUpperBound(); x++) {
           series.getData().add(new XYChart.Data<>(x, pow(x,2)-x+3));
       }
    }
    
    public XYChart.Series fourth_function(int A, int B, int C)
    {
        AreaChart.Series series4 = new AreaChart.Series();
        series4.setName("f(𝑥) = A𝑥^2 + B𝑥 + C");
        
        for (int x = (int)xAxis.getLowerBound(); x < (int)xAxis.getUpperBound(); x++) {
           series4.getData().add(new XYChart.Data<>(x, A*pow(x,2)+B*x+C));
       }
       
       return series4;
    }
}
