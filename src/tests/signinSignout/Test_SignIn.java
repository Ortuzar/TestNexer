package tests.signinSignout;

import core.helpers.AssertHelpers;
import core.helpers.ClickHelpers;
import core.helpers.WaitHelpers;
import core.utils.ReadExcelFile;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.signin.SigninPage;
import pom.signout.SignoutPage;
import tests.Hooks;


public class Test_SignIn extends Hooks {

    ClickHelpers click = new ClickHelpers();
    SigninPage signinPage = new SigninPage();
    AssertHelpers assertHelpers = new AssertHelpers();
    ReadExcelFile readFile = new ReadExcelFile();

    @Test(dataProvider="Login")
    public void TC0000_Signin(String username, String password, String message) {

        signinPage.login(driver, username, password);

        //Validation
        assertHelpers.assertEquals(driver, signinPage.errorMessageLabel(), message);

    }
    @DataProvider
    public Object[][] Login() throws Exception{

        Object[][] testObjArray = readFile.getTableArray(System.getProperty("user.dir") + "/src/data/test.xlsx","LOGIN");
        return (testObjArray);

    }
}