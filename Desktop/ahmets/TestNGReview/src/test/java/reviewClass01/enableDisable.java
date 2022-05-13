package reviewClass01;

import org.testng.annotations.Test;

public class enableDisable {

    @Test(enabled = false)
    public void test1(){
        System.out.println("hellow");
    }
    @Test
    public void test2(){
        System.out.println("hi");
    }
}
