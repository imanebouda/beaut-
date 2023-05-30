package com.management;

import com.management.entities.Categorie;
import com.management.entities.Product;
import com.management.repositories.CategorieRepository;
import com.management.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class MainApplicationApplicationTests {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategorieRepository categorieRepository;

	@Test
	public void TestCreateProduct(){
		Product product = new Product("Dior hivers",4400.00,new Date());
		productRepository.save(product);

	}
	/*
	@Test
	public void TestUpdateProduct(){
		Product product = productRepository.findById(1L).get();
		product.setPriceProduct(2500.00);
		productRepository.save(product);

	}
	@Test
	void TestFindProductById() {
		Product product = productRepository.findById(1L).get();
		System.out.println(product);
	}
	@Test
	public void TestFindAllProduct() {
		List<Product> products = productRepository.findAll();
		for (Product p : products) {
			System.out.println(p);

		}


		//products.forEach(System.out:println);

	}
	@Test
	public void TestDeleteProductById(){
		productRepository.deleteById(1L);

	}
	public void TestDeleteAllProductById(){
		productRepository.deleteAll();

	}
*/

	@Test
	public void TestCreateCategorie(){
		Categorie categorie = new Categorie("channel");
		categorieRepository.save(categorie);

	}

}
