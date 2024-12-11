# phoenixd-java

This is a Java wrapper for ACINQ's [phoenixd REST API](https://phoenix.acinq.co/server/api).

## Requirements
- Java 21
- Maven 
- A running instance of phoenixd
- A valid Lightning address (for testing. See below)

## Contributing
Currently, only a minimal subset of the endpoints are implemented. If you would like to contribute to this project, please feel free to fork the repository and submit a pull request.
To implement a new endppoint, you need to create three classes
1. A request parameter class that extends `Request.Param` (in the `phoenixd-model` module)
2. A response class that implements the `Response` interface (in the `phoenixd-model` module)
3. The actual endpoint request sub-class (in the `phoenixd-rest` module)
4. The corresponding unit tests (in the `phoenixd-test` module)

### Supported endpoints:
- /createinvoice
- /decodeinvoice
- /getlnaddress
- /payinvoice
- /paylnaddress

**IMPORTANT**: Please make sure to *change* the `test.pay_lnaddress` property in the `app.properties` file of the `phoenixd-test` module to a valid Lightning address that *you control* **before** running the tests.