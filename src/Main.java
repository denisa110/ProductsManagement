import entities.Catalog;
import entities.Category;
import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //catalog
        Catalog catalog = new Catalog("1", "Catalog 2020");

        //main categories
        Category category11 = new Category("1.1", "Software");
        Category category22 = new Category("1.2", "Hardware");

        //add category to catalog
        catalog.addCategory(category11);
        catalog.addCategory(category22);

        //subcategories (attach subcategories to main category
        Category category111 = new Category("1.1.1", "Sisteme de operare", category11);
        Category category112 = new Category("1.1.2", "Office", category11);

        Category category113 = new Category("1.1.3", "Desktop", category22);
        Category category114 = new Category("1.1.4", "Mobile", category22);

        //add subcategory in a list category
        category11.addSubCategory(category111);
        category11.addSubCategory(category112);
        category22.addSubCategory(category113);
        category22.addSubCategory(category114);

        //products
        Product p1 = new Product("P1", "MS Windows", 2150.0);
        Product p2 = new Product("P2", "Apple MacOS", 2550.0);
        Product p3 = new Product("P3", "MS Office", 850.0);
        Product p4 = new Product("P4", "PC Dell", 1700.0);
        Product p5 = new Product("P5", "NetBook Lenovo", 2100.0);
        Product p6 = new Product("P6", "iPhone 12", 2400.0);

        //attach products to main categories or subcategories
        category111.addProduct(p1);
        category111.addProduct(p2);
        category112.addProduct(p3);
        category113.addProduct(p4);
        category114.addProduct(p5);
        category114.addProduct(p6);

        //Test: view products from a category
        List<Catalog> catalogs = new ArrayList<>();
        catalogs.add(catalog);

        List<Category> toAddCategories = new ArrayList<>();
        toAddCategories.add(category11);
        toAddCategories.add(category22);

        List<Category> categories = new ArrayList<>();
        categories.addAll(toAddCategories);


        for (Catalog localCatalog : catalogs) {
            System.out.println(localCatalog.getCatalogName() + " has the following categories: ");
            for (Category c : categories) {
                System.out.println("-----------------------------------------------------");
                System.out.println(c.getCategoryName() + " has the following products: ");
                List<Product> productsCategory = c.getProductsCategory();
                for (Product p : productsCategory) {
                    System.out.println("Product category: " + p.getProductName());
                }
            }
        }

        //Test: view category of a product
        System.out.println("-----------------------------------------------------");
        System.out.println(p3.getProductName() + " has the following categories: ");
        for (Category category : catalog.getProductCategory(p6)) {
            System.out.println("->> " + category.getCategoryName());
        }


//        System.out.println("-----------------------------------------------------");
//        System.out.println(category11.getCategoryName() + " has the following products: ");
//        List<Product> productsCategory = category11.getProductsCategory();
//        for (Product p : productsCategory) {
//            System.out.println("Product category: " + p.getProductName());
//        }


    }
}