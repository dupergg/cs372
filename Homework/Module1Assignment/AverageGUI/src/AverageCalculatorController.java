import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AverageCalculatorController {

//region Global variables
    double temp = 0;
    double output = 0;
    int counter = 1;
//endregion

// region FXML Elements
    @FXML
    private TextField inputTextField;

    @FXML
    private TextField averageTextField;

    @FXML
    private Button confirmButton;

    @FXML
    private Button resetButton;

    @FXML
    private TextArea textArea;

// endregion

    @FXML
    void confirmButtonPressed(ActionEvent event) {
        try {
            double input = Double.parseDouble(inputTextField.getText());

            temp += input;
            output = temp / counter;
            counter++;

            inputTextField.setText("");
            
            textArea.appendText(Double.toString(input) + " + ");
            averageTextField.setText(Double.toString(output));
        } catch (NumberFormatException e) {
            averageTextField.setText("Error, try again.");
            inputTextField.selectAll();
            inputTextField.requestFocus();
        }
    }

    @FXML
    void resetButtonPressed(ActionEvent event) {
        inputTextField.setText("");
        averageTextField.setText("");
        textArea.setText("");

        temp = 0;
        output = 0;
        counter = 1;
    }
}
