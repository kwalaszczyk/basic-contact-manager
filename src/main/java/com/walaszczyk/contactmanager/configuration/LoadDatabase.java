package com.walaszczyk.contactmanager.configuration;

import com.walaszczyk.contactmanager.domain.Contact;
import com.walaszczyk.contactmanager.repository.ContactsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    @Profile("dev")
    CommandLineRunner initDatabase(ContactsRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new Contact("Jan", "Nowak", "665223111")));
            log.info("Preloading " + repository.save(new Contact("Jacek", "Kowal", "787878787")));
            log.info("Preloading " + repository.save(new Contact("Marek", "Paleta", "554338990")));
            log.info("Preloading " + repository.save(new Contact("John", "Doe", "887667555")));
            log.info("Preloading " + repository.save(new Contact("Kamil", "Twardowski", "887667555")));
            log.info("Preloading " + repository.save(new Contact("Krystian", "Kot", "66666666")));
            log.info("Preloading " + repository.save(new Contact("Natalia", "Ignaciuk", "123123123")));
            log.info("Preloading " + repository.save(new Contact("Marcin", "Jarosz", "7676776676")));
            log.info("Preloading " + repository.save(new Contact("Kamila", "Miła", "465356363")));
            log.info("Preloading " + repository.save(new Contact("Justyna", "Cywińska", "343434673")));
            log.info("Preloading " + repository.save(new Contact("Monika", "Polińska", "776767676")));
        };
    }
}
