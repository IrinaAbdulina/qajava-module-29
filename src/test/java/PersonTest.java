import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersonTest {
    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("Before class");
        currentTime();
    }

    @AfterClass
    void afterClass() {
        System.out.println("AfterClass");
        currentTime();
    }

    @Test(dataProvider = "teenagerDataProvider")
    void isTeenage(int age, boolean result) {
        Assert.assertEquals(Person.isTeenager(age), result);
    }

    @DataProvider(name = "teenagerDataProvider")
    Object[][] teenagerDataProvider() {
        return new Object[][]{
                {19, true},
                {13, true},
                {12, false},
                {20, false}
        };
    }
}
