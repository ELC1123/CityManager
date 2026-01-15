# City Break Manager 🌍✈️

A Spring Boot application designed for travel enthusiasts to manage their city breaks effectively. This REST API allows users to track cities they have visited (or plan to visit) and log detailed trip itineraries.

## 🚀 Project Overview

This backend application solves the "Level 1: City Break Manager" challenge. It provides a structured way to store:
* **Cities:** Details about destinations (Name, Country, Description).
* **Trips:** Logs of specific visits, including dates, ratings, and personal notes.

Link to Challenge (and other challenges): https://explainjavalikeim8.com/spring-projects-ideas/

## 🛠️ Tech Stack

* **Language:** Java 25
* **Framework:** Spring Boot (Web, Data JPA)
* **Build Tool:** Maven
* **Database:** H2 (In-memory database for rapid testing)
* **Tools:** Lombok, Postman (for API testing)

## ⚙️ How to Run

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/ELC1123/CityManager.git](https://github.com/ELC1123/CityManager.git)
    cd CityManager
    ```

2.  **Run the application:**
    You can run it directly using the Maven wrapper:
    ```bash
    ./mvnw spring-boot:run
    ```

3.  **Access the Console:**
    The application runs on `http://localhost:8080`.

## 🔌 API Endpoints

### Cities (`/cities`)
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/cities` | Get all cities |
| `GET` | `/cities/{id}` | Get specific city details |
| `POST` | `/cities` | Add a new city |
| `PUT` | `/cities/{id}` | Update an existing city |
| `DELETE` | `/cities/{id}` | Delete a city |

### Trips (`/trips`)
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/trips` | Get all trips |
| `GET` | `/trips/{id}` | Get specific trip details |
| `POST` | `/trips` | Log a new trip (Requires `city_id`) |
| `PUT` | `/trips/{id}` | Update trip details |
| `DELETE` | `/trips/{id}` | Delete a trip |

## 📝 Usage Examples

**Adding a City (JSON Body):**
```json
{
  "name": "Manila",
  "country": "Philippines",
  "details": "Hot!"
}
```

**Adding a Trip (JSON Body):**
```json
{
    "startDate": "2026-03-10",
    "endDate": "2026-03-15",
    "rating": 5,
    "personalNotes": "Graduation trip!",
    "city": {
        "id": 1
    }
}
```