package vendingMachine.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class VendingMachineController {
    public Label helloWorld;

    public void sayHelloWorld(ActionEvent actionEvent) {
        helloWorld.setText("Hello World!");
    }
}
