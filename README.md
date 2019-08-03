# spring-boot-contacts

###### Pre-requisites
```
Postgres

Java 1.8
```

###### Setup

`./gradlew clean build`

`./gradlew bootRun`

###### Sample request

```curl -X POST \
  http://localhost:8080/contacts/v1/ \
  -H 'Accept: */*' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: 2b2c9552-6d46-4578-9bd1-0949dc121228,2146b500-adbe-4737-b133-dc7cee3cbedf' \
  -H 'User-Agent: PostmanRuntime/7.13.0' \
  -H 'accept-encoding: gzip, deflate' \
  -H 'cache-control: no-cache' \
  -H 'content-length: 91' \
  -d '{
  "firstName":"Jon",
  "lastName":"Snow",
  "email":"jon@snow.com",
  "phone":"3000000"
}'
```
