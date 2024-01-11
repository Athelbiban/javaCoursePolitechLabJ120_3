package org.example;

import javafx.scene.control.Button;

public enum Num {

        ZERO("0"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"),
        SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), DOT(".");

        private final String NUM;

        Num(String num) {
            NUM = num;
        }

        public String getNum() { return NUM; }

        public Button getButton() {

                int SIZE_H = 50;
                int SIZE_V = 75;

                Button button = new Button(this.getNum());
                button.setMaxSize(SIZE_V, SIZE_H);
                button.setMinSize(SIZE_V, SIZE_H);
                button.setOnAction(HelloApplication::processNum);
                return button;

        }

}
