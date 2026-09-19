package com.evaluacion.automation.tasks;

import com.evaluacion.automation.ui.SeleniumHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;


public class BuscarEnSitio implements Task {

    private final String palabraClave;

    public BuscarEnSitio(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    public static BuscarEnSitio laPalabra(String palabraClave) {
        return Tasks.instrumented(BuscarEnSitio.class, palabraClave);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SeleniumHomePage.BOTON_BUSQUEDA),
                Enter.theValue(palabraClave).into(SeleniumHomePage.INPUT_BUSQUEDA),
                Click.on(SeleniumHomePage.PRIMER_RESULTADO)

        );
    }

}
