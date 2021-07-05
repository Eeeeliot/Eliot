package com.app.calculator;

public class Calculator {
    private double result = 0;
    private boolean first = true; //current token is left operand
    private char operator; //current operator
    private double firstOperand;
    private double secondOperand;
    private String token;
    private boolean eqPressed;
    private String lastText = "";

    public Calculator() {
        reset();
    }

    public void buttonClicked(String buttonText) {
        buttonText = buttonText.toLowerCase();
        lastText = buttonText;

        if (buttonText.equals("c")) {
            reset();
        } else if (buttonText.startsWith("<")) {
            //<-
            if (token.length() > 0) {
                token = token.substring(0, token.length() - 1);
            }
        } else if (buttonText.equals("sin") || buttonText.equals("cos")
                || buttonText.equals("tan")) {

            if (first) {
                firstOperand = Double.parseDouble(token);
                result = apply(firstOperand, buttonText);
                token = "";
            } else {
                buttonClicked("=");
                result = apply(result, buttonText);
                token = "";
                first = true;
            }

            eqPressed = true;
        } else if (buttonText.equals("+") || buttonText.equals("-")
                || buttonText.equals("*") || buttonText.equals("/")) {

            try {
                if(first){
                    firstOperand = Double.parseDouble(token);
                    first = false;
                    token = "";
                }else{
                    token = "";
                }

                operator = buttonText.charAt(0);
            } catch (NumberFormatException e) {
                reset();
            } catch (ArithmeticException e) {
                reset();
            }

        } else if (buttonText.startsWith("=")) {
            if(eqPressed){
                if(first){
                    result = firstOperand;
                }else {
                    result = apply(firstOperand, secondOperand, operator);
                }
                return;
            }

            //<-
            try {
                if (!first) {
                    secondOperand = Double.parseDouble(token);
                    result = apply(firstOperand, secondOperand, operator);
                    token = "";
                    firstOperand = result;
                }else{
                    firstOperand = Double.parseDouble(token);
                    result = firstOperand;
                    token = "";
                }
            } catch (NumberFormatException e) {
                reset();
            } catch (ArithmeticException e) {
                reset();
            }

            eqPressed = true;
        }else{
            if(eqPressed){
                eqPressed = false;
            }

            char ch = buttonText.charAt(0);
            if(ch >= '0' && ch <= '9'){
                token += ch;
            }else{
                if(!token.contains(".")){
                    token += ch;
                }
            }
        }
    }

    private double apply(double firstOperand, double secondOperand, char operator) {
        if (operator == '+') {
            return firstOperand + secondOperand;
        }
        if (operator == '-') {
            return firstOperand - secondOperand;
        }
        if (operator == '*') {
            return firstOperand * secondOperand;
        }

        return firstOperand / secondOperand;
    }

    private double apply(double result, String buttonText) {
        if (buttonText.equals("sin")) {
            return Math.sin(result);
        } else if (buttonText.equals("cos")) {
            return Math.cos(result);
        } else {
            return Math.tan(result);
        }
    }

    private void reset() {
        result = 0;
        first = true;
        operator = ' ';
        firstOperand = secondOperand = 0;
        token = "";
        eqPressed = false;
        lastText = "";
    }

    public String getResult() {
        if (lastText.equals("+") || lastText.equals("-")
                || lastText.equals("*") || lastText.equals("/")) {
            return lastText;
        }

        if(!eqPressed){
            return token;
        }

        return removeRearZeros(result + "");
    }

    private String removeRearZeros(String number) {
        while (number.length() > 0 && number.charAt(number.length() - 1) == '0') {
            number = number.substring(0, number.length() - 1);
        }

        if (number.endsWith(".")) {
            number = number + 0;
        }

        return number;
    }


}
