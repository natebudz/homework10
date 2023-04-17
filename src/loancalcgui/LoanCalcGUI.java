// Nathaniel Budz
// CPSC-24500.002
// Asks user to input loan data, and then shows all of the loans for the
// user to see on the right side of the screen

package loancalcgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoanCalcGUI extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        stage.resizableProperty().set(false);
        stage.setTitle("GUI LOAN CALC BY NATE BUDZ");
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
