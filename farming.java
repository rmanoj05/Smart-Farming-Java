package fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class farming extends Application {

    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Smart Farming");
        GridPane gridPane2 = createRegistrationFormPane();
        GridPane gridPane3 = createRegistrationFormPane();

        Scene scene2= new Scene(gridPane2,800,500);
        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        //addUIControls(gridPane, primaryStage);
        //addUIControls(gridPane,primaryStage);
        Label headerLabel = new Label("Login Page");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("Username : ");
        gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);
        String name="root";
        String pass="password";

        // Add Password Label
        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 3);

        // Add Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 3);

        // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));
      

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your username");
                    return;
                }
                if(passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password");
                    return;
                }
                
                if(name.equals(nameField.getText())&&pass.contentEquals(passwordField.getText())) {         
                    showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + nameField.getText());
                primaryStage.setScene(scene2);
                }
                    else
                      showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Incorrect username and/or password");
                return;
                
            }
        });
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);
        Button button1= new Button("Logout");
        gridPane2.add(button1, 0, 0);
        button1.setOnAction(e -> primaryStage.setScene(scene)); 
        // Set the scene in primary stage   
        Button button2= new Button("Add New Crop Details");
        //button2.setPrefSize(10,300);
        gridPane2.add(button2, 0, 1);
        button2.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                /*Text TextResponse=new Text();
                gridPane2.add(TextResponse, 3, 3);
                TextResponse.setText("Something");*/
                Text cropLabel=new Text("Crop Name: ");
                TextField crop=new TextField();
                Text areaLabel=new Text("Area Size: ");
                TextField area=new TextField();
                Text yeildLabel=new Text("Previous Yield: ");
                TextField yield=new TextField();
                gridPane3.add(cropLabel, 0, 0);
                gridPane3.add(crop, 1, 0);
                gridPane3.add(areaLabel, 0, 1);
                gridPane3.add(area, 1, 1);
                gridPane3.add(yeildLabel, 0, 2);
                gridPane3.add(yield, 1, 2);
                Button button3= new Button("Submit Data");
                gridPane3.add(button3, 1, 3);
                button3.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent event2) {
                        showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "Submission Success", "Crop Details Have Been Added");
                        primaryStage.setScene(scene2);
                    }
                });
                Scene scene3=new Scene(gridPane3,800,500);
                primaryStage.setScene(scene3);      
            }
        });

        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    
    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color:  #DAF7A6 ;");


        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }
    
  


    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
