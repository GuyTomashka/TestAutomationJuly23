package Lesson18;

import org.testng.annotations.Test;

public class MyTestNG1 {



        @Test(groups = {"regression"})
        public void MyTestNG1_Test01() {
            System.out.println("MyTestNG1_Test01");
        }

        @Test (groups = {"sanity"})
        public void MyTestNG1_Test02() {
            System.out.println("MyTestNG1_Test02");
        }

        @Test (groups = {"regression"})
        public void MyTestNG1_Test03() {
            System.out.println("MyTestNG1_Test03");
        }
    }

