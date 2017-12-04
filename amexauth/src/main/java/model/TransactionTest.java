package model;

public class TransactionTest {

    Transaction transaction;
    String result;

    public TransactionTest(Transaction transaction, String result) {
        this.transaction = transaction;
        this.result = result;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public String getResult() {
        return result;
    }

}
