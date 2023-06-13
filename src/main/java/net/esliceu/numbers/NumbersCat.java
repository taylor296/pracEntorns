package net.esliceu.numbers;

import net.esliceu.numbers.Numbers;

import java.util.Objects;

public class NumbersCat implements Numbers {


    public String say(long n) {
        // El primer que faig es assegurar-me de si el numero es negatiu per añadir menys al principi
        String res = "";
        if (n < 0) {
            n = -n;
            res = "menys ";// un cop he vist si es o no negatiu ja fiag el numero, aquetsa estructura en cascada em permet
            // accedir constantment des d'un numero més gran al més petit per formar el nombre complet
        }
        if (n < 20) {
            res += menor20(n);
        } else if (n < 100) {
            res = menorCien(res, n);
        } else if (n < 1000) {
            res = menorMil(res, n);
        } else if (n < 1000000) {
            res = menorMillo(res, n);
        } else if (n < 1_000_000_000_000L) {
            res = menorBilio(res, n);
        } else if (n < 1_000_000_000_000_000_000L) {
            res = menorTrilio(res, n);
        } // Com ya no hi pot haver-hi noms més grans que el strillons no es necessari crar un altre if.
        else {
            res = trilions(res, n);
        }

        // Abans de mostrar el resultat hi ha que pasar-ho a majuscules ja que he treballat en minisucles
        // durant tot el programa degut a la reutilització de codi.
        res = cambiarMajusc(res);
        return res;
    }

    private static String trilions(String res, long n) {
        long trilioUnitat = n / 1_000_000_000_000_000_000L;
        long residuTrilio = n % 1_000_000_000_000_000_000L;
        if (trilioUnitat == 1 && residuTrilio == 0) {
            res += "un trilió";
        } else if (trilioUnitat == 1) {
            res += "un trilió " + menorTrilio(res, residuTrilio);
        } else {
            res += menor20(trilioUnitat) + " trilions " + menorTrilio(res, residuTrilio);
        }
        return res;
    }

    private static String menorTrilio(String res, long n) {
        if (n >= 1_000_000_000_000_000L) {
            long milBilionsUnitats = n / 1_000_000_000_000_000L;
            long residuMilBilions = n - milBilionsUnitats * 1_000_000_000_000_000L;
            long bilionsUnitat = residuMilBilions / 1_000_000_000_000L;
            residuMilBilions = residuMilBilions - bilionsUnitat * 1_000_000_000_000L;
            // Per aconseguir separar el mil billons normals del cents de mils de billons el que he fet es crear
            // una variable extra la qual funciona perfectament amb el resultat
            // al igaul que he fet amb la funció menorBilio
            if (milBilionsUnitats == 1 && residuMilBilions == 0) {
                res += "mil bilions";
            } else if (milBilionsUnitats == 1 && bilionsUnitat == 0) {
                res += "mil bilions" + menorBilio(res, residuMilBilions);
            } else if (milBilionsUnitats == 100 && residuMilBilions == 0 && bilionsUnitat == 0) {
                res += "cent mil bilions";
            } else if (milBilionsUnitats > 100 && residuMilBilions == 0 && bilionsUnitat == 0) {
                res += menorMil(res, milBilionsUnitats) + " mil bilions";
            } else {
                res += menorMillo(res, milBilionsUnitats) + " mil " + menorMil(res, bilionsUnitat) + " bilions " + menorBilio(res, residuMilBilions);
            }
        } else {
            long bilioUnitat = n / 1_000_000_000_000L;
            long residuBilio = n - bilioUnitat * 1_000_000_000_000L;
            if (bilioUnitat == 1 && residuBilio == 0) {
                res += "un bilió";
            } else if (bilioUnitat == 1) {
                res += "un bilió " + menorBilio(res, residuBilio);
            } else if (residuBilio == 0) {
                res += menorMillo(res, bilioUnitat) + " bilions";
            } else {
                res += menorMillo(res, bilioUnitat) + " bilions " + menorBilio(res, residuBilio);
            }
        }
        return res;
    }

