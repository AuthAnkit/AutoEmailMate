package com.AutoEmailMate.eg.Service.ServiceImpl;

import com.AutoEmailMate.eg.DTO.RecuriterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageGeneratorService {
    public String generateMessage(RecuriterDTO recruiter){

        return """
        Hello %s,

        I hope you are doing well.

        My name is Ankit Singh, and I am a final-year Integrated MCA student
        specializing in Java Backend Development. I am currently looking for
        Java Developer / Backend Developer opportunities, including full-time
        roles and internships with PPO opportunities.

        I have hands-on experience building backend applications using Java,
        Spring Boot, Spring Security, REST APIs, PostgreSQL, JPA/Hibernate,
        JWT Authentication, Docker, and Git.

        I have developed backend systems including ERP applications, SaaS
        platforms, and automation solutions involving REST API development,
        database design, authentication, file processing, and third-party
        integrations.

        I am particularly interested in backend engineering roles where I can
        contribute to real-world software development while continuously
        improving my technical skills.

        I would appreciate it if you could consider my profile for any suitable
        Java Developer, Backend Developer, or Software Engineer openings at %s.

        I have attached my resume for your reference. I would be grateful for
        an opportunity to discuss how my skills and projects can contribute
        to your team.

        Thank you for your time and consideration.

        Regards,
        Ankit Singh
        """.formatted(
                recruiter.getName(),
                recruiter.getCompany()
        );
    }

    public String GenMessWithoutDetails(){
        return """
            Hello Hiring Team,

            I hope you are doing well.

            My name is Ankit Singh, and I am a final-year Integrated MCA student
            specializing in Java Backend Development. I am currently looking for
            Java Developer / Backend Developer opportunities, including full-time
            roles and internship opportunities with PPO potential.

            I have hands-on experience building backend applications using Java,
            Spring Boot, Spring Security, REST APIs, PostgreSQL, JPA/Hibernate,
            JWT Authentication, Docker, and Git.

            During my development journey, I have built backend systems including
            ERP applications, SaaS platforms, and automation solutions involving
            REST API development, database design, authentication, file processing,
            and third-party integrations.

            I am passionate about backend engineering and enjoy designing clean,
            maintainable APIs while continuously improving my understanding of
            software development practices.

            I would appreciate it if you could consider my profile for any suitable
            Java Developer, Backend Developer, or Software Engineer opportunities
            available within your organization.

            I have attached my resume for your reference. I would be grateful for
            an opportunity to discuss how my skills and projects can contribute
            to your team.

            Thank you for your time and consideration.

            Regards,
            Ankit Singh
            """;
    }
}
