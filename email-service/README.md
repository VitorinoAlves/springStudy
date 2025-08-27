# Spring Boot Email Service ✉️

This is a simple, lightweight email service developed using **Spring Boot** and **Maven**. The primary function of this application is to send emails using **Amazon Web Services (AWS) Simple Email Service (SES)**.

This project was created for educational purposes to demonstrate how to integrate AWS services into a modern Java application.

## 🌟 Features
* **Email Sending:** Core functionality to send emails.
* **AWS SES Integration:** Utilizes AWS SES for reliable and scalable email delivery.
* **RESTful API:** Exposes a simple REST endpoint for triggering email sends.

---

## 🛠️ Technologies Used
* **Java 17+**
* **Spring Boot 3.x**
* **Maven**
* **AWS SDK for Java**
* **Lombok**

---

## 📋 Prerequisites
Before you begin, ensure you have the following installed:

* **Java Development Kit (JDK) 17** or later
* **Maven 3.6.x** or later
* An **AWS Account** with access to AWS SES.
* **AWS CLI** configured with credentials that have permissions to send emails via SES.

---

## 📝 API Endpoints
The service exposes a single REST endpoint for sending emails.

| Method | Endpoint | Description | Request Body (Example) |
| :--- | :--- | :--- | :--- |
| **POST** | `/api/email` | Sends an email using SES | `{ "to": "recipient@example.com", "subject": "Test Email", "body": "Hello, world!" }` |