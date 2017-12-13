# Cooking Database Manager

This project enables transactions with the database and files from the server.

## Installation

To install this project you only need to make the right link with the database.
This project does not provide the database itself, however it provides you a script that generate the tables and populate the database.

The first thing you have to do is to create a database on the computer you will use as the server of your application.

To avoid having trouble as much as possible :
 - the database should be called "cooking" (no capital letters)
 - it should be a postgres database (PGAdmin can help)
 - the user of the database should be called "postgres" (default value)
 - the password for this user should be "password" (no capital letters too, there is no default value for this one. It is a password for developping purposes, that would of course be changed if we actually sold our product, but for us it does not matter whether it is a safe password or not. Besides, this password has to be written in plain text in our "persistence.xml" file, so you don't want it to be a real password anyway in our case)
 - the port used by postgres should be "5432" (default value)
 
 If for some reason you do not want to use this configuration, you can still try your personnal one and change the configuration file : ```src/main/resources/META-INF/persistence.xml```
  
Once your database is created and has the right values, you can either use the jars and scripts given with the package, or open the project on Netbeans and run it. (it is highly recommended to use the jars since more configuration might be needed for the project to run on netbeans)

To use the jars/scripts, refer to the next part.

## Generate Tables and populate the Database

After the installation the database is still empty, even the tables haven't been generated yet.
Run the service by clicking on "cooking.cmd" (at the root of the project). If you are running on Mac/Linux you can copy the content of this file on a terminal and run it instead. (java has to be installed on your server)

Note that if you use commands from a terminal, you have to use them at the root of the project.

To generate and populate the database, you have to run the file "dbFiller.sh" (at the root of the project) with the command ```sh dbFiller.sh``` .

This should be the step where you find out whether the project and the database have been mapped correctly (if this step succeed then there should not be any reason for the REST (haha) not to work).

You can check your database (with pgadmin for example), tables should have been instanciated and they should all contain at least one object.

Note : if at any moment you messed up with the database, you can delete all the tables and run this "DBFiller.java" class again to get it back to the original values.

## Use the API

You do not need any programmation skill to use the API, it consists in writing HTTP requests.
You can see the list of request in the console when you run the project :


```
INFO  [2017-12-13 13:58:06,452] org.eclipse.jetty.util.log: Logging initialized @1438ms to org.eclipse.jetty.util.log.Slf4jLog
INFO  [2017-12-13 13:58:06,555] io.dropwizard.server.DefaultServerFactory: Registering jersey handler with root path prefix: /
INFO  [2017-12-13 13:58:06,556] io.dropwizard.server.DefaultServerFactory: Registering admin handler with root path prefix: /
INFO  [2017-12-13 13:58:06,572] io.dropwizard.server.DefaultServerFactory: Registering jersey handler with root path prefix: /
INFO  [2017-12-13 13:58:06,572] io.dropwizard.server.DefaultServerFactory: Registering admin handler with root path prefix: /
INFO  [2017-12-13 13:58:06,573] io.dropwizard.server.ServerFactory: Starting CookingApplication
INFO  [2017-12-13 13:58:06,790] org.eclipse.jetty.setuid.SetUIDListener: Opened application@3dd4a6fa{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
INFO  [2017-12-13 13:58:06,791] org.eclipse.jetty.setuid.SetUIDListener: Opened admin@19f7222e{HTTP/1.1,[http/1.1]}{0.0.0.0:8081}
INFO  [2017-12-13 13:58:06,792] org.eclipse.jetty.server.Server: jetty-9.4.z-SNAPSHOT
INFO  [2017-12-13 13:58:07,317] io.dropwizard.jersey.DropwizardResourceConfig: The following paths were found for the configured resources:

    GET     /ingredient/get (com.isep.cooking.resources.IngredientResource)
    POST    /ingredient/get (com.isep.cooking.resources.IngredientResource)
    POST    /ingredient/get/list (com.isep.cooking.resources.IngredientResource)
    POST    /ingredient/new (com.isep.cooking.resources.IngredientResource)
    GET     /picture/{uuid} (com.isep.cooking.resources.PictureResource)
    POST    /recipe/fromUserFridge/checkTools={boolean} (com.isep.cooking.resources.RecipeResource)
    GET     /recipe/get (com.isep.cooking.resources.RecipeResource)
    POST    /recipe/get (com.isep.cooking.resources.RecipeResource)
    POST    /recipe/get/withIngredients (com.isep.cooking.resources.RecipeResource)
    POST    /recipe/new (com.isep.cooking.resources.RecipeResource)
    POST    /tool/byUser (com.isep.cooking.resources.ToolResource)
    GET     /tool/get (com.isep.cooking.resources.ToolResource)
    POST    /tool/get (com.isep.cooking.resources.ToolResource)
    POST    /tool/new (com.isep.cooking.resources.ToolResource)
    POST    /user/authenticate (com.isep.cooking.resources.CookingUserResource)
    GET     /user/get (com.isep.cooking.resources.CookingUserResource)
    POST    /user/get (com.isep.cooking.resources.CookingUserResource)
    POST    /user/new (com.isep.cooking.resources.CookingUserResource)

INFO  [2017-12-13 13:58:07,319] org.eclipse.jetty.server.handler.ContextHandler: Started i.d.j.MutableServletContextHandler@6ea246af{/,null,AVAILABLE}
INFO  [2017-12-13 13:58:07,323] io.dropwizard.setup.AdminEnvironment: tasks =

    POST    /tasks/log-level (io.dropwizard.servlets.tasks.LogConfigurationTask)
    POST    /tasks/gc (io.dropwizard.servlets.tasks.GarbageCollectionTask)

WARN  [2017-12-13 13:58:07,323] io.dropwizard.setup.AdminEnvironment:
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!    THIS APPLICATION HAS NO HEALTHCHECKS. THIS MEANS YOU WILL NEVER KNOW      !
!     IF IT DIES IN PRODUCTION, WHICH MEANS YOU WILL NEVER KNOW IF YOU'RE      !
!    LETTING YOUR USERS DOWN. YOU SHOULD ADD A HEALTHCHECK FOR EACH OF YOUR    !
!         APPLICATION'S DEPENDENCIES WHICH FULLY (BUT LIGHTLY) TESTS IT.       !
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
INFO  [2017-12-13 13:58:07,329] org.eclipse.jetty.server.handler.ContextHandler: Started i.d.j.MutableServletContextHandler@7f7c420c{/,null,AVAILABLE}INFO  [2017-12-13 13:58:07,573] org.eclipse.jetty.server.AbstractConnector: Started application@3dd4a6fa{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
INFO  [2017-12-13 13:58:07,577] org.eclipse.jetty.server.AbstractConnector: Started admin@19f7222e{HTTP/1.1,[http/1.1]}{0.0.0.0:8081}
INFO  [2017-12-13 13:58:07,577] org.eclipse.jetty.server.Server: Started @2563ms
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

```[{"id":"fa70e19e-2bb5-4f65-b1f5-48b80b6b27ba","name":"Spaghettis","usersId":["0734b9bc-0f2f-409a-b333-eef6faad70e8"],"recipesId":["245075ff-8239-4bfc-ab31-23b73f74b664"]},{"id":"f56051a0-eb88-455f-9fac-f02b3ec9f08d","name":"Lardons","usersId":["0734b9bc-0f2f-409a-b333-eef6faad70e8"],"recipesId":["0ef5d416-ad46-4bf9-97ac-6cfa8e0d7fb3","245075ff-8239-4bfc-ab31-23b73f74b664","a297c3b4-4862-4339-80f2-eb8c1191d2c5"]},{"id":"11a90723-21ee-495f-8f31-a0dab784a398","name":"Parmesan râpé","usersId":["0734b9bc-0f2f-409a-b333-eef6faad70e8"],"recipesId":["245075ff-8239-4bfc-ab31-23b73f74b664"]},{"id":"b49fd65b-760c-4d87-875f-20b4fcc76bd6","name":"Crème fraîche","usersId":["0734b9bc-0f2f-409a-b333-eef6faad70e8"],"recipesId":["245075ff-8239-4bfc-ab31-23b73f74b664"]},{"id":"c6d4152d-fb08-4cd5-8a9f-e199ffe4e3ff","name":"Jaune d'oeuf","usersId":["0734b9bc-0f2f-409a-b333-eef6faad70e8"],"recipesId":["245075ff-8239-4bfc-ab31-23b73f74b664"]},{"id":"2baf59f7-b2b8-4121-9bd0-5991dedb3b11","name":"Sel","usersId":["0734b9bc-0f2f-409a-b333-eef6faad70e8"],"recipesId":["0ef5d416-ad46-4bf9-97ac-6cfa8e0d7fb3","245075ff-8239-4bfc-ab31-23b73f74b664"]},{"id":"bc3c6b1d-c90b-45f5-af1b-6cecfe1412d7","name":"Poivre","usersId":["0734b9bc-0f2f-409a-b333-eef6faad70e8"],"recipesId":["245075ff-8239-4bfc-ab31-23b73f74b664"]},{"id":"83af4e81-50e0-49cc-8747-f0e2de74083c","name":"Farine","usersId":["0734b9bc-0f2f-409a-b333-eef6faad70e8"],"recipesId":["0ef5d416-ad46-4bf9-97ac-6cfa8e0d7fb3","6e515929-2b24-4d74-9d77-67ede09960cb","a297c3b4-4862-4339-80f2-eb8c1191d2c5"]},{"id":"0967ab90-5ca6-4ac8-833f-78f215cbc38a","name":"Gruyère râpé","usersId":["0734b9bc-0f2f-409a-b333-eef6faad70e8"],"recipesId":["0ef5d416-ad46-4bf9-97ac-6cfa8e0d7fb3","6456d374-5387-4a6b-bfa5-8d29e94ab660","a297c3b4-4862-4339-80f2-eb8c1191d2c5"]},{"id":"6e21383c-0e83-49b6-987f-192e92dfcc9f","name":"Sachet de levure","usersId":[],"recipesId":["0ef5d416-ad46-4bf9-97ac-6cfa8e0d7fb3","6e515929-2b24-4d74-9d77-67ede09960cb","a297c3b4-4862-4339-80f2-eb8c1191d2c5"]},{"id":"6cc7467d-671b-4459-8438-3cc497a61cc4","name":"Oeuf","usersId":[],"recipesId":["6456d374-5387-4a6b-bfa5-8d29e94ab660","6e515929-2b24-4d74-9d77-67ede09960cb","a297c3b4-4862-4339-80f2-eb8c1191d2c5"]},{"id":"50eb5944-7b90-4ce1-b87d-7885d7103eaf","name":"Moutarde","usersId":[],"recipesId":["a297c3b4-4862-4339-80f2-eb8c1191d2c5"]},{"id":"af9b2175-7151-4132-b1be-5eb23e9d9359","name":"Tablette de chocolat","usersId":[],"recipesId":["6e515929-2b24-4d74-9d77-67ede09960cb"]},{"id":"35f1f992-fb53-4d5d-8d69-acceaa7e258a","name":"Sucre en poudre","usersId":[],"recipesId":["0ef5d416-ad46-4bf9-97ac-6cfa8e0d7fb3","6e515929-2b24-4d74-9d77-67ede09960cb"]},{"id":"40c332cd-6af0-4f27-88e6-7e645d945bc1","name":"Tranche de pain de mie","usersId":[],"recipesId":["6456d374-5387-4a6b-bfa5-8d29e94ab660"]},{"id":"a3a28d8b-7f74-4634-9d77-cf27dacdb843","name":"Tranche de jambon","usersId":[],"recipesId":["6456d374-5387-4a6b-bfa5-8d29e94ab660"]},{"id":"2f070891-7665-4e61-bb7b-75086f2b2fe4","name":"Crème fraiche épaisse","usersId":[],"recipesId":["6456d374-5387-4a6b-bfa5-8d29e94ab660"]},{"id":"3d5a8046-3aa5-4c9a-b1e0-b5ea43402164","name":"Poudre d'amande","usersId":[],"recipesId":["6e515929-2b24-4d74-9d77-67ede09960cb"]},{"id":"2cc6d11a-78da-428a-b1ab-57185ca6c21a","name":"Huile d'olive","usersId":[],"recipesId":["0ef5d416-ad46-4bf9-97ac-6cfa8e0d7fb3"]},{"id":"4f2883cb-9b61-423c-b2bf-f84df1d62bc3","name":"Coulis de tomate","usersId":[],"recipesId":["0ef5d416-ad46-4bf9-97ac-6cfa8e0d7fb3"]},{"id":"805f91fe-77ac-45f8-96c9-7e4cbe4c99ed","name":"Champignons de Paris","usersId":[],"recipesId":["0ef5d416-ad46-4bf9-97ac-6cfa8e0d7fb3"]},{"id":"e166101f-374d-4351-968d-fed8357814f3","name":"beurre","usersId":[],"recipesId":["6e515929-2b24-4d74-9d77-67ede09960cb","a297c3b4-4862-4339-80f2-eb8c1191d2c5"]}]```

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

	Ingredient ingredient = dao.getIngredientById(id);
	JsonIngredient jsonIngredient = new JsonIngredient(ingredient);

	return jsonIngredient;

}
```

As we can see, the parameter for this method is ```String id```.
So the body of the request has to contain a String containing the id of the ingredient we want to retrieve.

Now get back to the first request you made (the GET request). The result we had gave us the id of an ingredient, which is the first field in our case:

```{"id":"fa70e19e-2bb5-4f65-b1f5-48b80b6b27ba","name":"Spaghettis","usersId":["0734b9bc-0f2f-409a-b333-eef6faad70e8"],"recipesId":["245075ff-8239-4bfc-ab31-23b73f74b664"]}```

By sending a POST request with the header ```content-type : Application/Json``` and ```fa70e19e-2bb5-4f65-b1f5-48b80b6b27ba``` as the body of the request, we should retrieve the whole object once again.
And indeed, the response is:

```{"id":"fa70e19e-2bb5-4f65-b1f5-48b80b6b27ba","name":"Spaghettis","usersId":["0734b9bc-0f2f-409a-b333-eef6faad70e8"],"recipesId":["245075ff-8239-4bfc-ab31-23b73f74b664"]}```

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
