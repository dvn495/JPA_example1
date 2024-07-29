package com.jpa1.jpa2_app;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa1.jpa2_app.entities.Address;
import com.jpa1.jpa2_app.entities.Client;
import com.jpa1.jpa2_app.repositories.ClientRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Jpa2AppApplication {
	@Autowired
	ClientRepository clientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Jpa2AppApplication.class, args);
	}

	@Transactional
	public void OneToManyFindById() {
		

		Optional<Client> optionalClient = clientRepository.findById(2L);
		optionalClient.ifPresent(client -> {
			Address address1 = new Address("Direccion cliente A", 1234);
			Address address2 = new Address("Direccion cliente b", 9875);

			client.setAddresses(Arrays.asList(address1, address2));
			
			clientRepository.save(client);
			
			System.out.println(client);

		});
	}

}
