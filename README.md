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