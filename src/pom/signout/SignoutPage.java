package pom.signout;

import org.openqa.selenium.By;

public class SignoutPage {

    public By openMenu(){
        return By.id("react-burger-menu-btn");
    }
    public By signOut(){
        return By.id("logout_sidebar_link");
    }


}
