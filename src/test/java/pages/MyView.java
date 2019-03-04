package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyView extends BasePage{
    public MyView(WebDriver navegador) {
        super(navegador);
    }

    public MyAccount clicarMyAccount(){
        navegador.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/a[8]")).click();
        return new MyAccount(navegador);
    }

    public FormReportIssue1 clicarReportIssue(){
        navegador.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/a[3]")).click();
        return new FormReportIssue1(navegador);
    }

    public LoginFormPage clicarLogout(){
        navegador.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/a[9]")).click();
        return new LoginFormPage(navegador);
    }
}