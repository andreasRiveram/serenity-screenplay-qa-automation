# serenity-screenplay-qa-automation
prueba tecnica

Este proyecto es un framework de automatización de pruebas para servicios **API** y aplicaciones **Web**, desarrollado con **Java 17**, **Serenity BDD**, **Cucumber** y el patrón de diseño **Screenplay**.

---

## 📋 Requisitos Previos

Contar con lo siguiente instaladas y configuradas en las variables de entorno del sistema:

1. **JDK 17**
2. **Apache Maven 3.8+**
3. **Google Chrome** (Actualizado a la última versión)
4. **Git**
5. **IntelliJ IDEA** (o cualquier IDE compatible con Java)

---
### 1. Ejecución Completa para todos los escenarios tanto Web como API(Entorno por defecto)

### macOS / Windows:

    mvn clean verify

---
### 2. Filtrado por Tags de Cucumber

### - Solo pruebas de API
     mvn clean verify -Dtags=@regresionapi

### - Pruebas Web en ambiente DEV
     mvn clean verify -Dtags=@regresion -Denvironment=dev

---
### 3. 📊 Reportes de Ejecución

####  Ruta:
     target/site/serenity/index.html

---
### Solución de Errores Rápidos
. Limpieza de Caché de Drivers (Selenium Manager)
Si hay un bloqueo con Chrome por actualización del navegador, elimina los binarios cacheados:

#### Bash / macOS:
    rm -rf ~/.cache/selenium

#### PowerShell:
    Remove-Item -Recurse -Force ~/.cache/selenium o
    Remove-Item -Recurse -Force $HOME/.cache/selenium 

---


## ⚙️ Integración Continua (CI/CD)

Adicional se agrega un pipeline automatizado en **GitHub Actions** para la ejecución de pruebas regresivas (Web & API) en entornos sin interfaz gráfica (*headless*).

* 🚀 **Historial de Ejecuciones:** [Ver ejecuciones en GitHub Actions](https://github.com/andreasRiveram/serenity-screenplay-qa-automation/actions)

> 🔐 **Nota sobre el acceso:** Aunque el repositorio es público, **debes haber iniciado sesión en GitHub** para poder disparar manualmente los ejecuciones (`Run workflow`) y descargar los reportes de prueba.

---

### 📌 ¿Cómo ejecutar las pruebas desde GitHub Actions?

1. Inicia sesión en tu cuenta de **GitHub**.
2. Ve a la pestaña **[Actions](https://github.com/andreasRiveram/serenity-screenplay-qa-automation/actions)** en el menú superior del repositorio.
3. En el panel izquierdo, selecciona el workflow **`Ejecución de Pruebas Automatizadas (Web & API)`**.
4. Haz clic en el menú desplegable **`Run workflow`** (ubicado a la derecha).
5. Selecciona los parámetros deseados:
    * **`cucumber_tag`**: Selecciona `TODOS` para ejecutar toda la suite de pruebas o escoge un tag específico (`@regresion`, `@regresionapi`, `@certi`, etc.).
    * **`environment`**: Especifica el entorno de ejecución (`dev`, `qa`, etc.).
6. Presiona el botón verde **`Run workflow`** para iniciar la ejecución.
7. Una vez completado el Job, desplázate hasta la sección **Artifacts** en la parte inferior del resumen para descargar el reporte visual interactivo de Serenity (`serenity-report`).