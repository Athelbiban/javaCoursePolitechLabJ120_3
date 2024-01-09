package org.example.javacoursepolitechlabj120_3;

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

    private TextField output;
    private double num1 = 0;
    private boolean start = true;
    private String operator = "";
    private final HelloController model = new HelloController();

    public void processNum(ActionEvent event){
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

    public void processOperator(ActionEvent event) {
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
                output.setText(String.valueOf(model.calculation(num1, Double.parseDouble(output.getText()), operator)));
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

        Map<Num, >

        Button[] buttonsNum = {
                new Button("0"),
                new Button("1"),
                new Button("2"),
                new Button("3"),
                new Button("4"),
                new Button("5"),
                new Button("6"),
                new Button("7"),
                new Button("8"),
                new Button("9"),
                new Button("."),
        };

        Button[] buttonsOperator = {
                new Button("+"),
                new Button("-"),
                new Button("*"),
                new Button("/"),
                new Button("="),
                new Button("C"),
        };

        for (Button b : buttonsNum) {
            b.setMaxSize(SIZE_V, SIZE_H);
            b.setMinSize(SIZE_V, SIZE_H);
            b.setOnAction(this::processNum);
        }

        for (Button b : buttonsOperator) {
            b.setMaxSize(SIZE_V, SIZE_H);
            b.setMinSize(SIZE_V, SIZE_H);
            b.setOnAction(this::processOperator);
        }

//        Button button7 = new Button("7");
//        button7.setMaxSize(SIZE_V,SIZE_H);
//        button7.setMinSize(SIZE_V,SIZE_H);
//        button7.setOnAction(this::processNum);
//        Button button8 = new Button("8");
//        button8.setMaxSize(SIZE_V,SIZE_H);
//        button8.setMinSize(SIZE_V,SIZE_H);
//        button8.setOnAction(this::processNum);
//        Button button9 = new Button("9");
//        button9.setMaxSize(SIZE_V,SIZE_H);
//        button9.setMinSize(SIZE_V,SIZE_H);
//        button9.setOnAction(this::processNum);
//        Button buttonPlus = new Button("+");
//        buttonPlus.setMaxSize(SIZE_V,SIZE_H);
//        buttonPlus.setMinSize(SIZE_V,SIZE_H);
//        buttonPlus.setOnAction(this::processOperator);

//        Button button4 = new Button("4");
//        button4.setMaxSize(SIZE_V,SIZE_H);
//        button4.setMinSize(SIZE_V,SIZE_H);
//        button4.setOnAction(this::processNum);
//        Button button5 = new Button("5");
//        button5.setMaxSize(SIZE_V,SIZE_H);
//        button5.setMinSize(SIZE_V,SIZE_H);
//        button5.setOnAction(this::processNum);
//        Button button6 = new Button("6");
//        button6.setMaxSize(SIZE_V,SIZE_H);
//        button6.setMinSize(SIZE_V,SIZE_H);
//        button6.setOnAction(this::processNum);
//        Button buttonMinus = new Button("-");
//        buttonMinus.setMaxSize(SIZE_V,SIZE_H);
//        buttonMinus.setMinSize(SIZE_V,SIZE_H);
//        buttonMinus.setOnAction(this::processOperator);

//        Button button1 = new Button("1");
//        button1.setMaxSize(SIZE_V,SIZE_H);
//        button1.setMinSize(SIZE_V,SIZE_H);
//        button1.setOnAction(this::processNum);
//        Button button2 = new Button("2");
//        button2.setMaxSize(SIZE_V,SIZE_H);
//        button2.setMinSize(SIZE_V,SIZE_H);
//        button2.setOnAction(this::processNum);
//        Button button3 = new Button("3");
//        button3.setMaxSize(SIZE_V,SIZE_H);
//        button3.setMinSize(SIZE_V,SIZE_H);
//        button3.setOnAction(this::processNum);
//        Button buttonMultiply = new Button("*");
//        buttonMultiply.setMaxSize(SIZE_V,SIZE_H);
//        buttonMultiply.setMinSize(SIZE_V,SIZE_H);
//        buttonMultiply.setOnAction(this::processOperator);

//        Button button0 = new Button("0");
//        button0.setMaxSize(SIZE_V,SIZE_H);
//        button0.setMinSize(SIZE_V,SIZE_H);
//        button0.setOnAction(this::processNum);
//        Button buttonDot = new Button(".");
//        buttonDot.setMaxSize(SIZE_V,SIZE_H);
//        buttonDot.setMinSize(SIZE_V,SIZE_H);
//        buttonDot.setOnAction(this::processNum);
//        Button buttonC = new Button("C");
//        buttonC.setMaxSize(SIZE_V,SIZE_H);
//        buttonC.setMinSize(SIZE_V,SIZE_H);
//        buttonC.setOnAction(this::processOperator);
//        Button buttonDivision = new Button("/");
//        buttonDivision.setMaxSize(SIZE_V,SIZE_H);
//        buttonDivision.setMinSize(SIZE_V,SIZE_H);
//        buttonDivision.setOnAction(this::processOperator);

        Button buttonEquals = new Button("=");
        buttonEquals.setMaxSize(300,SIZE_H);
        buttonEquals.setMinSize(300,SIZE_H);
        buttonEquals.setOnAction(this::processOperator);

        HBox root = new HBox();
        root.getChildren().add(output);
        HBox root1 = new HBox();
        root1.getChildren().addAll(Num.SEVEN.getNum(),button8,button9,buttonPlus);
        HBox root2 = new HBox();
        root2.getChildren().addAll(button4,button5,button6,buttonMinus);
        HBox root3 = new HBox();
        root3.getChildren().addAll(button1,button2,button3,buttonMultiply);
        HBox root4 = new HBox();
        root4.getChildren().addAll(button0,buttonDot,buttonC,buttonDivision);

        VBox rootMain = new VBox();
        rootMain.getChildren().addAll(root,root1,root2,root3, root4,buttonEquals);
        Scene scene = new Scene(rootMain,300,310);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

enum Num {

    ZERO("0"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"),
    FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9");

    private final String NUM;

    Num(String num) {
        NUM = num;
    }

    public String getNum() { return NUM; }
}

enum Operator {

}