**JavaFX Overview**

JavaFX is a powerful framework for building modern, rich client applications in Java. It enables the creation of graphical user interfaces (GUIs) with interactive features. JavaFX provides tools for UI controls, 2D and 3D graphics, media handling, animation, and much more, making it ideal for developing desktop applications.

Key features of JavaFX:

Supports building modern, cross-platform applications.

Includes UI controls like buttons, text fields, tables, and more.

Allows styling through CSS, theming, and media integration.

Provides rich graphics features, including 2D shapes, 3D support, and animations.

Built to be compatible with Java, allowing developers to leverage existing Java libraries.

--------------------------------------------------------

**JavaFX Installation and Architecture
Installation:**

JDK: To start with JavaFX, you need to have Java Development Kit (JDK) installed on your system. Starting with JDK 8, JavaFX was bundled with the JDK. However, since JDK 11, JavaFX is a separate module, and you need to download it separately.

Download JDK from **Oracle**.

Download JavaFX from **OpenJFX**.

IDE: Use any Java IDE like IntelliJ IDEA, Eclipse, or NetBeans. These IDEs support JavaFX development and help manage dependencies like JavaFX libraries.

Architecture: JavaFX follows a modular architecture:

Application Class: The entry point of the application that extends javafx.application.Application and overrides the start() method.

Scene: The container for all UI elements (controls, shapes, etc.) in the JavaFX application.

Stage: The main window of the application. A stage contains a scene and can have various configurations like size, title, etc.

Controls and Layouts: Used to create the UI components and manage the layout of these components.

--------------------------------------------------------
**JavaFX Text**

Text in JavaFX refers to the text content that you can display in UI elements, such as Label, TextField, TextArea, etc. JavaFX provides flexible methods for handling and styling text.

Label: A simple UI control that displays text.

Text: A class used to represent text in a scene (different from Label).

Example of displaying text using a Label:

**hello-view.fxml.java**
~~~~
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.text.Text?>
<?import javafx.scene.layout.VBox?>

<VBox xmlns="http://javafx.com/javafx"
      xmlns:fx="http://javafx.com/fxml"
      fx:controller="com.example.demo.HelloController"
      alignment="CENTER" spacing="20" style="-fx-padding: 40;">
    
    <Text fx:id="textDisplay" text="This is JavaFX Text!" style="-fx-font-size: 24px;"/>
    
</VBox>
~~~~
**HelloController.java**
~~~~
package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class HelloController {

    @FXML
    private Text textDisplay;

    // Optional: Modify the text programmatically if needed
    @FXML
    public void initialize() {
        textDisplay.setText("Welcome to JavaFX Text Example!");
    }
}

~~~~~
**HelloApplication.java**
~~~~
package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 400, 200);

        stage.setTitle("JavaFX Text Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

~~~~
--------------------------------------------------------
**JavaFX Event Handling**

Event handling in JavaFX lets you respond to user interactions like:

- Button 

- Mouse movements

- Key presses

The most common way: use onAction in FXML (or .setOnAction() in code) and handle the event in the controller.

**hello-view.fxml**
~~~~
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.*?>
<?import javafx.scene.layout.VBox?>

<VBox xmlns="http://javafx.com/javafx"
      xmlns:fx="http://javafx.com/fxml"
      fx:controller="com.example.demo.HelloController"
      alignment="CENTER" spacing="20" style="-fx-padding: 30;">
    
    <Button text="Click Me!" onAction="#handleClick" />
    
    <Label fx:id="responseLabel" text="Waiting for button click..." />

</VBox>
~~~~
**HelloController.java**
~~~~
package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class HelloController {

    @FXML
    private Label responseLabel;

    @FXML
    public void handleClick(ActionEvent event) {
        responseLabel.setText("Button was clicked!");
    }
}
~~~~
**HelloApplication.java**
~~~~
package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 400, 200);
        stage.setTitle("JavaFX Event Handling");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
~~~~
--------------------------------------------------
**JavaFX UI** 

Controls are components users can interact with. Common controls include:

* Label – display text
* TextField – single-line text input
* TextArea – multi-line text input
* Button – clickable button
* CheckBox – toggle on/off
* RadioButton – select one from a group
* ComboBox – dropdown menu
* ListView – scrollable list

**hello-view.fxml**
~~~~
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.*?>
<?import javafx.scene.layout.VBox?>

<VBox xmlns="http://javafx.com/javafx"
      xmlns:fx="http://javafx.com/fxml"
      fx:controller="com.example.demo.HelloController"
      spacing="10" alignment="CENTER" style="-fx-padding: 20;">

    <Label text="Enter your name:" />
    <TextField fx:id="nameField" />

    <Label text="Select your favorite color:" />
    <ComboBox fx:id="colorBox" />

    <CheckBox fx:id="agreeCheck" text="I agree to the terms" />

    <Button text="Submit" onAction="#handleSubmit" />

    <Label fx:id="resultLabel" wrapText="true" />
