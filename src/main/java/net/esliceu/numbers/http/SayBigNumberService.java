package net.esliceu.numbers.http;

import net.esliceu.numbers.SayBigNumberFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class SayBigNumberService extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException {

        String operation = request.getParameter("operation");
        String first = request.getParameter("number1");
        String second = request.getParameter("number2");

        String number = SayBigNumberFactory.getInstance().operate(operation, first, second);


        String result = invokeExternalSayService(number);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.write("<html>" +
                "<head><style>" +
                "    p {" +
                "      font-family: Arial, sans-serif;" +
                "    }" +
                "    h1 {" +
                "      font-family: Arial, sans-serif;" +
                "    }" +
                "  </style></head>" +
                "<body>" +
                "<h1>Say Operate Big Numbers</h1>" +
                "<p>" + first + " " + SayBigNumberFactory.getOperator(operation) + " " + second + " = " + number + " --> <b>" + result + "</b></p>" +
                "</body></html>");
        writer.close();

    }

    private String invokeExternalSayService(String number) {
        StringBuilder result = new StringBuilder();
        String path = "/say?number=" + number;
        try {
            URL url = new URL(SayBigNumberFactory.getInstance().getOperateService(path));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;


            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}