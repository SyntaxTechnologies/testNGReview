package reviewClass01;

import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAnnotations {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("i am before method");
    }
    @Test
    public void test1(){

        System.out.println("i am test1");
    }
    @Test
    public void test2(){

        System.out.println("i am test2");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("i am after method");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("i am before class method");
    }
    @AfterClass
    public  void afterClass(){
        System.out.println("i am after class method");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("i am before test method");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("i am after test method");
    }

    @BeforeSuite
    public void beforesuit(){
        System.out.println("i am before suit");
    }

}

//we need to write down the code that opens the browser and
//navigates to a particular url
//in testNG under which annotation that kind of method should be written

//you need to read a file that has the link to the website
//some inforamtion regarding crdentials
//some information regarding the browser





