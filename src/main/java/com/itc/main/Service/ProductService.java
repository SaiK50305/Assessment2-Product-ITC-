package com.itc.main.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.main.Entity.Product;
import com.itc.main.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	public ProductRepository prodrepo;
	
	 public Product saveProduct(Product product) {
		 this.prodrepo.save(product);
		 return product;
	 }
     public Product getProductById(int id) {
    	 Optional<Product> prod=this.prodrepo.findById(id);
    	 if(prod.isPresent()) {
    		return prod.get(); 
    	 }
    	 else
    		 return null;
    	 
     }
     public List<Product> getAllProducts(){
    	 List<Product> list = this.prodrepo.findAll();
    	 return list;
     }
     public Product getProductByName(String name) {
    	 Product product = this.prodrepo.findProductByName(name);
		 return product;
     }
     public Product updateProduct(Product product){
    	 Product op= this.prodrepo.save(product);
    	 return op;
    	 
     }
     public boolean deleteProductById(int id) {
    	 this.prodrepo.deleteById(id);
    	 return true;
     }
     public boolean deleteProductByName(String name) {
    	 this.prodrepo.deleteProductByName(name);
    	 return true;
     }
     
     
 
}
