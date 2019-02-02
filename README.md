# CellTrackProject

This README would normally document whatever steps are necessary to get CellTrackProject up and running.

### What is this repository for? ###

* An API Test restassured and java to test the functionality of the github API
* CellTrackProject 1.0

### How do I get set up? ###

Last version of maven is needed.

##### Install required dependencies:

```
clone repo
cd [pathTo]/
```

#### Run tests:

```
mvn test -P githubTests
```

### List of Tests: ###

verifyStatusCode200 (Verify thay the search of repositories with the API answer 200, the parameters of the call are on the URL)

verifyStatusCode200WithParams (Verify thay the search of repositories with the API answer 200, the parameters of the call are not on the URL, are variables)

verifyOwnerLoginValue (Verify the owner of the repositories of the search)

verifyHasOneItem (Verify that there are only one item per page on the result)

verifyHasMoreThanOneResult (Verify that there are more than one result on the total of the search, but only shows one)

verifyHasTwoItems (Verify that in this case are two items per page on the result)
#### Run tests with Authentication:

```
mvn test -P githubTests2
```

### List of Tests: ###

verifyNeedAuthorization (Verify that to access to the data of a user has to be authenticated)

verifyAuthorizationWorks (Verify that with the username and password can access to the data of an user - NEED FILL THE DATA OF USER AND PASS ON THE CODE)

### Who do I talk to? ###

* Repo owner or admin:
emmmau@gmail.com