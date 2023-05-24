package net.esliceu.numbers;

public class SayBigNumberFactory {
    private static final SayBigNumberFactory INSTANCE = new SayBigNumberFactory();

    private final Numbers numbers;
    private BigNumberOperator operator;
    private final String operateService = "http://localhost:8080/SayBigNumber";

    private SayBigNumberFactory() {
        numbers = new NumbersCat();

    }

    public static SayBigNumberFactory getInstance() {
        return INSTANCE;
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public String operate(String operation, String first, String second) throws NumbersException {
        checkParameters(operation, first, second);

        String result;
        switch (operation) {
            case "add":
                result = SayBigNumberFactory.getInstance().add(first, second);
                break;
            case "subtract":
                result = SayBigNumberFactory.getInstance().subtract(first, second);
                break;
            default:
                throw new NumbersException("Invalid operation");
        }

        return result;
    }

    public String add(String first, String second) {
        initOperator(first);

        return operator.add(new BigNumber(second));
    }


    public String subtract(String first, String second) {
        initOperator(first);

        return operator.subtract(new BigNumber(second));
    }

    private void initOperator(String first) {
        operator = new BigNumber(first);
    }

    public String getOperateService(String path) {
        return operateService + path;
    }


    public String multiply(String first, String second) throws NumbersException {
        throw new NumbersException("Method not implemented");
    }

    public String divide(String first, String second) throws NumbersException {
        throw new NumbersException("Method not implemented");
    }

    private void checkParameters(String operation, String first, String second) throws NumbersException {
        checkOperation(operation);

        checkNumbers(first, second);
    }

    private void checkNumbers(String first, String second) throws NumbersException {
        if(first == null)
            throw new NumbersException("First number is missing");

        if(second == null)
            throw new NumbersException("Second number is missing");

        String errorMessage = "";
        try {
            errorMessage = "number1 parameter is not a valid number: " + first;
            Long.parseLong(first);
            errorMessage = "number2 parameter is not a valid number: " + second;
            Long.parseLong(second);
        } catch (Exception ex) {
            throw new NumbersException(errorMessage);
        }
    }

    private void checkOperation(String operation) throws NumbersException {
        String validOperations = ". Supported operations are: [add, subtract]";
        if(operation == null)
            throw new NumbersException("Operation is missing" + validOperations);

        if((!operation.equals("add")) && (!operation.equals("subtract")))
            throw new NumbersException("Invalid operation: " + operation + validOperations);
    }


    public static String getOperator(String operation) {
        String operator = "";
        switch (operation) {
            case "add":
                return "+";
            case "subtract":
                return "-";
        }

        return operator;
    }


}
