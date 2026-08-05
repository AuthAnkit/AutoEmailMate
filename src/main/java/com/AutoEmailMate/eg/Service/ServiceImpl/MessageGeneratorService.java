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

                My name is Ankit Singh, and I am a fresher Java Backend Developer
                currently looking for opportunities to begin my professional journey
                in software development.

                I am particularly interested in backend development and have been
                actively building projects using Java, Spring Boot, REST APIs,
                PostgreSQL, Spring Security, JWT Authentication, Docker, and Git.

                During my learning journey, I have worked on backend applications
                involving API development, database design, authentication,
                file processing, and email automation systems. I enjoy designing
                scalable backend solutions and continuously improving my knowledge
                of Java and software engineering practices.

                I am interested in exploring backend development opportunities
                at %s and would be grateful if you could consider my profile for
                any suitable Java Developer / Backend Developer roles or internship
                opportunities.

                I have attached my resume for your reference. I would appreciate
                the opportunity to discuss how I can contribute and grow with your
                team.

                Thank you for your time and consideration.

                Regards,
                Ankit Singh
                """.formatted(
                recruiter.getName(),
                recruiter.getCompany()
        );
    }
}
