package ddd.model.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import ddd.model.api.MessageBoard;
import ddd.model.api.ModelFactory;

public class ModelFactoryImpl implements ModelFactory {

    private final Injector injector;

    public ModelFactoryImpl() {
        injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(MessageBoard.class).to(MessageBoardImpl.class);
            }
        });
    }

    @Override
    public <T> T getInstance(Class<T> clazz) {
        return injector.getInstance(clazz);
    }
}
