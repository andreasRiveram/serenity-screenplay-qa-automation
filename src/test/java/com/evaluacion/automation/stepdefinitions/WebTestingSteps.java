package com.evaluacion.automation.stepdefinitions;

import com.evaluacion.automation.tasks.BuscarEnSitio;
import com.evaluacion.automation.ui.SeleniumHomePage;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class WebTestingSteps {

    @Before
    public void setTheStage() {
        // Inicializa el escenario de Screenplay con un elenco web que autogestiona el driver
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario web se encuentra en la pagina de inicio")
    public void queElUsuarioWebSeEncuentraEnLaPaginaDeInicio() {
        theActorCalled("TesterWeb").attemptsTo(
                Open.browserOn().the(SeleniumHomePage.class)
        );
    }

    @Entonces("se deberia ver que el título de la pagina principal contiene {string}")
    public void deberiaVerQueElTituloDeLaPaginaPrincipalContiene(String textoTitulo) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(TheWebPage.title()).contains(textoTitulo)
        );
    }

    @Cuando("navega hacia la sección de {string}")
    public void navegaHaciaLaSeccionDe(String seccion) {
        theActorInTheSpotlight().attemptsTo(
                Click.on(SeleniumHomePage.LINK_DOCUMENTATION)
        );
    }

    @Entonces("la URL de la página debería cambiar a la sección de documentación")
    public void laUrlDeLaPaginaDeberiaCambiarALaSeccionDeDocumentacion() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).contains("/documentation")
        );
    }

    @Cuando("realiza la busqueda de la palabra {string}")
    public void realizaLaBusquedaDeLaPalabra(String palabra) throws InterruptedException {
        theActorInTheSpotlight().attemptsTo(
                BuscarEnSitio.laPalabra(palabra)
        );
        //Thread.sleep(180000);
    }

    @Entonces("los resultados mostrados deben corresponder a la búsqueda de {string}")
    public void losResultadosMostradosDebenCorresponderALaBusquedaDe(String palabraEsperada) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(SeleniumHomePage.TITULO_RESULTADO).text().contains(palabraEsperada)
        );
    }
}