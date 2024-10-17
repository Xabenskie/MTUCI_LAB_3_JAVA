import java.util.HashMap;

// Класс для учета продуктов на складе
public class WareHouse {
	private HashMap<String, Product> products;

	public WareHouse() {
			products = new HashMap<>();
	}

	// Метод для добавления продукта
	public void addProduct(String barcode, Product product) {
			products.put(barcode, product);
			System.out.println("Product added: " + product);
	}

	// Метод для поиска продукта по штрихкоду
	public Product findProduct(String barcode) {
			if (products.containsKey(barcode)) {
					return products.get(barcode);
			} else {
					System.out.println("Product with barcode " + barcode + " not found.");
					return null;
			}
	}

	// Метод для удаления продукта по штрихкоду
	public Product removeProduct(String barcode) {
			if (products.containsKey(barcode)) {
					Product removedProduct = products.remove(barcode);
					System.out.println("Product removed: " + removedProduct);
					return removedProduct;
			} else {
					System.out.println("Product with barcode " + barcode + " not found.");
					return null;
			}
	}

	// Метод для отображения всех продуктов
	public void displayAllProducts() {
			if (products.isEmpty()) {
					System.out.println("No products in the warehouse.");
			} else {
					for (String barcode : products.keySet()) {
							System.out.println("Barcode: " + barcode + ", " + products.get(barcode));
					}
			}
	}

	public static void main(String[] args) {
		WareHouse warehouse = new WareHouse();

			// Создаем несколько продуктов
			Product product1 = new Product("Apple", 1.5, 100);
			Product product2 = new Product("Banana", 0.75, 150);
			Product product3 = new Product("Orange", 1.2, 80);

			// Добавляем продукты в склад
			warehouse.addProduct("123456", product1);
			warehouse.addProduct("234567", product2);
			warehouse.addProduct("345678", product3);

			// Поиск продукта по штрихкоду
			System.out.println("Found: " + warehouse.findProduct("123456"));

			// Удаление продукта по штрихкоду
			warehouse.removeProduct("234567");

			// Отображение всех продуктов
			warehouse.displayAllProducts();
	}
}
