# Instalacion

### Requisitos
Para ejecutar la aplicacion se debe tener como minimo instalado:
*	Java 11
*	Gradle 8.4
*	GIT
*	Sistema Operativo compatible

* [Official Gradle documentation](https://docs.gradle.org)


### Paso a paso
Las siguientes son las instrucciones para ejecutar la aplicacion:

* Descargar desde Github: 
* Ejecutar en el directorio de descarga el comando en la consola(CMD:): gradle build 
* En la Carpeta de usuario (c:\users\xxx), crear un archivo con el nombre demoPrueba.mv.db
* Importar el proyecto en eclipse y ejecutar la clase cl.prueba.demo.DemoAppApplication.java
* Documentacion Servicios: http://localhost:8080/v2/api-docs
* Swagger configurado en: http://localhost:8080/swagger-ui/index.html
* Con alguna app o cliente de ApiRest (como postman), agregar las siguientes llamadas:
	1. Guardar  usuario: http://localhost:8080/usuarioRest/guardarUsuario
		como body poner :
		{
			"name": "Juan Rodriguez",
			"email": "juan@rodriguez.org",
			"password": "Geeks@portal20",
			"phones": [
				{
				"number": "1234567",
				"citycode": "1",
				"contrycode": "57"
				}
				]
			}
		
		o ejecutar con Curl: curl --location 'http://localhost:8080/usuarioRest/guardarUsuario' \
									--header 'Content-Type: application/json' \
									--data-raw '{
									"name": "Juan Rodriguez",
									"email": "juan@rodriguez.org",
									"password": "Geeks@portal20",
									"phones": [
									{
									"number": "1234567",
									"citycode": "1",
									"contrycode": "57"
									}
									]
									}'
	2. buscar un usuario por mail:
		curl --location 'http://localhost:8080/usuarioRest/consultarUsuario?email=a%40lla.cl'

Para validar su guarda en la base de datos H2 en memoria, acceder a http://localhost:8080/h2-console
	Usar las credenciales del archivo de application.properties
