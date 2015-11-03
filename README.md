# About
This is a test project to test an implementation of knapsack algorithm developed to optimize the revenue from advertisement campaigns a company can sell to customers.

#Test Strategy
The project under test is a webservice written in Java. The test strategy is based on the levels of testing:
##1- Unit tests:
Project was lacking any unit tests, so first step was to implement unit tests for public methods of classes. Unit tests are implemented for all classes except Bookings. 
##2- Function tests: 
The class that implements knapsack algorithm is called Bookings.java. This is basically the core of what this webservice does and had the highest priority from the testing prespective. The strategy used to test this class was to compare it against another implementation of knapsack algorithm. Therefore another version of knapsack was implemented and tested 

# To Do:

- Test the case when impression is null
- Test the case when impresion or inventroy is negative
- Check the code for possible exceptions
...

#What is done:
create unit tests
create an alternative algorithm as a base for comparision
manual testing
random customer object generator
adding logger
adding pmd check



#Tests:
unit tests
automated functional tests to test the knapsack algorithm using an alternative algorithm
manual test
performance test

#Manual tests:
inventory very big (eg 500000000) - failed - java heap space
empty inventory - failed
inventory = -1
inventory = -500 failed
inventory = 0
inventory = abcd

Impressions < 0 - failed


#Load tests:
A normal customer set with small number of threads to do performance test
A normal customer set with relatively high number of threads to do performance test
A normal customer set with burst scenario (robustness)
A normal customer set with medium number of threads to test stability
A huge customer set with small number of threads to do performance test
A huge customer set with high number of threads to do performance test

#Tools used
http://beta.json-generator.com/Nyf1W_xMg

#Check Port number of the service




Another interesting test data, algorithm under test reaches the same revenue with less impressions in total:

{
  "customers":[
     {
        "name":"CustomerA",
        "impressions":3258035,
        "revenue":26
     },
     {
        "name":"CustomerB",
        "impressions":4788954,
        "revenue":29
     },
     {
        "name":"CustomerC",
        "impressions":5975402,
        "revenue":2
     },
     {
        "name":"CustomerD",
        "impressions":4603949,
        "revenue":23
     },
     {
        "name":"CustomerE",
        "impressions":377169,
        "revenue":3
     }
  ]
}

Expected Impressions : 49994702
Actual   Impressions : 49897835
