package main.lessons_5;

public class CalcCostDelivery extends CalcCostBase {

    private final static double deliveryPrice = 7.0;

    @Override
    public double calcCost(Product product) {
        double baseCost = super.calcCost(product);
        return baseCost + deliveryPrice;
    }
}

