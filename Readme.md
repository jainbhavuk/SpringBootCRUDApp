# Employee CRUD App

Employee CRUD App is a simple RESTful API built using Spring Boot that allows users to perform CRUD (Create, Read, Update, Delete) operations on employee records.

## Table of Contents

- [Introduction](#introduction)
- [Endpoints](#endpoints)
- [How to Use](#how-to-use)
- [Examples](#examples)

## Introduction

This project provides a simple API to manage employee data. Users can perform various operations like adding new employees, retrieving all employees, updating existing employees, deleting employees by ID, and more.

The project uses Spring Boot, which makes it easy to run the application as a standalone service with an embedded web server.

## Endpoints
| Method   | Endpoint                             | Description                                  |
|----------|--------------------------------------|----------------------------------------------|
| POST     | **/api/employee**                    | Create a new employee                        |
| GET      | **/api/employee**                    | Get all employees                            |
| GET      | **/api/employee/{empId}**            | Get an employee by ID                        |
| PUT      | **/api/employee/{empId}**            | Modify an existing employee                  |
| DELETE   | **/api/employee/{empId}**            | Delete an employee by ID                     |
| DELETE   | **/api/employee**                    | Delete all employees                         |
| GET      | **/api/employee/city/{cityName}**    | Get employees by city name                   |
| GET      | **/api/employee/age/{age}**          | Get employees by age                         |

## How to Use

To use the Employee CRUD API, you can use tools like Postman or any other REST client to interact with the endpoints.

## Examples

### Create a New Employee

**Endpoint**: `POST /api/employee`

**Example Request:**
```json
{
  "empName": "John Doe",
  "empCity": "New York",
  "empAge": 30,
  "empSalary": 50000
}
```

**Example Response:**

```json
[
  {
    "empId": 1,
    "empName": "John Doe",
    "empCity": "New York",
    "empAge": 30,
    "empSalary": 50000
  },
  {
    "empId": 4,
    "empName": "Michael Brown",
    "empCity": "Los Angeles",
    "empAge": 30,
    "empSalary": 52000
  }
]
```

**Get All Employees**

**Endpoint**: `GET /api/employee`

**Example Response**:

```json
[
  {
    "empId": 1,
    "empName": "John Doe",
    "empCity": "New York",
    "empAge": 30,
    "empSalary": 50000
  },
  {
    "empId": 4,
    "empName": "Michael Brown",
    "empCity": "Los Angeles",
    "empAge": 30,
    "empSalary": 52000
  }
]
```

**Get Employee by ID**

**Endpoint:** `GET /api/employee/{empId}`

**Example Request:** `GET /api/employee/1`

**Example Response:**

```json
{
  "empId": 1,
  "empName": "John Doe",
  "empCity": "New York",
  "empAge": 30,
  "empSalary": 50000
}
```

**Modify an Employee**

**Endpoint:** `PUT /api/employee/{empId}`

**Example Request:**

```json
{
  "empName": "John Doe",
  "empCity": "Chicago",
  "empAge": 31,
  "empSalary": 55000
}
```

**Example Response:**
```
Successfully modified the records of employee with id 1
```


**Delete Employee by ID**

**Endpoint**: `DELETE /api/employee/{empId}`

**Example Request:** `DELETE /api/employee/1`

**Example Response:**

```
Successfully Deleted Employee With Id 1
```


**Delete All Employees**

**Endpoint:** `DELETE /api/employee`

**Example Response:**

```
All records deleted!
```

**Get Employees by City**

**Endpoint:** `GET /api/employee/city/{cityName}`

**Example Request:** `GET /api/employee/city/New York`

**Example Response:**

```json
[
  {
    "empId": 1,
    "empName": "John Doe",
    "empCity": "New York",
    "empAge": 30,
    "empSalary": 50000
  },
  {
    "empId": 4,
    "empName": "Michael Brown",
    "empCity": "Los Angeles",
    "empAge": 30,
    "empSalary": 52000
  }
]
```

**Get Employees by Age**

**Endpoint:** `GET /api/employee/age/{age}`

**Example Request:** `GET /api/employee/age/30`

**Example Response:**

```json
[
  {
    "empId": 1,
    "empName": "John Doe",
    "empCity": "New York",
    "empAge": 30,
    "empSalary": 50000
  },
  {
    "empId": 4,
    "empName": "Michael Brown",
    "empCity": "Los Angeles",
    "empAge": 30,
    "empSalary": 52000
  }
]
```

**Contributor: [Bhavuk Jain](https://www.linkedin.com/in/jainbhavuk555/)** (Follow On LinkedIn)

**Thanks! :)**