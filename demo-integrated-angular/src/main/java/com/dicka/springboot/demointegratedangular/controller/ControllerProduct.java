package com.dicka.springboot.demointegratedangular.controller;

import com.dicka.springboot.demointegratedangular.entity.Product;
import com.dicka.springboot.demointegratedangular.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class ControllerProduct {

    @Autowired
    private ProductService productService;

    private Logger log = LoggerFactory.getLogger(ControllerProduct.class);

    //save and upload
    private Product savedAndUploadPotoToServer(Product product){
        return productService.createProduct(product);
    }

    //save and upload to server
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
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
