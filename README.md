Spring Boot
-------------------------------------------------------------------

    Objective
        1. Spring Boot
        2. Profiling
        3. Testing
        4. Rest Api

    Pre - Requisits

        1. Spring IoC / DI
        2. Spring Expression Language and ApplicationContext
        3. Autowiring and External Value Injection
        4. Spring Data / Spring Data JPA

    Lab Setup

        1. STS latest IDE
        2. JDK 1.8
        3. Maven
        4. Spring Boot 2.x
        5. MySQL (or other RDBMS) / H2DB

    Introduction

        Spring Boot is one of the module of spring framework that offers
        RAD as its primary feature.

        Rapid Application Development - through auto-config.

        For each spring module a new '-stater-' module is created.
        This '-starter-' is a conjuction of the module dependencies and default configs.

        Spring Boot supported embeded servers. To support containarization.

        @SpringBootApplication  =   @Configuaration
                                    @ComponentScan
                                    @PropertySource
                                    @AutoConfig
        
        SpringApplication.run(ConfigClass.class,commandLineArgs);

            ApplicationContext is created (Container is created)
                CommandLineRunner and ApplicationRunner are invoked (if any)
                Server gets started (if any)
                The mainExecutor is held until the server shuts donw (if any)
            Container is closed and destroyed.

        Creating a Spring Boot Application

            Using 'Spring Starter Project' option from STS.
            Using SpringInitilizr at 'http://start/spring.io'.
            Using Spring Boot CLI

Spring Data

    is a spring framework module that offer dynamically implemented repositories.

    Spring Data JPA

        is a sub-module of Spring Data that provide implemnentations based on JPA.

        CrudRepository
            |- JpaRespository<E,primaryKeyType>
                    |- List<E> findAll()
                    |- Optional<E> findById(primaryKey)
                    |- boolean existsById(primaryKey)
                    |- E save(entity)
                    |- void deleteById(primaryKey)

        @Entity
        @Table(name="contacts")
        public class Contact {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Integer contactId;
            private String fullName;
            private String mobileNumber;
            private String meilId;
            private LocalDate dateOfBith;

            //.........
        }

        interface ContactRepository extends JpaRepository<Contact,Integer> {

            boolean existsByMobileNumber(String mobileNumber);
            Optional<Contact> findByMobileNumber(String mobileNumber);
            List<Contact> findAllByFullName(String fullName);
            void deleteByMobileNumber(String mobileNumber);

            @Query("SELECT c FROM Contact c WHERE c.dateOfBirth BETWEEN :start AND :end")
            List<Contact> getAllBornIn(LocalDate start,LocalDate end);
        }        

Assignment

    Develop a spring boot and spring data jpa powered
    console application to ADD/List/DELETE an Employee where
    Employee entity has empId, fullName, dateOfJoining, mailId and salary as fields.

Spring Web

    Spring Web is a Spring Framwork Module that helps in developing Dynamiv Web Applications based on MVC archetecture
    and for developing Rest API as well.

    MVC archetecture

         Repos  <--entities--> Services <---models--> Controllers <------------ Request 
                                                            |
                                                            | model
                                                            |
                                                            ↓
                                                            Views ----------------> Responses

            Servlets are used as Controllers
            JSP/ JFC/ ThymeLeaf are used as Views.

    MVC FrontController archetecture
    
         Repos  <--entities--> Services <---models--> Controllers <---model--- FronController <------------ Request 
                                                            |
                                                            | model
                                                            |
                                                            ↓
                                                            Views ----------------------------------------> Responses

        FrontController     DispatcherServlet
        Comntroller         is any POJO, that has actions mapped to specific urls
        JSP/ JFC/ ThymeLeaf are used as Views.


    REST api

        REpreentational State Transfer - REST

            is a modern model of Web Services where instaed of SOAP protocol, http protocol itself is used to publish
            and consume web services.

                                                            <----------->   UIForDesktop
                    DataBase    <----------->  WebServices  <----------->   UIForAndirodMobile
                                                            <----------->   UIForIOSMobile


            REST api is web services hosted on http protocol deriving the advantage of 
                standard exchange system
                support for a large variety of media (inclduing JSON and XML)

        REST api standards (taking the advantage of http protocol)

            In Rest Api a single endPoint (URL) is enough to manage all CRUD operations, thanks to the HttpMethod system in http protocol

            /emps   is the endPoint if Employee is a resource assumed,

                                http                                                        Success     Failure             Failure
        Operations             Method   endPoint        reqBody         respBody            Status      Status @ Client     Status @ Serv
        ----------------------------------------------------------------------------------------------------------------------------------
        Create                  POST    /emps           emp(json/xml)   emp (json/xml)      CREATED-201     400-BAD REQ         500-I S E
        Retrive A Record        GET     /emps/{empID}   NONE            emp (json/xml)      OK-200          404-Not Found       500-I S E
        Retrive All Records     GET     /emps           NONE            emp[] (json/xml)    OK-200          404-Not Found       500-I S E
        Update                  PUT     /emps           emp(json/xml)   emp (json/xml)      ACCEPTED-202    400-BAD REQ         500-I S E
                                PATCH   /emps           emp(json/xml)   emp (json/xml)      ACCEPTED-202    400-BAD REQ         500-I S E
        Delete                  DELETE  /emps/{empID}   NONE            NONE                No CONTENT-204  404-Not Found       500-I S E

        Http Status Code System

            1xx         signal indicating that the requet is received and is being processed.
            2xx         singal indicating that a request is successfully proccessed and a resposne is sent.
            3xx         signal redirections
            4xx         signal errors due to client side issues
            5xx         signal errors due to server side issues
    
        Spring Web Rest Api

            @RestController     =   @Controller
                                    @ResponseBody
            
            @RequestMapping()
                |- @GetMapping("endPoint")
                |- @PutMapping("endPoint")
                |- @PostMapping("endPoint")
                |- @DeleteMapping("endPoint")

            @RequestBody
            @Consumes
            @Produces
            @Valid

            @RestControllerAdvice

            @ExceptionHandler


            


