package categoryservice.categoryservice.services;

import categoryservice.categoryservice.entity.Category;
import categoryservice.categoryservice.entity.Products;

import java.util.List;

public interface IcategorySercies {
    List<Category>getAll();
    List<Products> getAllprodcut();
    void delete(long id);
}
