package net.esliceu.numbers.http;

import net.esliceu.numbers.Numbers;
import net.esliceu.numbers.NumbersException;
import net.esliceu.numbers.SayBigNumberFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OperateBigNumberService extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();

        String operation = request.getParameter("operation");
        String first = request.getParameter("number1");
        String second = request.getParameter("number2");

        String result = SayBigNumberFactory.getInstance().operate(operation, first, second);

        out.print(result);
    }


}