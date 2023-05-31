package net.esliceu.numbers;


public class BigNumber implements BigNumberOperator {
    String valor;
    int llevar;

    // Constructor 1
    public BigNumber(String s) {
        this.valor = quitarCeros(s);
    }

    // Constructor 2
    public BigNumber(BigNumber b) {

    }

    // Suma
    public String add(BigNumberOperator other) {
        String s1 = this.valor;
        String s2 = ((BigNumber) other).valor;
        if (s1.length() > s2.length()) {
            int diferencia = s1.length() - s2.length();
            for (int i = 0; i < diferencia; i++) {
                s2 = addCeros(s2);
            }
        } else if (s2.length() > s1.length()) {
            int diferencia = s2.length() - s1.length();
            for (int i = 0; i < diferencia; i++) {
                s1 = addCeros(s1);
            }
        }
        String[] sumas1 = s1.split("");
        String[] sumas2 = s2.split("");
        int resultat = 0;
        String soluc = "";
        llevar = 0;
        for (int i = s1.length() - 1; i >= 0; i--)
            soluc = sumar1Digit(
                    Integer.parseInt(sumas1[i]),
                    Integer.parseInt(sumas2[i]),
                    i)
                    + soluc;

        soluc = quitarCeros(soluc);
        return soluc;
    }

    private int sumar1Digit(int sm1, int sm2, int i) {
        int resultat;
        resultat = sm1 + sm2 + llevar;

        if (ultimNum(i)) {
            resultat = resultat;
        } else if (tengoQueLlevar(resultat, 10)) {
            llevar = resultat / 10;
            resultat = resultat % 10;
        } else {
            llevar = 0;
        }
        return resultat;
    }

    private static boolean tengoQueLlevar(int resultat, int x) {
        return resultat >= 10;
    }

    private static boolean ultimNum(int i) {
        return i == 0;
    }

    private String addCeros(String s) {
        s = "0" + s;
        return s;
    }

    // Resta
    public String subtract(BigNumberOperator other) {
        int resultadoResta = 0;
        StringBuilder juntar = new StringBuilder();
        BigNumber resF = null;
        String s1 = this.valor;
        String s2 = ((BigNumber) other).valor;
        if (s1.length() > s2.length()) {
            int diferencia = s1.length() - s2.length();
            for (int i = 0; i < diferencia; i++) {
                s2 = addCeros(s2);
            }
        } else if (s2.length() > s1.length()) {
            int diferencia = s2.length() - s1.length();
            for (int i = 0; i < diferencia; i++) {
                s1 = addCeros(s1);
            }
        }
        String[] restas1 = s1.split("");
        String[] restas2 = s2.split("");
        int[] tabla = new int[s1.length()];
        int longitud = tabla.length;
        int llevar = 0;
        for (int i = longitud - 1; i >= 0; i--) {
            if (Integer.parseInt(restas1[i]) < Integer.parseInt(restas2[i])) {
                restas1[i] = 1 + restas1[i];
                llevar = 1;
            }
            resultadoResta = Integer.parseInt(restas1[i]) - Integer.parseInt(restas2[i]);
            tabla[i] = resultadoResta;
            if (llevar == 1) {
                if (restas1[i - 1].equals("0")) {
                    restas2[i - 1] = String.valueOf(Integer.parseInt(restas2[i - 1]) + 1);
                }
                restas1[i - 1] = quitarUn(restas1[i - 1]);
                llevar = 0;
            }
        }
        for (int i = 0; i < tabla.length; i++) {
            juntar.append(tabla[i]);
        }
        String res = juntar.toString();
        res=quitarCeros(res);

        return res;
    }

    private String quitarUn(String s) {
        switch (s) {
            case "1" -> s = "0";
            case "2" -> s = "1";
            case "3" -> s = "2";
            case "4" -> s = "3";
            case "5" -> s = "4";
            case "6" -> s = "5";
            case "7" -> s = "6";
            case "8" -> s = "7";
            case "9" -> s = "8";
        }
        return s;
    }

    // EJ: te paso "123" y '2'
    // y devuelvo "246"
    String mult1digito(String s, char c) {
        String[] operador1 = s.split("");
        int m0 = 0;
        int m2 = Integer.parseInt(String.valueOf(c));
        int r = 0;
        int llevar = 0;
        String soluc = "";
        for (int i = operador1.length - 1; i >= 0; i--) {
            m0 = Integer.parseInt(operador1[i]);
            r = m0 * m2;
            if (llevar > 0) {
                r += llevar;
                llevar = 0;
            }
            if (i == 0) {
                r = r;
            } else if (r >= 10) {
                llevar = r / 10;
                r = r % 10;
            }
            soluc = "" + r + soluc;
        }
        return soluc;
    }

    // Compara dos BigNumber. Torna 0 si són iguals, -1
// si el primer és menor i torna 1 si el segon és menor
    public int compareTo(BigNumber other) {
        BigNumber b = (BigNumber) other;
        String s1 = this.valor;
        String s2 = other.valor;

        if (s1.length() == s2.length()) {
            String[] cifras1 = s1.split("");
            String[] cifras2 = s2.split("");
            for (int i = 0; i < s1.length(); i++) {
                int v1 = Integer.parseInt(cifras1[i]);
                int v2 = Integer.parseInt(cifras2[i]);
                if (v1 < v2) {
                    return -1;
                } else if (v1 > v2) {
                    return 1;
                }
            }
        } else if (s1.length() < s2.length()) {
            return -1;
        } else if (s1.length() > s2.length()) {
            return 1;
        }
        return 0;
    }

    // Torna un String representant el número
    public String toString() {
        return this.valor;
    }

    // Mira si dos objectes BigNumber són iguals
    public boolean equals(Object other) {
        BigNumber b = (BigNumber) other;
        String s1 = this.valor;
        String s2 = b.valor;
        this.valor = s1;
        b.valor = s2;

        if (b.valor.equals(this.valor)) return true;
        return false;
    }

    private String quitarCeros(String s) {
        String[] ceros = s.split("");
        if (ceros.length == 0) {
            return "0";
        }


        if (ceros[0].equals("0")) {
            for (int i = 0; i < ceros.length; i++) {
                int contador = i;
                if (!ceros[i].equals("0")) {
                    s = s.substring(contador);
                    break;
                }
            }

        }
        return s;
    }


}
