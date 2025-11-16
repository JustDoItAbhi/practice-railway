package categoryservice.categoryservice.services;

import categoryservice.categoryservice.entity.Category;
import categoryservice.categoryservice.entity.Products;
import categoryservice.categoryservice.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Service
public class CateServices implements IcategorySercies {
    private RestTemplateBuilder restTemplate;

    @Autowired
    private CategoryRepo categoryRepo;

    public CateServices(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("categories")
    public List<Category> getAll() {
        RestTemplate template = restTemplate.build();
        String url = "https://fakestoreapi.com/products/categories";
        try {
            ResponseEntity<String[]> templates = template.getForEntity(url, String[].class);
            if (templates.getBody() != null) {
                List<Category> categoryList = new ArrayList<>();
                for (String category : templates.getBody()) {
                    Category categorys1 =new Category();

                    categorys1.setName(category);
//                    Scanner scn=new Scanner(System.in);
//                    long num=scn.nextLong();
//                    Random random=new Random();
//                    long randomLong=random.nextLong();
//                    categorys1.setId(randomLong);
                    categoryList.add(categorys1);
                }
                categoryRepo.saveAll(categoryList);

                return categoryList;
            } else {
                // Handle the case where the response body is null
                throw new RuntimeException("Failed to fetch categories from the API");
            }
        }catch(Exception e){
                // Handle any exceptions that occur during the API call
                throw new RuntimeException("Error while calling the API: " + e.getMessage(), e);
            }
        }

    @Override
    public List<Products> getAllprodcut() {
        RestTemplate restTemplate1=restTemplate.build();
   try{
        String url="https://fakestoreapi.com/products/category/jewelery";
        ResponseEntity<Products[]>template=restTemplate1.getForEntity(url,Products[].class);
       Scanner scn=new Scanner(System.in);
        if(template.getBody()!=null){
           List<Products>productsList=new ArrayList<>();
            for(Products p: template.getBody()){
                Products products=new Products();
                Random random=new Random();
                products.setId(random.nextLong());
                products.setTitle(p.getTitle());
                products.setPrice(p.getPrice());
                products.setCategory(p.getCategory());
                productsList.add(products);
            }
        return productsList;

        } else {
            // Handle the case where the response body is null
            throw new RuntimeException("Failed to fetch categories from the API");
        }
    }catch(Exception e){
        // Handle any exceptions that occur during the API call
        throw new RuntimeException("Error while calling the API: " + e.getMessage(), e);
    }
}

    @Override
    public void delete(long id) {
    RestTemplate restTemplate1=restTemplate.build();
    String url="'https://fakestoreapi.com/products/"+id;
       restTemplate1.delete(url);
    }
}