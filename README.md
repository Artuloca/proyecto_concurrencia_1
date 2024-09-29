Arturo lopez, Hugo Sanchez,jose daniel martin, fernando santamaria
https://github.com/Artuloca/proyecto_concurrencia_1.git
# proyecto_concurrencia_1
[Link al repositorio](https://github.com/Artuloca/proyecto_concurrencia_1.git)

A partir de la rama "Enlazar-Menu" la base de datos ya no se vacía cuando ejecutas el programa pero funciona adecuadamente, mostrandose los eventos detectados en su respectivo menú de foma visual.

Este ejercicio está compuesto por diferentes paquetes, dentro del paquete de bootify, estos son: Asincrono, Config, ControlAcceso,Controller,Domain,Evrntos,Menu,Respos,Reset,Sensores,Servicio,Util,Visual

## PAQUETE ASINCRONO
Está compuesto por una única clase, la cual se llama ConfiguracionAsincrona, usa @Component,@EnableAsync y @Async. Contiene un objeto de cada sensor y uno de la pantalla principal, los cuales se inyectan en el constructor y 3 métodos que se encargan de realizar la comprobación de cada campo del evento, también tienen un print donde se ve que cada uno está siendo usado por un hilo diferente, esta comprobación se realiza de forma concurrente entre los 3.

## PAQUETE CONFIG
Está compuesto por 3 clases, ControllerConfig,DomainConfig,LocalDevConfig.

- ControllerConfig: usa @ControllerAdvice, se encarga de que si llega alguna de texto vacía la convierte a null antes de vincularlo a nada.
- DomainConfig: usa @Configuration, @EntityScan,@EnableJpaRepositories y @EnableTransactionManagement, está compuesta por un constructor vacío, se encarga de crear las entidades y repositorios, con los atributos y relaciones que se crean en la base de datos.
- LocalDevConfig: usa @Configuration,@SneakyThrows y @Profile, está formada por un único método el cual se encarga de configurar las plantillas del Thymeleaf y así evitar tener que cargarlas desde el classpath.

## PAQUETE CONTROLACCESO
Está formado por una única clase, AuthenticationService, la cual usa @Service y @Autowired, tiene un objeto de tipo UsuarioRepository, y un método el cual se encarga de comprobar el usuario y contraseña introducido y buscarlo en la base de datos, muestra si ambos campos son correctos o si alguno no lo es.

## PAQUETE CONTROLLER
Está formado por dos clases, HomeController y HtmxErrorController.

- HomeController usa @Controller y @GetMapping, tiene un método index que se encarga de llevar al index.
- HtmxErrorController usa @Controller,@RequestMapping, @ResponseStatus, se encarga de manejar los errores para las solicitudes htmx y asegurar que siempre se devuelva un estado HTTP 200, para que el HTML se intercambie correctamente en el cliente.

## PAQUETE DOMAIN
Usa @Entity,@Getter,@Setter,@Id,@GeneratedValue,@(el tipo de relación que se vaya a usar),@JoinColumn,@Column, también hace uso del patrón de diseño strategy, contiene las entidades que se utilizan en nuestra base de datos con sus respectivos atributos, estas clases son: Acceso,AccesoSensor,Databases,Evento,EventoAcceso,EventoMovimiento,EventoTemperatura,ExecutorService,Movimiento,MovimientoSensor,Sensor,SpringSecurity,Temperatura,TemperaturaSensor y Usuario.

## PAQUETE EVENTOS
Está compuesto por una única clase llamada GeneradorEventos, usa @Component, tiene objetos de tipo MovimientoRepository, TemperaturaRepository,AccesoRepository, un random,ScheduledExecutorService y SensorService, los cuales se inyectan en el constructor, menos el random. Contiene un método para generar los eventos y añadir cada valor a su respectiva tabla, también SensorService ejecuta su método de comprobación de los datos.

## PAQUETE MENU
Está formado por una única clase llamada PantallaPrincipal, la cual usa @Component y @Async, se encarga de mostrar la parte visual, con los campos de usuario y contraseña, se ejecuta de forma concurrente a la creación de los eventos.

## PAQUETE REPOS
Cada entidad tiene asociado un repositorio para que se puedan realizar operaciones sobre ellos, en este caso tenemos los repositorios AccesoRepository,AccesoSensorRepository,DatabaseRepository, EventoAccesoRepository,EventoMovimientoRepository,EventoRepository,EventoTemperaturaRepository,ExecutorServiceRepository,Movimientorepository,MovimientoSensorRepository,SensorRepository,SpringSecurityRepository,TemperaturaRepository,TemperaturaSensorRepository y UsuarioRepository, todas extienden de JpaRepository junto con que entidad está asociado.

## PAQUETE RESET
Está compuesto por una única clase la cual se llama DatabaseCleanUpService usa @Service, tiene un único método el cual se encarga de borrar los datos de los eventos y los usuarios (menos el admin) cuando se deja de compilar el programa.

##PAQUETE REST
-EventControler: Controlador REST que maneja solicitudes HTTP GET para obtener listas de diferentes tipos de eventos (movimientos, temperaturas y accesos).
-UserControler: Controlador REST que maneja solicitudes HTTP GET para obtener una lista de usuarios.

## PAQUETE SENSORES
Está compuesto por 3 clases, SensorAcceso,SensorMovimiento,SensorTemperatura.

- SensorAcceso: está compuesto por @Component, tiene un método que recibe un booleano y dependiendo del valor activa o no el sensor.
- SensorMovimiento: está compuesto por @Component, tiene un método que recibe un booleano y dependiendo del valor activa o no el sensor.
- SensorTemperatura: está compuesto por @Component, tiene un método que recibe un entero y dependiendo del valor activa o no el sensor.

## PAQUETE SERVICIO
Está compuesto por una única clase llamada SensorService, la cual usa @Component, tiene un objeto de tipo configuracionAsincrona el cual inyecta en el constructor, se encarga de imprimir por pantalla los resultados de cada evento.

## PAQUETE UTIL
Está compuesto por 2 clases, WebAdvice y WebUtils.

- WebAdvice hace uso de @ControllerAdvice y @ModelAttribute, se encarga de asignar un valor general a los controladores.
- WebUtils hace uso de @Component, se encarga de proporcionar diferentes funciones a Spring.

## PAQUETE VISUAL
Está compuesto por 3 clases las cuales son MenuAdmin,MenuUsuario y PantallaMenu.

- MenuAdmin hace uso de @Controller,@Autowired,@RequestParam, @GetMapping y @Postmapping, se encarga de mostrar el menú del admin, un botón de crear usuario, también comprueba si ese usuario está ya o no creado y si el nombre es distinto que el del admin, al crear al usuario te lleva de vuelta a la pantalla del admin, también hay un botón de borrar usuario que comprueba si el usuario se encuentra en la base de datos y si su nombre es diferente que el de admin, ya que al admin no se puede borrar, también al borrar al usuario te lleva de vuelta al menú del admin, también hay un botón para mostrar la tabla de los usuarios (TODO), también hay un botón para ver la tabla de los eventos críticos solo(TODO), también hay una tabla para ver la tabla de todos los eventos, también hay un botón para filtrar los eventos críticos (TODO) y finalmente hay un botón para salir, el cual te lleva al menú principal y borra los campos de usuario y contraseña en la pantallaMenu.
- MenuUsuario: es igual que MenuAdmin pero no tiene la posibilidad de crear ni borrar usuarios.
- PantallaMenu: hace uso de @Controller,@Autowired, @GetMapping y @Postmapping, se encarga de mostrar los campos de usuario y contraseña y dependiendo de los datos introducidos te redirige a un menú u a otro, también comprueba que los parámetros sean correctos, si no se encuentra ningún usuario/admin con la contraseña asociada no te lleva a ningún menú y te deja en el principal.

Clase MyAppApplication, se encuentra en el paquete de bootify, hace uso de @SpringBootApplication,Autowired,@Bean,@Configuration,@PreDestroy. Tiene un método para iniciar el navegador, tiene otro método para que al cerrar el programa se vacíe la base de datos, tiene un método para que en el navegador se muestra el menú principal y finalmente tiene una clase AsynConfig para inicializar hilos separados.

## Directorio resources
Dentro de la carpeta templates se encuentra:

- add_user.html: pide un nombre, una contraseña y tiene un botón de añadir.
- admin_menu.html: muestra los botones de añadir, eliminar, ver todas las diferencias tablas y el botón de salir.
- user_menu: muestra ver todas las diferencias tablas y el botón de salir.
- menu.html: pide un nombre, una contraseña y tiene un botón de ingresar.
- delete_user.html: pide un nombre y un botón de borrar.
- view_event_database_user.html: Página HTML que muestra la base de datos de eventos para los usuarios, actualizándose automáticamente cada 5 segundos.
- view_event_database_admin.html:  Página HTML que muestra la base de datos de eventos para los administradores, actualizándose automáticamente cada 5 segundos.
- view_user_database_admin.html: Página HTML que muestra la base de datos de usuarios para los administradores, actualizándose automáticamente cada 5 segundos.
- view_user_database_user.html: Página HTML que muestra la base de datos de usuarios para los usuarios, actualizándose automáticamente cada 5 segundos.

## Carpeta test
Contiene una clase SensorServiceTest para comprobar que se está ejecutando todo de forma asíncrona.
