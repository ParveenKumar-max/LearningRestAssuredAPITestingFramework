package org.apitestinglearning.Ex_02_BuilderPattern;

public class Ex_API_04_BuilderPattern {

    // Builder Pattern

    public Ex_API_04_BuilderPattern step1(){
        System.out.println("Step 1 Builder Pattern");
        return this;
    }
    public Ex_API_04_BuilderPattern step2(){
        System.out.println("Step 2 Builder Pattern");
        return this;
    }
    public Ex_API_04_BuilderPattern step3(String Content){
        System.out.println("Step 3 Builder Pattern" + " " + Content);
        return this;
    }

    public static void main(String[] args) {
        Ex_API_04_BuilderPattern builderPattern = new Ex_API_04_BuilderPattern();
        builderPattern.step1().step2().step3("Parveen Chaudhary");
    }
}
