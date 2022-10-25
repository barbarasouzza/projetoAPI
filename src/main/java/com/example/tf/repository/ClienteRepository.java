package com.example.tf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tf.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByEmailCliente(String emailCliente);

	Cliente findByCpfCliente(String cpfCliente);

	
}
