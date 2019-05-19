package ddd.model.impl;

import ddd.model.api.MessageBoard;
import ddd.model.api.ModelFactory;
import ddd.model.api.ModelFactoryBuilder;
import org.junit.Test;

import java.util.ServiceLoader;

import static org.junit.Assert.*;

public class ModelFactoryImplTest {

    @Test
    public void name() {
        ModelFactory factory = new ModelFactoryBuilder().build();

        MessageBoard instance = factory.getInstance(MessageBoard.class);

        System.out.println(instance);

    }
}
