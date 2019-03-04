package pages;

import org.kohsuke.rngom.parse.host.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver navegador;

    public BasePage(WebDriver navegador){

        this.navegador=navegador;
    }
    public String capturarMensagemLoginTestesDT() {
        try{ return

               navegador.findElement(By.className("login-info-left")).getText();
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
}

