package ddd.model.api;

import java.util.Iterator;

public interface MessageBoard {

    void write(String message);

    Iterator<String> messages();
}
