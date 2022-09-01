package com.itc.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.main.Entity.Product;
import com.itc.main.Service.ProductService;

@RestController
@RequestMapping("/api/")
public class ProductController {
	
	@Autowired
	public ProductService prodService;
	
	@GetMapping("product/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id){
        //1 Get Product By Id
        //2.Return Product with HttpStatus as OK
		Product prod = this.prodService.getProductById(id);
		if(prod!=null) {
			return new ResponseEntity(prod,HttpStatus.OK);
		}
		else
			return new ResponseEntity("Not Found",HttpStatus.NOT_FOUND);
		
	}
	@GetMapping("product")
    public ResponseEntity<List<Product>> getAllProducts(){
  		//1. Get All Products
  		//2. Return All products with HttpStatus is OK
	  List<Product> list = this.prodService.getAllProducts();
	  return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
    }
	@GetMapping("prod/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name){
  		//1. Get Product ByName
  		//2. Return Product with HttpStatus is OK
	  Product prod = this.prodService.getProductByName(name);
	  return new ResponseEntity<Product>(prod,HttpStatus.OK);
    }
	
	@PutMapping("product/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product prod){
         //1. Update Product
         //2. Return Product with HttpStatus is OK
		Product p1=this.prodService.updateProduct(prod);
		return new ResponseEntity<Product>(p1,HttpStatus.OK);
	}
	
	@DeleteMapping("product/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable int id){
          //1. Delete Product By Id
          //2. Return HttpStatus Message is Success Delete with Status Code Ok
		boolean b = this.prodService.deleteProductById(id);
		if(b) {
			return new ResponseEntity<String>("Deleted Sucessfully",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Not Found",HttpStatus.NOT_FOUND);
    }
	
	@PostMapping("product/save")
    public ResponseEntity<String> saveProduct(@RequestBody Product prod){
   		  //1. Delete Product By Name
          //2. Return HttpStatus Message is Success Delete with Status Code Ok
    	this.prodService.saveProduct(prod);
    	return new ResponseEntity<String>("Created sucessfully",HttpStatus.OK);
    	
    }
	@DeleteMapping("prodname/{name}")
	public ResponseEntity deleteProductByName(@PathVariable String name) {
	boolean product=this.prodService.deleteProductByName(name);
	if(product==true)
		return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
	else
		return new ResponseEntity<String>("Not-found", HttpStatus.NOT_FOUND);
	}
}

