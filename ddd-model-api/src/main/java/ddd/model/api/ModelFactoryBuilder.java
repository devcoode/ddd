package ddd.model.api;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ModelFactoryBuilder {

    public ModelFactory build() {
        Iterator<ModelFactory> it = ServiceLoader.load(ModelFactory.class).iterator();
        if (!it.hasNext()) {
            throw new IllegalStateException("check your classpath");
        }
        return it.next();
    }
}
