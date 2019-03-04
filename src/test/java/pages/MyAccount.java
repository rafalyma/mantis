package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyAccount extends BasePage {
    public MyAccount(WebDriver navegador) {
        super(navegador);
    }


    public MyAccount digitaNovoPassword(String password){
        navegador.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[3]/td[2]/input")).clear();
        navegador.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[3]/td[2]/input")).sendKeys(password);
        return this;
    }

    public MyAccount digitaConfirmaNovoPassword(String confirmaPassword){
        navegador.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[4]/td[2]/input")).clear();
        navegador.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[4]/td[2]/input")).sendKeys(confirmaPassword);
        return this;
    }
    public MyAccount digitaNovoEmail(String novoEmail) {
        navegador.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[5]/td[2]/input")).clear();
        navegador.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[5]/td[2]/input")).sendKeys(novoEmail);
        return this;
    }
    public MyAccount digitarNovoRealName(String novoRealName) {
        navegador.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[6]/td[2]/input")).clear();
        navegador.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[6]/td[2]/input")).sendKeys(novoRealName);
        return this;
    }
    public MyAccount clicarUpdateUser(){
        navegador.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[10]/td[2]/input")).click();
        return this;
    }

    public MyAccount alterarPassword(String password, String confirmaPassword, String novoEmail, String novoRealName){
        digitaNovoPassword(password);
        digitaConfirmaNovoPassword(confirmaPassword);
        digitaNovoEmail(novoEmail);
        digitarNovoRealName(novoRealName);
        clicarUpdateUser();
        return this;
    }
}
