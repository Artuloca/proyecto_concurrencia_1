# proyecto_concurrencia_1
//en configuracionAsincrona sobra un metodo
//comentar la limpieza del bootify
https://github.com/Artuloca/proyecto_concurrencia_1.git

este ejercicio está compuesto por diferentes paquetes, dentro del paquete de bootify, estos son: Asincrono, Config, ControlAcceso,Controller,Domain,Evrntos,Menu,Respos,Reset,Sensores,Servicio,Util,Visual

PAQUETE ASINCRONO:
está compuesto por una unica clase, la cual se llama ConfiguracionAsincrona, usa @Component,@EnableAsync y @Async. contiene un objeto de cada sensor y uno de la pantalla principal,los cuales se inyectan en el constructor y 3 metodos que se encargan de realizar la comprobacion de cada campo del evento, tambien tienen un print donde se ve que cada uno está siendo usado por un hilo diferente, esta comprobacion se realiza de forma concurrente entre los 3

PAQUETE CONFIG
está compuesto por 3 clases, ControllerConfig,DomainConfig,LocalDevConfig
ControllerCOnfig: usa @ControllerAdvice, se encarga de que si llega alguna de texto vacia la convierte a null antes de vincularlo a nada
DomainConfig: usa @Configuration, @EntityScan,@EnableJpaRepositories y @EnableTransactionManagment, esta compuesta por un constructor vacio, se encarga de crear las entidades y repositorios,con los atributos y relaciones que se crean en la base de datos.
LocalDevConfig: usa @Configuration,@SneakyThrows y @Profile, está formada por un unico metodo el cual se encarga de configurar las plantillas del Thymeleaf y asi evitar tener que cargarlas desde el classpath
