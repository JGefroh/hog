# hog
HOG, the Highly Opinionated Generator, is a code generator designed to make work easier for me.

It auto-generates a barebones Java EE backend (REST Endpoint, Manager, DAO Layer, Entity) for a given data model.

 Work smart, not hard.
 
 
### How do I use it?
* Run it as a .jar file. eg. `java -jar hog-v0.0.1.jar` (requires `Java 1.7`)
* Add field names, types, and relationships as if you were creating a domain model object or JPA entity.
* Once you are done, click `generate`.
* Copy the generated code in the `generated/` folder into your project.


### Frequently Asked Questions (FAQ)

##### Nothing happens when I click `generate`.
Be sure you ran it with administrator rights. Then check the `/generated` folder to see if your files are there.


##### Generate causes errors.
Sorry. Try making sure you don't have any typos in your input and that all fields are filled out. If it doesn't fix it, please submit an issue.


##### Why are there compile errors in the generated code?
The program doesn't do any input checking. If a field name or type is invalid, or a field has a disallowed attribute, the program will still generate it anyways. I recommend hand-fixing any code that is generated and double checking if that is what you wanted.

Some areas also skipped because the program doesn't know what to do - fill these in manually!


##### GenericDAO and GenericDAOImpl are missing!
These files are assumed to be included. Later on an option will be added to generate these as well. They are basically simple DAO implementations that use entity manager to provide standard CRUD operations.


##### Why does the generated code not follow `INSERT BEST PRACTICE HERE`?
The generators were designed for a specific non-ideal development situation. I highly recommend changing things to match your coding needs.


##### Why is this application's source code so weird?
I read about a style where parameter passing was done using strongly typed objects - no primitives of any kind. I tried it out for this project, but practicality won about halfway through. It was kind of weird programming like that and I'm not sure of the benefit of it. I'll have to try again before I form a solid opinion of it.
