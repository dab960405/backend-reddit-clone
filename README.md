Reddit Clone - Backend API
RESTful API backend for a Reddit clone built with Spring Boot, providing all necessary functionalities for a complete social media platform.
🚀 Demo
🌐 API Base URL:https://backend-reddit-clone-q4pl.onrender.com

🛠️ Tech Stack

Spring Boot 3.0.3 - Main framework
Spring Security v6 - Authentication and authorization
Spring Data JPA - Persistence layer
Spring MVC - REST APIs
MySQL - Relational database
OpenAPI 3 - API documentation
JWT - Token-based authentication

🏗️ Architecture
Database

Provider: Aiven (MySQL)
ORM: Spring Data JPA with Hibernate

Deployment

Application: Render
Database: Aiven MySQL
Frontend: Vercel (repository)

📋 Features
Authentication & Users

✅ User registration
✅ JWT login
✅ Email authentication
✅ User profiles
✅ Account activation via email

Posts & Content

✅ Create posts
✅ Edit posts
✅ Delete posts
✅ Paginated post listing
✅ Voting system (upvote/downvote)

Subreddits

✅ Create subreddits/communities
✅ Join subreddits
✅ Subreddit management
✅ Posts by subreddit

Comments

✅ Comment on posts
✅ Reply to comments
✅ Vote on comments
✅ Comment threading system

🔧 Configuration
Environment Variables
properties# Database (Aiven)
DB_HOST=your-host.aiven.tech
DB_PORT=port
DB_NAME=database_name
DB_USERNAME=username
DB_PASSWORD=password

# JWT Configuration
JWT_SECRET=your_super_secure_jwt_secret
JWT_EXPIRATION_TIME=86400000

# Email Configuration (for account activation)
MAIL_HOST=smtp.gmail.com
MAIL_PORT=587
MAIL_USERNAME=your-email@gmail.com
MAIL_PASSWORD=your-app-password

# CORS (Frontend URL)
FRONTEND_URL=https://your-app.vercel.app
application.yml
yamlspring:
  datasource:
    url: jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}?useSSL=true&serverTimezone=UTC
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
    driver-class-name: com.mysql.cj.jdbc.Driver
  
  jpa:
    hibernate:
      ddl-auto: update
    database-platform: org.hibernate.dialect.MySQL8Dialect
    show-sql: false
  
  mail:
    host: ${MAIL_HOST}
    port: ${MAIL_PORT}
    username: ${MAIL_USERNAME}
    password: ${MAIL_PASSWORD}
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true

app:
  jwt:
    secret: ${JWT_SECRET}
    expiration: ${JWT_EXPIRATION_TIME}
  frontend:
    url: ${FRONTEND_URL}
💻 Local Development
Prerequisites

Java 17 or higher
Maven 3.6+
MySQL 8.0+

Installation

Clone the repository

bashgit clone https://github.com/dab960405/backend-reddit-clone.git
cd backend-reddit-clone

Set up local MySQL database

sqlCREATE DATABASE reddit_clone;

Configure environment variables or application-dev.properties

propertiesspring.datasource.url=jdbc:mysql://localhost:3306/reddit_clone
spring.datasource.username=your_username
spring.datasource.password=your_password

Install dependencies and run

bashmvn clean install
mvn spring-boot:run

The API will be available at http://localhost:8080

📚 API Endpoints
Authentication
POST /api/auth/signup       # User registration
POST /api/auth/login        # User login
POST /api/auth/refresh      # Refresh token
GET  /api/auth/verify/{token} # Email verification
Posts
GET    /api/posts           # Get all posts
GET    /api/posts/{id}      # Get post by ID
POST   /api/posts           # Create new post
PUT    /api/posts/{id}      # Update post
DELETE /api/posts/{id}      # Delete post
Subreddits
GET    /api/subreddits      # Get all subreddits
GET    /api/subreddits/{id} # Get subreddit by ID
POST   /api/subreddits      # Create new subreddit
Votes
POST   /api/votes          # Vote on a post
Comments
GET    /api/comments/post/{postId}  # Comments for a post
POST   /api/comments               # Create comment
🚀 Deployment on Render
Render Configuration

Connect your GitHub repository with Render
Configure environment variables in the dashboard
Render will automatically detect it's a Spring Boot project
Build command will be: mvn clean install
Start command will be: java -jar target/reddit-clone-backend-0.0.1-SNAPSHOT.jar

Dockerfile (optional)
dockerfileFROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
🧪 Testing
bash# Run unit tests
mvn test

# Run integration tests
mvn verify


🔒 Security

JWT Authentication - Secure tokens for authentication
BCrypt - Password hashing
CORS - Configured for Vercel frontend
Spring Security - Endpoint protection
Data Validation - Bean Validation with annotations

📊 Monitoring & Logs

Actuator - Health check and metrics endpoints
Logback - Configured logging system
Health Check - Available at /actuator/health

🤝 Contributing

Fork the project
Create a feature branch (git checkout -b feature/AmazingFeature)
Commit your changes (git commit -m 'Add some AmazingFeature')
Push to the branch (git push origin feature/AmazingFeature)
Open a Pull Request

