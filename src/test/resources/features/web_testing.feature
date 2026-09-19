# language: es
Característica: Pruebas automatizadas de interfaz web en url Selenium.dev

  Antecedentes:
    Dado que el usuario web se encuentra en la pagina de inicio

  @web1 @regresion @certi
  Escenario: Caso de Prueba 1 - Validar carga de pagina de inicio y titulo
    Entonces se deberia ver que el título de la pagina principal contiene "Selenium"

  @web2 @regresion @certi
  Escenario: Caso de Prueba 2 - Verificar navegacion a la pagina Documentation
    Cuando navega hacia la sección de "Documentation"
    Entonces la URL de la página debería cambiar a la sección de documentación

  @web3 @regresion @certi
  Escenario: Caso de Prueba 3 - Validar flujo de busqueda en el sitio
    Cuando realiza la busqueda de la palabra "web"
    Entonces los resultados mostrados deben corresponder a la búsqueda de "WebDriver"

