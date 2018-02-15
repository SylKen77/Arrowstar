package be.mdc.arrowstar.controller;

import be.mdc.arrowstar.command.DeleteProductCommand;
import be.mdc.arrowstar.command.UpdateProductCommand;
import be.mdc.arrowstar.dto.ProductDTO;
import be.mdc.arrowstar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import be.mdc.arrowstar.command.CreateProductCommand;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired private ProductService productService;

	@GetMapping
	public List<ProductDTO> getProducten() {
		return productService.getAlleProducten().sorted(Comparator.comparing(ProductDTO::getSortOrder)).collect(Collectors.toList());
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.OK)
	public void createProduct(@RequestBody CreateProductCommand createProductCommand) {
		productService.createProduct(createProductCommand);
	}

	@PostMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public void updateProduct(@RequestBody UpdateProductCommand updateProductCommand) {
		productService.updateProduct(updateProductCommand);
	}

	@PostMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public void deleteProduct(@RequestBody DeleteProductCommand deleteProductCommand) {
		productService.deleteProduct(deleteProductCommand);
	}

}
