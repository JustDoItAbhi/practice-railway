package categoryservice.categoryservice.dtos;

import lombok.Getter;
import lombok.Setter;

public class FakeStoreProductDto {
    private String title;
    private Double price;
    private String category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}