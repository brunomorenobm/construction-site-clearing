# Site Construction Cleaning Simulator

Site cleaning simulation tool, console based tool to calculate the cost of cleaning construction sites.

This is a test applied for Oracle ACONEX Company for Java Developer Candidates.

More Details on: [construction-site-clearing.pdf](docs/construction-site-clearing.pdf) 

If you are a DEV and needs to change or extend anything you **MUST READ ;)** : [developer-guide](README-DEV.md)

## How to Run

#### Requirements:
- Java 8 [download](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
- Maven [download](https://maven.apache.org/install.html)
###### Generate the Package:
In order to run the simulation you have to make sure that the code is working and generate the package.
Please execute the command below to run the tests and generate the Java package file.

`mvn package`


###### run the Package:
After the Java package is generated, and all tests have been executed, you are able to run the simulation, please execute the command below:

`java -jar target/construiction-site-clearing-1.0.jar src/main/resources/maps/map1.txt`

where

`java -jar <jar-generated-package> <map-file-path>`

## Design and Approach

The SOLID principles were used to design this solution with some other patterns.

All Classes depends only Interfaces.


All Business Classes have a single responsibility.


All subclassed may be substitutable for their base/parent class.


All Business components are close to change and open for extension.


All classes implements only the methods they affective have to implement.

###Approaches
In order to be easier to change and to extend the simulation I have used the solutions below:

#### - Rules

Each rule is aims to execute only one specific part of the business rule.

#### - Block

Each block has a set of rules, each rule is applied in every suitable situation, to add more behaviours just add more rules to each block.

To add more blocks just set the Business rules and add an enum Item.
 
#### - Commands

Each command has a set of actions, needs more action, just include more CommandAction objects, needs more commands, just create an enum item
I have implemented Observer pattern to have the ability to add more behaviours without change the command. 


#### - Actions
Is attached to a command or to an event, observer patter implemented


#### CommandActionAdvance
Specialization of a navigate command, to have smaller classes each direction is in a different file,
and if you have to add more directions, you don´t need t change the existing code, just add more commands and more specializations.

#### - Simulation

Proxy class that manages everything, the component exposes only functions that clients needs, and manage everything internally

#### - Billing

Abstraction to manage the consumed items and, easy to extend and to test, even the calculation of each line is abstracted, you may have different calculations for different items, without changing any existing code.

## Files
All files are listed in folder [src/main/resources/maps](src/main/resources/maps)

## Test
All business classes have their implementation of an JUnit Test


#### Future Additional Items

- Show only valid commands
- Warn used before execute the command if it will execute anything illegal.
- Give best prescriptive command options 