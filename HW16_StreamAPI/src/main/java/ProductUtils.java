import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ProductUtils {
    private static final double DISCOUNT = 0.1;
    private static final int NUMBER_OF_PRODUCTS_LIMIT = 3;
    private static final int CHEAP_PRICE_LIMIT = 75;
    private static final int EXPENSIVE_PRICE_LIMIT = 250;

    public static List<Product> getAllExpensiveBooks(List<Product> products) {
        return products.stream()
                .filter(ProductUtils::isExpensiveBook)
                .collect(Collectors.toList());
    }

    public static List<Product> getAllBooksWithDiscount(List<Product> products) {
        return products.stream()
                .filter(ProductUtils::isBookWithDiscount)
                .map(ProductUtils::buildProductWithDiscount)
                .collect(Collectors.toList());
    }

    public static Product getCheapestBook(List<Product> products) {
        return products.stream()
                .filter(ProductUtils::isBook)
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Product [category: Book] has not found"));
    }

    public static List<Product> getLastAddedProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getCreateDate, Comparator.reverseOrder()))
                .limit(NUMBER_OF_PRODUCTS_LIMIT)
                .collect(Collectors.toList());
    }

    public static double calculateSumOfCheapBooksPricesOfCurrentYear(List<Product> products) {
        return products.stream()
                .filter(ProductUtils::isCheapBookAddedCurrentYear)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<String, List<Product>> groupingByType(List<Product> products) {
        return products.stream().collect(Collectors.groupingBy(Product::getCategory));
    }

    private static boolean isBook(Product product) {
        return product.getCategory().equals("Book");
    }

    private static boolean isExpensiveBook(Product product) {
        return product.getPrice() > EXPENSIVE_PRICE_LIMIT && isBook(product);
    }

    private static boolean isBookWithDiscount(Product product) {
        return isBook(product) && product.isNeededDiscount();
    }

    private static Product buildProductWithDiscount(Product product) {
        double priceWithDiscount = product.getPrice() - (product.getPrice() * DISCOUNT);
        return new Product(
                product.getCategory(),
                priceWithDiscount,
                product.isNeededDiscount(),
                product.getCreateDate(),
                product.getIdentificationNumber()
        );
    }

    private static boolean isCheapBookAddedCurrentYear(Product product) {
        return isBook(product)
                && product.getCreateDate().getYear() == LocalDateTime.now().getYear()
                && product.getPrice() <= CHEAP_PRICE_LIMIT;
    }
}
