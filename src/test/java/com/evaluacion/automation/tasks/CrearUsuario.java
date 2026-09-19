package com.evaluacion.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.HashMap;
import java.util.Map;

public class CrearUsuario implements Task {

    private final String nombre;
    private final String trabajo;

    public CrearUsuario(String nombre, String trabajo) {
        this.nombre = nombre;
        this.trabajo = trabajo;
    }

    public static CrearUsuario conDatos(String nombre, String trabajo) {
        return Tasks.instrumented(CrearUsuario.class, nombre, trabajo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, Object> body = new HashMap<>();
        body.put("name", nombre);
        body.put("job", trabajo);

        actor.attemptsTo(
                Post.to("/api/users").with(request -> request
                        .header("Content-Type", "application/json")
                        .body(body))
        );
    }
}
