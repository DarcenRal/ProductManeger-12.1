package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product book1 = new Book(1, "Сверхчеловек", 1032, "Дэйв Эспри");
    private Product book2 = new Book(2, "Орлеан", 492, "Лия Стеффи");
    private Product book3 = new Book(3, "Мечтатель Стрэндж", 120, "Лэйни Тейлор");
    private Product smartphone1 = new Smartphone(4, "Redmi 9T", 15990, "Xiaomi");
    private Product smartphone2 = new Smartphone(5, "Galaxy S21 Ultra", 95990, "Samsung");
    private Product smartphone3 = new Smartphone(6, "Blade V2020", 12490, "ZTE");

    @BeforeEach
    public void manageAdd() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void searchByBookName() {
        Product[] expected = new Product[]{book2};
        Product[] actual = manager.searchBy("Орлеан");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByBookAuthor() {
        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy("Дэйв Эспри");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNonExistentAuthor() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Конан Дойл");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNonExistentBookName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Тёрн");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBySmartphoneName() {
        Product[] expected = new Product[]{smartphone3};
        Product[] actual = manager.searchBy("Blade V2020");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBySmartphoneCreator() {
        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNonExistentSmartphoneName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Redmi 3S");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNonExistentSmartphoneCreator() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }
}