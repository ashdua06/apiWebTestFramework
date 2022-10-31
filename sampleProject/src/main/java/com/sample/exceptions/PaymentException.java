package com.sample.exceptions;

public class PaymentException  extends RuntimeException{
    public PaymentException() {
    }

    private PaymentException(String var1) {
        super(var1);
    }

    public PaymentException(Object var1) {
        this(String.valueOf(var1));
        if (var1 instanceof Throwable) {
            this.initCause((Throwable) var1);
        }

    }

    public PaymentException(boolean var1) {
        this(String.valueOf(var1));
    }

    public PaymentException(char var1) {
        this(String.valueOf(var1));
    }

    public PaymentException(int var1) {
        this(String.valueOf(var1));
    }

    public PaymentException(long var1) {
        this(String.valueOf(var1));
    }

    public PaymentException(float var1) {
        this(String.valueOf(var1));
    }

    public PaymentException(double var1) {
        this(String.valueOf(var1));
    }

    public PaymentException(String var1, Throwable var2) {
        super(var1, var2);
    }
}
