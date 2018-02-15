package be.mdc.arrowstar.mapper;

import be.mdc.arrowstar.domain.Product;
import be.mdc.arrowstar.dto.ImmutableProductDTO;
import be.mdc.arrowstar.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

	public ProductDTO productToProductDto(Product product) {
		return ImmutableProductDTO.builder()
				.id(product.getId())
				.naam(product.getNaam())
				.prijsLid(product.getPrijsLid())
				.prijsGast(product.getPrijsGast())
				.isZichtbaar(product.isZichtbaar())
				.aangemaaktOp(product.getAangemaaktOp())
				.sortOrder(product.getSortOrder())
				.build();
	}

}
