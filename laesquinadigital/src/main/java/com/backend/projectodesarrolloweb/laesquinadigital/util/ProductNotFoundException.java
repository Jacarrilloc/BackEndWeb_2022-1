package com.backend.projectodesarrolloweb.laesquinadigital.util;

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
		super("Could not find Producto by id:" + id);
	}
	
	public ProductNotFoundException(String identificacion) {
		super("Could not find Producto by identificacion:" + identificacion);
	}
    
}
