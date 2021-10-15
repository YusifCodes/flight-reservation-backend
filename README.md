# flight-reservation-backend

HELLO FRIENDS
Here are some instructions for this thing to run:

SETTING UP

1.This is was done with JDK 8
2.Don't froget to set up connection to your local or remote database in application.properties
3.In ApplicationService you should specify your service email and password for it.

DATABASE SETTINGS

1. Create a database with 3 tables inside of it.

1.1 First one is flightinfo

                                       Table "public.flightinfo"
    Column    |          Type          | Collation | Nullable |                Default
--------------+------------------------+-----------+----------+----------------------------------------
 id           | integer                |           | not null | nextval('flightinfo_id_seq'::regclass)
 flightnumber | character varying(255) |           |          |
 flyingfrom   | character varying(255) |           |          |
 flyingto     | character varying(255) |           |          |
 flightdate   | character varying(255) |           |          |
 flighttime   | character varying(255) |           |          |
 airline      | character varying(255) |           |          |
 price        | character varying(255) |           |          |
 
 1.2 The other one is flightseats
 
                                         Table "public.flightseats"
    Column    |          Type          | Collation | Nullable |                 Default
--------------+------------------------+-----------+----------+-----------------------------------------
 id           | integer                |           | not null | nextval('flightseats_id_seq'::regclass)
 flightnumber | character varying(255) |           |          |
 flightseat   | character varying(255) |           |          |
 seatstatus   | boolean                |           |          |

1.3 The last one being flightpassengers

                                       Table "public.flightpassengers"
     Column     |          Type          | Collation | Nullable |                   Default
----------------+------------------------+-----------+----------+----------------------------------------------
 id             | integer                |           | not null | nextval('flightpassengers_id_seq'::regclass)
 firstname      | character varying(255) |           |          |
 lastname       | character varying(255) |           |          |
 passportnumber | character varying(255) |           |          |
 email          | character varying(255) |           |          |
 address        | character varying(255) |           |          |
 flightnumber   | character varying(255) |           |          |
 seats          | character varying(255) |           |          |
 
 API FUNCTIONALITY
 
 1.Change the @CrossOrigin location at the top of ApplicationController, mine is set up for default webpack localhost
 2.Request mapping is set up for "/api/v1" by default
 
 2.1."/setFlight" be careful with this one as it calls the static method that creates a flight in flightinfo, and seats in flightseats, commented out by default
 DISCLAIMER: this method is populated with a mock flight by default, be careful
 2.2."get/flights/{from}/{to}" this one gets you flights from A to B if they exist in flightinfo
 2.3."get/flights/all" gets you all flights from flightinfo
 2.4"get/seats/{flightnumber}" gets you seats fro a flight, requires a flightnumber
 DISCLAIMER: don't create flights with same flightnumbers
 2.5"set/passenger" takes in a json with all the info, creates a passenger in passengerinfo, changes seatstatus in flightseats, sends a confirmation email to a user specified email
 
 HAVE FUN WITH IT
