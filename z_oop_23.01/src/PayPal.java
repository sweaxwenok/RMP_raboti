public class PayPal implements PaymentSystem {
    private String email;

    public PayPal(String email){
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("оплачено " + amount + " через PayPal по электронной почте " + email);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Возвращен " + amount + " через PayPal по электронной почте " + email);
    }
}