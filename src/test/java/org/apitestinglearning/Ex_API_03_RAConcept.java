package org.apitestinglearning;

public class Ex_API_03_RAConcept {

    // NoDesignPattern

    public void step1(){
        System.out.println("Step 1");
    }

    public void step2(){
        System.out.println("Step 2");
    }

    public void step3(String Content){
        System.out.println("Step 3" + " " + Content);
    }

    public static void main(String[] args) {
        Ex_API_03_RAConcept np = new Ex_API_03_RAConcept();
        np.step1();
        np.step2();
        np.step3("Parveen");
    }


}
