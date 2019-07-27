## Building the project  
  
The project can be built by running:  
 ```bash mvn clean install  ```  
This produces a .jar file.  
  
## Running the project  
  If building of the project completed successfully, the project can be run either from the .jar directly:  
 ```bash java -jar target/atrtask-1.0-SNAPSHOT.jar```  
  
  In order for the project to run sucesfully the jar /resources/mock-partner-service-1.0-all.jar must be running on port 8080. 
  The project is configured to use an in memory H2 database, everything would be lost after restarting it.

### Helpfull settings:  
```properties  
  
 server.port=8081
   
```   
In case you need the data between runs persisted in order to generate larger test cases, it can be achieved with this setting in the application.properties file:
By picking the scond one of the bellow settings, we are redirecting the h2 DB to file.
```properties
 spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1
 spring.datasource.url=jdbc:h2:~/jooq

``` 
  
 ###Endpoints:
 
 * [http://locahost:8081/chart/{isin}](http://locahost:8081/chart/{isin}) HTTP: gets the candlesticks data for the requested instrument
 * [http://locahost:8081/instruments](http://locahost:8081/instruments)  HTTP: gets the list of instruments with the latest price
 * [ws://locahost:8081/topic/hotinstruments](ws://locahost:8081/topic/hotinstruments) WS: broadcasts a message to all subscribers when a instrument becomes hot.
 
  