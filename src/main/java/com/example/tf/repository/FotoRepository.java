package com.example.tf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tf.domain.Foto;
import com.example.tf.domain.Produto;

@Repository
public interface FotoRepository extends JpaRepository<Foto,Long>{
	public Optional<Foto> findByProduto(Produto produto);
	
}
