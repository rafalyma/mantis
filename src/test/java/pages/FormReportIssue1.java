package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormReportIssue1 extends BasePage{
    public FormReportIssue1(WebDriver navegador) {
        super(navegador);
    }

    public FormReportIssue2 selecionarProjeto(){
        WebElement campoSelecaoProjeto = navegador.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[2]/td[2]/select"));
        new Select(campoSelecaoProjeto).selectByVisibleText("Rafael Maia's Project");
        navegador.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[4]/td/input")).click();
        return new FormReportIssue2(navegador);
    }
}
