package ddd.model.api;

public interface ModelFactory {

    <T> T getInstance(Class<T> clazz);
}
