module com.rocs.java.practice.application.javafxpractice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.rocs.java.practice.application.javafxpractice to javafx.fxml;
    exports com.rocs.java.practice.application.javafxpractice;
}