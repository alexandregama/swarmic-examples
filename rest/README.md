# Rest Example

This example show how to build a JAX-RS service using Undertow and RESTEasy fragments





## Running from maven

You can run the example with

`mvn clean package exec:exec`

You can then test the Rest service with url (with curl or your browser)

`http://localhost:8080/hello/swarmic`

Answer should be `Hello : swarmic`

## Building and running from fat jar

You can create a fat jar containing all resources to run this example just enter the following command:

`mvn clean package -Pjar`

Then you can launch the service with:

`java -jar ./target/swarmic.jar`


## Feedback

You can join the swarmic development team on the following channels:

* Gitter [chat room](https://gitter.im/swarmic/devs?utm_source=share-link&utm_medium=link&utm_campaign=share-link)
* Google [group & mailing list](https://groups.google.com/forum/#!forum/swarmic)
* Of course you can fill an issue and send a pull request directly on this repo