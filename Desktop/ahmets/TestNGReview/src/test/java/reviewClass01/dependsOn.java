package reviewClass01;

import org.testng.annotations.Test;

public class dependsOn {

    @Test
    public void login(){
        System.out.println("Login");
    }


    @Test(dependsOnMethods = "login")
    public void verifytheDashBoardpage(){
        System.out.println("dependent method");
    }
}
