package org.example;

public enum Operator {

    SUM("+"){
        public void action(int x, int y) {
            System.out.println(x + y);
        }
    };
//    SUB("-"), MUL("*"), DIV("/");

    private final String OPERATOR;

    Operator(String operator) {
        OPERATOR = operator;
    }

    public String getOperator() { return OPERATOR; }

    public abstract void action(int x, int y);
}
