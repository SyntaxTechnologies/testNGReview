package reviewClass01;

import org.testng.annotations.Test;

public class priority {

    @Test(priority = 1)
    public void bIAMTEST1(){
        System.out.println("TEst 1");
    }
    @Test(priority = 2)
    public void aIAMTEST2(){
        System.out.println("TEst 2");
    }


}
