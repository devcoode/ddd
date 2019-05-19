package ddd.model.api;

public interface UnitOfWork {

    void begin();

    void end();
}
