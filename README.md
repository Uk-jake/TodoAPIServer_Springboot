# Todo API Server Documentation

## 서비스 설명

- Spring Boot를 사용하여 간단한 API 서버를 구현했습니다.
- 서버의 기능은 Todo 리스트를 조회, 등록, 수정, 삭제하는 기능을 제공합니다.
- 예외 처리는 포함되어 있지 않습니다.

## **ERD (Entity Relationship Diagram)**

| **Entity** | **Attribute**  | **Type** | **Description**                |
|------------|----------------|----------|--------------------------------|
| Todo       | id             | Long     | 기본 키 (자동 생성)            |
|            | title          | String   | 할 일 제목                     |
|            | description    | String   | 할 일에 대한 설명              |
|            | completed      | boolean  | 할 일의 완료 여부 (`true`/`false`) |

## **API 명세서 (API Specification)**

### **1. Todo 생성**

- **URL**: `/todos`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "title": "Learn Spring Boot",
    "description": "Understand how to create a REST API using Spring Boot",
    "completed": false
  }
  ```
- **Response**:
  - **Status**: `200 OK`
  - **Body**:
    ```json
    {
      "id": 1,
      "title": "Learn Spring Boot1",
      "description": "Understand how to create a REST API using Spring Boot1",
      "completed": false
    }
    ```

### **2. Todo 목록 조회**

- **URL**: `/todos`
- **Method**: `GET`
- **Response**:
  - **Status**: `200 OK`
  - **Body**:
    ```json
    [
      {
        "id": 1,
        "title": "Learn Spring Boot",
        "description": "Understand how to create a REST API using Spring Boot",
        "completed": false
      },
      {
        "id": 2,
        "title": "Learn Spring Boot2",
        "description": "Understand how to create a REST API using Spring Boot2",
        "completed": false
      },
      {
        "id": 3,
        "title": "Learn Spring Boot3",
        "description": "Understand how to create a REST API using Spring Boot3",
        "completed": false
      }
    ]
    ```

### **3. 세부 Todo 조회**

- **URL**: `/todos/{id}`
- **Method**: `GET`
- **Path Variable**: `id` (Todo's ID)
- **Response**:
  - **Status**: `200 OK`
  - **Body**:
    ```json
    {
      "id": 1,
      "title": "Learn Spring Boot",
      "description": "Understand how to create a REST API using Spring Boot",
      "completed": false
    }
    ```

### **4. Todo 업데이트 (Update Todo)**

- **URL**: `/todos/{id}`
- **Method**: `PUT`
- **Path Variable**: `id` (Todo's ID)
- **Request Body**:
  ```json
  {
    "title": "Updated todo title",
    "description": "Updated todo description",
    "completed": true
  }
  ```
- **Response**:
  - **Status**: `200 OK`
  - **Body**:
    ```json
    {
      "id": 1,
      "title": "Updated todo title",
      "description": "Updated todo description",
      "completed": true
    }
    ```

### **5. Todo 삭제 (Delete Todo)**

- **URL**: `/todos/{id}`
- **Method**: `DELETE`
- **Path Variable**: `id` (Todo's ID)
- **Response**:
  - **Status**: `200 OK`

