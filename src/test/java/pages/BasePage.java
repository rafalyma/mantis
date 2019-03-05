package pages;

import org.kohsuke.rngom.parse.host.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    protected WebDriver navegador;

    public BasePage(WebDriver navegador){

        this.navegador=navegador;
    }
    public String capturarMensagemLoginTestesDT() {
        try{

            return navegador.findElement(By.className("login-info-left")).getText();
    }catch (Exception e){
                 return navegador.findElement(By.xpath("/html/body/div[2]/font")).getText();
               }
    }

        public String capturarMensagemAlteraPasswordDT() {
            try{ return

                    navegador.findElement(By.linkText("Proceed")).getText();
            }catch (Exception e){
                return navegador.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td/p")).getText();
            }

 }

    public String capturarMensagemReportIssueDT() {
        try{
            return navegador.findElement(By.partialLinkText("View Submitted Issue")).getText();
        }catch (Exception e){
            return navegador.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td/p")).getText();
        }

    }

    public String capturarValorDefaultReproducibility(){
        WebElement pegaDefault= navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[3]/td[2]/select"));
        try {
            return new Select(pegaDefault).getFirstSelectedOption().getText();
        }catch (Exception e){
           return e.getMessage();

        }
 }
    public String capturarValorDefaultSeverity(){
        WebElement pegaDefault= navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[4]/td[2]/select"));
        try {
            return new Select(pegaDefault).getFirstSelectedOption().getText();
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public String capturarValorDefaultPriority(){
        WebElement pegaDefault= navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[5]/td[2]/select"));
        try{
           return new Select(pegaDefault).getFirstSelectedOption().getText();
        }catch (Exception e){
            return e.getMessage();
        }
    }
}

