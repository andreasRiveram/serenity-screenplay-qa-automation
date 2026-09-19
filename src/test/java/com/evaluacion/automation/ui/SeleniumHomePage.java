package com.evaluacion.automation.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class SeleniumHomePage extends PageObject {

    public static final Target LINK_DOCUMENTATION = Target.the("Enlace a Documentación")
            .located(By.xpath("//a[contains(@href, '/documentation')]"));

    public static final Target BOTON_BUSQUEDA = Target.the("Botón de búsqueda")
            .located(By.className("DocSearch-Button"));

    public static final Target INPUT_BUSQUEDA = Target.the("Campo de entrada de texto")
            .located(By.id("docsearch-input"));

    // Define el Target para la primera sugerencia que aparece en la lista
    public static final Target PRIMER_RESULTADO = Target.the("Primer resultado de la lista")
            .located(By.cssSelector(".DocSearch-Hit a"));

    public static final Target TITULO_RESULTADO = Target.the("Título principal del resultado")
            .located(By.tagName("h1"));
}
