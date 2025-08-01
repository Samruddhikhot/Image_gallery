# 📸 Image Gallery Web App

A full-stack **Image Gallery** application built with **Spring Boot**, **React.js**, and **MySQL** that allows users to upload, view, search, filter, sort, and delete images with metadata like title, description, category, and upload date.

> 🟢 Live Demo: [Frontend (Netlify)](https://willowy-biscotti-f1deef.netlify.app) | [Backend API (Render)](https://image-gallery-zbk5.onrender.com/getAll)

---

## 🛠 Tech Stack

### ⚙ Backend
- Java 17
- Spring Boot
- Spring Data JPA + Hibernate
- MySQL (hosted on Clever Cloud)
- REST API
- CORS Configured

### 🎨 Frontend
- React.js (with Vite)
- Axios for API calls
- Bootstrap 5
- Responsive UI

### ☁ Deployment
- **Backend**: Render
- **Database**: Clever Cloud (MySQL)
- **Frontend**: Netlify

---

## 🚀 Features

- 📤 Upload image with:
  - Title
  - Description
  - Category
- 🖼 View all uploaded images in a grid layout
- 🔍 Search images by title
- 🗂 Filter images by category
- 📅 Sort by upload date (latest first)
- 🧹 Bulk delete images
- ⚡ Real-time UI updates after any action
- 🔒 Cross-origin supported for frontend-backend communication

---

## 🧾 API Endpoints

| Method | Endpoint                | Description                      |
|--------|-------------------------|----------------------------------|
| POST   | `/upload`               | Upload image with metadata       |
| GET    | `/getAll`               | Get all images                   |
| GET    | `/getOne/{id}`          | Download single image            |
| DELETE | `/delete/{id}`          | Delete image by ID               |
| DELETE | `/deleteAll`            | Bulk delete by IDs               |
| GET    | `/search?title=`        | Search images by title           |
| GET    | `/filter?category=`     | Filter images by category        |
| GET    | `/sort`                 | Sort by upload date (desc)       |

---

## 📁 Project Structure

### Backend (`ImageGalleryBackend/`)
```
src/
├── controller/
├── service/
├── model/
├── repository/
└── application.properties
```

### Frontend (`image-gallery-frontend/`)
```
src/
├── components/
│   ├── UploadForm.jsx
│   ├── ImageGrid.jsx
│   ├── SearchBar.jsx
│   ├── BulkDeleteButton.jsx
│   └── ...
├── App.jsx
└── main.jsx
```

---

## 🌐 Environment Variables

### 🔧 Render (Backend):
```
PORT = (auto assigned by Render)

MYSQL_DB_URL = jdbc:mysql://<clevercloud-host>:3306/<db-name>
MYSQL_DB_USER = your_username
MYSQL_DB_PASSWORD = your_password
```

Add these in `application.properties`:
```properties
server.port=${PORT:8080}
spring.datasource.url=${MYSQL_DB_URL}
spring.datasource.username=${MYSQL_DB_USER}
spring.datasource.password=${MYSQL_DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false
spring.jpa.show-sql=true
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
```

---

## 🧪 How to Run Locally

### Backend
```bash
cd ImageGalleryBackend
./mvnw spring-boot:run
```

### Frontend
```bash
cd image-gallery-frontend
npm install
npm run dev
```

---

## 📌 Author

**Samruddhi Khot**  
🎓 B.E. Computer Science  
🔗 [GitHub](https://github.com/Samruddhikhot)  
📫 samruddhishrirangkhot@gmail.com

---

## ⭐️ Show Your Support

If you like this project, give it a ⭐️ on [GitHub](https://github.com/Samruddhikhot/Image_gallery)!  
Contributions, issues, and suggestions are welcome.
