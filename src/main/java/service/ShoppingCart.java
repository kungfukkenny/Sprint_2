package service;

import model.Food;
import model.Discountable;

public class ShoppingCart {
    private Food[] products;

    public ShoppingCart(Food[] products) {
        this.products = products;
    }
    public double PriceWithoutDiscount() {
        double sum = 0;
        for (int i = 0; i < products.length; i++) {
            Food product = products[i];
            double price = product.getPrice();
            int amount = product.getAmount();
            sum = sum + price * amount;
        }
        return sum;
    }
    public double PriceWithDiscount() {
        double sum = 0;

        // Перебираем все товары
        for (int i = 0; i < products.length; i++) {
            Food item = products[i];
            double price = item.getAmount() * item.getPrice();

            // Если товар со скидкой
            if (item instanceof Discountable) {
                Discountable discountedItem = (Discountable) item;
                double discount = discountedItem.getDiscount();
                price = price - (price * discount / 100);
            }

            sum += price;
        }

        return sum;
    }
    public double VegTotalPriceWithoutDiscount() {
        double sum = 0;
        for (int i = 0; i < products.length; i++) {
            Food product = products[i];
            if (product.isVegetarian()) {
                double price = product.getPrice();
                int amount = product.getAmount();
                sum = sum + price * amount;
            }
        }
        return sum;
    }
}

