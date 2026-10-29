public class Order {
    private MenuItem item;
    private int quantity;

    public Order(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return item.getPrice() * quantity;
    }

    public String getReceiptLine() {
        return item.getName() + " x" + quantity + " = Rp. " + getSubTotal();
    }
}