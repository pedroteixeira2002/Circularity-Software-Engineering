package productsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductList {
    /**
     * A list of products
     */
    private List<Product> list;
    /**
     * The name of the list
     */
    private String name;

    /**
     * Constructor for ProductList
     * @param name
     */

    public ProductList(String name) {
        this.name = name;
        this.list = new ArrayList<>();
    }

    /**
     * Get the name of the list
     * @return the name of the list
     */
    public String getName() {
        return this.name;
    }
    /**
     * Set the name of the list
     * @param name the name of the list
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Add a product to the list
     * @param product the product to be added
     * @return
     */
    public Product addProduct(Product product) {
        if (product == null)
            throw new IllegalArgumentException("Product cannot be null");
        this.list.add(product);
        return product;
    }
    /**
     * Get the list of products
     * @return the list of products
     */
    public List<Product> getList() {
        return list;
    }
    /**
     * Remove a product from the list by name
     * @param name the name of the product to be removed
     */
    public Product removeProduct(String name) {
        int pos=findProduct(name);
        if(pos==-1){
            throw new NoSuchElementException("Product cannot be null");
        }
        Product product = this.list.get(pos);
        this.list.remove(pos);
        return product;
    }
    /**
     * Find a product by name
     * @param name the name of the product to be found
     * @return the position of the product in the list
     */
    public int findProduct(String name) {
        int position=0;
        if(name==null)
            throw new NoSuchElementException("Product cannot be null");
        for(Product p:this.list){
            if(p.getName().equals(name)){
                return position;
            }
            position++;
        }
        return -1;
    }
    /**
     * Method to print the name of list and the products in the list
     * @return
     */
    @Override
    public String toString() {
        String str = "";
        System.out.println("List name: " + this.name);
        for (Product p : this.list) {
            str += p.toString() + "\n";
        }
        return str;
    }
}

