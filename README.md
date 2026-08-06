# AutoEmailMate - Personalized Email Automation Platform

AutoEmailMate is a Spring Boot based backend application that automates the process of sending personalized emails to multiple recipients using CSV data.

The application allows users to upload recruiter details through a CSV file, generate customized emails based on recruiter and company information, and automatically send emails with resume attachments using SMTP.

The main goal of this project is to simplify job application outreach by reducing repetitive manual email writing and sending.

--------------------------------------------------

FEATURES

1. CSV Based Recruiter Management

- Upload recruiter details using CSV files.
- Extract recruiter information:
    - Company Name
    - Recruiter Name
    - Designation
    - Email Address

- Convert CSV records into structured DTO objects.


2. Personalized Email Generation

AutoEmailMate generates customized emails for every recruiter.

The email content is personalized using:

- Recruiter Name
- Company Name
- Designation

Example:

Hello Rahul,

I hope you are doing well.

My name is Ankit Singh, and I am a fresher Java Backend Developer currently looking for opportunities.

I have experience with Java, Spring Boot, REST APIs, PostgreSQL, Spring Security, JWT Authentication, Docker and Git.

I would appreciate the opportunity to discuss suitable roles where I can contribute and grow with your team.

Regards,
Ankit Singh


3. Resume Attachment Support

- Upload resume files through API.
- Attach PDF resume automatically with emails.
- Uses MimeMessage and MimeMessageHelper for multipart email support.


4. Bulk Email Sending

- Processes multiple recruiter records from CSV.
- Generates unique emails for each recruiter.
- Sends emails automatically using SMTP.


--------------------------------------------------

TECH STACK

Backend:

- Java
- Spring Boot
- Spring Web
- JavaMailSender
- Maven


Libraries:

- OpenCSV
- Lombok


Tools:

- IntelliJ IDEA
- Postman
- Git
- GitHub
- Gmail SMTP


--------------------------------------------------

SYSTEM ARCHITECTURE


Client

    |
    |
    v

EmailController

    |
    |
    v

BulkEmailService

    |
    |-------------------------|
    |                         |
    v                         v

CsvService          MessageGeneratorService

    |                         |
    v                         v

RecruiterDTO        Personalized Email Content

              |
              |
              v

        EmailService

              |
              |
              v

       JavaMailSender

              |
              |
              v

          SMTP Server

              |
              |
              v

       Recipient Inbox



--------------------------------------------------

PROJECT STRUCTURE


AutoEmailMate

src/main/java/com/AutoEmailMate/eg


Controller

    - EmailController


DTO

    - RecruiterDTO


Service

    - EmailService

    ServiceImpl

        - CsvService
        - BulkEmailService
        - MessageGeneratorService


Model

Repository

Config


--------------------------------------------------

APPLICATION FLOW


Step 1: Upload CSV File

User uploads recruiter CSV containing:

Company
Name
Designation
Email


Example:

Google,Rahul,HR Manager,rahul@gmail.com

Amazon,Priya,Recruiter,priya@gmail.com


--------------------------------------------------


Step 2: CSV Processing

CsvService reads CSV using OpenCSV.

Each row is converted into:

RecruiterDTO


Example:

RecruiterDTO(
    company,
    name,
    designation,
    email
)


--------------------------------------------------


Step 3: Generate Personalized Email

MessageGeneratorService creates customized messages.

The generated email contains:

- Recruiter name
- Company name
- Developer profile
- Technical skills
- Job interest


--------------------------------------------------


Step 4: Send Email

EmailService uses:

JavaMailSender

along with:

MimeMessage
MimeMessageHelper


to send:

- Personalized email content
- Resume attachment


--------------------------------------------------

API DOCUMENTATION


1. Send Bulk Emails


Endpoint:

POST /email/send-bulk


Request Type:

multipart/form-data


Parameters:


csv

Type:
File

Description:
Recruiter CSV file



resume

Type:
File

Description:
Resume PDF file



subject

Type:
String

Description:
Email subject



Example:

csv:
recruiters.csv


resume:
AnkitResume.pdf


subject:
Application for Java Backend Developer Opportunity



Response:

Bulk emails sent successfully


--------------------------------------------------

CONFIGURATION


SMTP configuration is added in:

application.properties


Example:


spring.mail.host=smtp.gmail.com

spring.mail.port=587

spring.mail.username=your-email@gmail.com

spring.mail.password=your-app-password

spring.mail.properties.mail.smtp.auth=true

spring.mail.properties.mail.smtp.starttls.enable=true



--------------------------------------------------

SECURITY NOTES


- Gmail App Password is used for SMTP authentication.
- SMTP credentials should never be pushed to GitHub.
- Sensitive information should be stored using environment variables.


--------------------------------------------------

TESTING


The application was tested using Postman.


Tested scenarios:

- Sending normal emails
- Sending emails with attachments
- Uploading CSV files
- Processing multiple recruiter records
- Generating personalized emails


--------------------------------------------------

FUTURE IMPROVEMENTS


1. Email Tracking

Store:

- Recipient email
- Email status
- Sent timestamp
- Failure reason


2. Asynchronous Processing

Implement:

- Spring @Async
- RabbitMQ
- Kafka


for handling large email campaigns.


3. Email Templates

Allow users to create reusable email templates.


4. Dashboard

Add UI for:

- Uploading CSV
- Managing campaigns
- Tracking sent emails
- Viewing failures


--------------------------------------------------

LEARNING OUTCOMES


Through this project, I learned:

- Spring Boot REST API development
- Multipart file handling
- CSV parsing using OpenCSV
- SMTP email integration
- JavaMailSender usage
- MIME based email attachments
- DTO based architecture
- Service layer design


--------------------------------------------------

AUTHOR


Ankit Singh

Java Backend Developer


Skills:

Java
Spring Boot
REST APIs
PostgreSQL
Docker
Git
