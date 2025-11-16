package categoryservice.categoryservice.CONTROLLER;

import categoryservice.categoryservice.entity.Products;
import categoryservice.categoryservice.services.IcategorySercies;
import categoryservice.categoryservice.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cat")
public class Controller {
    @Autowired
    private IcategorySercies cateServices;

    @GetMapping("/")
    public ResponseEntity<List<Category>> getAll(){
    return ResponseEntity.ok(cateServices.getAll());
}
//    @GetMapping("/")
//    public ResponseEntity<List<Products>> getAll() {
//        return ResponseEntity.ok(cateServices.getAllprodcut());
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable("id") long id) {
   cateServices.delete(id);
//   if(isDeleted){
    return ResponseEntity.noContent().build();
//    }else{
//       return ResponseEntity.notFound().build();
   }
}
