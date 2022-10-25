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

import com.example.tf.domain.ItemPedido;
import com.example.tf.service.ItemPedidoService;

@RestController
@RequestMapping("/api/ItemPedido")
public class ItemPedidoController {

				@Autowired
				ItemPedidoService itemPedidoService;

				@GetMapping
				public ResponseEntity<List<ItemPedido>> findAll() {
					return ResponseEntity.ok(itemPedidoService.findAll()); 
				}

				@GetMapping("/{id}")
				public ResponseEntity<Optional<ItemPedido>> findById(@PathVariable Long id) {
					Optional<ItemPedido> itemPedido = itemPedidoService.findById(id);
					if (!itemPedido.isPresent()) {
						return ResponseEntity.notFound().build();
					}
					return ResponseEntity.ok(itemPedido);
				}

				@PostMapping
				public ResponseEntity<ItemPedido> PostItemPedido(@Valid @RequestBody ItemPedido itemPedido) {
					ItemPedido itemPedidoTemp = itemPedidoService.PostItemPedido(itemPedido);
					URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(itemPedido.getIdItemPedido())
							.toUri();
					if (itemPedidoTemp == null) {
						return ResponseEntity.notFound().build();
					}
					return ResponseEntity.created(uri).body(itemPedidoTemp);
				}

				@PutMapping("/{id}")
				public ResponseEntity<Optional<ItemPedido>> PutItemPedido(@Valid @RequestBody ItemPedido itemPedido, @PathVariable Long id) {

					Optional<ItemPedido> itemPedidoTemp = itemPedidoService.PutItemPedido(itemPedido, id);
					if (!itemPedidoTemp.isPresent()) {
						return ResponseEntity.notFound().build();
					}
					return ResponseEntity.ok(itemPedidoTemp);

				}

				@DeleteMapping("/{id}")
				public ResponseEntity<Void> delete(@PathVariable Long id) {
					if (itemPedidoService.Delete(id)) {
						return ResponseEntity.noContent().build();
					}
					return ResponseEntity.notFound().build();
				}
		}
