package com.example.assignment1;

public class calc {

    private float leftNum;
    private float rightNum;
    private float negNum;

    public float getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(float leftNum) {
        this.leftNum = leftNum;
    }

    public float getRightNum() {
        return rightNum;
    }

    public void setRightNum(float rightNum) {
        this.rightNum = rightNum;
    }

    public float getNegNum() {
        return negNum;
    }

    public void setNegNum(float negNum) {
        this.negNum = negNum;
    }

    public String NegPos(){
        float negPos = -1 * this.negNum;
        return String.format("%.01f", negPos);
    }

    public String addition(){
        float Add = this.leftNum + this.rightNum;
        return String.format("%.02f",Add);
    }

    public String Subtraction(){
        float Sub = this.leftNum - this.rightNum;
        return String.format("%.02f",Sub);
    }

    public String Multiplication(){
        float Multi = this.leftNum * this.rightNum;
        return String.format("%.02f",Multi);
    }

    public float Division(){
        float Divide =  this.leftNum / this.rightNum;
        return Divide;
    }//endDivision


}//end calc
