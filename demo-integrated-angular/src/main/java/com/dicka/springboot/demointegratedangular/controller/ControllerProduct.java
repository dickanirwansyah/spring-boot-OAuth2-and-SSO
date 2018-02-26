package com.dicka.springboot.demointegratedangular.controller;

import com.dicka.springboot.demointegratedangular.entity.Product;
import com.dicka.springboot.demointegratedangular.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

@RestController
public class ControllerProduct {

    @Autowired
    private ProductService productService;

    private Logger log = LoggerFactory.getLogger(ControllerProduct.class);

    //save and upload
    private Product savedAndUploadPotoToServer(Product product){
        return productService.createProduct(product);
    }

    //update an upload
    private Product updateAndUloadPotoToServer(Product product){
        return productService.updateProduct(product);
    }

    //save and upload to server
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/api/product/secure/create")
    public @ResponseBody void savedUpload(@RequestParam(value = "file")MultipartFile file,
                                          Product product){

        String originalNamePoto = "";
        savedAndUploadPotoToServer(product);
        try{
            log.debug("Proccess upload..");
            System.out.println("data product "+ product.getIdproduct()+" berhasil disave");
            byte[] bytes = file.getBytes();
            originalNamePoto = product.getImage();

            BufferedOutputStream stream = new
                    BufferedOutputStream(new FileOutputStream(
                            new File("//var//www//html//server-poto//"+originalNamePoto)
            ));
            stream.write(bytes);
            stream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //update and upload to server
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/api/product/secure/edit")
    public @ResponseBody void updateUpload(@RequestParam(value = "file")
                                                MultipartFile file, Product product){

        String originalNamePoto = "";
        updateAndUloadPotoToServer(product);
        try{
            log.debug("Update upload image");
            byte[] bytes = file.getBytes();
            originalNamePoto = product.getImage();

            System.out.println("image "+originalNamePoto+" berhasil diedit !");

            BufferedOutputStream stream = new
                    BufferedOutputStream(new FileOutputStream(
                    new File("//var//www//html//server-poto//"+originalNamePoto)
            ));
            stream.write(bytes);
            stream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_STAFF') or hasAuthority('ROLE_USER')")
    @GetMapping(value = "/api/product/secure/list")
    public ResponseEntity<List<Product>> getList(){
        return Optional.ofNullable(productService.findAllProduct())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST));
    }

    @PreAuthorize("hasAuthority('ROLE_STAFF')")
    @GetMapping(value = "/api/product/secure/lost")
    public ResponseEntity<List<Product>> getLost(){
        return Optional.ofNullable(productService.findDisabledProduct())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND));
    }

    //just update entity
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_STAFF')")
    @PostMapping(value = "/api/product/secure/update")
    public ResponseEntity<Product> justUpdate(@RequestBody Product product){
        return Optional.ofNullable(productService.createProduct(product))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Product>(HttpStatus.BAD_REQUEST));
    }
}
