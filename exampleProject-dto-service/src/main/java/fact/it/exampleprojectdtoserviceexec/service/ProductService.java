package fact.it.exampleprojectdtoserviceexec.service;

import fact.it.exampleprojectdtoserviceexec.dto.ProductRequestDTO;
import fact.it.exampleprojectdtoserviceexec.dto.ProductResponseDTO;
import fact.it.exampleprojectdtoserviceexec.model.Product;
import fact.it.exampleprojectdtoserviceexec.repository.ProductRepository;
import fact.it.exampleprojectdtoserviceexec.util.ProductMapper;
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
                .get();
    }

    public Long create(ProductRequestDTO productRequestDTO) {
        final Product product = new Product();
        ProductMapper.mapToProductEntity(productRequestDTO, product);
        return productRepository.save(product).getId();
    }


    public void update(Long id, ProductRequestDTO productRequestDTO) {
        final Product product = productRepository.findById(id)
                .get();

        ProductMapper.mapToProductEntity(productRequestDTO, product);
        productRepository.save(product);
    }


    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}