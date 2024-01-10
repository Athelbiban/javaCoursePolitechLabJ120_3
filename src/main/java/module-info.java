module org.example.javacoursepolitechlabj120_3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.scripting;


    exports org.example;
    opens org.example to javafx.fxml;
}