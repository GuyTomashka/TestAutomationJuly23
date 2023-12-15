package Lesson01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JsoupEx {


    Document doc;
    @BeforeClass
    public void startSession() throws IOException{
        doc= Jsoup.connect("https://www.ebay.com").get();

    }

}
