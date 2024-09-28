# proyecto_concurrencia_1
//en configuracionAsincrona sobra un metodo
//comentar la limpieza del bootify
//sobran muchos imports q no se usan pa na
https://github.com/Artuloca/proyecto_concurrencia_1.git

este ejercicio está compuesto por diferentes paquetes, dentro del paquete de bootify, estos son: Asincrono, Config, ControlAcceso,Controller,Domain,Evrntos,Menu,Respos,Reset,Sensores,Servicio,Util,Visual

PAQUETE ASINCRONO:
está compuesto por una unica clase, la cual se llama ConfiguracionAsincrona, usa @Component,@EnableAsync y @Async. contiene un objeto de cada sensor y uno de la pantalla principal,los cuales se inyectan en el constructor y 3 metodos que se encargan de realizar la comprobacion de cada campo del evento, tambien tienen un print donde se ve que cada uno está siendo usado por un hilo diferente, esta comprobacion se realiza de forma concurrente entre los 3

PAQUETE CONFIG
está compuesto por 3 clases, ControllerConfig,DomainConfig,LocalDevConfig
ControllerCOnfig: usa @ControllerAdvice, se encarga de que si llega alguna de texto vacia la convierte a null antes de vincularlo a nada
DomainConfig: usa @Configuration, @EntityScan,@EnableJpaRepositories y @EnableTransactionManagment, esta compuesta por un constructor vacio, se encarga de crear las entidades y repositorios,con los atributos y relaciones que se crean en la base de datos.
LocalDevConfig: usa @Configuration,@SneakyThrows y @Profile, está formada por un unico metodo el cual se encarga de configurar las plantillas del Thymeleaf y asi evitar tener que cargarlas desde el classpath

PAQUETE CONTROLACCESO
esta formado por una unica clase, AuthenticationService, la cual usa @Service y @Autowired, tiene un objeto de tipo UsuarioRepository, y un metodo el cual se encarga de comprobar el usuario y contraseña introducido y buscarlo en la base de datos, muestra si ambos campos son correctos o si alguno no lo es

PAQUETE CONTROLLER
esta formado por dos clases, HomeController y HtmxErrorController
HomeController usa @Controller y @GetMapping, tiene un metodo index que se encarga de llevar al index
HtmxErrorController usa @Controller,@RequestMapping, @ResponseStatus, se encarga de manejar los errores para las solicitudes htmx y asegurar que siempre se devuelva un estado HTTP 200, para que el HTML se intercambie correctamente en el cliente

PAQUETE DOMAIN
USA @Entity,@Getter,@Setter,@Id,@GeneratedValue,@(eltipo de relacion que se vaya a usar),@JoinColumn,@Column, tambien hace uso del patronde diseño strategy,contiene las entidades que se utilizan en nuestra base de datos con sus respectivos atributos, estas clases son: Acceso,AccesoSensor,Databases,Evento,EventoAcceso,EventoMovimiento,EventoTemperatura,ExecutorService,Movimiento,MovimientoSensor,Sensor,SpringSecurity,Temperatura,TemperaturaSensor y Usuario

PAQUETE EVENTOS
esta compuesto por una unica clase llamada GeneradorEventos, usa @Component, tiene objetos de tipo MovimientoRepository, TemperaturaRepository,AccesoRepository, un random,ScheduledExecutorService y SensorService, los cuales se inyectan en el constructor, menos el random
Contiene un metodo para generar los eventos y añadir cada valor a su respectiva tabla, tambien SensorService ejecuta su metodo de comprobacion de los datos

PAQUETE MENU
esta formado por una unica clase llamada PantallaPrincipal, la cual usa @Component y @Async, se encarga de mostrar la parte visual, con los campos de usuario y contraseña, se ejecuta de forma concurrente a la creacion de los eventos

PAQUETE REPOS
cada entidad tiene asociado un repositorio para que se puedan realizar operaciones sobre ellos, en este caso tenemos los repositorios AccesoRepository,AccesoSensorRepository,DatabaseRepository, EventoAccesoRepository,EventoMovimientoRepository,EventoRepository,EventoTemperaturaRepository,ExecutorServiceRepository,Movimientorepository,MovimientoSensorRepository,SensorRepository,SpringSecurityRepository,TemperaturaRepository,TemperaturaSensorRepository y UsuarioRepository, todas extienden de JpaRepository junto con que entidad está asociado

