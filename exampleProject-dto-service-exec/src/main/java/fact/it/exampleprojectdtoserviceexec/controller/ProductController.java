package fact.it.exampleprojectdtoserviceexec.controller;


import fact.it.exampleprojectdtoserviceexec.dto.ProductRequestDTO;
import fact.it.exampleprojectdtoserviceexec.dto.ProductResponseDTO;
import fact.it.exampleprojectdtoserviceexec.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index() {
        return "Welcome to the Product API.";
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(productService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        final Long createdId = productService.create(productRequestDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateProduct(@PathVariable(name = "id") Long id,
                                              @RequestBody ProductRequestDTO productRequestDTO) {
        productService.update(id, productRequestDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(name = "id") Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}