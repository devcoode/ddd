package ddd.web;

import ddd.model.api.MessageBoard;
import ddd.model.api.ModelFactory;
import ddd.model.api.ModelFactoryBuilder;
import ddd.model.api.Transaction;
import ddd.model.api.UnitOfWork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class MyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ModelFactory factory = new ModelFactoryBuilder().build();
        MessageBoard room = factory.getInstance(MessageBoard.class);

        UnitOfWork unitOfWork = factory.getInstance(UnitOfWork.class);

        try (BufferedReader r = req.getReader()) {
            unitOfWork.begin();
            try {
                Transaction tx = factory.getInstance(Transaction.class);
                tx.begin();
                try {
                    String line;
                    while ((line = r.readLine()) != null) {
                        room.write(line);
                    }
                    tx.commit();
                } catch (RuntimeException e) {
                    tx.rollback();
                    throw e;
                }
            } finally {
                unitOfWork.end();
            }
        }
    }
}
