package model;

import model.constants.Colour;
import model.constants.Discount;

public class Apple extends Food implements Discountable {
    private String colour;

    public Apple(int amount, double price, String colour) {
        this.amount = amount;
        this.price = price;
        this.colour = colour;
        this.isVegetarian = true;
    }

    @Override
    public double getDiscount() {
        if (Colour.red.equals(colour)) {
            return Discount.discount;
        }
        return 0;
    }
}
