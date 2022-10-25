package com.example.tf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tf.DTO.ItemPedidoDTO_GET;
import com.example.tf.DTO.PedidoDTO_GET;
import com.example.tf.domain.ItemPedido;
import com.example.tf.domain.Pedido;
import com.example.tf.repository.ItemPedidoRepository;
import com.example.tf.repository.PedidoRepository;

@Service
public class PedidoService {
		
		@Autowired
		PedidoRepository pedidoRepository;
		@Autowired
		ItemPedidoRepository itemPedidoRepository;

		public List<PedidoDTO_GET> findAll() {
			List<Pedido> pedido = pedidoRepository.findAll();
			List<PedidoDTO_GET> pedidoDTO_GET = new ArrayList<>();
			List<ItemPedido> itemPedido = itemPedidoRepository.findAll();		
			List<ItemPedidoDTO_GET> itemPedidoTemp = new ArrayList<>();		
			
			for (Pedido pedidoTemp : pedido) {
				for(ItemPedido i : itemPedido) {
					if(i.getPedido().getIdPedido() == pedidoTemp.getIdPedido()) {

						itemPedidoTemp.add(new ItemPedidoDTO_GET(i));
					}
				}
				
				pedidoDTO_GET.add(new PedidoDTO_GET(pedidoTemp, itemPedidoTemp));
			}
			
			return pedidoDTO_GET;
		}

		public Optional<Pedido> findById(Long id) {
			return pedidoRepository.findById(id);
		}

		@Transactional
		public Pedido PostPedido(Pedido pedido) {
//			Optional<Pedido> pedidoTemp = PedidoRepository.findByNome(pedido.getNomePedido());
//			if (pedidoTemp.isPresent()) {
//				return null;
//			}

			pedidoRepository.save(pedido);
			return pedido;
		}

		public Optional<Pedido> PutPedido(Pedido pedido, Long id) {
			Optional<Pedido> pedidoTemp = pedidoRepository.findById(id);
			if (pedidoTemp.isPresent()) {
				pedido.setIdPedido(id);
				pedido = pedidoRepository.save(pedido);
				return Optional.ofNullable(pedido);
			}
			return null;
		}

		public Boolean Delete(Long id) {
			Optional<Pedido> pedidoTemp = pedidoRepository.findById(id);
			if (!pedidoTemp.isPresent()) {
				return false;
			}
			pedidoRepository.deleteById(id);
			return true;
		}
}