    private static String menorBilio(String res, long n) {
        // Tenia problemes quan el numero era mayor que 10k milions,
        // per tant primer veig si ho és, i si així és el dividesc entre mil milions
        // per obtenir les unitats de mil de milions al igual que he fet previament.
        if (n >= 10_000_000_000L) {
            long milMilionsUnitats = n / 1_000_000_000L;
            long residuMilMilions = n - milMilionsUnitats * 1_000_000_000L;
            // A pesar de poder usar el calcul amb % he optat per fer aquesta petita operació ja que
            // la entenc molt millor i puc veure el que fa
            long milioUnitat = (int) residuMilMilions / 1000000;
            residuMilMilions = residuMilMilions - milioUnitat * 1000000;
            if (milioUnitat == 0) {
                res += menorMillo(res, milMilionsUnitats) + " mil milions " + menorMillo(res, residuMilMilions);
            } else {
                res += menorMillo(res, milMilionsUnitats) + " mil " + menorMillo(res, milioUnitat) + " milions " + menorMillo(res, residuMilMilions);
            }
        } else {
            long milloUnitat = (int) n / 1000000;
            long residuMillo = (int) n - milloUnitat * 1000000;
            if (milloUnitat == 1000 && residuMillo == 0) {
                res += "mil milions";
            } else if (milloUnitat == 1000) {
                res += "mil milions " + menorMillo(res, residuMillo);
            } else if (milloUnitat > 1000 && residuMillo == 0) {
                res += menorMillo(res, milloUnitat) + " milions";
            } else if (milloUnitat > 1000) {
                res += menorMillo(res, milloUnitat) + " milions " + menorMillo(res, residuMillo);
            } else if (residuMillo == 0) {
                res += menorMillo(res, milloUnitat) + " milió ";
            } else if (milloUnitat == 1) {
                res += "un milió " + menorMillo(res, residuMillo);
            } else {
                res += menorMillo(res, milloUnitat) + " milions " + menorMillo(res, residuMillo);
            }
        }
        return res;
    }

    private static String menorMillo(String res, long n) {
        long milUnitat = (int) n / 1000;
        long residuMil = (int) n - milUnitat * 1000;
        if (residuMil == 0 && milUnitat == 1) {
            res += "mil";
        } else if (milUnitat == 1) {
            res += "mil " + menorMil(res, residuMil);
        } else if (milUnitat == 100 && residuMil == 0) {
            res += "cent mil";
        } else if (milUnitat == 100) {
            res += "cent mil " + menorMil(res, residuMil);
        } else if (residuMil == 0) {
            res += menorMil(res, milUnitat) + " mil";
        } else if (milUnitat == 0) {
            res += menorMil(res, residuMil);
        } else {
            res += menorMil(res, milUnitat) + " mil " + menorMil(res, residuMil);
        }
        return res;
    }

    private static String menorMil(String res, long n) {
        long centena = (int) n / 100;
        long residu = (int) n - centena * 100;
        if (residu == 0 && centena == 1) {
            res += "cent";
        } else if (centena == 1) {
            res += "cent " + menorCien(res, residu);
        } else if (residu == 0) {
            res += menor20(centena) + "-cents";
        } else if (centena == 0) {
            res += menorCien(res, residu);
        } else if (residu < 100) {
            res += menor20(centena) + "-cents " + menorCien(res, residu);
        } else {
            res += menor20(centena) + "-cents " + menorCien(res, residu);
        }
        return res;
    }

    private static String menorCien(String res, long n) {
        if (n < 20) {
            res += menor20(n);
            return res;
        }
        long decena = (int) n / 10;
        long unitat = (int) n % 10;
        if (unitat == 0) {
            res += numDecena(decena);
        } else if (decena == 2) {
            res += numDecena(decena) + "-i-" + menor20(unitat);
        } else if (decena == 0) {
            res += menor20(unitat);
        } else {
            String decenaString = numDecena(decena);
            String unidadString = menor20(unitat);
            res += numDecena(decena) + "-" + menor20(unitat);
        }
        return res;
    }

    private static String numDecena(long decena) {
        String res = "";
        if (decena == 2) {
            res += "vint";
        } else if (decena == 3) {
            res += "trenta";
        } else if (decena == 4) {
            res += "quaranta";
        } else if (decena == 5) {
            res += "cinquanta";
        } else if (decena == 6) {
            res += "seixanta";
        } else if (decena == 7) {
            res += "setanta";
        } else if (decena == 8) {
            res += "vuitanta";
        } else if (decena == 9) {
            res += "noranta";
        }
        return res;
    }

    static String menor20(long n) {
        String res = "";
        if (n == 0) {
            res += "zero";
        } else if (n == 1) {
            res += "un";
        } else if (n == 2) {
            res += "dos";
        } else if (n == 3) {
            res += "tres";
        } else if (n == 4) {
            res += "quatre";
        } else if (n == 5) {
            res += "cinc";
        } else if (n == 6) {
            res += "sis";
        } else if (n == 7) {
            res += "set";
        } else if (n == 8) {
            res += "vuit";
        } else if (n == 9) {
            res += "nou";
        } else if (n == 10) {
            res += "deu";
        } else if (n == 11) {
            res += "onze";
        } else if (n == 12) {
            res += "dotze";
        } else if (n == 13) {
            res += "tretze";
        } else if (n == 14) {
            res += "catorze";
        } else if (n == 15) {
            res += "quinze";
        } else if (n == 16) {
            res += "setze";
        } else if (n == 17) {
            res += "disset";
        } else if (n == 18) {
            res += "divuit";
        } else if (n == 19) {
            res += "dinou";
        }
        return res;
    }

