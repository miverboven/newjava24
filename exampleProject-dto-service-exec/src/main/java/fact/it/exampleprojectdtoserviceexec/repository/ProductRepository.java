package fact.it.exampleprojectdtoserviceexec.repository;

import fact.it.exampleprojectdtoserviceexec.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByBarcodeIgnoreCase(String barcode);

}
