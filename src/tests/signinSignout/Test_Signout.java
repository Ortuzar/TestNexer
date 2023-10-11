package tests.signinSignout;

import core.helpers.AssertHelpers;
import core.helpers.ClickHelpers;
import core.helpers.WaitHelpers;
import core.utils.ReadExcelFile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.signin.SigninPage;
import pom.signout.SignoutPage;
import tests.Hooks;


public class Test_Signout extends Hooks {

    ClickHelpers click = new ClickHelpers();
    SigninPage signinPage = new SigninPage();
    AssertHelpers assertHelpers = new AssertHelpers();
    SignoutPage signoutPage = new SignoutPage();
    WaitHelpers waitHelpers = new WaitHelpers();
    ReadExcelFile readFile = new ReadExcelFile();

    @Test(dataProvider="Logout")
    public void TC0002_Signout(String username, String password, String message) {

        //login
        signinPage.login(driver, username, password);

        //open menu
        click.click(driver, signoutPage.openMenu());

        //logout
        click.click(driver, signoutPage.signOut());

        //Validation
        assertHelpers.assertExist(driver, signinPage.loginButton());

    }
    @DataProvider
    public Object[][] Logout() throws Exception{

        Object[][] testObjArray = readFile.getTableArray(System.getProperty("user.dir") + "/src/data/test.xlsx","LOGOUT");
        return (testObjArray);

    }
}