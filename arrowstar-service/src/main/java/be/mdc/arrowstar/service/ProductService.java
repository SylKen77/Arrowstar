package be.mdc.arrowstar.service;

import be.mdc.arrowstar.command.DeleteProductCommand;
import be.mdc.arrowstar.command.UpdateProductCommand;
import be.mdc.arrowstar.domain.Product;
import be.mdc.arrowstar.dto.ProductDTO;
import be.mdc.arrowstar.mapper.ProductMapper;
import be.mdc.arrowstar.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.mdc.arrowstar.command.CreateProductCommand;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Service
@Transactional
public class ProductService {

	@Autowired private ProductRepository productRepository;
	@Autowired private ProductMapper productMapper;

	public Stream<ProductDTO> getAlleProducten() {
		return productRepository.streamAll().map(productMapper::productToProductDto);
	}

	public void createProduct(CreateProductCommand createProductCommand) {
		productRepository.save(new Product(createProductCommand.getNaam(), createProductCommand.getPrijsLid(), createProductCommand.getPrijsGast(), createProductCommand.isZichtbaar(), createProductCommand.getSortOrder()));
	}

	public void updateProduct(UpdateProductCommand updateProductCommand) {
		Product product = productRepository.findOne(updateProductCommand.getId());
		product.setNaam(updateProductCommand.getNaam());
		product.setPrijsLid(updateProductCommand.getPrijsLid());
		product.setPrijsGast(updateProductCommand.getPrijsGast());
		product.setZichtbaar(updateProductCommand.isZichtbaar());
		product.setSortOrder(updateProductCommand.getSortOrder());
	}

	public void deleteProduct(DeleteProductCommand deleteProductCommand) {
		Product product = productRepository.findOne(deleteProductCommand.getId());
		product.setVerwijderdOp(LocalDateTime.now());
	}

}
