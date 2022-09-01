package com.itc.main.Repository;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.itc.main.Entity.Product;

@EnableJpaRepositories
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	public Product findProductByName(String name);
	

	@Transactional
	@Query(value = "delete from Product where name= :name",nativeQuery=true)
	@Modifying
	public Integer deleteProductByName(String name);
}
