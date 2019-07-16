# Proyecto de Selección - Riplay Labs (Adaptado para Android)
### (- Levi A. Hurtado -)


### Planteamiento:

Servicio a utilizar:
https://developer.forecast.io/

Requerimientos:
Se desea mostrar en pantalla completa la hora y la temperatura y hora de las siguientes ciudades:

Santiago (CL), Zurich (CH), Auckland (NZ), Sydney (AU), Londres (UK), Georgia (USA)

Las latitudes y longitudes de cada ciudad deben ser guardadas en Redis al momento de iniciar la aplicación.

Cada request de la API deberá ir a Redis, sacar las latitudes y longitudes correspondientes, y hacer las consultas necesarias al servicio de Forecast.io.

Cada request a la API tiene un 10% de chances de fallar, al momento de hacer el request deberá suceder lo siguiente:

if (Math.rand(0, 1) < 0.1) throw new Error('How unfortunate! The API Request Failed')

Esto nos simulara un fallo del 10%~, la aplicacion deberá rehacer el request las veces que sea necesario para tener una respuesta correcta, cada fallo deberá guardarse en Redis dentro de un hash llamado "api.errors", la llave deberá ser el timestamp y el contenido debe ser relevante al error. El handler de error deberá capturar solamente este error y no otro con diferente clase o mensaje.

El frontend deberá actualizarse cada 10 segundos a través de web sockets. El proceso deberá actualizar redis y luego enviar el update al frontend.

El temas el diseño esta 100% en tus manos, nos interesa más la funcionalidad y orden más que cuan bonito se ve. 

# Breve explicación:

+ El desarrollo se llevó a cabo usando el Patrón de Diseño MVC.

+ Para la persistencia de datos se hizo uso de SQLITE.

+ Para el consumo de la API REST se usó la librería OKHTTP.


# Algunos screenshot de la app
 Vistas                    |  Vistas
:-------------------------:|:-------------------------:
![](https://downstagram.com/images/screenshot_1.png)  |  ![](https://downstagram.com/images/screenshot_2.png)

# Demo
[Ver en youtube](https://www.youtube.com/watch?v=Fg1KSrhcOvk)
