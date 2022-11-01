# Game-of-Life

# MUNtour Algorithms Module

## MUNtour REST API - Getting Started

The MUNtour Algorithms Module provIDes a suite of REST API's for interacting with the module.

### Accessing Database

These API's require no body and return database models as json. See [Models](#muntour-rest-api---models) for more info.

| Method   | URL                                                           | Description                      | Response                                |
| -------- | ------------------------------------------------------------- | -------------------------------- | --------------------------------------- |
| `GET`    | `http://127.0.0.1:5000/api/airports/<ID>`                     | Retrieve airport by ID           | [Airport](#airport)                     |
| `GET`    | `http://127.0.0.1:5000/api/flights/<ID>`                      | Retrieve flight by ID            | [Flight](#flight)                       |
| `GET`    | `http://127.0.0.1:5000/api/cars/<ID>`                         | Retrieve car by ID               | [Car](#car)                             |
| `GET`    | `http://127.0.0.1:5000/api/car-rentals/<ID>`                  | Retrieve car rental by ID        | [Car Rental](#car-rental)               |
| `GET`    | `http://127.0.0.1:5000/api/car-rental-agencies/<ID>`          | Retrieve car rental agency by ID | [Car Rental Agency](#car-rental-agency) |
| `GET`    | `http://127.0.0.1:5000/api/hotels/<ID>`                       | Retrieve hotel by ID             | [Hotels](#hotel)                        |
| `GET`    | `http://127.0.0.1:5000/api/hotel-bookings/<ID>`               | Retrieve hotel booking by ID     | [Hotel Bookings](#hotel-booking)        |
| `GET`    | `http://127.0.0.1:5000/api/users/<ID>`                        | Retrieve user by ID              | [Users](#user)                          |
| `GET`    | `http://127.0.0.1:5000/api/bookings/<ID>`                     | Retrieve booking by ID           | [Booking](#booking)                     |

### Public Functions

These API's require a body which contains the functions inputs. See [Public Function Message Format](#muntour-rest-api---public-function-message-format) for more info.

| Method   | URL                                                           | Description                                                            | Message Format                                        |
| -------- | ------------------------------------------------------------- | ---------------------------------------------------------------------- | ----------------------------------------------------- |
| `GET`    | `http://127.0.0.1:5000/api/public/airports/in-area`           | Retrieve all airports in an area                                       | [Airports in Area](#airports-in-area)                 |
| `GET`    | `http://127.0.0.1:5000/api/public/car-rental-agencies/in-area`| Retrieve all car rental agencies in an area                            | [Car Rental Agenies](#car-rental-agencies-in-area)    |
| `GET`    | `http://127.0.0.1:5000/api/public/hotels/in-area`             | Retrieve all hotels in an area                                         | [Hotels in Area](#hotels-in-area)                     |
| `GET`    | `http://127.0.0.1:5000/api/public/hotels/near-airport`        | Retrieve the best bookable hotels near an airport                      | [Hotels Near Airport](#hotels-near-airport)           |
| `GET`    | `http://127.0.0.1:5000/api/public/cars/near-airport`          | Retrieve the best rentable cars near an airport                        | [Cars Near Airport](#cars-near-airport)               |
| `GET`    | `http://127.0.0.1:5000/api/public/flights/between-airports`   | Retrieve the best bookable flight sequences between two airports       | [Flights Between Airports](#flights-between-airports) |
| `GET`    | `http://127.0.0.1:5000/api/public/account/bookings`           | Retrieve all bookings associated with a user                           | [Account Bookings](#account-bookings)                 |
| `POST`   | `http://127.0.0.1:5000/api/public/account/book`               | Book a complete trip. This includes a flight sequence, hotels and cars | [Account Book](#account-book)                         |
| `POST`   | `http://127.0.0.1:5000/api/public/account/login`              | Log in user with email                                                 | [Account Login](#account-login)                       |
| `POST`   | `http://127.0.0.1:5000/api/public/account/signup`             | Create new user with email                                             | [Account Signup](#account-signup)                     |

## MUNtour REST API - Models

The JSON snippets below indicate field names and expected data type.

### Airport
Airport model data is made of a float longitude and latitude, a string airport name, as well as a list of departing flight IDs, arriving flight IDs, nearby hotel IDs, and nearby car rental agency IDs.
```
{
    "latitude": float,
    "longitude": float,
    "name": str,
    "departing_flight_IDs": [str],
    "arriving_flight_IDs": [str],
    "nearby_hotels": [str],
    "nearby_car_rental_agencies": [str]
}
```
### Flight
Flight model data consists of a string departure airport ID and arrival airport ID, as well as a floating point cost.
```
{
    "departure_airport_id": str,
    "arrival_airport_id": str,
    "cost": float
}
```
### Car
Car model data is composed of a string representing the ID of the owner, the car's model as a string, and floating point rental price.
```
{
    "owner_id": str,
    "model": str,
    "rental_price": float
}
