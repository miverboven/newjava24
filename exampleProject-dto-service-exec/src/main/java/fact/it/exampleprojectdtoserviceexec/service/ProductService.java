package fact.it.exampleprojectdtoserviceexec.service;

import fact.it.exampleprojectdtoserviceexec.dto.ProductRequestDTO;
import fact.it.exampleprojectdtoserviceexec.dto.ProductResponseDTO;
import fact.it.exampleprojectdtoserviceexec.util.ProductMapper;
import fact.it.exampleprojectdtoserviceexec.util.ValidationException;
import fact.it.exampleprojectdtoserviceexec.util.NotFoundException;
import fact.it.exampleprojectdtoserviceexec.model.Product;
import fact.it.exampleprojectdtoserviceexec.repository.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponseDTO> findAll() {
        final List<Product> products = productRepository.findAll(Sort.by("id"));
        return products.stream()
                .map(product -> ProductMapper.mapToProductResponseDTO(product, new ProductResponseDTO()))
                .toList();
    }

    public ProductResponseDTO get(Long id) {
        return productRepository.findById(id)
                .map(product -> ProductMapper.mapToProductResponseDTO(product, new ProductResponseDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(ProductRequestDTO productRequestDTO) {
        // Check if the barcode already exists
        if (barcodeExists(productRequestDTO.getBarcode())) {
            throw new ValidationException("A product with the same barcode already exists.");
        }
        final Product product = new Product();
        ProductMapper.mapToProductEntity(productRequestDTO, product);
        return productRepository.save(product).getId();
    }


    public void update( Long id, ProductRequestDTO productRequestDTO) {
        final Product product = productRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        // Check if the new barcode already exists and it's not the current product's barcode
        if (!product.getBarcode().equalsIgnoreCase(productRequestDTO.getBarcode()) && barcodeExists(productRequestDTO.getBarcode())) {
            throw new ValidationException("A product with the same barcode already exists.");
        }

        ProductMapper.mapToProductEntity(productRequestDTO, product);
        productRepository.save(product);
    }


    public void delete( Long id) {
        productRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        productRepository.deleteById(id);
    }


    public boolean barcodeExists(final String barcode) {
        return productRepository.existsByBarcodeIgnoreCase(barcode);
    }

}