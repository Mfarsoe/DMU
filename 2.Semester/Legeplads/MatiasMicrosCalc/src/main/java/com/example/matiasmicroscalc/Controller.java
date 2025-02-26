package com.example.matiasmicroscalc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class Controller {

    @FXML
    private ComboBox<?> comboboxIng;

    @FXML
    private Label labelCurrentICarb;

    @FXML
    private Label labelCurrentIFat;

    @FXML
    private Label labelCurrentIKcal;

    @FXML
    private Label labelCurrentIPro;

    @FXML
    private Label labelTotalFedt;

    @FXML
    private Label labelKcal;

    @FXML
    private Label labelKulhydrater;

    @FXML
    private Label labelProtein;

    @FXML
    private TableColumn<Ingridiens, Double> tableColumnCarb;

    @FXML
    private TableColumn<Ingridiens, Double> tableColumnFat;

    @FXML
    private TableColumn<Ingridiens, Double> tableColumnKcal;

    @FXML
    private TableColumn<Ingridiens, String> tableColumnName;

    @FXML
    private TableColumn<Ingridiens, Double> tableColumnProtein;

    @FXML
    private TableView<Ingridiens> tableViewIngridiens;

    @FXML
    private TextField textfieldGram;

    @FXML
    private TextField textfieldPercentCarb;

    @FXML
    private TextField textfieldPercentFat;

    @FXML
    private TextField textfieldPercentPro;

    public void initialize() {
        setTableColumns();

    }


    @FXML
    void addBtn(ActionEvent event) {

        setTotals();
    }

    @FXML
    void calcBtn(ActionEvent event) {

    }

    @FXML
    void menuIngridienser(ActionEvent event) {

    }

    @FXML
    void menuMakroberegner(ActionEvent event) {

    }

    @FXML
    void printBtn(ActionEvent event) {

    }

    @FXML
    void removeBtn(ActionEvent event) {

    }


    private void setTableColumns(){
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnCarb.setCellValueFactory(new PropertyValueFactory<>("carb"));
        tableColumnFat.setCellValueFactory(new PropertyValueFactory<>("fat"));
        tableColumnKcal.setCellValueFactory(new PropertyValueFactory<>("kcal"));
        tableColumnProtein.setCellValueFactory(new PropertyValueFactory<>("protein"));

        updateTableColumns(Utils.readFromFile("Ingridienser"));
    }

    private void updateTableColumns(List<Ingridiens> ingridiens) {
        ObservableList<Ingridiens> data = FXCollections.observableArrayList(ingridiens);
        tableViewIngridiens.setItems(data);
    }

    private void setTotals(){
        labelTotalFedt.setText(String.format("%.2f",calculateTotal(Utils.readFromFile("Ingridienser"),"fat")) + "g");
        labelKcal.setText(String.format("%.2f",calculateTotal(Utils.readFromFile("Ingridienser"),"kcal")) + "g");
        labelKulhydrater.setText(String.format("%.2f",calculateTotal(Utils.readFromFile("Ingridienser"),"carb")) + "g");
        labelProtein.setText(String.format("%.2f",calculateTotal(Utils.readFromFile("Ingridienser"),"protein")) + "g");
    }

    public static double calculateTotal(List<Ingridiens> ingriList, String column) {
        double total = 0;
        for (Ingridiens ing : ingriList) {
            switch (column.toLowerCase()) {
                case "protein":
                    total += ing.getProtein();
                    break;
                case "carb":
                    total += ing.getCarb();
                    break;
                case "fat":
                    total += ing.getFat();
                    break;
                case "kcal":
                    total += ing.getKcal();
                    break;
                default:
                    System.out.println("Ugyldigt kolonnenavn: " + column);
                    return -1;
            }
        }
        return total;
    }

}
