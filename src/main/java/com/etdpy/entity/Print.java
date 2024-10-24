package com.etdpy.entity;

import jakarta.persistence.*;



public class Print {

        private String selectedItem;
        private int input1;
        private int input2;
        private int input3;
        private int input4;
        private String result;

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public int getInput1() {
        return input1;
    }

    public void setInput1(int input1) {
        this.input1 = input1;
    }

    public int getInput2() {
        return input2;
    }

    public void setInput2(int input2) {
        this.input2 = input2;
    }

    public int getInput3() {
        return input3;
    }

    public void setInput3(int input3) {
        this.input3 = input3;
    }

    public int getInput4() {
        return input4;
    }

    public void setInput4(int input4) {
        this.input4 = input4;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Print{" +
                "selectedItem='" + selectedItem + '\'' +
                ", input1=" + input1 +
                ", input2=" + input2 +
                ", input3=" + input3 +
                ", input4=" + input4 +
                ", result='" + result + '\'' +
                '}';
    }
}

