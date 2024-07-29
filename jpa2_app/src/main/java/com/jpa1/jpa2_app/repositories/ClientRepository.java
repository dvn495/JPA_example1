package com.jpa1.jpa2_app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jpa1.jpa2_app.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long>{

}
