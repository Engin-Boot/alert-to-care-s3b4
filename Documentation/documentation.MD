# Alert to Care API


This project implements a service that receives measurements from devices that monitor patients. 
It's part of a solution that provides care in an ICU.

## Index
1. [Prerequisites](#Prerequisites)
2. [Compiling](#Compiling)
3. [Executing](#Executing)
4. [APIs Created](#ApiCreated)
5. [Goal Set and Achieved](#Goalset)

## Prerequisites
Firstly, the project makes use of Spring Boot in order to build the source files and hence, the target system must have a Spring tool suite (recommmended: Spring 3.0) .
Then, the target system must have Java (>=8) installed and available in the system path.
The project makes use of Maven as the build tool and hence, Maven must also be in the system path.
Also, the java based embedded 'H2' database is used in this project for convenience. 

## Compiling
In the root directory of the project, a batch file by the name "<insert_name_here>.bat" is present. 
Run the batch file in the command line and it will compile the sources and execute the test cases.  
```
./../Alert-to-Care-API> <insert_name_here>.bat
```  
Once the batch file has sucessfully executed, you should be able to see a `"build successful"` message.

NOTE : This <insert_name_here>.bat also runs JaCoCo code coverage library and you can check the code coverage report by opening `"index.html"` in browser. 

```
./target/site/jacoco> index.html
```


## Execution
Once the main spring application (com.philips.alerttocare) has been run,Tomcat apache server would set up.

## APIs Created

When posting values via the API's for the first time, follow the same order mentioned : 
ICUs -> BEDs -> MONITORING DEVICEs -> BED & DEVICE MAPPINGs -> PATIENTs

### ICU-Management API
| HTTP Mehtod | API URL        | Description                                                                | Success Response                                 | Failure Response  |
|-------------|----------------|----------------------------------------------------------------------------|--------------------------------------------------|-------------------|
| GET        | "/icu-mgmt/icu"      |  Fetches list of all ICUs along with their status | 200 status code with "OK"    | -- |
| POST        | "/icu-mgmt/icu"      |  This adds a new ICU to the system  | 201 status code with "CREATED"    | -- |




### BED-Management API
| HTTP Mehtod | API URL        | Description                                                                | Success Response                                 | Failure Response  |
|-------------|----------------|----------------------------------------------------------------------------|--------------------------------------------------|-------------------|
| GET        | "/bed-mgmt/allBeds"      |  Fetches list of all beds along with their status | 200 status code with "OK"    | -- |
| POST        | "/bed-mgmt/bed"      |  This adds a new bed to the specified ICU  | 201 status code with "CREATED"    | -- |
| GET         | "/bed-mgmt/bed/{bedId}" | Fetches the details of bed with the bedID = "id"                                   | 200 Status code 'OK' | 404 status code 'Not Found'     |
| DELETE      | "/bed-mgmt/bed/{bedId}"  | Deletes specified record of bed                                                  | 204 status code 'NO CONTENT'                                   | 400 status code 'BAD REQUEST'     |




### MONITORING DEVICE-Management API
| HTTP Mehtod | API URL        | Description                                                                | Success Response                                 | Failure Response  |
|-------------|----------------|----------------------------------------------------------------------------|--------------------------------------------------|-------------------|
| GET        | "/device-mgmt/devices"      |  Fetches list of all devices along with their status | 200 status code with "OK"    | -- |
| POST        | "/device-mgmt/devices"      |  This adds a new device to the system  | 201 status code with "CREATED"    | -- |
| GET         | "/device-mgmt/devices/{deviceId}" | Fetches the details of device with the deviceID = "id"                                   | 200 Status code 'OK' | 404 status code 'Not Found'     |
| DELETE      | "/device-mgmt/devices/{deviceId}"  | Deletes specified record of device                                                 | 204 status code 'NO CONTENT'                                   | 400 status code 'BAD REQUEST'     |




### BED & MONITORING DEVICE- mapping API
| HTTP Mehtod | API URL        | Description                                                                | Success Response                                 | Failure Response  |
|-------------|----------------|----------------------------------------------------------------------------|--------------------------------------------------|-------------------|
| GET        | "/bed-device/allMaps"      |  Fetches list of all 1-1 mappings of beds and devices along with their status | 200 status code with "OK"    | -- |
| POST        | "/bed-device/map"      |  This adds a new mapping of bed to device to the system  | 201 status code with "CREATED"    | -- |
| PUT         | "/bed-device/map/{id}" | Updates the vital values of patient admitted to the device  and alerts accordingly  | 200 Status code 'OK' | 404 status code 'Not Found'     |




### PATIENT-Management API
| HTTP Mehtod | API URL        | Description                                                                | Success Response                                 | Failure Response  |
|-------------|----------------|----------------------------------------------------------------------------|--------------------------------------------------|-------------------|
| GET        | "/patient-mgmt/patients"      |  Fetches list of all patients along with their status | 200 status code with "OK"    | -- |
| POST        | "/patient-mgmt/patient"      |  This admits/adds a new patient to the specified bed  | 201 status code with "CREATED"    | -- |
| GET         | "/patient-mgmt/patient/{patientId}" | Fetches the details of patient with the patientID = "id"                                   | 200 Status code 'OK' | 404 status code 'Not Found'     |
| DELETE      | "/patient-mgmt/bed/{bedId}"  | Discharges/Deletes specified record of patient                                                  | 204 status code 'NO CONTENT'                                   | 400 status code 'BAD REQUEST'     |



For more UI based understanding on the API's, start the springboot application and access the Swagger UI representation via
http://localhost:8080/swagger-ui/index.html#/ .
