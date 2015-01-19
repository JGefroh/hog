# hog
HOG, the Highly Opinionated Generator, is a code generator designed to make work easier for me.

It auto-generates a barebones Java EE backend (REST Endpoint, Manager, DAO Layer, Entity) for a given data model.

PIG, the Practical Interface Generator, is included with HOG and generates a simple AngularJS 1.2 CRUD interface for a given data model. PIG assumes you have uiRouter and uiBootstrap in your project.

* Note that this interface uses directives that are NOT currently included with this project. They can easily be replaced, however.

Work smart, not hard.
 

### Why does this exist?
Instead of spending a lot of time writing a bunch of boilerplate code, I'd rather have it all generated for me so I can get started on implementing business rules. The idea is to generate enough relevant scaffolding and massage the code to suit the specific situation.


### How do I use it?
* Run it as a .jar file. eg. `java -jar hog-v0.0.1.jar` (requires `Java 1.7`)
* Add field names, types, and relationships as if you were creating a domain model object or JPA entity.
* Once you are done, click `Generate with HOG` to create the backend or `Generate with PIG` to create the frontend.
* Copy the generated code in the `generated/` folder into your project.


### Frequently Asked Questions (FAQ)

##### Nothing happens when I click `Generate...`.
Be sure you ran it with administrator rights. Then check the `/generated` folder to see if your files are there.


##### Generate causes errors.
Sorry. Try making sure you don't have any typos in your input and that all fields are filled out. If it doesn't fix it, please submit an issue.


##### Why are there compile errors in the generated code?
The program doesn't do any input checking. If a field name or type is invalid, or a field has a disallowed attribute, the program will still generate it anyways. I recommend hand-fixing any code that is generated and double checking if that is what you wanted.

Some areas also skipped because the program doesn't know what to do - fill these in manually!


##### (HOG) GenericDAO and GenericDAOImpl are missing!
These files are assumed to be included. Later on an option will be added to generate these as well. They are basically simple DAO implementations that use entity manager to provide standard CRUD operations.

##### (PIG) The routes aren't working!
You may need to move the routes to your main route file.

##### (PIG) There are dependencies in the generated code that I don't have!
You can download uiBootstrap and uiRouter and include them in your project. PIG shouldn't be used if you aren't using them. As for the custom directives, you may replace the directives with your own input fields/loading GIFs.


##### Why does the generated code not follow `INSERT BEST PRACTICE HERE`?
The generators were designed for a specific non-ideal development situation. I highly recommend changing things to match your coding needs.


##### Why is this application's source code so weird?
I read about a style where parameter passing was done using strongly typed objects - no primitives of any kind. I tried it out for this project, but practicality won about halfway through. It was kind of weird programming like that and I'm not sure of the benefit of it. I'll have to try again before I form a solid opinion of it.
