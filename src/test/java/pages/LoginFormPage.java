package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {

    public LoginFormPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginFormPage digitarLogin(String login){
        navegador.findElement(By.name("username")).sendKeys(login);
        return this;

    }
    public LoginFormPage digitarSenha(String senha){
        navegador.findElement(By.name("password")).sendKeys(senha);
        return this;

    }
    public LoginFormPage clicarLogin(){
        navegador.findElement(By.className("button")).click();
        return this;
    }
    public MyView fazerLogin(String login, String senha){
        digitarLogin(login)
        .digitarSenha(senha)
        .clicarLogin();
        return new MyView(navegador);

    }
}
