package com.example.tf.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tf.domain.ItemPedido;
import com.example.tf.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
			
			@Autowired
			ItemPedidoRepository itemPedidoRepository;

			public List<ItemPedido> findAll() {
				return itemPedidoRepository.findAll();
			}

			public Optional<ItemPedido> findById(Long id) {
				return itemPedidoRepository.findById(id);
			}

			@Transactional
			public ItemPedido PostItemPedido(ItemPedido ItemPedido) {
//				Optional<ItemPedido> ItemPedidoTemp = ItemPedidoRepository.findByNome(ItemPedido.getNomeItemPedido());
//				if (ItemPedidoTemp.isPresent()) {
//					return null;
//				}
				itemPedidoRepository.save(ItemPedido);
				return ItemPedido;
			}

			public Optional<ItemPedido> PutItemPedido(ItemPedido itemPedido, Long id) {
				Optional<ItemPedido> itemPedidoTemp = itemPedidoRepository.findById(id);
				if (itemPedidoTemp.isPresent()) {
					itemPedido.setIdItemPedido(id);
					itemPedidoRepository.save(itemPedido);
					return Optional.ofNullable(itemPedido);
				}
				return null;
			}

			public Boolean Delete(Long id) {
				Optional<ItemPedido> itemPedidoTemp = itemPedidoRepository.findById(id);
				if (!itemPedidoTemp.isPresent()) {
					return false;
				}
				itemPedidoRepository.deleteById(id);
				return true;
			}
	}

