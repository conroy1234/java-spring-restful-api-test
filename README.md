# Hunter Six - Java Spring RESTful API Test

## How to build
```./gradlew clean build```

## How to test
```./gradlew test```

## Exercises
### Exercise 1
## -completed idsShouldBeDifferent is now green
Make the tests run green (there should be one failing test)

### Exercise 2
### completed added PersonExceptionBean to handle out put, personNotFoundException to handle not found exception and personExceptionHandler with controller advise
Update the existing `/person/{lastName}/{firstName}` endpoint to return an appropriate RESTful response when the requested person does not exist in the list
- prove your results

### Exercise 3

Write a RESTful API endpoint to retrieve a list of all people with a particular surname
- pay attention to what should be returned when there are no match, one match, multiple matches
- prove your results
### completed extra person added Conroy Smith
## test results:
## http://localhost:8080/person/Smith

 [{
 "id": 1,
 "firstName": "Mary",
 "lastName": "Smith"
 },
 {
 "id": 1,
 "firstName": "Conroy",
 "lastName": "Smith"
 }
 ]

result for non-existing last name
http://localhost:8080/person/Thompson

return 404 not found with below message
{
"now": "2024-01-05T16:09:51.831",
"message": "no result found",
"description": "uri=/person/Thompson"
}

### Exercise 4
Write a RESTful API endpoint to add a new value to the list
- pay attention to what should be returned when the record already exists
- prove your resutls
## completed

