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

        interface ContactRepository extends JpaRepository<Contact,Integer> {

        }        

Assignment

    Develop a spring boot and spring data jpa powered
    console application to ADD/List/DELETE an Employee where
    Employee entity has empId, fullName, dateOfJoining, mailId and salary as fields.


    

