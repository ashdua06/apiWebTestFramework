package com.sample.exceptions;

public class UserGeneratorException extends RuntimeException{
    public UserGeneratorException() {
    }

    private UserGeneratorException(String var1) {
        super(var1);
    }

    public UserGeneratorException(Object var1) {
        this(String.valueOf(var1));
        if (var1 instanceof Throwable) {
            this.initCause((Throwable) var1);
        }

    }

    public UserGeneratorException(boolean var1) {
        this(String.valueOf(var1));
    }

    public UserGeneratorException(char var1) {
        this(String.valueOf(var1));
    }

    public UserGeneratorException(int var1) {
        this(String.valueOf(var1));
    }

    public UserGeneratorException(long var1) {
        this(String.valueOf(var1));
    }

    public UserGeneratorException(float var1) {
        this(String.valueOf(var1));
    }

    public UserGeneratorException(double var1) {
        this(String.valueOf(var1));
    }

    public UserGeneratorException(String var1, Throwable var2) {
        super(var1, var2);
    }
}
