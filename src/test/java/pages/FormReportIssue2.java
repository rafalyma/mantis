package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormReportIssue2 extends BasePage{


    public FormReportIssue2(WebDriver navegador) {
        super(navegador);
    }
    public FormReportIssue2 informarCategoria(String categoria){
        WebElement campoCategoria = navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[2]/td[2]/select"));
        try{
            new Select(campoCategoria).selectByVisibleText(categoria);
        }catch (Exception e){
            new Select(campoCategoria).selectByVisibleText("(select)");
    }
        return this;
    }
    public FormReportIssue2 informarSelectProfile(String profile){
        WebElement campoProfile = navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[6]/td[2]/select"));
        new Select(campoProfile).selectByVisibleText(profile);
        return this;
    }
    public FormReportIssue2 informarAssignTo(String assignto){
        WebElement campoAssign = navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[8]/td[2]/select"));
        new Select(campoAssign).selectByVisibleText(assignto);
        return this;
    }
    public FormReportIssue2 informarSummary(String summary){
        navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[9]/td[2]/input")).sendKeys(summary);
        return this;
    }
    public FormReportIssue2 informarDescription(String description){
        navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[10]/td[2]/textarea")).sendKeys(description);
        return this;
    }
    public FormReportIssue2 informarStepsToReproduce(String steps){
        navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[11]/td[2]/textarea")).sendKeys(steps);
        return this;
    }
    public FormReportIssue2 informarAdditionalInformation(String additional){
        navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[12]/td[2]/textarea")).sendKeys(additional);
        return this;
    }
    public FormReportIssue2 clicarSubmitReport(){
        navegador.findElement(By.className("button")).click();
        return this;
    }

    public FormReportIssue2 submitReport(String categoria,
                                         String profile,
                                         String assignto,
                                         String summary,
                                         String description,
                                         String steps,
                                         String additional)
                                        {
                informarCategoria(categoria)
                .informarSelectProfile(profile)
                .informarAssignTo(assignto)
                .informarSummary(summary)
                .informarDescription(description)
                .informarStepsToReproduce(steps)
                .informarAdditionalInformation(additional)
                .clicarSubmitReport();

        return this;

    }

}
