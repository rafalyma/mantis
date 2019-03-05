package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginFormPage;
import pages.MyView;
import sun.rmi.runtime.Log;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "testLoginUsuarioValido.csv")

public class TestePaginaInicial {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void SetUp(){
        //método criarNavegadorChrome para testar no google Chrome ou trocar para método criarNavegadorFirefox para
        // testar no Firefox
        navegador=Web.criarNavegadorChrome();

    }
    @Test
    public void checaTituloPaginaInicial(){
        String urlAcessada;
        urlAcessada=navegador.getTitle();
        assertEquals("MantisBT",urlAcessada);
    }

    @Test
    public void testLoginUsuarioValido(
            @Param(name="login")String login,
            @Param(name="senha") String senha,
            @Param(name="mensagem")String mensagem
    )
    {
        String mensagemRetorno = new LoginFormPage(navegador)
                .fazerLogin(login,senha)
                 .capturarMensagemLoginTestesDT();

        assertEquals(mensagem, mensagemRetorno);

    }

    @Test
    public void testLogout(){
        new LoginFormPage(navegador).fazerLogin("rafael.maia","anacondyas").clicarLogout();

        assertEquals(navegador.getCurrentUrl(),"http://mantis-prova.base2.com.br/login_page.php");

    }

    @After
    public void tearDown(){
        String screenshotArquivo = "C:\\Users\\eliana\\Desktop\\Screenshots\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador, screenshotArquivo);
        navegador.quit();
    }

}
