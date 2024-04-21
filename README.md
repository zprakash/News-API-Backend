# News Backend Service

The purpose of this project is to provide a backend service that fetches data from the News API and integrates it with frontend applications to provide real-time news data.
## Features

- **Data Fetching**: Fetches data from a news API to provide the latest news to clients.
- **RESTful API**: Provides a RESTful API for frontend applications to consume news data.

## Prerequisites

- **Java Development Kit (JDK) 21**: Make sure you have Java 21 installed on your system. You can download it from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use a package manager for your operating system.
- **Git**: You need Git installed to clone the repository.



### News API Key: Create an account at [News API](https://newsapi.org/) to get your API key.
## Usage
Locate the application.yml `src/main/resources/application.yml` file and paste your API key in `YOUR_API_KEY`
```yaml
news:  
   api:
     apiKey: YOUR_API_KEY 
   ```
## Installation Guide
1. **Clone the repository**:
   `git clone https://github.com/zprakash/News-API-Backend.git `
2. **Navigate to Project Directory**:
   `cd News-API-Backend`
3. **Build the Project**:
   ` ./gradlew build`
4. **Run the Application**:
   `./gradlew bootRun`



