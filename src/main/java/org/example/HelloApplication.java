package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private static TextField output;
    private static double num1 = 0;
    private static boolean start = true;
    private static String operator = "";
//    private static final HelloController model = new HelloController();

    public static void processNum(ActionEvent event){

        if(start){
            output.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        boolean isHaveDot = false;

        if(value.equals(".")){
            if(operator.equals("")&&output.getText().isEmpty())output.setText("0.0");
            char[] temp = output.getText().toCharArray();
            for (char x:temp) {
                if (x == '.') {
                    isHaveDot = true;
                    break;
                }
            }
        }

        if(isHaveDot){
            output.setText(output.getText());
        }else {
            if(output.getText().equals("0.0")){
                output.setText("0." + value);
            }else {
                output.setText(output.getText() + value);
            }
        }

    }

    public static void processOperator(ActionEvent event) {

        String value = ((Button) event.getSource()).getText();

        if ("C".equals(value)){
            output.setText("0.0");
            operator = "";
            start = true;
        }else {

            if (!"=".equals(value)) {

                if (!operator.isEmpty()) return;
                operator = value;
                num1 = Double.parseDouble(output.getText());
                output.setText("");
            } else {
                if (operator.isEmpty()) return;
                output.setText(String.valueOf(Operator.calculation(num1, Double.parseDouble(output.getText()), operator)));
                operator = "";
                start = true;
            }

        }
    }

    @Override
    public void start(Stage stage){

        final int SIZE_V = 75;
        final int SIZE_H = 50;

        output = new TextField();
        output.setAlignment(Pos.CENTER_RIGHT);
        output.setFont(new Font(24));
        output.setMinSize(300,60);
        output.setMaxSize(300,60);

        HBox hBox = new HBox();
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        HBox hBox4 = new HBox();

        hBox.getChildren().add(output);
        hBox1.getChildren().addAll(
                Num.SEVEN.getButton(), Num.EIGHT.getButton(), Num.NINE.getButton(), Operator.SUM.getButton()
        );
        hBox2.getChildren().addAll(
                Num.FOUR.getButton(),Num.FIVE.getButton(),Num.SIX.getButton(), Operator.SUB.getButton()
        );
        hBox3.getChildren().addAll(
                Num.ONE.getButton(), Num.TWO.getButton(), Num.THREE.getButton(), Operator.MUL.getButton()
        );
        hBox4.getChildren().addAll(
                Num.ZERO.getButton(), Num.DOT.getButton(), Operator.C.getButton(), Operator.DIV.getButton()
        );

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, hBox1, hBox2, hBox3, hBox4, Operator.EQUAL.getButton());
        Scene scene = new Scene(vBox,300,310);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}