    private static String cambiarMajusc(String res) {
        String firstLtr = res.substring(0, 1);
        String restLtrs = res.substring(1, res.length());

        firstLtr = firstLtr.toUpperCase();
        res = firstLtr + restLtrs;
        return res;
    }


    public static long words(String s) {
        long n = 0;
        s = s.toLowerCase();
        String[] numeros = s.split(" ");
        if (Objects.equals(numeros[0], "menys")) {
            s = s.substring(6);
        }



        n = inferiorMil(s, n);
        n = inferior100(s, n);
        if (s.length() == 1) {
            n = inferior20(s, n);
        }


        if (Objects.equals(numeros[0], "menys")) {
            n = -n;
        }

        return n;
    }

    private static long inferiorMil(String s, long n) {
        String[] centena = s.split(" ");
        if (centena[0].equals("cent")) {
            n += 100;
        } else if (centena[0].equals("dos-cents")) {
            n += 200;
        } else if (centena[0].equals("tres-cents")) {
            n += 300;
        } else if (centena[0].equals("quatre-cents")) {
            n += 400;
        } else if (centena[0].equals("cinc-cents")) {
            n += 500;
        } else if (centena[0].equals("sis-cents")) {
            n += 600;
        } else if (centena[0].equals("set-cents")) {
            n += 700;
        } else if (centena[0].equals("vuit-cents")) {
            n += 800;
        } else if (centena[0].equals("nou-cents")) {
            n += 900;
        }
        return n;
    }

    private static long inferior100(String s, long n) {
        if (s.contains("cents")) {
            String[] ar2 = s.split("-cents ");
            s = ar2[1];
        } else if (s.equals("cent")) {
            return n;
        } else if (s.contains("cent")) {
            String[] ar2 = s.split("cent");
            s = ar2[0];
        }
        String[] decena = s.split("-");
        if (decena[0].equals("vint")) {
            n += 20;
        } else if (decena[0].equals("trenta")) {
            n += 30;
        } else if (decena[0].equals("quaranta")) {
            n += 40;
        } else if (decena[0].equals("cinquanta")) {
            n += 50;
        } else if (decena[0].equals("seixanta")) {
            n += 60;
        } else if (decena[0].equals("setanta")) {
            n += 70;
        } else if (decena[0].equals("vuitanta")) {
            n += 80;
        } else if (decena[0].equals("noranta")) {
            n += 90;
        }
        n = inferior20(s, n);
        return n;
    }

    private static long inferior20(String s, long n) {
        if (s.contains("-")) {
            if (s.contains("-i-")) {
                String[] ar = s.split("-i-");
                s = ar[1];
            } else {
                String[] ar = s.split("-");
                s = ar[1];
            }
        }
        if (Objects.equals(s, "Zero")) {
            n += 0;
        } else if (Objects.equals(s, "un")) {
            n += 1;
        } else if (Objects.equals(s, "dos")) {
            n += 2;
        } else if (Objects.equals(s, "tres")) {
            n += 3;
        } else if (Objects.equals(s, "quatre")) {
            n += 4;
        } else if (Objects.equals(s, "cinc")) {
            n += 5;
        } else if (Objects.equals(s, "sis")) {
            n += 6;
        } else if (Objects.equals(s, "set")) {
            n += 7;
        } else if (Objects.equals(s, "vuit")) {
            n += 8;
        } else if (Objects.equals(s, "nou")) {
            n += 9;
        } else if (Objects.equals(s, "deu")) {
            n += 10;
        } else if (Objects.equals(s, "onze")) {
            n += 11;
        } else if (Objects.equals(s, "dotze")) {
            n += 12;
        } else if (Objects.equals(s, "tretze")) {
            n += 13;
        } else if (Objects.equals(s, "catorze")) {
            n += 14;
        } else if (Objects.equals(s, "quinze")) {
            n += 15;
        } else if (Objects.equals(s, "setze")) {
            n += 16;
        } else if (Objects.equals(s, "disset")) {
            n += 17;
        } else if (Objects.equals(s, "divuit")) {
            n += 18;
        } else if (Objects.equals(s, "dinou")) {
            n += 19;
        }
        return n;
    }

    public static String oper(String s) {
        return "";
    }
}