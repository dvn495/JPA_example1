package com.jpa1.jpa1_app;


import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa1.jpa1_app.entities.Person;
import com.jpa1.jpa1_app.repositories.PersonRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Jpa1AppApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(Jpa1AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Person> persons = (List<Person>) personRepository.findAll();
		persons.stream().forEach(person -> System.out.println(person));
		create();
		findById();
	}

	@Transactional
	public void findById() {
		Scanner scanner = new Scanner(System.in);
    	try {
        	System.out.println("Ingrese el id:");

        	// Verificar si la entrada es un Long válido
        	if (scanner.hasNextLong()) {
            	Long id = scanner.nextLong();
            	Optional<Person> searchPerson = personRepository.findOne(id);

            	if (searchPerson.isPresent()) {
                	System.out.println("Persona encontrada: " + searchPerson.get());
            	} else {
                	System.out.println("No se encontró ninguna persona con el id proporcionado.");
            	}
        	} else {
            	System.out.println("Entrada no válida. Por favor, ingrese un número válido.");
        	}
    	} catch (InputMismatchException e) {
        	System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
    	} catch (NoSuchElementException e) {
    		System.out.println("Error al leer la entrada.");
		} finally {
    		scanner.close(); // Cerrar el scanner en el bloque finally
		}
	}

	@Transactional
	public void create() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el nombre");
		String name = scanner.nextLine();
		System.out.println("Ingrese el apellido");
		String lastname = scanner.nextLine();
		System.out.println("Ingrese el lenguaje de programacion");
		String programmingLanguage = scanner.nextLine();
		scanner.close();

		Person person = new Person(null, name, lastname, programmingLanguage);

		Person personNew = personRepository.save(person);
		System.out.println(personNew);

		personRepository.findById(personNew.getId()).ifPresent(System.out::println);
	}

}
