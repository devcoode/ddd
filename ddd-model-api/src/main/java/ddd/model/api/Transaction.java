package ddd.model.api;

public interface Transaction {

    void begin();

    void commit();

    void rollback();
}
