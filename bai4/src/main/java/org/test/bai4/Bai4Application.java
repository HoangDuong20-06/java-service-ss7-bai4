package org.test.bai4;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;
import org.test.bai4.aspect.GlobalExceptionHandler;
import org.test.bai4.exception.ResourceNotFoundException;
import org.test.bai4.service.TestService;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Bai4Application {

    public static void main(String[] args) {
        SpringApplication.run(Bai4Application.class, args);
    }
    @Bean
    public CommandLineRunner runner(TestService service, GlobalExceptionHandler exceptionHandler) {
        return args -> {
            try {
                service.findData();
            } catch (ResourceNotFoundException ex) {
                ResponseEntity<?> response = exceptionHandler.handleResourceNotFound(ex);

                System.out.println("\n>>> KẾT QUẢ TỪ GLOBAL EXCEPTION HANDLER:");
                System.out.println("Status Code: " + response.getStatusCode());
                System.out.println("Body JSON: " + response.getBody());
            }
        };
    }
}
