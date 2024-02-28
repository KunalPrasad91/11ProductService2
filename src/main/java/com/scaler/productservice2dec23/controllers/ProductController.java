package com.scaler.productservice2dec23.controllers;


import com.scaler.productservice2dec23.commons.AuthenticationCommon;
import com.scaler.productservice2dec23.dtos.Role;
import com.scaler.productservice2dec23.dtos.UserDto;
import com.scaler.productservice2dec23.exceptions.ProductNotFoundException;
import com.scaler.productservice2dec23.models.Product;
import com.scaler.productservice2dec23.services.FakeStoreProductService;
import com.scaler.productservice2dec23.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;
    AuthenticationCommon authenticationCommon;

    @Autowired
    //ProductController(@Qualifier("fakeProductService") ProductService productService)
   ProductController(@Qualifier("fakeProductService") ProductService productService,
                     AuthenticationCommon authenticationCommon)
    {
        this.productService = productService;
        this.authenticationCommon = authenticationCommon;
    }

    /*
    // working example getSingleProduct phase 1
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long product_id)
    {
        return productService.getSingleProduct(product_id);
    }
    */

    /*
    // working example getSingleProduct phase 2
    @GetMapping("/{id}")
    public  Product getSingleProduct(@PathVariable("id") Long product_id)
    {
       // throw new RuntimeException("Its time for exception");
        return productService.getSingleProduct(product_id);
    }
     */

/*
    // working example getSingleProduct phase 3
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long product_id)
    {
        // ResponseEntity helps to send more data apart from response body
        return new ResponseEntity<>(productService.getSingleProduct(product_id),
                HttpStatus.OK);
    }
 */
/*

    // working example getSingleProduct phase 3
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long product_id)
    {
        // ResponseEntity helps to send more data apart from response body
        //throw new RuntimeException("from controller layer");
        try {
            return new ResponseEntity<>(productService.getSingleProduct(product_id),
                    HttpStatus.OK);
        } catch (ArithmeticException e)
        {
            ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
            return  response;
        } catch(RuntimeException e)
        {
            ResponseEntity response = new ResponseEntity(HttpStatus.FORBIDDEN);
            return  response;
        }
    }
*/


/*    // working example getSingleProduct phase 4
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long product_id) throws ProductNotFoundException {
        // ResponseEntity helps to send more data apart from response body
        //throw new RuntimeException("from controller layer");
    *//*    try {*//*
            return new ResponseEntity<>(productService.getSingleProduct(product_id),
                    HttpStatus.OK);
       *//* } catch (ArithmeticException e)
        {
            ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
            return  response;
        } catch(RuntimeException e)
        {
            ResponseEntity response = new ResponseEntity(HttpStatus.FORBIDDEN);
            return  response;
        }*//*
    }*/


        // working example getSingleProduct phase 4
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long product_id) throws ProductNotFoundException {
        // ResponseEntity helps to send more data apart from response body
        //throw new RuntimeException("from controller layer");
        try {
            return new ResponseEntity<>(productService.getSingleProduct(product_id),
                    HttpStatus.OK);
        } catch (ArithmeticException e)
        {
            ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
            return  response;
        } catch(RuntimeException e)
        {
            ResponseEntity response = new ResponseEntity(HttpStatus.FORBIDDEN);
            return  response;
        }catch (ProductNotFoundException e)
        {
            ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
            return  response;
        }
    }

    @GetMapping("/ProductWithTokenAuth")
    public ResponseEntity<List<Product>> getAllProductWithTokenAuth(@RequestHeader("AuthenticationToken") String token)
    {
        UserDto userDto = authenticationCommon.validateToken(token);

        if(userDto == null)
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        boolean isAdmim = false;
        for(Role role : userDto.getRoles())
        {
            if(role.getName().equals("Admin")) {
                isAdmim = true;
                break;
            }
        }

        if(!isAdmim)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        List<Product> products = productService.getAllProduct();
        List<Product> finalproducts = new ArrayList<>();

        for(int i = 0; i < products.size() ; i++)
        {
            // products.get(i).setTitle("Hello " +products.get(i).getTitle());
            finalproducts.add(products.get(i));
        }

        return  new ResponseEntity<>(finalproducts, HttpStatus.OK);
        //return  productService.getAllProduct();
    }



  /*  @GetMapping()
    public List<Product> getAllProduct()
    {
        List<Product> products = productService.getAllProduct();
        List<Product> finalproducts = new ArrayList<>();

         for(int i = 0; i < products.size() ; i++)
         {
            // products.get(i).setTitle("Hello " +products.get(i).getTitle());
             finalproducts.add(products.get(i));
         }

        return  finalproducts;
        //return  productService.getAllProduct();
    }*/

    @GetMapping() // localhost:8080/products
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.getAllProduct(); // o p q

        List<Product> finalProducts = new ArrayList<>();

        for (Product p: products) { // o  p q
            p.setTitle("Hello" + p.getTitle());
            finalProducts.add(p);
        }

        ResponseEntity<List<Product>> response = new ResponseEntity<>(
                finalProducts, HttpStatus.OK
        );
        return response;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(id,product);
    }

    @PutMapping("/{id}")
    public Product replace(@PathVariable("id") Long id, @RequestBody Product product) {
        return new Product();
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody  Product product)
    {
      /*  Product p = new Product();
        return  p;*/

        return  productService.addNewProduct(product);

    }

   /* @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id)
    {
        return;
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id)
    {
        productService.deleteProduct(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }
}
