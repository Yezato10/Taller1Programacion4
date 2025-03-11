-----------Implementación de Spring en un Proyecto Maven------------

** Explique la diferencia entre @Component y @Configuration en Spring.**

RTA. En Spring Framework, @Component y @Configuration son dos anotaciones empleadas para gestionar y registrar beans en el contexto de la aplicación, pero con funciones 
diferentes:

1. @Component
- Función: es una anotación genérica utilizada para marcar una clase como un bean que debe ser gestionado por Spring. Esta clase es detectada y registrada de manera 
automática por el contenedor de Spring si es escaneada por el paquete adecuado.

-Uso: utilizado principalmente para clases que son componentes simples de servicios o negocio dentro de la aplicación.

- Escaneo: Para que @Component pueda funcionar, se debe configurar Spring para realizar escaneo de clases , ejemplo: hacer uso de @ComponentScan.

2. @Configuration
- Función: es una especialización de @Component, pero se usa de manera específica para clases que contienen definiciones de beans. Una clase que se anota con @Configuration
esta destinada a contener métodos que definan beans haciendo uso de @Bean. 

-Uso: Se utiliza en clases de configuración donde los beans se definen de manera explícita por medio de métodos @Bean. Esta tipo de clase es una opción a los archivos XML 
de la configuración en Spring.

 Otras Características:
- Las clases que se anotan con @Configuration suelen utilizarse para la configuración programática de beans con posibilidad de contener lógica compleja de inicialización.
- De manera interna, hace uso de una técnica llamada CGLIB Proxying que garantiza que los métodos @Bean se ejecuten de manera correcta y puedan devolverse en instacias únicas.

En conclusión: @Configuration es una variante mas explicita de @Component, enfrocada en clases q definen beans de forma explícita, mientras @Component es mas general 
y se emplea en cualquier clase que Spring debe gestionar como bean.

-----------Uso de Repositorios Genéricos en Java.------------

**Explique el principio de inversión de control y cómo se aplica en esta solución.**

El principio de inversión de control (IoC) es un patrón de diseño de software utilizado para desmontar el código y hacer mejoras en su flexibilidad y mantenimiento. 
Este principio establece que, en lugar de que los objetos o clases puedan controlar el flujo de ejecución del programa, el control de este flujo pueda invertirse y se 
delegue a un componente externo o marco (framework) encargado de gestionar la creación y el ciclo de vida de los objetos.

Es un proceso clave en muchos patrones de diseño, como la inyección de dependencias y la inversión de dependencias; es decir, el principio de IoC promueve que el control del
 flujo y las dependencias no las gestione el propio código, sino por un componente externo que pueda encargarse de la creación y asociación de las dependencias.

- ¿Cómo se aplica en una solución?

En una solución, el principio de inversión de control se aplica generalmente haciendo uso de frameworks o contenedores de inversión de control (IoC containers) 
como Spring (en Java), Unity (en .NET), o Angular (en el desarrollo de aplicaciones web). La función de estos frameworks es gestionar las dependencias entre los objetos
 de forma automática.


- Beneficios de la IoC

1. Desacoplamiento:
 Las clases no tienen responsabilidad de crear sus propias dependencias, permitiendo intercambiar o modificar implementaciones sin afectar el código principal.

2.Facilita las pruebas: 
Las dependencias pueden sustituirse por implementaciones simuladas (mocks o stubs), haciendo mas facil las pruebas unitarias.

3.Mejora la mantenibilidad:
 Como el eje central es la creación de dependencias, el código es más fácil de modificar y mantener.

4.Flexibilidad: 
El uso de IoC permite un sistema más flexible, posibilitando cambiar componentes sin necesidad de reescribir o ajustar el código en múltiples sitios.

---------------Configuración de Spring y Lectura de Propiedades desde application.properties-------------------

**Explique cómo funciona la inyección de propiedades en Spring utilizando @Value y qué precedencia tiene cada fuente.**

En Spring Framework, la inyección de propiedades es un mecanismo que permite que los valores de las propiedades (por ejemplo, configuraciones externas
 como archivos de propiedades, variables de entorno, etc.) sean inyectados en las clases de la aplicación. Esto se logra a través de la anotación @Value, que permite
 inyectar valores en campos, métodos o constructores de un bean de Spring.

- ¿Cómo funciona la inyección de propiedades con @Value en Spring?

Cuando se hace uso de la anotación @Value, Spring inyecta un valor determinado en el campo, método o constructor de una clase. Este valor puede provenir de distintas 
fuentes de configuración, como:

- Archivos de propiedades (application.properties o application.yml).
- Variables de entorno.
- Argumentos de línea de comando.
- Propiedades del sistema.

- ¿Cómo maneja Spring la precedencia de las fuentes de propiedades?

Cuando Spring requiere resolver un valor para una propiedad que está siendo inyectada con @Value, tiene la posibilidad de buscar ese valor en varias fuentes. 
La precedencia de estas fuentes va a depender del orden en que Spring las carga y las configura . A continuación, la descripción del orden de precedencia comúnmente utilizado:

1. Propiedades del archivo application.properties o application.yml:
   - Las propiedades que se definen en estos archivos tienen la prioridad más alta dentro del contexto de la aplicación.
   -Estas propiedades pueden definirse en el directorio "src/main/resources" de tu aplicación Spring Boot.

2. Variables de entorno:
   - Si una propiedad no se encuentra en "application.properties" o "application.yml", Spring se encargará de buscar un valor en las "variables de entorno". 
Las variables de entorno pueden tener nombres similares al de la propiedad, y Spring se encarga de realizar una conversión automática de nombres, pasando de "myapp.username"
 a "MYAPP_USERNAME" (convención de mayúsculas y guiones bajos).
   
3. Argumentos de línea de comandos:
   - Al ejecutar la aplicación con parámetros de línea de comando, esos valores tienen una "precedencia más alta" que las propiedades en archivos de configuración
 y las variables de entorno.

4. Propiedades del sistema:
   - Las propiedades definidas en el sistema, por medio de la JVM (por ejemplo, utilizando "-D" en la línea de comandos), poseen una precedencia aún mayor 
que las propiedades definidas en los archivos de configuración y variables de entorno.
   
5.Valores predeterminados:
   - Si ninguna de las fuentes anteriores ofrece un valor, Spring puede hacer uso de un valor predeterminado que puede especificarse directamente 
en la anotación @Value por medio de la sintaxis "${propertyName:defaultValue}".
   

--Orden de precedencia completo--

De mayor a menor precedencia:

1. Propiedades del sistema (`-D` o `System.setProperty()`).
2. Argumentos de línea de comando (`--myapp.username=value`).
3. Variables de entorno (`MYAPP_USERNAME`).
4. Archivos de configuración (`application.properties`, `application.yml`).
5. Valor por defecto especificado en la anotación `@Value` (`@Value("${property:default}")`).






 
