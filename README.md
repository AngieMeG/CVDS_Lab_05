# Laboratorio 5 - MVC Primefaces Introduction - 2021-1
## Escuela Colombiana de Ingeniería
### Introducción a proyectos Web
### Parte I. - Jugando a ser un cliente HTTP1
1. **Abra una terminal Linux o consola de comandos Windows.**
2. **Realice una conexión síncrona TCP/IP a través de *Telnet* al siguiente servidor:**
    * ***Host:*** www.escuelaing.edu.co
    * ***Puerto:*** **80**
    
    **Teniendo en cuenta los parámetros del comando *telnet*: ```telnet HOST PORT```**\
    Para poder utilizarl el comando *telnet* prinero habra que activarlo, pues este viene deshabilitado por defecto. Para esto se ejecutara la consola de comandos de Windows como administrador y se escribira el siguiente comando: \
    ``` dism /online /enable-feature /featurename:telnetclient```
    ![EnabledTelnet](./img/EnableTelnet.PNG)
    \
    Una vez realizado esto ahora si se puede escribir el comando ```telnet www.escuelaing.edu.co 80``` en la consola
    ![Telnet](./img/Telnet.PNG)

3. **Antes de que el servidor cierre la conexión por falta de comunicación:**
    * **Revise la página 36 del *RFC del protocolo HTTP*, sobre cómo realizar una petición *GET*. Con esto, solicite al servidor el recurso *‘sssss/abc.html’*, usando la versión *1.0 de HTTP*.**\
    Para realizar la petición *GET* se utiliza el comando: ```GET sssss/abc.html HTTP/1.0```
    * **Asegúrese de presionar *ENTER* dos veces después de ingresar el comando.**
    * **Revise el resultado obtenido. ¿Qué codigo de error sale?, revise el significado del mismo en *la lista de códigos de estado HTTP*.**\
    El error arrojado es *400 Bad Request*. Lo cual significa que el servidor no puede o no procesara la petición debido a un error aparente de cliente (ej. sintaxis de petición mal formada, tamaño muy grande, framming de mensaje de solicitud invalid, o enrutamiento de solicitud engañosa)  
    ![PeticionGET](./img/PeticionGET.PNG)
    * **¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?**\
    Se tienen 5 grupos:
        * Respuestas informativas (100-199): Esta respuesta significa que el servidor ha recibido los encabezados de la petición, y que el cliente debería proceder a enviar el cuerpo de la misma
        * Respuestas satisfactorias (200 - 299: Esta clase de código de estado indica que la petición fue recibida correctamente, entendida y aceptada. 
        * Redirecciones (300 - 399): Esta clase de código de estado indica que una acción subsecuente necesita efectuarse por el agente de usuario para completar la petición, es decir, el cliente tiene que tomar una acción adicional para completar la petición. 
        * Errores de los clientes (400 - 499):La intención de la clase de códigos de respuesta 4xx es para casos en los cuales el cliente parece haber errado la petición.
        * Errores de los servidores (500 - 599): Indican casos en los cuales el servidor tiene registrado aún antes de servir la solicitud, que está errado o es incapaz de ejecutar la petición. El servidor falló al completar una solicitud aparentemente válida. 
4. **Realice una nueva conexión con telnet, esta vez a:**
    * ***Host:*** www.httpbin.org
    * ***Puerto:*** **80**
    * ***Versión HTTP:*** **1.1**
    
    **Ahora, solicite (*GET*) el recurso */html*. ¿Qué se obtiene como resultado?**\
    Se escribe el comando ```telnet www.httpbin.org 80``` y luego ```GET /html HTTP/1.0```, el resultado optenido es el siguiente *html*:\
    ![PeticionGET2](./img/PeticionGET2.PNG)


**¡Muy bien!, ¡Acaba de usar del protocolo *HTTP* sin un navegador Web!. Cada vez que se usa un navegador, éste se conecta a un servidor *HTTP*, envía peticiones (del protocolo *HTTP*), espera el resultado de las mismas, y -si se trata de contenido HTML- lo interpreta y dibuja.**

5. **Seleccione el contenido *HTML* de la respuesta y copielo al cortapapeles *CTRL-SHIFT-C*. Ejecute el comando *wc* (word count) para contar palabras con la opción *-c* para contar el número de caracteres:**
```wc c```  
**Pegue el contenido del portapapeles con *CTRL-SHIFT-V* y presione *CTRL-D* (fin de archivo de Linux). Si no termina el comando *wc* presione *CTRL-D* de nuevo. No presione mas de dos veces *CTRL-D* indica que se termino la entrada y puede cerrarle la terminal. Debe salir el resultado de la cantidad de caracteres que tiene el contenido *HTML* que respondió el servidor.**\
Se guardo el contenido del HTMl en el archivo de texto *ContarHTML* que se puede encontrar en el repositorio  
![CountWords](./img/CountWords.PNG)  
    **Claro está, las peticiones *GET* son insuficientes en muchos casos. Investigue:**
    * **¿Cuál es la diferencia entre los verbos *GET* y *POST*?** 
        |                          |     GET     |     POST    |
        | ------------------------ | ----------- | ----------- |
        | Visibilidad              | Visible en la barra de direcciones para el usuario| Invisible para el usuario|
        | Marcadores e historiales | Los parámetros URL se guardan junto al URL| Los parámetros URL no se guardan junto al URL|
        | Caché y registro del servidor | Los parámetros URL se guardan sin cifrar.  | Los parámetros URL no se guardan automáticamente |
        | Comportamiento al actualizar el navegador o retroceder | Los parámetros URL no se envían de nuevo | El navegador advierte de que los datos del formulario se enviarán de nuevo  |
        | Tipo de datos     | Solo caracteres ASCII                        | Caracteres ASCII y datos binarios |
        | Longitud de datos | Limitado al máximo del URL (2048 caracteres) | Ilimitado                         |
        
        A modo de resumen la petición:
        * GET se usa para la configuración de páginas web (filtros, ordenación, búsquedas, etc.)
        * POST se usa para la transferencia de información y datos 

    * **¿Qué otros tipos de peticiones existen?**
        * *HEAD:* Pide una respuesta idéntica a la de una petición GET, pero sin el cuerpo de la respuesta.
        * *POST:* Se utiliza para enviar una entidad a un recurso en específico, causando a menudo un cambio en el estado o efectos secundarios en el servidor.
        * *PUT:* Reemplaza todas las representaciones actuales del recurso de destino con la carga útil de la petición.
        * *DELETE:* Borra un recurso en específico.
        * *CONNECT:* Establece un túnel hacia el servidor identificado por el recurso.
        * *OPTIONS:* Es utilizado para describir las opciones de comunicación para el recurso de destino.
        * *TRACE:* Realiza una prueba de bucle de retorno de mensaje a lo largo de la ruta al recurso de destino.
        * *PATCH:* Es utilizado para aplicar modificaciones parciales a un recurso.
6. **En la practica no se utiliza *telnet* para hacer peticiones a sitios web sino el comando *curl* con ayuda de la linea de comandos:**
    ```
    curl www.httpbin.org  
    ```
    ![Curl](./img/Curl.PNG)  
    **Utilice ahora el parámetro *-v* y con el parámetro *-i*:**
    ```
    curl -v www.httpbin.org  
    ```
    ![CurlV](./img/CurlV.PNG)  
    ```
    curl -i www.httpbin.org
    ```
    ![CurlI](./img/CurlI.PNG)  
**¿Cuáles son las diferencias con los diferentes parámetros?**  
* El comando con el parametro ```-v``` se usa para obtener el encabezado de la solicitud y su respuesta
* El comando con el parametro ```-i``` se usa para obtener el encabezado de la dirección remota
### Parte II. - Haciendo una aplicación Web dinámica a bajo nivel.
**En este ejercicio, va a implementar una aplicación Web muy básica, haciendo uso de los elementos de más bajo nivel de *Java-EE* (Enterprise Edition), con el fin de revisar los conceptos del protocolo *HTTP*. En este caso, se trata de un módulo de consulta de clientes Web que hace uso de una librería de acceso a datos disponible en un repositorio *Maven* local.**
1. **Para esto, cree un proyecto *maven* nuevo usando el arquetipo de aplicación Web estándar maven-archetype-webapp y realice lo siguiente:**  
    ```
    mvn archetype:generate -DartifactId=Webapp -DgroupId=edu.eci.cvds -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
    ```
    **Revise la clase *SampleServlet* incluida a continuacion, e identifique qué hace:**
    Los modulos servlet sirven para extender las capacidades de los sevidores web. La clase en particular es un servlet que al resiviruna petcición GET imprimira "Hello *[parameter]*"
    ``` java
    package edu.eci.cvds.servlet;
    import java.io.IOException;
    import java.io.Writer;
    import java.util.Optional;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

    @WebServlet(
        urlPatterns = "/helloServlet"
    )
    public class SampleServlet extends HttpServlet{
        static final long serialVersionUID = 35L;
    
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Writer responseWriter = resp.getWriter();
            Optional<String> optName = Optional.ofNullable(req.getParameter("name"));
            String name = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
            
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write("Hello" + name + "!");
            responseWriter.flush();
       }
    }
    ```
    **Revise qué valor tiene el parámetro *‘urlPatterns’* de la anotación *@WebServlet*, pues este indica qué URLs atiende las peticiones el *servlet*.**

2. **En el *pom.xml*, modifique la propiedad *"packaging"* con el valor *"war"*. Agregue la siguiente dependencia:**
    ``` xml
    <dependency>
         <groupId>javax</groupId>
         <artifactId>javaee-web-api</artifactId>
         <version>7.0</version>
         <scope>provided</scope>
    </dependency>
    ```
    **y agregue la seccion build al final del tag *project* en el archivo *pom.xml*:**
    ``` xml
    <build>
       <plugins>
           <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-compiler-plugin</artifactId>
               <version>3.8.0</version>
               <configuration>
                   <source>1.8</source>
                   <target>1.8</target>
               </configuration>
           </plugin>
           <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-war-plugin</artifactId>
               <version>2.3</version>
               <configuration>
                   <failOnMissingWebXml>false</failOnMissingWebXml>
               </configuration>
           </plugin>
           <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-dependency-plugin</artifactId>
               <version>2.6</version>
               <executions>
                   <execution>
                       <phase>validate</phase>
                       <goals>
                           <goal>copy</goal>
                       </goals>
                       <configuration>
                           <silent>true</silent>
                           <artifactItems>
                               <artifactItem>
                                   <groupId>javax</groupId>
                                   <artifactId>javaee-endorsed-api</artifactId>
                                   <version>7.0</version>
                                   <type>jar</type>
                               </artifactItem>
                           </artifactItems>
                       </configuration>
                   </execution>
               </executions>
           </plugin>
    
           <!-- Tomcat embedded plugin. -->
           <plugin>
               <groupId>org.apache.tomcat.maven</groupId>
               <artifactId>tomcat7-maven-plugin</artifactId>
               <version>2.2</version>
               <configuration>
                   <port>8080</port>
                   <path>/</path>
               </configuration>
           </plugin>
       </plugins>
    </build>
    ```
3. **Revise en el *pom.xml* para qué puerto TCP/IP está configurado el servidor embebido de *Tomcat* (ver sección de plugins).**  
Esta configurado en el puerto *8080*

4. **Compile y ejecute la aplicación en el servidor embebido *Tomcat*, a través de *Maven* con:**
```mvn package```
```mvn tomcat7:run```  
![Tomcat](./img/Tomcat.PNG)  
5. **Abra un navegador, y en la barra de direcciones ponga la *URL* con la cual se le enviarán peticiones al *‘SampleServlet’*. Tenga en cuenta que la *URL* tendrá como host *‘localhost’*, como puerto, el configurado en el *pom.xml* y el path debe ser el del *Servlet*. Debería obtener un mensaje de saludo.**  
![SampleServlet](./img/SampleServlet.png)  

6. **Observe que el *Servlet* *‘SampleServlet’* acepta peticiones *GET*, y opcionalmente, lee el parámetro *‘name’*. Ingrese la misma *URL*, pero ahora agregando un parámetro *GET* (si no sabe como hacerlo, revise la documentación en http://www.w3schools.com/tags/ref_httpmethods.asp).**  
![SampleServlet2](./img/SampleServlet2.png)  

7. **Busque el artefacto *gson* en el repositorio de *maven* y agregue la dependencia.**
    ``` xml
    <!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.8.6</version>
    </dependency>
    ```
8. **En el navegador revise la dirección https://jsonplaceholder.typicode.com/todos/1. Intente cambiando diferentes números al final del *path* de la url.**
    * Id = 1  
    ![Json1](./img/json1.png)  
    * Id = 10  
    ![Json2](./img/json2.png)  
    * Id = 20  
    ![Json3](./img/json3.png)  

9. **Basado en la respuesta que le da el servicio del punto anterior, cree la clase *edu.eci.cvds.servlet.model.Todo* con un constructor vacío y los métodos **getter** y **setter** para las propiedades de los "To Dos" que se encuentran en la url indicada.**

10. **Utilice la siguiente clase para consumir el servicio que se encuentra en la dirección url del punto anterior:**
    ``` java
    package edu.eci.cvds.servlet;
    
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.net.MalformedURLException;
    import java.net.URL;
    import java.net.URLConnection;
    import java.util.List;
    
    import com.google.gson.Gson;
    
    import edu.eci.cvds.servlet.model.Todo;
    
    public class Service {
    
       public static Todo getTodo(int id) throws MalformedURLException, IOException {
           URL urldemo = new URL("https://jsonplaceholder.typicode.com/todos/" + id);
           URLConnection yc = urldemo.openConnection();
           BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
           Gson gson = new Gson();
           Todo todo = gson.fromJson(in, Todo.class);
           in.close();
           return todo;
       }
    
       private static String todoToHTMLRow(Todo todo) {
           return new StringBuilder("<tr>")
               .append("<td>")
               .append(todo.getUserId())
               .append("</td><td>")
               .append(todo.getId())
               .append("</td><td>")
               .append(todo.getTitle())
               .append("</td><td>")
               .append(todo.getCompleted())
               .append("</td>")
               .append("</tr>")
               .toString();
       }
    
       public static String todosToHTMLTable(List<Todo> todoList) {
           StringBuilder stringBuilder = new StringBuilder("<table>")
               .append("<tr>")
               .append("<th>User Id</th>")
               .append("<th>Id</th>")
               .append("<th>Title</th>")
               .append("<th>Completed</th>")
               .append("</tr>");
    
           for (Todo todo : todoList) {
               stringBuilder.append(todoToHTMLRow(todo));
           }
    
           return stringBuilder.append("</table>").toString();
       }
    }
    ```
11. **Cree una clase que herede de la clase *HttpServlet* (similar a *SampleServlet*), y para la misma sobrescriba el método heredado *doGet*. Incluya la anotación *@Override* para verificar –en tiempo de compilación- que efectivamente se esté sobreescribiendo un método de las superclases.**

12. **Para indicar en qué *URL* el servlet interceptará las peticiones *GET*, agregue al método la anotación *@WebServlet*, y en dicha anotación, defina la propiedad *urlPatterns*, indicando la *URL* (que usted defina) a la cual se asociará el *servlet*.**

13. ***Teniendo en cuenta las siguientes métodos disponibles en los objetos *ServletRequest* y *ServletResponse* recibidos por el método *doGet*:**
    * ***response.setStatus(N);* <- Indica con qué código de error N se generará la respuesta. Usar la clase HttpServletResponse para indicar el código de respuesta.**
    * ***request.getParameter(param);* <- Consulta el parámetro recibido, asociado al nombre *‘param’*.**
    * ***response.getWriter()* <- Retorna un objeto PrintWriter a través del cual se le puede enviar la respuesta a quien hizo la petición.**
    * ***response.setContentType(T)* <- Asigna el tipo de contenido (MIME type) que se entregará en la respuesta.**
    
    **Implemente dicho método de manera que:**
    * **Asuma que la petición *HTTP* recibe como parámetro el número de id de una lista de cosas por hacer (todo), y que dicha identificación es un número entero.**
    * **Con el identificador recibido, consulte el item por hacer de la lista de cosas por hacer, usando la clase *"Service"* creada en el punto 10.**
    * **Si el item existe:**
        * **Responder con el código *HTTP* que equivale a ‘OK’ (ver referencia anterior), y como contenido de dicha respuesta, el código html correspondiente a una página con una tabla que tenga los detalles del item, usando la clase *"Service"* creada en el punto 10 par crear la tabla.**
    * **Si el item no existe:**
        * **Responder con el código correspondiente a ‘no encontrado’, y con el código de una página *html* que indique que no existe un item con el identificador dado.**
        * **Si no se paso parámetro opcional, o si el parámetro no contiene un número entero, devolver el código equivalente a *requerimiento inválido*.**
        * **Si se genera la excepcion *MalformedURLException* devolver el código de *error interno en el servidor***
        * **Para cualquier otra excepcion, devolver el código equivalente a *requerimiento inválido*.**

14. **Una vez hecho esto, verifique el funcionamiento de la aplicación, recompile y ejecute la aplicación.**  
Compilación  
![Package2](./img/Package2.png)  
Ejecución  
![Tomcat2](./img/Tomcat2.png)  
15. **Intente hacer diferentes consultas desde un navegador Web para probar las diferentes funcionalidades.**  
    * Parámetro valido  
    ![Valid](./img/Valid.png)  
    * Parámetro no existente  
    ![NotValid](./img/NotValid.png)  
    * Parametro no pasado  
    ![Null](./img/Null.png)  
    * Parámetro con error de formato  
    ![Format](./img/Format.png)  
### Parte III.
1. **En su *servlet*, sobreescriba el método *doPost*, y haga la misma implementación del *doGet*.**

2. **Cree el archivo *index.html* en el directorio *src/main/webapp/index.html* de la siguiente manera:**
    ``` html
        <!DOCTYPE html>
        <html>
            <head>
                <title>Start Page</title>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            </head>
            <body>
                <h1>Hello World!</h1>
            </body>
        </html>
    ```
3. **En la página anterior, cree un formulario que tenga un campo para ingresar un número (si no ha manejado *html* antes, revise *http://www.w3schools.com/html/* ) y un botón. El formulario debe usar como método *‘POST’*, y como acción, la ruta relativa del último servlet creado (es decir la *URL* pero excluyendo *‘http://localhost:8080/’*).**  
![FormServlet1](./img/FormServlet.PNG)
![FormServlet2](./img/FormServlet2.png)  

4. **Revise este ejemplo de validación de formularios con javascript y agruéguelo a su formulario, de manera que -al momento de hacer *‘submit’*- desde el browser se valide que el valor ingresado es un valor numérico.**  
![FormInvalid](./img/FormInvalid.PNG)  

5. **Recompile y ejecute la aplicación. Abra en su navegador en la página del formulario, y rectifique que la página hecha anteriormente sea mostrada. Ingrese los datos y verifique los resultados. Cambie el formulario para que ahora en lugar de *POST*, use el método *GET* . Qué diferencia observa?**  
    * Usando POST  
    ![FormServlet2](./img/FormServlet2.png)  
    * Usando GET  
    ![FormServlet3](./img/FormServlet3.png)
    
    La diferencia es que con POST el URL aparece sin el nombre ni valor del parametro ingresado y con GET esta información si es visible
6. **¿Qué se está viendo? Revise cómo están implementados los métodos de la clase Service.java para entender el funcionamiento interno.**  
El metodo usado por Service crea un html con la información del identificador del usuario, el identificador (el cual tiene como valor lo que se ingresó en el formulario), un texto y si esta completo o no.  
#### Parte IV. - Frameworks Web MVC – Java Server Faces / Prime Faces

**En este ejercicio, usted va a desarrollar una aplicación Web basada en el marco JSF, y en una de sus implementaciones más usadas: *PrimeFaces.***

**Escriba una aplicación web que utilice PrimeFaces para calcular la media, la moda, la desviación estándar y varianza de un conjunto de N números reales. Este conjunto de N números reales deben ser ingresados por el usuario de manera que puedan ser utilizados para los cálculos.**

**Diagrama de casos de uso de la aplicación:**  
 ![CasosUso](./img/CasosUso.PNG)


1. **Al proyecto *Maven*, debe agregarle las dependencias mas recientes de *javax.javaee-api*, *com.sun.faces.jsf-api*, *com.sun.faces.jsf-impl*, *javax.servlet.jstl* y *Primefaces* (en el *archivo pom.xml*).**

2. **Para que configure automáticamente el descriptor de despliegue de la aplicación (archivo *web.xml*), de manera que el framework *JSF* se active al inicio de la aplicación, en el archivo *web.xml* agregue la siguiente configuración:**
    ```
    <servlet>
       <servlet-name>Faces Servlet</servlet-name>
       <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
       <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
       <servlet-name>Faces Servlet</servlet-name>
       <url-pattern>/faces/*</url-pattern>
    </servlet-mapping>
    <welcome-file-list>
       <welcome-file>faces/index.jsp</welcome-file>
    </welcome-file-list>
    ```
3. **Revise cada una de las configuraciones agregadas anteriormente para saber qué hacen y por qué se necesitan. Elimine las que no se necesiten.**  
	Se puede decir que todas son necesarias:
	* <servlet> Se utiliza para especificar un Java servlet y sus parametros, los Servlets no pueden ser llamados directamente por lo que una o mas Servlet tags y Servlet-mappigs deben existir para decirle a Tomcat cuando llamar el Servlet
	* <servlet-mapping> Especifica un URL para el servlet definido con el tag <servlet>
	* <welcome-file-list> Especifica los archivos que seran mostrados cuando no se provee un nombre de archivo en el URL


4. **Ahora, va a crear un Backing-Bean de sesión, el cual, para cada usuario, mantendrá de lado del servidor las siguientes propiedades:**
    1. **El conjunto de datos ingresados por el usuario.**
    2. **Los resultados de las operaciones.**
    3. **La cantidad de números ingresados por el usuario.**
    
    **Para hacer esto, cree una clase que tenga:**
    * **El constructor por defecto (sin parámetros)**
    * **Los métodos get/set necesarios dependiendo si las propiedades son de escritura o lectura**
    * **Coloque las anotaciones:**
        * ***@ManagedBean*, incluyendo el nombre: *@ManagedBean(name = "calculadoraBean")*.**
        * ***@ApplicationScoped.***
        
        **A la implementación de esta clase, agregue los siguientes métodos:**
        * ***calculateMean:* Debe recibir como parámetro el listado de valores y retornar el promedio de los números en ella.**
        * ***calculateStandardDeviation:* Debe recibir como parámetro el listado de valores y retornar el la desviación estandar de los números en ella.**
        * ***calculateVariance:* Debe recibir como parámetro el listado de valores y retornar la varianza de los números en ella.**
        * ***calculateMode:* Debe recibir como parámetro el listado de valores y retornar la moda de los números en ella.**
        * ***restart:* Debe volver a iniciar la aplicación (Borrar el campo de texto para que el usuario agregue los datos).**

5. **Cree una página *XHTML*, de nombre *calculadora.xhtml* (debe quedar en la ruta *src/main/webapp*). Revise en la página 13 del manual de *PrimeFaces*, qué espacios de nombres *XML* requiere una página de PrimeFaces y cuál es la estructura básica de la misma.**

    Son necesarias:

    * xmlns="http://www.w3.org/1999/xhtml"  
    * xmlns:h="http://xmlns.jcp.org/jsf/html"  
    * xmlns:p="http://primefaces.org/ui"  

6. **Con base en lo anterior, agregue un formulario con identificador calculadora_form con el siguiente contenido básico:**
    ``` html
    <h:body>
     <h:form id="calculadora_form">
    
     </h:form>
    </h:body>
    ```

7. **Al formulario, agregue:**
    * **Un elemento de tipo *<p:outputLabel>* para el resultado de la moda, sin embargo, este elemento se debe ocultar. Para ocultarlo, se puede agregar el estilo display: none; al elemento. Una forma de hacerlo es por medio de la propiedad style.**
        * **En una aplicacion real, no se debería tener este elemento, solo se crea con el fin de simplificar una prueba futura.**

    * **Un elemento ```<p:inputText>``` para que el usuario ingrese los números. (Tenga en cuenta que una opción para separar los números es con “;” aunque no necesariamente debe hacerlo así)**
    **Por ejemplo:**
    **2; 3.5; 4.8; 5.1**

    * **Un elemento de tipo ```<p:outputLabel>``` para mostrar cada una de las operaciones resultantes. Y asocie dichos elementos al *BackingBea* de sesión a través de su propiedad *value*, y usando como referencia el nombre asignado: *value="#{calculadoraBean.nombrePropiedad}"***

8. **Al formulario, agregue dos botones de tipo ```<p:commandButton>```, cuatro para enviar la lista de números ingresados y ver el calculo de cada valor, y otro para reiniciar el juego.**
    * **El botón de Calculo de valores debe tener asociado a su propiedad *update* el nombre del formulario en el que se agregaron los campos antes descritos, de manera que al hacer clic, se ejecute un ciclo de *JSF* y se refresque la vista.**
    * **Debe tener también una propiedad *actionListener* con la cual se le indicará que, al hacer clic, se ejecutará el método *CalculateXXX*, creado en el backing-bean de sesión:**
    ``` <p:commandButton update="calculadora_form" actionListener="#{calculadoraBean.calculateXXX}">...```
    * **El botón de reiniciar juego tendrá las mismas propiedades de *update* y *actionListener* del otro con el valor correspondiente:**
    ``` <p:commandButton update="…" actionListener="…"> ```

9. **Para verificar el funcionamiento de la aplicación, agregue el plugin tomcat-runner dentro de los plugins de la fase de construcción (build). Tenga en cuenta que en la configuración del plugin se indica bajo que ruta quedará la aplicación:**
    ```$ mvn package```
    ```$ mvn tomcat7:run```

   **Si no hay errores, la aplicación debería quedar accesible en la URL: http://localhost:8080/faces/calculadora.xhtml**  
  ![Calculadora1](./img/Calculadora1.png)

10. **Si todo funcionó correctamente, realice las siguientes pruebas:**
    * **Abra la aplicación en un explorador. Realice algunas pruebas de aceptación con la aplicación.**

        ![Prueba1](./img/PruebaDeAceptacion1.png)

        ![Prueba3](./img/PruebaDeAceptacion2.png)

    * **Abra la aplicación en dos computadores diferentes. Si no dispone de uno, hágalo en dos navegadores diferentes (por ejemplo Chrome y Firefox; incluso se puede en un único navegador usando una ventana normal y una ventana de incógnito / privada). Haga cinco intentos en uno, y luego un intento en el otro. ¿Qué valor tiene cada uno?** 

        Tienen los mismos valores puesto que el *Backing-beans* esta configurado con *@ApplicationScoped*.
    
        ![Calculadora2](./img/Calculadora2.png)
    
    * **Aborte el proceso de *Tomcat-runner* haciendo *Ctrl+C* en la consola, y modifique el código del *backing-bean* de manera que use la anotación *@SessionScoped* en lugar de *@ApplicationScoped*. Reinicie la aplicación y repita el ejercicio anterior.**
      
    * **Dado la anterior, ¿Cuál es la diferencia entre los *backing-beans* de sesión y los de aplicación?**
        Para el backing-beans con ApplicationScoped los datos se guardaban asi se abrieran dos sesiones diferentes pues solo existe una instacia por aplicacion mientras que en SessionScoped se tiene una instancia de la aplicacion por sesion\
        
    * **Por medio de las herramientas de desarrollador del explorador (Usando la tecla "F12" en la mayoría de exploradores):**
        * **Ubique el código HTML generado por el servidor.**
        
          ![Calculadora3](./img/Calculadora3.png)
        
        * **Busque el elemento oculto, que contiene el número generado aleatoriamente.**
        
        * **En la sección de estilos, deshabilite el estilo que oculta el elemento para que sea visible.**
        
          ![Calculadora4](./img/Calculadora4.png)
        
        * **Observe el cambio en la página, cada vez que se realiza un cambio en el estilo.**
        
        * **Revise qué otros estilos se pueden agregar a los diferentes elementos y qué efecto tienen en la visualización de la página.**
        
          Se puede cambiar:
        
          * La alineacion del texto
        
          * El color
        
          * El background 
        
          * El tamaño de la fuente 
        
          * La fuente Capturas 
        
            ![Calculadora5](./img/Calculadora5.png)
        
        * **Actualice la página. Los cambios de estilos realizados desaparecen, pues se realizaron únicamente en la visualización, la respuesta del servidor sigue siendo la misma, ya que el contenido de los archivos allí almacenados no se ha modificado.**
        
          ![Calculadora6](./img/Calculadora6.png)
    
        * **Revise qué otros cambios se pueden realizar y qué otra información se puede obtener de las herramientas de desarrollador.**
        
          En general se puede modificar todo el apartado visual de la pagina aunque los cambios no se guardaran al solo estar editando sobre la vista
    
11. **Para facilitar los intentos del usuario, se agregará una lista de los últimos valores ingresados:**
     * **Agregue en el *Backing-Bean*, una propiedad que contenga una lista de valores ingresados por el usuario.**
     * **Cuando se reinicie la aplicación, limpie el contenido de la lista.**
     * **Busque cómo agregar una tabla a la página, cuyo contenido sea la lista de listas de números.**



### **DIAGRAMA DE CLASES**

![Diagrama](./img/DiagramClass.png)