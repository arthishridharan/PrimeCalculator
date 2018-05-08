# PrimeCalculator
Project to calculate series of prime numbers upto and including given initial input
##H2 Technologies used
1. Springboot 2.0.1
2. Spring Rest Web Services
3. Gradle 4.6
4. Java 8

#H2 How-to import project
1. Import project as gradle project to your IDE
2. clean and build project using gradle commands
3. Run project as a spring boot application

#H2 Test project from URL using following:
1. Using path extension
..1. For JSON output
http://localhost:8080/primes/23.json
Will return prime numbers starting from 1 and upto and including 23 as JSON output

..2. For XML output
http://localhost:8080/primes/23.xml
Will return prime numbers starting from 1 and upto and including 23 as xml output

2. Using url parameter
..1.) For JSON output
http://localhost:8080/primes/23?mediaType=json
Will return prime numbers starting from 1 and upto and including 23 as JSON output

..2. For XML output
http://localhost:8080/primes/23?mediaType=xml
Will return prime numbers starting from 1 and upto and including 23 as xml output


