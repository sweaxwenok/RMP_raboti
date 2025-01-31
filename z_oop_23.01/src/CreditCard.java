public class CreditCard implements PaymentSystem {
    private String cardNumber;

    public CreditCard(String cardNumber){
        this.cardNumber = cardNumber;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Оплачено " + amount + " с помощью кредитной карты " + cardNumber);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Возвращен " + amount + " на кредитную карту " + cardNumber);
    }
}