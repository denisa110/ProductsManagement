package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Category {
    private String id;
    private String categoryName;
    private Category parentCategory;
    private List<Category> subCategories = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    public Category() {
    }

    public Category(String id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Category(String id, String categoryName, Category parentCategory) {
        this.id = id;
        this.categoryName = categoryName;
        this.parentCategory = parentCategory;
    }

    //this is first approach for add product.
    //    public void addProduct(Product product) {
    //        this.products.add(product);
    //    }

    public void addProduct(Product product) {
        //this is second approach for add product.
        //in this way, product will be added only if that product doesn't already exist in the list of products
        if (!this.products.contains(product)) {
            this.products.add(product);
        }
    }

    public void addSubCategory(Category category) {
        this.subCategories.add(category);
    }

    //Recursion
    public List<Product> getProductsCategory() {
        List<Product> productsCategory = new ArrayList<>();
        productsCategory.addAll(this.products);
        for (Category category : this.subCategories) {
            productsCategory.addAll(category.getProductsCategory());
        }
        return productsCategory;
    }

    public List<Category> getProductsCategoryOf(Product product) {
        List<Category> categoryProduct = new ArrayList<>();
        if (getProductsCategory().contains(product))
            categoryProduct.add(this);

        for (Category subCategory : subCategories) {
            categoryProduct.addAll(subCategory.getProductsCategoryOf(product));
        }
        return categoryProduct;
    }

    //hashCode method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
