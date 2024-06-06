## Email Sander

Email Sender is an application written in Java using Domain-Driven Design concepts, responsible for sending emails.
<br>
<br>
The application uses MongoDB for efficient database querying and management.
<br>
<br>
Kafka and REST are leveraged for efficient data input.
<br>
<br>


## Technologies Used
- Java 21
- Spring
- Spring Boot
- MongoDB
- Kafka
- Docker

## Prerequisites

- Java 21
- Maven (for building the project)
- Docker (to run MongoDB)

## How to Run the Project

1. Clone the repository:
    ```bash
    git clone https://github.com/justynapalacz/wsbEmailSender
    ```

2. Navigate to the docker directory:
    ```bash
    cd docker
    ```

3. Download containers:
   ```bash
   docker-compose up
   ```

4. Run containers:
   ```
   MongoDB
   ```

5. Update fields in application.properties:
  ``` 
 email.username, email.properties.mail.smtp.starttls.required, email.host, email.por,
 email.password, email.properties.mail.smtp.auth, email.properties.mail.transport.protocol,
 email.properties.mail.smtp.starttls.enable
   ```

6. Navigate to the project directory:
    ```bash
    cd EmailSender
    ```

7. Build the project:
    ```bash
    mvn clean install
    ```

8. Run application in IntelliJ.