PAQUETE RESET
esta compuesto por una unica clase la cual se llama DatabaseCleanUpService usa @Service, tiene un unico metodo el cual se encarga de borrar los datos de los eventos y los usuarios (menos el admin) cuando se deja de compilar el programa

PAQUETE SENSORES
esta compuesto por 3 clases, SensorAcceso,SensorMovimiento,SensorTemperatura
SensorAcceso:está compuesto por @Component, tiene un metodo que recibe un booleano y dependiendo del valor activa o no el sensor
SensorMovimiento:está compuesto por @Component, tiene un metodo que recibe un booleano y dependiendo del valor activa o no el sensor
SensorTemperatura:está compuesto por @Component, tiene un metodo que recibe un entero y dependiendo del valor activa o no el sensor

PAQUETE SERVICIO
esta compuesto por una unica clase llamada SensorService, la cual usa @Component, tiene un objeto de tipo configuracionAsincrona el cual inyecta en el constructor, se encarga de imprimir por pantalla los resultados de cada evento

PAQUETE UTIL
esta compuesto por 2 clases, WebAdvice y WebUtils
WebAdvice hace uso de @ControllerAdvice y @ModelAttribute, se encarga de asignar un valor general a los controladores  
WebUtils hace uso de @Component, se encarga de proporcionar diferentes funciones a Spring

PAQUETE VISUAL
esta compuesto por 3 clases las cuales son MenuAdmin,MenuUsuario y PantallaMenu
MenuAdmin hace uso de @Controller,@Autowired,@RequestParam, @GetMapping y @Postmapping, se encarga de mostrar el menu del admin, un boton de crear usuario, tambien comprueba si ese usuario esta ya o no creado y si el nombre es distinto que el del adim, al crear al usuario te lleva de vuelva a la pantalla del admin, tambien hay un boton de borrar usuario que comprueba si el usuario se encuentra en la base de datos y si su nombre es diferente que el de admin, ya que al admin no se puede borrar, tambien al borrar al usuario te lleva de vuelva al menu del admin, tambien hay un boton para mostrar la tabla de los usuarios (TODO),tambien hay un boton para ver la tabla de los eventos criticos solo(TODO), tambien hay una tabla para ver la tabla de todos los eventos, tambien hay un boton para filtrar los eventos criticos (TODO) y finalmente hay un boton para salir, el cual te lleva al menu principal y borra los campos de usuario y contraseña en la pantallaMenu
MenuUsuario: es igual que MenuAdmin pero no tiene la posibilidad de crear ni borrar usuarios
PantallaMenu: hace uso de @Controller,@Autowired, @GetMapping y @Postmapping, se encarga de mostrar los campos de usuario y contraseña y depenediendo de los datos introducidos te redirige a un menu u a otro, tambien comprueba que los parametros sean correctos, si no se encuentra ningun usuario/admin con la contraseña asociada no te lleva a ningun menu y te deja en el principal

Clase MyAppApplication, se encuentra en el paquete de bootify, hace uso de @SpringBootApplication,Autowired,@Bean,@Configuration,@PreDestroy. tiene un metodo para iniciar el navegador, tiene otro metodo para que al cerrar el programa se vacie la base de datos,tiene un metodo para que en el navegador se muestra el menu principal y finalmente tiene una clase AsynConfig para inicializar hilos separados


directorio resources
dentro de la carpeta templates se encuentra:
add_user.html->pide un nombre,una contraseña y tiene un boton de añadir
admin_menu.html-> muestra los botones de añadir,eliminar,ver todas las diferences tablas y el boton de salir
user_menu-> muestra ver todas las diferences tablas y el boton de salir
menu.html->pide un nombre,una contraseña y tiene un boton de ingresar
delete_user.html-> pide un nombre y un boton de borrar


carpeta test
contiene una clase SensorServiceTest para comprobar que se esta ejecutando todo de forma asincrona
