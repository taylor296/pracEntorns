package net.esliceu.numbers.http;

import net.esliceu.numbers.Numbers;
import net.esliceu.numbers.SayBigNumberFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SayNumberService extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException
    {
        PrintWriter out = response.getWriter();

        Numbers numbers = SayBigNumberFactory.getInstance().getNumbers();

        String numberStr = request.getParameter("number");

        try {
            long number = Long.parseLong(numberStr);
            out.println(numbers.say(number));
        } catch (Exception ex) {
            out.print("Invalid input number: " + numberStr);
        }

    }
}