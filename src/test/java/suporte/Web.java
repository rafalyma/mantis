package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver criarNavegadorChrome() {
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\eliana\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.manage().window().maximize();

        // Navegando para a página do Mantis!
        navegador.get("http://mantis-prova.base2.com.br/");

        return navegador;
    }
    public static WebDriver criarNavegadorFirefox() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\eliana\\Desktop\\selenium\\firefox\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette", false);
        WebDriver navegador=new FirefoxDriver(options);
        //especificando tempo de espera implícito
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //maximizando a tela do navegador google chrome
        navegador.manage().window().maximize();
        //acessando a página do mantis
        navegador.get("http://mantis-prova.base2.com.br/");

        return navegador;
    }
}

