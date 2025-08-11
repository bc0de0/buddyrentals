# Buddy Rental App API

Buddy Rental App API is a complete backend service built with Spring Boot designed to support a rental platform where customers can book “buddies” (rental providers). This API provides essential location-based features powered by Google Maps services to enhance user experience and booking accuracy.

---

## Key Features

- **User & Buddy Management** *(assumed implemented)*  
  Manage customers and rental buddies with profiles, availability, and booking history.

- **Booking System** *(assumed implemented)*  
  Create, update, and manage rental bookings between customers and buddies.

- **Google Maps Integration**
    - **Geocoding API:** Convert physical addresses into latitude and longitude coordinates to precisely locate users and buddies.
    - **Distance Matrix API:** Calculate the distance and estimated travel time between the buddy’s location and the customer’s location to optimize bookings and provide ETA estimations.

- **Scalable & Extensible Architecture**  
  Easily extend the API to integrate additional Google Maps services like Places, Directions, or Elevation APIs.

---

## Google Maps API Integration

This API leverages Google Maps web services to provide real-time location intelligence:

1. **Geocoding API**  
   Converts user-input addresses into geographic coordinates, enabling accurate location tracking and mapping.

2. **Distance Matrix API**  
   Computes travel distance and expected travel time between two coordinate points (buddy and customer), supporting smarter booking and scheduling decisions.

3. **API Key Management**  
   All Google Maps API calls require a valid API key configured in the Spring Boot application.

---

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven or Gradle build tool
- Google Cloud API key with enabled Geocoding and Distance Matrix APIs

### Installation

1. Clone the repository:

```bash
git clone <your-repo-url>
cd buddy-rental-app
