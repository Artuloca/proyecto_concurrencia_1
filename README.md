# proyecto_concurrencia_1
//en configuracionAsincrona sobra un metodo
//comentar la limpieza del bootify
//el paquete controller no se si sobra
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
