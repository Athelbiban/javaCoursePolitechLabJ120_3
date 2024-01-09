module org.example.javacoursepolitechlabj120_3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.scripting;


    opens org.example.javacoursepolitechlabj120_3 to javafx.fxml;
    exports org.example.javacoursepolitechlabj120_3;
}