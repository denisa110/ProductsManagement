package entities;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String id;
    private String catalogName;
    private List<Category> productsCategories = new ArrayList<>();

    public Catalog() {
    }

    public Catalog(String id, String catalogName) {
        this.id = id;
        this.catalogName = catalogName;
    }

    public void addCategory(Category category) {
        this.productsCategories.add(category);
    }

    public List<Category> getProductCategory(Product product) {
        List<Category> productsCategory = new ArrayList<>();
        for (Category category : productsCategories) {
            productsCategory.addAll(category.getProductsCategoryOf(product));
        }
        return productsCategory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public List<Category> getProductsCategories() {
        return productsCategories;
    }

    public void setProductsCategories(List<Category> productsCategories) {
        this.productsCategories = productsCategories;
    }
}
