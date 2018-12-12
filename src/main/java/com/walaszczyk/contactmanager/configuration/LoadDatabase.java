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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@Slf4j
public class LoadDatabase{
    private final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    @Profile("dev")
    CommandLineRunner initDatabase(ContactsRepository contactsRepository, UserRepository userRepository){
        return args -> {
            Set<Contact> set = new HashSet<>();
            Set<Contact> set2 = new HashSet<>();
            Set<Contact> set3 = new HashSet<>();
            set.add(new Contact("Jan", "Nowak", "665223111"));
            set.add(new Contact("Jacek", "Kowal", "787878787"));
            set2.add(new Contact("Marek", "Paleta", "554338990"));
            set2.add(new Contact("John", "Doe", "887667555"));
            set2.add(new Contact("Kamil", "Twardowski", "887667555"));
            set2.add(new Contact("Krystian", "Kot", "66666666"));
            set3.add(new Contact("Natalia", "Ignaciuk", "123123123"));
            set3.add(new Contact("Marcin", "Jarosz", "7676776676"));
            set3.add(new Contact("Kamila", "Miła", "465356363"));
            set3.add(new Contact("Justyna", "Cywińska", "343434673"));
            set3.add(new Contact("Monika", "Polińska", "776767676"));
            set3.add(new Contact("Jan", "Nowak", "665223111"));
            set3.add(new Contact("Jacek", "Kowal", "787878787"));
            log.info("Preloading " + userRepository.save(new User("K", "W", "xxx@xx.pl", encoder.encode("123456"), new ArrayList<>(Arrays.asList(Role.ROLE_ADMIN)), set)));
            log.info("Preloading " + userRepository.save(new User("N", "M", "test@test.pl", encoder.encode("123456"), new ArrayList<>(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_USER)), set2)));
            log.info("Preloading " + userRepository.save(new User("Test", "Test", "t@test.pl", encoder.encode("aabbcc"), new ArrayList<>(Arrays.asList(Role.ROLE_USER)), set3)));
            log.info("Preloading " + userRepository.save(new User("Test", "Test", "teest@test.pl", encoder.encode("111111"), new ArrayList<>(Arrays.asList(Role.ROLE_USER)), null)));
        };
    }
}
