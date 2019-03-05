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
import pages.LoginFormPage;
import pages.MyAccount;
import pages.MyView;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "testAlteraPassword.csv")

public class AlterarDadosUsuario {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void SetUp(){
        //método criarNavegadorChrome para testar no google Chrome ou trocar para método criarNavegadorFirefox para
        // testar no Firefox
        navegador= Web.criarNavegadorChrome();
        new LoginFormPage(navegador).fazerLogin("rafael.maia","anacondyas");
        new MyView(navegador).clicarMyAccount();
    }
    @Test
    public void checaTituloPaginaMyAccount(){
        String urlAcessada;
        urlAcessada=navegador.getTitle();
        assertEquals("My Account - MantisBT",urlAcessada);
    }

    @Test
    public void testAlterarPasswordMyAccount(
            @Param(name="password")String password,
            @Param(name="confirm") String confirmaPassword,
            @Param(name="email")String novoEmail,
            @Param(name="realname")String novoRealName,
            @Param(name="mensagem")String mensagem
    ){

        String mensagemRetorno= new MyAccount(navegador)
                .alterarPassword(password,confirmaPassword,novoEmail,novoRealName)
                .capturarMensagemAlteraPasswordDT();
        assertEquals(mensagem, mensagemRetorno);

    }

    @After
    public void tearDown(){
        String screenshotArquivo = "C:\\Users\\eliana\\Desktop\\Screenshots\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador, screenshotArquivo);
        navegador.quit();
 }
}