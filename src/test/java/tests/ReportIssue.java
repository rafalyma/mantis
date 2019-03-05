package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.FormReportIssue1;
import pages.LoginFormPage;
import pages.MyAccount;
import pages.MyView;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "testReportIssue.csv")

public class ReportIssue {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void SetUp(){
        //método criarNavegadorChrome para testar no google Chrome ou trocar para método criarNavegadorFirefox para
        // testar no Firefox
        navegador= Web.criarNavegadorChrome();
        new LoginFormPage(navegador).fazerLogin("rafael.maia","anacondyas").clicarReportIssue();
    }
    @Test
    public void checaTituloPaginaReportIssue(){
        String urlAcessada;
        urlAcessada=navegador.getTitle();
        assertEquals("Select Project - MantisBT",urlAcessada);
    }
    //testar se os campos Priority, Severity e Reproducibility são preenchidos com os valores Default (padrões) na tela.
    @Test
    public void testDefaultValuePriority() {
        String retornaDefaultPriority = new MyView(navegador)
                .clicarReportIssue()
                .selecionarProjeto()
                .capturarValorDefaultPriority();
        assertEquals("normal", retornaDefaultPriority);
    }
    @Test
    public void testDefaultValueSeverity() {
        String retornaDefaultSeverity = new MyView(navegador)
                .clicarReportIssue()
                .selecionarProjeto()
                .capturarValorDefaultSeverity();
        assertEquals("minor", retornaDefaultSeverity);
    }
    @Test
    public void testDefaultValueReproducibility() {
        String retornaDefaultReproducibility = new MyView(navegador)
                .clicarReportIssue()
                .selecionarProjeto()
                .capturarValorDefaultReproducibility();
        assertEquals("have not tried", retornaDefaultReproducibility);
    }

    @Test
    // Atenção: este teste também valida se os reports estão sendo gravados em sequencial correto em sua chave primária no banco. Por isso, declare no arquivo data drive os próximos sequenciais também
    public void testReportIssue(
            @Param(name="categoria")String categoria,
            @Param(name="profile") String profile,
            @Param(name="assignto")String assignto,
            @Param(name="summary")String summary,
            @Param(name="description")String description,
            @Param(name="steps")String steps,
            @Param(name="additional")String additional,
            @Param(name="mensagem")String mensagem,
            @Param(name="sequencial")String sequencial
    ){

        String mensagemRetorno= new MyView(navegador)
                .clicarReportIssue().selecionarProjeto().submitReport(categoria,profile,assignto,summary,description,steps,additional)
                .capturarMensagemReportIssueDT();

        //assertEquals((mensagem)+" "+sequencial, mensagemRetorno +" ");
        Assert.assertThat(mensagem+" "+sequencial, CoreMatchers.containsString(mensagemRetorno));

    }
    @After
    public void tearDown(){
        String screenshotArquivo = "C:\\Users\\eliana\\Desktop\\Screenshots\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador, screenshotArquivo);
        navegador.quit();
    }
}
