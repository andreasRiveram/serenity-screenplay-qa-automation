# language: es
Característica: Pruebas automatizadas de servicios REST en ReqRes API

  @api1 @regresionapi
  Escenario: Caso de Prueba 4 - Validar listado de usuarios
    Cuando el usuario consulta el listado de usuarios en la página 2
    Entonces la API responde con código de estado 200
    Y el contenido de la respuesta contiene datos de usuarios válidos

  @api2 @regresionapi
  Escenario: Caso de Prueba 5 - Verificar creación de un nuevo usuario
    Cuando el usuario envía una solicitud para crear un usuario con nombre "morpheus" y trabajo "leader"
    Entonces la API responde con código de estado 201
    Y la respuesta contiene el nombre "morpheus", el trabajo "leader" y un ID asignado

  @api3 @regresionapi
  Escenario: Caso de Prueba 6 - Validar actualización de datos de un usuario
    Cuando el usuario envía una solicitud para actualizar el usuario 2 con nombre "morpheus" y trabajo "zion resident"
    Entonces la API responde con código de estado 200
    Y los datos actualizados reflejan el trabajo "zion resident"
