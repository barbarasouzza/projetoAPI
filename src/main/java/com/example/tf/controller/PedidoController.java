package com.example.tf.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.tf.DTO.PedidoDTO_GET;
import com.example.tf.domain.Pedido;
import com.example.tf.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController{

				@Autowired
				PedidoService pedidoService;

				@GetMapping
				public ResponseEntity<List<PedidoDTO_GET>> findAll() {
					List<PedidoDTO_GET> pedido = pedidoService.findAll();
					if(pedido.isEmpty()) {
					return  ResponseEntity.notFound().build();
					}
					return ResponseEntity.ok(pedido);
				
				}

				@GetMapping("/{id}")
				public ResponseEntity<Optional<Pedido>> findById(@PathVariable Long id) {
					Optional<Pedido> pedido = pedidoService.findById(id);
					if (!pedido.isPresent()) {
						return ResponseEntity.notFound().build();
					}
					return ResponseEntity.ok(pedido);
				}

				@PostMapping
				public ResponseEntity<Pedido> PostPedido(@Valid @RequestBody Pedido pedido) {
					Pedido pedidoTemp = pedidoService.PostPedido(pedido);
					URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getIdPedido())
							.toUri();
					if (pedidoTemp == null) {
						return ResponseEntity.notFound().build();
					}
					return ResponseEntity.created(uri).body(pedidoTemp);
				}

				@PutMapping("/{id}")
				public ResponseEntity<Optional<Pedido>> PutPedido(@Valid @RequestBody Pedido pedido, @PathVariable Long id) {

					Optional<Pedido> pedidoTemp = pedidoService.PutPedido(pedido, id);
					if (!pedidoTemp.isPresent()) {
						return ResponseEntity.notFound().build();
					}

					return ResponseEntity.ok(pedidoTemp);

				}

				@DeleteMapping("/{id}")
				public ResponseEntity<Void> delete(@PathVariable Long id) {
					if (pedidoService.Delete(id)) {
						return ResponseEntity.noContent().build();
					}
					return ResponseEntity.notFound().build();
				}
}
