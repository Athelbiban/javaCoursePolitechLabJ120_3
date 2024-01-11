package org.example;

import javafx.scene.control.Button;

public enum Operator {

    SUM("+") {
        public double calculation(double v1, double v2) { return v1 + v2; } },
    SUB("-") { public double calculation(double v1, double v2) { return v1 - v2; } },
    MUL("*") { public double calculation(double v1, double v2) { return v1 * v2; } },
    DIV("/") { public double calculation(double v1, double v2) { return v1 / v2; } },
    EQUAL("=") {
        public double calculation(double v1, double v2) { return v1 = v2; }
    },
    C("C") {
        public double calculation(double v1, double v2) {
            return 0;
        }

    };

    private final String OPERATOR;

    Operator(String operator) {
        OPERATOR = operator;
    }

    public String getOperator() { return OPERATOR; }

    public Button getButton() {

        int SIZE_H = 50;
        int SIZE_V = 75;

        Button button = new Button(this.getOperator());
        button.setMaxSize(SIZE_V, SIZE_H);
        button.setMinSize(SIZE_V, SIZE_H);
        button.setOnAction(HelloApplication::processOperator);
        return button;

    }
    public static double calculation(double a, double b, String operator){
        switch (operator){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                if(b==0) return 0;
                return a/b;
        }

        System.out.println("Неизвестный оператор " +operator);
        return 0;
    }

//    public abstract double calculation(double v1, double v2);
}
