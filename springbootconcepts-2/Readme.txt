Topics

1. JPA(JAVA PERSISTENCE API) OR HIBERNATE ORM(OBJECT RELATION MAPPING) TOOL
2. SPRING BEAN
3. IOC (INVERSION OF CONTROL)
4. DEPENDENCY INJECTION

 INVERSION OF CONTROL IOC
------------------------
 When ever you are required to create an object of a class we need not create object manually
 like Person person = new Person(). Instead IOC container will do that for us. This is called
 inversion of control. Meaning instead of we creating the object manually springboot framework
 will create the object on behalf of us this is called inversion of control i.e we are giving
 control for creating object in hands of IOC container.

 roles of IOC container

 a) create an object
 b) store the reference
 c) destroy the object


 DEPENDENCY INJECTION
 ---------------------

 Injection an object into some other object.

 @Autowire annotation is used to inject dependency of one object to some other object.

 BENEFIT OF DEPENDENCY INJECTION
 -------------------------------

 If a class has several dependency the we need not worry about initialising those dependency. SpringBoot will
 take-care of it.

 SPRING BEAN
 -------------

 Bean is simply a java object. It is called bean because it is created and managed by the spring
 not by any user.

 It is simple java object which is initiated and whose reference is stored in memory and reference
 is passed to the object which are dependent on this bean.

 BEAN SCOPE
 -----------

 Singleton scope - only one instance of the object will be created and reference will be passed other objects.
 Prototype scope - a new instance is created on every request.

 DEFINING BEANS
 ----------------

 1. BY CREATING XML FILE  (e.g. bean.xml)  // this kind of initialisation is now obsolete
 2. Annotation
    like
    @RestControllers
    @Service


 HOW SPRINGBOOT WILL SCAN WHENEVER APPLICATION IS LOADED
 --------------------------------------------------------

 1. CLASS PATH SCANNING - SCAN ALL CLASSES IN THE APPLICATION
 2. WHILE SCANNING IT WILL CHECK FOR @Component annotation.
 3. If a class has @Component annotation springboot will create bean
    for that class else no bean will be created for that class.



@Component annotation is inherited by three annotations :

 1. @Controller
 2. @Repository
 3. @Service


@Entity will tell JPA to do ORM


IoC container is a hypothetical term in code it is implement as Application Context.
Application Context can be implemented in many ways like
1. classpath xml application context
2. annotation config application context

A springboot application context has a default application context. But we can create our own
application context if required.


NOTE: Each annotation has @Target annotation as dependency which tells about where the
      annotation can be applied.




