package org.europa.together.chapter04;

public class SystemUnderTest {

    private int parameter;

    public int power() {
        return calculate(parameter, parameter);
    }

    public void setParameter(int parameter) {
        this.parameter = parameter;
    }

    public int getParameter() {
        return this.parameter;
    }

    private int calculate(int operand01, int operand02) {
        return operand01 * operand02;
    }
}
