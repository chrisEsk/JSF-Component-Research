package demo.calculadora;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "CalculadoraBean")
@SessionScoped
public class CalculadoraBean implements Serializable {

    String input;
    Integer accum;
    
    String currentOperation;
    Integer memory;

    public CalculadoraBean() {
        input = "";
        if (currentOperation == null)
            currentOperation = "=";
        if (memory == null)
            memory = 0;
        if (accum == null || currentOperation.equals("="))
            accum = 0;
    }
    
    public Integer getAccum() {
        return accum;
    }
    
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
    
    private boolean isInt(String text) {
        boolean is = true;
        try {
            Integer.parseInt(text);
        } catch(NumberFormatException exc) {
            is = false;
        }
        return is;
    }
    
    private void endOperation() {
        // An operation ends when we have just displayed the result
        currentOperation = "=";
    }
    
    private void resetOperation() {
        accum = 0;
    }
    
    private void checkOperationResetRequired() {
        if (currentOperation.equals("="))
            resetOperation();
    }
    
    private void handleOperation(String operation) {
        if (isInt(input)) {
            Integer inputValue = Integer.parseInt(input);
            if (operation.equals("!")) { // unary operators first
                if (inputValue >= 0) {
                    int factorial = 1;
                    for (int i = 1; i <= inputValue; i++)
                        factorial *= i;
                    accum = factorial;
                }
            } else if (accum == 0) {
                accum = inputValue;
            } else {
                if (operation.equals("+"))
                    accum += inputValue;
                else if (operation.equals("-"))
                    accum -= inputValue;
                else if (operation.equals("*"))
                    accum *= inputValue;
                else if (operation.equals("/") && inputValue != 0)
                    accum /= inputValue;
                else if (operation.equals("^"))
                    accum = (int)Math.pow(accum, inputValue);
            }
        }
        input = "";
    }
    
    public void sum() {
        checkOperationResetRequired();
        currentOperation = "+";
        handleOperation(currentOperation);
    }
    
    public void diff() {
        checkOperationResetRequired();
        currentOperation = "-";
        handleOperation(currentOperation);
    }
    
    public void mul() {
        checkOperationResetRequired();
        currentOperation = "*";
        handleOperation(currentOperation);
    }
    
    public void divi() {
        checkOperationResetRequired();
        currentOperation = "/";
        handleOperation(currentOperation);
    }
    
    public void factorial() {
        checkOperationResetRequired();
        currentOperation = "!";
        handleOperation(currentOperation);
    }
    
    public void pow() {
        checkOperationResetRequired();
        currentOperation = "^";
        handleOperation(currentOperation);
    }
    
    public void result() {
        handleOperation(currentOperation);
        endOperation();
    }
    
    public void memorySet() {
        if (isInt(input))
            memory = Integer.parseInt(input);
    }
    
    public void memoryGet() {
        input = String.valueOf(memory);
    }
    
    public void memoryClear() {
        memory = 0;
    }
}
