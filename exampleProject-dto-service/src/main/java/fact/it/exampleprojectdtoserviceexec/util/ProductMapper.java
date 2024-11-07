package fact.it.exampleprojectdtoserviceexec.util;

import fact.it.exampleprojectdtoserviceexec.dto.ProductRequestDTO;
import fact.it.exampleprojectdtoserviceexec.dto.ProductResponseDTO;
import fact.it.exampleprojectdtoserviceexec.model.Product;

public class ProductMapper {

    public static ProductResponseDTO mapToProductResponseDTO(Product product, ProductResponseDTO productResponseDTO) {
        productResponseDTO.setId(product.getId());
        productResponseDTO.setBarcode(product.getBarcode());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        return productResponseDTO;
    }

    public static Product mapToProductEntity(ProductRequestDTO productRequestDTO, Product product) {
        product.setBarcode(productRequestDTO.getBarcode());
        product.setName(productRequestDTO.getName());
        product.setPrice(productRequestDTO.getPrice());
        product.setPurchaseCost(productRequestDTO.getPurchaseCost());
        return product;
    }

}
