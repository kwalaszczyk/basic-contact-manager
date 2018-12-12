package com.walaszczyk.contactmanager.configuration;

import com.walaszczyk.contactmanager.domain.Contact;
import com.walaszczyk.contactmanager.domain.Role;
import com.walaszczyk.contactmanager.domain.User;
import com.walaszczyk.contactmanager.repository.ContactsRepository;
import com.walaszczyk.contactmanager.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Slf4j
public class LoadDatabase{
    private final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    @Profile("dev")
    CommandLineRunner initDatabase(ContactsRepository contactsRepository, UserRepository userRepository){
        return args -> {
            log.info("Preloading " + contactsRepository.save(new Contact("Jan", "Nowak", "665223111")));
            log.info("Preloading " + contactsRepository.save(new Contact("Jacek", "Kowal", "787878787")));
            log.info("Preloading " + contactsRepository.save(new Contact("Marek", "Paleta", "554338990")));
            log.info("Preloading " + contactsRepository.save(new Contact("John", "Doe", "887667555")));
            log.info("Preloading " + contactsRepository.save(new Contact("Kamil", "Twardowski", "887667555")));
            log.info("Preloading " + contactsRepository.save(new Contact("Krystian", "Kot", "66666666")));
            log.info("Preloading " + contactsRepository.save(new Contact("Natalia", "Ignaciuk", "123123123")));
            log.info("Preloading " + contactsRepository.save(new Contact("Marcin", "Jarosz", "7676776676")));
            log.info("Preloading " + contactsRepository.save(new Contact("Kamila", "Miła", "465356363")));
            log.info("Preloading " + contactsRepository.save(new Contact("Justyna", "Cywińska", "343434673")));
            log.info("Preloading " + contactsRepository.save(new Contact("Monika", "Polińska", "776767676")));
            log.info("Preloading " + userRepository.save(new User("K", "W", "xxx@xx.pl", encoder.encode("123456"), new ArrayList<>(Arrays.asList(Role.ROLE_ADMIN)))));
            log.info("Preloading " + userRepository.save(new User("N", "M", "test@test.pl", encoder.encode("123456"), new ArrayList<>(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_USER)))));
            log.info("Preloading " + userRepository.save(new User("Test", "Test", "t@test.pl", encoder.encode("aabbcc"), new ArrayList<>(Arrays.asList(Role.ROLE_USER)))));
        };
    }
}
