# THC-HOME
Design and Develop an administrative interface for Texas Hamburger company Texas Hamburger Company -
THC - Home. The administrative function should allow the users to add, list, search, update and delete 
locations, menus, reservations, and open hours. Use all the concepts you’ve learned as part of the program 
into your design and coding. Build it as a spring boot application using Mongo and any RDBMS DB.
Key Requirements
• Use industry standard naming convention for REST URI
• Add pagination to your GET services, introduce status filters for location/Menu
• Exception handling & Logging with log4j2 (Defensive logging with appropriate details)
• Use Lombok for getter/setter
• Spring Security - Basic Auth (username, password) => Postgres DB /any RDBMS
• Capture the Hamburger APIs execution time through interceptor and store it in postgresDB /any RDBMS
• REST API to GET execution time of Hamburger APIs from postgresDB/any RDBMS (Filter by name, date)
• The API should allow for historical data collection. At the end of each day, all locations submit a 
collection of all orders received during the day. Save the order info into the database and use Kafka to
stream the data.
• Create a Docker compose file (SpringBoot App, Mongo & RDBMS).
• Deploy the Docker containers on a local instance via Jenkins and access the API via a public 
• Include Unit and Integration test cases.
• API documentation with Swagger
Optional Features to Explore 
Want to show that you can do more than the minimum requirments? FANTASTIC! See if you can implement 
any of the following set your work apart. 
• Open API3
• Lombok
• MDC/Thread Context for distributed logging (See links for Reference)
o https://logging.apache.org/log4j/2.x/manual/thread-context.html
o https://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/MDC.html
o https://www.baeldung.com/mdc-in-log4j-2-logback
Do you have other ideas? We love insatiably curious learners who bring fresh new ideas…show us what you 
can do!!
Make your Project Next Level
Feel like you have mastered the basics requirements? Have you completed them with more time to submit? 
Consider learning and implementing any of the following to establish your work as next level. 
• Implement Spring Security to configure OAUTH2 for your API.Egen, Inc. • 40 Shuman Blvd. Suite 302, Naperville, IL, 60563 • https://egen.solutions
• Introduce Reactive Programming with Spring 5.
• Build a reactive web application leveraging Spring Boot, Kotlin, and Coroutines
