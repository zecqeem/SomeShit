# 🔐 Secure IMDb Parser & Exporter Web App

A Spring Boot web application that securely parses the **Top 25 movies from IMDb**, stores them in a PostgreSQL database, and allows users to download them as **Excel files**, including an **AES-encrypted version**. The application includes user authentication with password policies, login attempt tracking, and full access logging.

---

## 🚀 Features

- 🔎 Parse IMDb Top 25 movies using **Jsoup**
- 🗃️ Store movie data in **PostgreSQL**
- 📥 Download as standard **Excel file**
- 🔐 Optionally download **AES-encrypted Excel** file
- ✅ User **password rotation**
- 📊 **Logging of login attempts** 
- 🔒 Password hashing + entropy check for complexity

---

## 🧠 Technologies Used

- Java 17
- Spring Boot
- Spring Security
- PostgreSQL
- Jsoup (HTML parsing)
- Apache POI (Excel generation)
- AES (Java `javax.crypto` encryption)
- Maven

---

### 📦 Prerequisites

- Java 17+
- Maven
- PostgreSQL

---


## ⬇️ Download

You can download the latest prebuilt `.jar` file from the [Releases](https://github.com/zecqeem/SomeShit/releases) section.

To run:

```bash
java -jar bruteforceauth-0.0.1-SNAPSHOT.jar

---

## 🔐 Default Login Credentials

> Use these credentials to log in and access the application:
Username: admin
Password: b_L@&5HFP”6:akbE


