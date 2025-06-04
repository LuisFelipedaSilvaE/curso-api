package org.example.api.config;

import org.example.api.domain.User; // Mantenha os seus imports de domínio e repositório
import org.example.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner; // 1. IMPORTE CommandLineRunner
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local") // Verifique se "Local" é o nome exato do seu perfil ativo
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean // 2. A anotação @Bean continua aqui
    public CommandLineRunner startDB() { // 3. O MÉTODO AGORA RETORNA CommandLineRunner
        // 4. O MÉTODO AGORA RETORNA UMA EXPRESSÃO LAMBDA (que é uma implementação de CommandLineRunner)
        return args -> {
            // 5. TODA A SUA LÓGICA DE INICIALIZAÇÃO VAI AQUI DENTRO DA LAMBDA
            User u1 = new User(null, "Jonathan", "jona@gmail.com", "J0J0");
            User u2 = new User(null, "Joseph", "jose@gmail.com", "J0J0");
            User u3 = new User(null, "Jotaro", "jota@gmail.com", "J0J0");

            repository.saveAll(List.of(u1, u2, u3));

            System.out.println("--- DADOS DE TESTE CARREGADOS NO BANCO (PERFIL LOCAL) ---"); // Opcional: log para confirmar
        };
    }
}