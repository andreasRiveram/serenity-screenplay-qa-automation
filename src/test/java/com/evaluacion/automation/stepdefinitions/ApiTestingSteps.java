package com.evaluacion.automation.stepdefinitions;

import com.evaluacion.automation.tasks.CrearUsuario;
import io.cucumber.java.es.*;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.util.EnvironmentVariables;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.*;

public class ApiTestingSteps {

    private EnvironmentVariables environmentVariables;
    private Actor analistaApi = Actor.named("AnalistaAPI");

    private String getApiBaseUrl() {
        return EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("api.base.url");
    }

    @Cuando("el usuario consulta el listado de usuarios en la página {int}")
    public void elUsuarioConsultaElListadoDeUsuariosEnLaPagina(int pagina) {
        analistaApi.can(CallAnApi.at(getApiBaseUrl()));
        analistaApi.attemptsTo(Get.resource("/api/users?page=" + pagina));
    }

    @Entonces("la API responde con código de estado {int}")
    public void laApiRespondeConCodigoDeEstado(int codigo) {
        SerenityRest.then().statusCode(codigo);
    }

    @Y("el contenido de la respuesta contiene datos de usuarios válidos")
    public void elContenidoDeLaRespuestaContieneDatosDeUsuariosValidos() {
        SerenityRest.then()
                .body("page", notNullValue())
                .body("data", hasSize(greaterThan(0)))
                .body("data.email", everyItem(containsString("@reqres.in")));
    }

    @Cuando("el usuario envía una solicitud para crear un usuario con nombre {string} y trabajo {string}")
    public void elUsuarioEnviaUnaSolicitudParaCrearUnUsuarioConNombreYTrabajo(String nombre, String trabajo) {
        analistaApi.can(CallAnApi.at(getApiBaseUrl()));
        analistaApi.attemptsTo(CrearUsuario.conDatos(nombre, trabajo));
    }

    @Y("la respuesta contiene el nombre {string}, el trabajo {string} y un ID asignado")
    public void laRespuestaContieneElNombreElTrabajoYUnIdAsignado(String nombre, String trabajo) {
        SerenityRest.then()
                .body("name", equalTo(nombre))
                .body("job", equalTo(trabajo))
                .body("id", notNullValue());
    }

    @Cuando("el usuario envía una solicitud para actualizar el usuario {int} con nombre {string} y trabajo {string}")
    public void elUsuarioEnviaUnaSolicitudParaActualizarElUsuarioConNombreYTrabajo(int id, String nombre, String trabajo) {
        analistaApi.can(CallAnApi.at(getApiBaseUrl()));
        Map<String, Object> body = new HashMap<>();
        body.put("name", nombre);
        body.put("job", trabajo);

        analistaApi.attemptsTo(
                Put.to("/api/users/" + id).with(request -> request
                        .header("Content-Type", "application/json")
                        .body(body))
        );
    }

    @Y("los datos actualizados reflejan el trabajo {string}")
    public void losDatosActualizadosReflejanElTrabajo(String trabajo) {
        SerenityRest.then()
                .body("job", equalTo(trabajo))
                .body("updatedAt", notNullValue());
    }


}
