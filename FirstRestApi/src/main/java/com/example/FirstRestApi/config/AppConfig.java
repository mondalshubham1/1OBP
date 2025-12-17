package com.example.FirstRestApi.config;

import com.example.FirstRestApi.repository.DoctorRepository;
import com.example.FirstRestApi.repository.NewRepo;
import com.example.FirstRestApi.repository.NewRepo1;
import com.example.FirstRestApi.service.DoctorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public DoctorService createDoctorService(DoctorRepository doctorRepository) {
        System.out.println("createDoctorService is called");
        return new DoctorService(doctorRepository);
    }

    @Bean
    public DoctorRepository createDoctorRepository() {
        System.out.println("createDoctorRepository is called");
        return new DoctorRepository();
    }

    @Bean
    public NewRepo newDoctorRepo() {
        System.out.println("newrepo is called");
        DoctorRepository repo = createDoctorRepository();
        System.out.println("Manual repo hash = " + System.identityHashCode(repo));
        return new NewRepo(repo);
    }

    @Bean
    public NewRepo1 newDoctorRepo1() {
        System.out.println("newrepo is called");
        DoctorRepository repo = createDoctorRepository();
        System.out.println("Manual repo hash = " + System.identityHashCode(repo));
        return new NewRepo1(repo);
    }

}
