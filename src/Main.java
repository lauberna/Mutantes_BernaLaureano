public class Main {
    public static boolean isMutant(String[] dna) {
        int filas = dna.length;
        int columnas = dna[0].length();
        int contadorSecuencias = 0;

        //busca cualquier secuencia vertical en cualquier lado
        for (int j = 0; j < columnas; j++) {
            int conteoActual = 1;
            for (int i = 1; i < filas; i++) {
                if (dna[i].charAt(j) == dna[i - 1].charAt(j)) {
                    conteoActual++;
                    if (conteoActual == 4) {
                        contadorSecuencias++;
                        break;
                    }
                } else {
                    conteoActual = 1;
                }
            }
        }

        //busca cualquier secuencia horizontal en cualquier lado
        for (String s : dna) {
            int conteoActual = 1;
            for (int i = 1; i < columnas; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    conteoActual++;
                    if (conteoActual == 4) {
                        contadorSecuencias++;
                        break;
                    }
                } else {
                    conteoActual = 1;
                }
            }
        }

        //busca en la diagonal PRINCIPAL
        int conteoActual = 1;
        for (int j = 1; j < filas; j++) {
            if (dna[j].charAt(j) == dna[j - 1].charAt(j - 1)) {
                conteoActual++;
                if (conteoActual == 4) {
                    contadorSecuencias++;
                    break;
                }
            } else {
                conteoActual = 1;
            }
        }

        //busca en la diagonal SECUNDARIA
        conteoActual = 1;
        for (int j = 1; j < filas; j++) {
            if (dna[j].charAt(dna[j].length()-(1+j)) == dna[j - 1].charAt(dna[j].length()-j)) {
                conteoActual++;
                if (conteoActual == 4) {
                    contadorSecuencias++;
                    break;
                }
            } else {
                conteoActual = 1;
            }
        }

        System.out.println("Cantidad de secuencias encontradas: " + contadorSecuencias);
        return contadorSecuencias >= 2;
    }

    public static void main(String[] args) {
        String[] dnaMutant = {
                "ATGCAG",
                "CAGTAC",
                "CCAAGT",
                "CGAAGG",
                "CACCGA",
                "TCACTG"};

        String[] dnaNoMutante = {
                "ATGCGA",
                "CAGTGC",
                "TTATTT",
                "AGACGG",
                "GCGTCA",
                "TCACTG"};

        System.out.println("---------------");
        System.out.println("ADN MUTANTE");
        System.out.println("---------------");

        for (String adn : dnaMutant) {
            System.out.println(adn);
        }

        System.out.println("---------------");
        System.out.println("Es mutante? " + isMutant(dnaMutant));

        System.out.println("---------------");
        System.out.println("ADN NO MUTANTE");
        System.out.println("---------------");

        for (String adn : dnaMutant) {
            System.out.println(adn);
        }
        System.out.println("---------------");
        System.out.println("Es mutante? " + isMutant(dnaNoMutante));
        System.out.println("---------------");
    }

}