package ru.kondrashkov.demo
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class DemoApplication {

	static void main(String[] args) {
		SpringApplication.run(DemoApplication, args)
	}
}
