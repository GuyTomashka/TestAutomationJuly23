package Lesson18;

import org.testng.annotations.Test;

public class MyTestNG2 {

    @Test(groups = {"sanity"})
    public void MyTestNG2_Test01() {
        System.out.println("MyTestNG2_Test01");
    }

    @Test (groups = {"regression"})
    public void MyTestNG2_Test02() {
        System.out.println("MyTestNG2_Test02");
    }

    @Test (groups = {"sanity"})
    public void MyTestNG2_Test03() {
        System.out.println("MyTestNG2_Test03");
    }
}

