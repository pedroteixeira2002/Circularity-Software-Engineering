package circularityIndexCalculator;

import productsystem.Product;
import productsystem.ProductList;

/**
 * This class calculates the MCI of a product or a list of products
 */
public class ProductMCI {
    /**
     * This method calculates the MCI of all materials of a product
     * @param materials the materials of the product
     * @return the MCI of all materials of a product
     */
    public static double mciTotal(CreateMaterials materials) {
        if (materials == null)
            throw new IllegalArgumentException("Material List cannot be null");
        double numerator = 0, denominator = 0;
        for (Material material : materials.getMaterials()) {
            numerator += material.getVirginMaterial() * material.circularityIndex();
            denominator += material.getMass();
        }
        if (denominator == 0)
            throw new ArithmeticException("The circularity index sum of all materials cannot be zero");
        return numerator / denominator;
    }
    /**
     * This method calls the method mciTotal to calculate the MCI of a product
     * @param product the product
     */
    public static void productMciTotal(Product product) {
        if (product == null)
            throw new IllegalArgumentException("Product cannot be null");

        CreateMaterials createMaterials = new CreateMaterials(product.getProcess());
        product.setMci(mciTotal(createMaterials));
    }
    /**
     * This method goes through all products of a list and calls the method productMciTotal to calculate the MCI of each product
     * @param products the list of products
     */
    public static void productListMciTotal(ProductList products) {
        if (products == null)
            throw new IllegalArgumentException("Product List cannot be null");
        for (Product product : products.getList())
            productMciTotal(product);
    }
}
