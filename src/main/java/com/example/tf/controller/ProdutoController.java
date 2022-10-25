package com.example.tf.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.tf.DTO.ProdutoDTO;
import com.example.tf.domain.Foto;
import com.example.tf.domain.Produto;
import com.example.tf.service.FotoService;
import com.example.tf.service.ProdutoService;



@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private FotoService fotoService;
//	@Autowired
//	private FotoRepository fotoRepository;



	@GetMapping("/{id}/foto")
	public ResponseEntity<byte[]> buscarFoto(@PathVariable Long id) {
		Foto foto = fotoService.buscarPorIdProduto(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", foto.getTipo());
		headers.add("Content-length", String.valueOf(foto.getDados().length));
		return new ResponseEntity<>(foto.getDados(), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ProdutoDTO buscar(@PathVariable Long id) {
		return produtoService.buscar(id);
	}

	@PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ProdutoDTO inserir(@RequestPart MultipartFile file, @RequestPart Produto produto) throws IOException {
		return produtoService.inserir(produto, file);
	}

	
	@GetMapping
	public List<ProdutoDTO> listar() {
		return produtoService.findAll();
	}


//	@PostMapping
//	public ResponseEntity<Produto> PostProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
//		Produto produtoTemp = produtoService.PostProduto(produtoDTO);
//		if (produtoTemp == null) {
//			return ResponseEntity.notFound().build();
//		}
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(produtoTemp.getIdProduto()).toUri();
//		return ResponseEntity.created(uri).body(produtoTemp);
//	}

	@PutMapping("/{id}")
	public ResponseEntity<Optional<Produto>> PutProduto(@Valid @RequestBody ProdutoDTO produtoDTO,
			@PathVariable Long id) {
		Optional<Produto> produtoTemp = produtoService.PutProduto(produtoDTO, id);
		if (!produtoTemp.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(produtoTemp);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (produtoService.Delete(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}