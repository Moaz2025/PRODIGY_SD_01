package com.example.prodigy_sd_01;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ChoiceBox<String> chooseUnit;

    @FXML
    private Button convertUnit;

    @FXML
    private TextField temperatureInput;

    @FXML
    private Text temperatureOutput;

    @FXML
    void convertUnit(MouseEvent event) {
        String input = temperatureInput.getText();
        NumericCheck numericCheck = new NumericCheck();
        if (numericCheck.isNumeric(input)) {
            String unit = chooseUnit.getSelectionModel().getSelectedItem();
            double celsius, fahrenheit, kelvin;
            if (Objects.equals(unit, "Celsius")) {
                celsius = Double.parseDouble(temperatureInput.getText());
                fahrenheit = 1.80 * celsius + 32.0;
                kelvin = celsius + 273.15;
                String formattedFahrenheit = String.format("%.4f", fahrenheit);
                String formattedKelvin = String.format("%.4f", kelvin);
                temperatureOutput.setText("Fahrenheit = " + formattedFahrenheit + ", "
                        + "Kelvin = " + formattedKelvin);
            } else if (Objects.equals(unit, "Fahrenheit")) {
                fahrenheit = Double.parseDouble(temperatureInput.getText());
                celsius = (fahrenheit - 32) / 1.80;
                kelvin = (5.0 / 9.0) * (fahrenheit - 32) + 273.15;
                String formattedCelsius = String.format("%.4f", celsius);
                String formattedKelvin = String.format("%.4f", kelvin);
                temperatureOutput.setText("Celsius = " + formattedCelsius + ", "
                        + "Kelvin = " + formattedKelvin);
            } else if (Objects.equals(unit, "Kelvin")) {
                kelvin = Double.parseDouble(temperatureInput.getText());
                if(kelvin < 0){
                    temperatureOutput.setText("The Kelvin scale does not contain negative values.");
                }
                else {
                    celsius = kelvin - 273.15;
                    fahrenheit = 1.8 * (kelvin - 273.15) + 32;
                    String formattedCelsius = String.format("%.4f", celsius);
                    String formattedFahrenheit = String.format("%.4f", fahrenheit);
                    temperatureOutput.setText("Celsius = " + formattedCelsius + ", "
                            + "Fahrenheit = " + formattedFahrenheit);
                }
            } else temperatureOutput.setText("Choose a unit");
        }
        else temperatureOutput.setText("Enter a valid temperature");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chooseUnit.getItems().addAll("Celsius", "Fahrenheit", "Kelvin");
    }
}
