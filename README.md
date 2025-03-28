# Digital Library Book Management System

## 📌 Overview
This is a **Spring Boot-based Digital Library Management System** that allows users to:
- 📖 **Add Books** (Title, Author, Genre, Availability Status)
- 🔍 **Search Books** by ID or Title
- 📝 **Update Book Details** (Title, Author, Availability)
- 🗑️ **Delete Books**
- 📜 **View All Books**

## 🛠️ Technologies Used
- **Backend**: Java, Spring Boot, Spring Data JPA, Hibernate
- **Database**: MySQL (or H2 for testing)
- **Build Tool**: Maven
- **API Testing**: Postman

## 🚀 Setup Instructions
### **1️⃣ Clone the Repository**
```sh
git clone https://github.com/yourusername/digital-library.git
cd digital-library
```

### **2️⃣ Database**
Present at `src/main/resources/application.properties` with your **H2db **:
1st time run generates a data folder at `digital library' main in which we have hdatabase file which stores the data.
Can use h2console to access the data  

### **3️⃣ Build the Project**
```sh
mvn clean package
```

### **4️⃣ Run the Application**
```sh
java -jar target/digital-library-1.0.jar
```

The application will start at **http://localhost:8080**.

## 📡 API Endpoints
| Method  | Endpoint                 | Description                      |
|---------|--------------------------|------------------------------    |
| **POST**   | `/api/books`              | Add a new book               |
| **GET**    | `/api/books`              | Get all books                |
| **GET**    | `/api/books/{id}`         | Get book by ID               |
| **GET**    | `/api/books/search?title=xyz` | Search books by title    |
| **PUT**    | `/api/books/{id}`         | Update book details          |
| **DELETE** | `/api/books/{id}`         | Delete a book                |

## 🚀 Future Improvements
- ✅ Implement User Authentication
- 📊 Add Book Borrowing & Return Features
- 🌐 Create a Frontend with Angular


✨ _Happy Coding!_ 🚀

