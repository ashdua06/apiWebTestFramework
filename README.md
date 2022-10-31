- Project consits of four modules
1) apiCore: It contains core code of API (RestAssured , utils , JacksonJson class)
2) webCore: It contains core code of web (Selenium , utils)
3) reportingCore: It contains core code of reporting , common utils , testNg
4) sampleProject: It contains code of testing an application

**sampleProject:**
Run testng.xml in this project to run tests. Tests are present in below directory
sampleProject/src/test/java/systemTesting and contains 3 tests.
- Test1: Generating random user and storing it in public variable
- Test2: Registering same user
- Test3: Purchasing item and validating payment status

**Uses below design patterns**
- Single ton
- Page object model
- chaining method design pattern


**Framework supports below things**
- Rest Assured in apiCore
- Extent report implementation in reportingCore
- Selenium functions in webCore
- Running tests through TestNg