</VBox>
~~~~
**HelloController.java**
~~~~
package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private TextField nameField;

    @FXML
    private ComboBox<String> colorBox;

    @FXML
    private CheckBox agreeCheck;

    @FXML
    private Label resultLabel;

    @FXML
    public void initialize() {
        colorBox.getItems().addAll("Red", "Blue", "Green", "Yellow");
    }

    @FXML
    protected void handleSubmit() {
        String name = nameField.getText();
        String color = colorBox.getValue();
        boolean agreed = agreeCheck.isSelected();

        if (name.isEmpty() || color == null || !agreed) {
            resultLabel.setText("Please complete all fields and agree to the terms.");
        } else {
            resultLabel.setText("Hello, " + name + "! Your favorite color is " + color + ".");
        }
    }
}
~~~~
**HelloApplication.java**
~~~~
package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("JavaFX UI Controls");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
~~~~
--------------------------------------------------
**Layout panes** 

Are containers that organize UI controls in a specific layout. Common ones include:
* VBox - Vertically stacked elements
* HBox - Horizontally aligned elements
* GridPane - Grid with rows and columns
* BorderPane - Top, bottom, left, right, and center regions
* StackPane - All nodes stacked on top of each other
* FlowPane - Like word wrapping layout

**hello-view.fxml**
~~~~
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.text.*?>

<VBox xmlns="http://javafx.com/javafx"
      xmlns:fx="http://javafx.com/fxml"
      fx:controller="com.example.demo.HelloController"
      spacing="15" alignment="CENTER" style="-fx-padding: 20;">

    <Text text="User Login" style="-fx-font-size: 24px;" />

    <GridPane hgap="10" vgap="10">
        <Label text="Username:" GridPane.rowIndex="0" GridPane.columnIndex="0" />
        <TextField fx:id="usernameField" GridPane.rowIndex="0" GridPane.columnIndex="1" />

        <Label text="Password:" GridPane.rowIndex="1" GridPane.columnIndex="0" />
        <PasswordField fx:id="passwordField" GridPane.rowIndex="1" GridPane.columnIndex="1" />
    </GridPane>

    <HBox spacing="10" alignment="CENTER">
        <Button text="Login" onAction="#handleLogin" />
        <Button text="Clear" onAction="#handleClear" />
    </HBox>

    <Label fx:id="statusLabel" text="" />
</VBox>
~~~~
**HelloController.java**
~~~~
package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    @FXML
    protected void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if ("user".equals(username) && "pass".equals(password)) {
            statusLabel.setText("Login successful!");
        } else {
            statusLabel.setText("Invalid credentials.");
        }
    }

    @FXML
    protected void handleClear() {
        usernameField.clear();
        passwordField.clear();
        statusLabel.setText("");
    }
}
~~~~
**HelloApplication.java**
~~~~
package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("JavaFX Layout Panes");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
~~~~
-----------------------------------------------------------------
**JavaFX CSS**

JavaFX allows you to style UI elements using CSS, just like you would style HTML elements on a web page. You can:

* Change colors, fonts, padding, borders
* Style controls like Button, Label, TextField
* Define styles for classes, IDs, or types

**hello-view.fxml (link the CSS)**
~~~~
<VBox ... stylesheets="@style.css">
~~~~
**Example of hello-view.fxml:**
~~~~
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>
<?import javafx.scene.text.Text?>

<VBox xmlns="http://javafx.com/javafx"
      xmlns:fx="http://javafx.com/fxml"
      fx:controller="com.example.demo.HelloController"
      spacing="15" alignment="CENTER" style="-fx-padding: 20;"
      stylesheets="@style.css">

    <Text text="User Login" />

    <GridPane hgap="10" vgap="10">
        <Label text="Username:" GridPane.rowIndex="0" GridPane.columnIndex="0" />
        <TextField fx:id="usernameField" GridPane.rowIndex="0" GridPane.columnIndex="1" />

        <Label text="Password:" GridPane.rowIndex="1" GridPane.columnIndex="0" />
        <PasswordField fx:id="passwordField" GridPane.rowIndex="1" GridPane.columnIndex="1" />
    </GridPane>

    <HBox spacing="10" alignment="CENTER">
        <Button text="Login" onAction="#handleLogin" />
        <Button text="Clear" onAction="#handleClear" />
    </HBox>

    <Label fx:id="statusLabel" text="" />
</VBox>
~~~~
**style.css**
~~~~
/* style.css */

/* Apply to all text fields */
.text-field, .password-field {
    -fx-border-color: #aaa;
    -fx-border-radius: 4;
    -fx-background-radius: 4;
    -fx-padding: 6;
    -fx-font-size: 14px;
}

/* Apply to all labels */
.label {
    -fx-font-size: 14px;
    -fx-text-fill: #333;
}

/* Style the main heading */
.text {
    -fx-font-size: 24px;
    -fx-font-weight: bold;
    -fx-fill: #336699;
}

/* Buttons */
.button {
    -fx-background-color: #336699;
    -fx-text-fill: white;
    -fx-font-weight: bold;
    -fx-padding: 6 12;
    -fx-background-radius: 6;
}

.button:hover {
    -fx-background-color: #2a5a88;
}

/* Status label for login result */
#statusLabel {
    -fx-font-size: 14px;
    -fx-font-weight: bold;
    -fx-text-fill: green;
}
~~~~
**HelloController.java (optional: update text color based on result)**
~~~~
@FXML
protected void handleLogin() {
    String username = usernameField.getText();
    String password = passwordField.getText();

    if ("user".equals(username) && "pass".equals(password)) {
        statusLabel.setStyle("-fx-text-fill: green;");
        statusLabel.setText("Login successful!");
    } else {
        statusLabel.setStyle("-fx-text-fill: red;");
        statusLabel.setText("Invalid credentials.");
    }
}
~~~~