package app.nanaBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*
 * @EnableJpaAuditing is used to enable JPA auditing features
 * It allows us to automatically populate fields 
 * like createdAt, updatedAt, createdBy, and updatedBy in our entities
 * This is particularly useful for tracking
 * The  auditorAwareRef = "auditAwareImpl" specifies the bean name of the AuditorAware implementation
 */
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
