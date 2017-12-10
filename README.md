# Cooking Database Manager

This project enables transactions with the database.

## Installation

To install this project you only need to make the good link with the database.
This project does not provide the database itself, which means you still have to generate the database (You do not have to generate the tables: the project will do it for you).

To avoid having trouble as much as possible :
 - the database should be called "cooking" (no capital letters)
 - it should be a postgres database (PGAdmin can help)
 - the user of the database should be called "postgres" (default value)
 - the password for this user should be "password" (no capital letters too, there is no default value for this one. It is a password for developping purposes, that would of course be changed if we actually sold our product, but for us it does not matter whether it is a safe password or not. Besides, this password has to be written in plain text in our "persistence.xml" file, so you don't want it to be a real password anyway in our case)
 - the port used by postgres should be "5432" (default value)
 
If you really want to change any of these, all the team will have to make changes in a way or an other, so just go with these unless you have a very good reason not to.
 
Once your database is created and has the right values, open the project on Netbeans and build it.
Then you should be able to run the project, the installation is finished.

## Generate Tables and populate the Database

After the installation the database is still empty, and the tables haven't been generated yet.
Run the service by clicking on "cooking.cmd" (at the root of the project). If you are running on Mac/Linux you can copy the content of this file on a terminal and run it instead.

To do so you have to run the file "dbFiller.sh" (at the root of the project) with the command ```sh dbFiller.sh``` .

This should be the step where you find out whether the project and the database have been mapped correctly (if this step succeed then there should not be any reason for the REST (haha) not to work).

You can check your database (with pgadmin for example), tables should have been instanciated and they should all contain an object.

Note : if at any moment you messed up with the database, you can delete all the tables and run this "DBFiller.java" class again to get it back to the original values.

## Use the API

You do not need any programmation skill to use the API, it consists in writing HTTP requests.
You can see the list of request in the console when you run the project :


```
INFO  [2017-10-20 07:00:41,587] org.eclipse.jetty.util.log: Logging initialized @2043ms to org.eclipse.jetty.util.log.Slf4jLog
INFO  [2017-10-20 07:00:41,797] io.dropwizard.server.DefaultServerFactory: Registering jersey handler with root path prefix: /
INFO  [2017-10-20 07:00:41,800] io.dropwizard.server.DefaultServerFactory: Registering admin handler with root path prefix: /
INFO  [2017-10-20 07:00:41,806] io.dropwizard.server.DefaultServerFactory: Registering jersey handler with root path prefix: /
INFO  [2017-10-20 07:00:41,806] io.dropwizard.server.DefaultServerFactory: Registering admin handler with root path prefix: /
INFO  [2017-10-20 07:00:41,809] io.dropwizard.server.ServerFactory: Starting CookingApplication
INFO  [2017-10-20 07:00:42,009] org.eclipse.jetty.setuid.SetUIDListener: Opened application@6dcc40f5{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
INFO  [2017-10-20 07:00:42,010] org.eclipse.jetty.setuid.SetUIDListener: Opened admin@2b680207{HTTP/1.1,[http/1.1]}{0.0.0.0:8081}
INFO  [2017-10-20 07:00:42,011] org.eclipse.jetty.server.Server: jetty-9.4.6.v20170531
INFO  [2017-10-20 07:00:42,694] io.dropwizard.jersey.DropwizardResourceConfig: The following paths were found for the configured resources:

    GET     /ingredient/get (com.isep.cooking.resources.IngredientResource)
    POST    /ingredient/get (com.isep.cooking.resources.IngredientResource)
    POST    /ingredient/new (com.isep.cooking.resources.IngredientResource)
    GET     /recipe/get (com.isep.cooking.resources.RecipeResource)
    POST    /recipe/get (com.isep.cooking.resources.RecipeResource)
    POST    /recipe/new (com.isep.cooking.resources.RecipeResource)
    GET     /tool/get (com.isep.cooking.resources.ToolResource)
    POST    /tool/get (com.isep.cooking.resources.ToolResource)
    POST    /tool/new (com.isep.cooking.resources.ToolResource)
    GET     /user/get (com.isep.cooking.resources.CookingUserResource)
    POST    /user/get (com.isep.cooking.resources.CookingUserResource)
    POST    /user/new (com.isep.cooking.resources.CookingUserResource)

INFO  [2017-10-20 07:00:42,697] org.eclipse.jetty.server.handler.ContextHandler: Started i.d.j.MutableServletContextHandler@6b357eb6{/,null,AVAILABLE}
INFO  [2017-10-20 07:00:42,703] io.dropwizard.setup.AdminEnvironment: tasks = 

    POST    /tasks/log-level (io.dropwizard.servlets.tasks.LogConfigurationTask)
    POST    /tasks/gc (io.dropwizard.servlets.tasks.GarbageCollectionTask)

WARN  [2017-10-20 07:00:42,703] io.dropwizard.setup.AdminEnvironment: 
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!    THIS APPLICATION HAS NO HEALTHCHECKS. THIS MEANS YOU WILL NEVER KNOW      !
!     IF IT DIES IN PRODUCTION, WHICH MEANS YOU WILL NEVER KNOW IF YOU'RE      !
!    LETTING YOUR USERS DOWN. YOU SHOULD ADD A HEALTHCHECK FOR EACH OF YOUR    !
!         APPLICATION'S DEPENDENCIES WHICH FULLY (BUT LIGHTLY) TESTS IT.       !
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
INFO  [2017-10-20 07:00:42,710] org.eclipse.jetty.server.handler.ContextHandler: Started i.d.j.MutableServletContextHandler@28279a49{/,null,AVAILABLE}
INFO  [2017-10-20 07:00:42,752] org.eclipse.jetty.server.AbstractConnector: Started application@6dcc40f5{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
INFO  [2017-10-20 07:00:42,755] org.eclipse.jetty.server.AbstractConnector: Started admin@2b680207{HTTP/1.1,[http/1.1]}{0.0.0.0:8081}
INFO  [2017-10-20 07:00:42,755] org.eclipse.jetty.server.Server: Started @3211ms
```

The second section lists the resources of the API : the URL you can call.

### GET Request
Let's take a closer look to the first line.

```GET     /ingredient/get (com.isep.cooking.resources.IngredientResource)```

The first part means you use a "GET" method to call this resource, the second part is the path to get to this resource, and the last one gives you the path in the project where the code for this resource is. All resources are stored in the "com.isep.resources" package.

So in order to call this resource, you have to make a GET request, which URL would be :

```[SERVER ADDRESS]/ingredient/get```

If you start the service yourself, the server address is the address of your computer (the port is the default one : 8080), so if you run the service on your computer, this command should work :

```localhost:8080/ingredient/get```

It returns you : 
```[{"id":"a3b2bfdc-4809-44ac-b463-94fa1eebeb39","name":"pain","usersId":["9882061a-8362-48ff-ad7d-4da15ef9e93d"],"recipesId":["296d78f2-189b-4dba-94bd-e3dbf8c64ce5"]}]```
(with different ids of course)

And if you run the service on your pc and your smartphone is on the same network, you should be able to access the resource with your phone (yes, even if it's an iPhone!!!) by replacing "localhost" by the ip address of your pc, if the ip address of your pc is 123.456.78.9, you can call the resource with the following url :

```123.456.78.9:8080/ingredient/get```

GET requests are really easy to test, because they don't require headers or request bodies, and you can just write them in your web browser.

### POST Request
If you want to test a POST request, you can use Curl, or RESTClient (if you're using firefox) : https://addons.mozilla.org/fr/firefox/addon/restclient/ .
For all the resources using POST, the header "content-type : application/json" is necessary.
The body of the request has to be valid too, for this go in the resource file where the code is written, and check the parameter of the function.

For example, the second resource in the list is :

```POST    /ingredient/get (com.isep.cooking.resources.IngredientResource)```

In the IngredientResource file, we find the POST method which path is "get" :

```
@POST
@Path("get")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public JsonIngredient getIngredientById(String id) {

	UUID uuid = UUID.fromString(id);

	Ingredient ingredient = dao.getIngredientById(uuid);
	JsonIngredient jsonIngredient = new JsonIngredient(ingredient);

	return jsonIngredient;

}
```

As we can see, the parameter for this method is ```String id```.
So the body of the request has to contain a String containing the id of the ingredient we want to retrieve.

Now get back to the first request you made (the GET request). The result we had gave us the id of an ingredient, which is the first field in our case:
```[{"id":"a3b2bfdc-4809-44ac-b463-94fa1eebeb39","name":"pain","usersId":["9882061a-8362-48ff-ad7d-4da15ef9e93d"],"recipesId":["296d78f2-189b-4dba-94bd-e3dbf8c64ce5"]}]```

By sending a POST request with the header ```content-type : Application/Json``` and ```a3b2bfdc-4809-44ac-b463-94fa1eebeb39``` as the body of the request, we should retrieve the whole object once again.
And indeed, the response is:

```{"id":"a3b2bfdc-4809-44ac-b463-94fa1eebeb39","name":"pain","usersId":["9882061a-8362-48ff-ad7d-4da15ef9e93d"],"recipesId":["296d78f2-189b-4dba-94bd-e3dbf8c64ce5"]}```

This request was still pretty simple : it only required a String as the request's body, but in some cases you will need to send a whole object. But it really isn't that hard, if you want to use the third request for example the body of the request would be :

```{"name":"myIngredientName"}```

Just this would be acceptable : every single field is optional (so far).


### Download pictures from the server

The computer that runs this jar becomes a server. Data about users, recipes etc. are stored in a database, but pictures are stored as png files.
Downloading pictures using the rest api is really simple, you first need to add the picture (as a *png* file) in the following directory:

```src/main/resources/pictures/```

Once stored there, the picture can be accessed through a GET request :

```http://localhost:8080/picture/[name_of_the_png_file]```

Note that the name of the file should not contain the extension of it (as all files stored in there are supposed to be .png).
For example the command ```http://localhost:8080/picture/hello_world``` would return you the file ```src/main/resources/pictures/hello_world.png``` (if it exists of course).

In order to reduce calls to database, files stored in this directory shall be named according to the UUID of the object they are representing.
Let a3b2bfdc-4809-44ac-b463-94fa1eebeb39 be the UUID of a recipe "A".
The picture for this recipe should be :

```src/main/resources/pictures/a3b2bfdc-4809-44ac-b463-94fa1eebeb39.png```

This way it is very simple to retrieve the picture for a given object :

```http://localhost:8080/picture/[uuid_of_the_object]```
