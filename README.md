# Person API 👤

### 📖 Description

REST API for creating, updating, searching, listing, and deleting person records. The application uses Spring Boot and persists data through Spring Data JPA.

---

### ⚡ Features

- 👤 Create a person record
- ✏️ Update a person by ID
- 🔍 Find a person by ID
- 📋 List all people
- 🗑️ Delete a person by ID
- ✅ Validate request fields

---

### 🌐 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/person/create` | Create a person |
| `PUT` | `/person/update/{personId}` | Update a person |
| `GET` | `/person/{personId}` | Find a person by ID |
| `GET` | `/person/all` | List all people |
| `DELETE` | `/person/{personId}` | Delete a person |

Create and update requests accept a JSON body with `name`, `old`, `city`, and `job`:

```json
{
  "name": "Alex",
  "old": "30",
  "city": "Brasilia",
  "job": "Developer"
}
```

---

### 🖥️ Running Locally

**Requirements:** Java 21 and a running MySQL database.

Configure the database properties referenced by `src/main/resources/application.properties`, then run:

```powershell
.\gradlew.bat bootRun
```

To run the tests:

```powershell
.\gradlew.bat test
```

---

### 🛠️ Technologies Used

- ☕ Java 21
- 🍃 Spring Boot
- 🌐 Spring Web MVC
- 📦 Spring Data JPA
- 🗄️ MySQL
- 🔧 Gradle

---

### 🛺 Author

[Wesley Lima](https://www.linkedin.com/in/wesslima/)
