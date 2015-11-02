# knapsack


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



Interesting test data:
taxjd
881793
35
=========================
yebrr
5094333
12
=========================
byixo
469094
49
=========================
cqxkb
1304981
0
=========================
zmfck
2793629
14


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