/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.test;

import org.junit.Test;

/**
 *
 * @author camm
 */
public class TextLogin extends TestFXBase {
    private String BTN_LOGIN = "Login";
    private String BTN_NEW_USER = "New User?";
    private String BTN_ACEPT = "Acept";
    private String BTN_CANCEL = "Cancel";
    private String TXT_USER_NAME = "#txtUserName";
    private String TXT_PASSWORD = "#passPassword";

    @Test
    public void ensureLoginIsShown(){
        clickOn(BTN_LOGIN);
        clickOn(BTN_NEW_USER);
    }

    @Test
    public void ensureNewUserIsCreated(){
        clickOn(BTN_NEW_USER);
        clickOn(BTN_CANCEL);
        clickOn(BTN_NEW_USER);
        clickOn(TXT_USER_NAME).write("USER_TEST");
        clickOn(TXT_PASSWORD).write("USER_PASS");
        clickOn(BTN_ACEPT);
    }

    @Test
    public void ensureNewUserIsLoged(){
        clickOn(TXT_USER_NAME).write("USER_TEST");
        clickOn(TXT_PASSWORD).write("USER_PASS");
        clickOn(BTN_LOGIN);
    }
}
