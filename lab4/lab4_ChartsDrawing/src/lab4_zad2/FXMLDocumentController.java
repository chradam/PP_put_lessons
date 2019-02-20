/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_zad2;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


/**
 *
 * @author Adam Ch
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private GridPane grid;
    
    @FXML
    private TextField aValue;

    @FXML
    private TextField bValue;

    @FXML
    private TextField cValue;
    
    @FXML
    private ComboBox<String> charComboBox;
    
    @FXML
    private Button button;
    
    private ScatterChart scatterChart;
    private LineChart lineChart;
    private AreaChart areaChart;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        charComboBox.getItems().addAll("Scatter Chart", "Line Chart", "Area Chart");
        
        scatterChart = new ScatterChartApp().createContent();
        lineChart = new LineChartApp().createContent();
        areaChart = new AreaChartApp().createContent();
        
        grid.add(scatterChart, 2, 0, 1, 5);
        
        //scatterChart = new ScatterChartApp().createContent();
        
        
//        XYChart.Series series = new XYChart.Series();
//        series.getData().add(new XYChart.Data("1", 23));
//        scatterChart.getData().addAll(series);
        
//        grid = new GridPane();
//        GridPane.setConstraints(x.createContent(), 0, 0);
//        grid.getChildren().addAll(x.createContent());
    }
    
    //Setting an action for the Submit button
    @FXML
    public void buttonHandle(ActionEvent e) {
        int A, B, C;
        A = B = C = 0;
        boolean draw = false;
        
        if ((aValue.getText() != null && !aValue.getText().isEmpty())) {
            A = Integer.parseInt(aValue.getText());
            draw = true;
        }
        if ((bValue.getText() != null && !bValue.getText().isEmpty())) {
            B = Integer.parseInt(bValue.getText());
            draw = true;
        }
        if ((cValue.getText() != null && !cValue.getText().isEmpty())) {
            C = Integer.parseInt(cValue.getText());
            draw = true;
        }
        if (draw) {
            clearLastChart();
            scatterChart.getData().addAll(new ScatterChartApp().fourth_function(A,B,C));
            lineChart.getData().addAll(new LineChartApp().fourth_function(A,B,C));
            areaChart.getData().addAll(new AreaChartApp().fourth_function(A,B,C));
        }
    }
    
    @FXML
    public void comboBoxHandle(ActionEvent e){
        switch(charComboBox.getValue()){
            case "Scatter Chart":
                grid.getChildren().remove(lineChart);
                grid.getChildren().remove(areaChart);
                grid.add(scatterChart, 2, 0, 1, 5);
                break;
            case "Line Chart":
                grid.getChildren().remove(scatterChart);
                grid.getChildren().remove(areaChart);
                grid.add(lineChart, 2, 0, 1, 5);
                break;
            case "Area Chart":
                grid.getChildren().remove(scatterChart);
                grid.getChildren().remove(lineChart);
                grid.add(areaChart, 2, 0, 1, 5);
                break;
            }
    }
    
    private void clearLastChart(){
          if (scatterChart.getData().size() == 4) {
            scatterChart.getData().remove(3);
            lineChart.getData().remove(3);
            areaChart.getData().remove(3);
          }
    }
}
