import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Projeto {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        String localDataHora = in.nextLine();
        int L = in.nextInt();
        int C = in.nextInt();
        int[][] temperaturas = new int[L][C];
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                temperaturas[h][i] = in.nextInt();
            }
        }
        System.out.println("b)");
        mostrarMT(temperaturas, L, C);
        System.out.println("c)");
        mostrarMA(temperaturas, L, C);
        System.out.println("d)");
        int[][] Temperaturas = mostrarNovoMA(temperaturas, L, C);
        System.out.println("e)");
        mostrarAreaAfetada(temperaturas, L, C);
        System.out.println("f)");
        mostrarTemperaturamenor(temperaturas, L, C);
        System.out.println("g)");
        String[][] MAalteradopor10C = percentagemAlteracao(Temperaturas, L, C);
        System.out.println("h)");
        MAafetadopelovento(MAalteradopor10C, L, C);
        int[][] temperaturasomada = temperaturasSomadas(temperaturas, L, C);
        System.out.println("i)");
        mostrarCoordenadas(temperaturasomada, L, C);
        System.out.println("j)");

    }

    private static void mostrarMT(int[][] temperaturas, int L, int C) {
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                System.out.printf("%4d", temperaturas[h][i]);                  //escrita dos valores de temperatura na tela//
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void mostrarMA(int[][] temperaturas, int L, int C) {
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                if (temperaturas[h][i] < 20) {
                    System.out.print("M");
                } else if (temperaturas[h][i] >= 20 && temperaturas[h][i] < 30) {
                    System.out.print("H");
                } else if (temperaturas[h][i] >= 30 && temperaturas[h][i] < 40) {
                    System.out.print("E");
                } else {
                    System.out.print("C");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] mostrarNovoMA(int[][] temperaturas, int L, int C) {
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                temperaturas[h][i] -= 10;
            }
        }
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                System.out.printf("%4d", temperaturas[h][i]);                  //escrita dos valores de temperatura na tela//
            }
            System.out.println();
        }
        System.out.println();
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                if (temperaturas[h][i] < 20) {
                    System.out.print("M");
                } else if (temperaturas[h][i] >= 20 && temperaturas[h][i] < 30) {
                    System.out.print("H");
                } else if (temperaturas[h][i] >= 30 && temperaturas[h][i] < 40) {
                    System.out.print("E");
                } else if (temperaturas[h][i] >= 40) {
                    System.out.print("C");
                }
            }
            System.out.println();
        }
        System.out.println();
        return temperaturas;
    }

    private static void mostrarAreaAfetada(int[][] temperaturas, int L, int C) {
        double contardorTemperaturas = L * C;
        int contadorModerate = 0;
        int contadorHight = 0;
        int contadorExtreme = 0;
        int contadorCatastrophic = 0;
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                if (temperaturas[h][i] < 20) {
                    contadorModerate++;
                } else if (temperaturas[h][i] >= 20 && temperaturas[h][i] < 30) {
                    contadorHight++;
                } else if (temperaturas[h][i] >= 30 && temperaturas[h][i] < 40) {
                    contadorExtreme++;
                } else if (temperaturas[h][i] >= 40) {
                    contadorCatastrophic++;
                }
            }
        }
        System.out.printf("Moderate      :%8.2f%%%n", media(contadorModerate, contardorTemperaturas));
        System.out.printf("Hight         :%8.2f%%%n", media(contadorHight, contardorTemperaturas));
        System.out.printf("Extreme       :%8.2f%%%n", media(contadorExtreme, contardorTemperaturas));
        System.out.printf("Catastrophic  :%8.2f%%%n\n", media(contadorCatastrophic, contardorTemperaturas));

    }

    private static double media(int contadores, double contardorTemperaturas) {
        double media = contadores / contardorTemperaturas * 100;
        return media;
    }

    private static void mostrarTemperaturamenor(int[][] temperaturas, int L, int C) {
        int menor = 10000;                   //? perguntar
        int diferencaCatastrophic;
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                if (temperaturas[h][i] < menor) {
                    menor = temperaturas[h][i];
                }
            }
        }
        diferencaCatastrophic = 40 - menor;
        System.out.println("To get all terrain on CATASTROPHIC alert, the temperature has to rise : " + diferencaCatastrophic + " ºC");
        System.out.println();
    }

    private static String[][] percentagemAlteracao(int[][] Temperaturas, int L, int C) {     // //int [][] Temperaturas = int [][] mostrarNovoMA
        int[][] temperaturaSomada = new int[L][C];
        int[][] temperaturas = Temperaturas;
        String[][] MAtemperaturas = new String[L][C];
        String[][] MAtemperaturasSomadas = new String[L][C];
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                temperaturaSomada[h][i] = Temperaturas[h][i] + 10;
            }
        }
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                if (temperaturaSomada[h][i] < 20) {
                    MAtemperaturasSomadas[h][i] = "M";
                } else if (temperaturaSomada[h][i] >= 20 && temperaturaSomada[h][i] < 30) {
                    MAtemperaturasSomadas[h][i] = "H";
                } else if (temperaturaSomada[h][i] >= 30 && temperaturaSomada[h][i] < 40) {
                    MAtemperaturasSomadas[h][i] = "E";
                } else {
                    MAtemperaturasSomadas[h][i] = "C";
                }
            }
        }
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                if (Temperaturas[h][i] < 20) {
                    MAtemperaturas[h][i] = "M";
                } else if (Temperaturas[h][i] >= 20 && Temperaturas[h][i] < 30) {
                    MAtemperaturas[h][i] = "H";
                } else if (Temperaturas[h][i] >= 30 && Temperaturas[h][i] < 40) {
                    MAtemperaturas[h][i] = "E";
                } else {
                    MAtemperaturas[h][i] = "C";
                }
            }
        }
        int contadortotal = L * C;
        String[][] MAfinalcomparacao = new String[L][C];
        int contadorMAalterados = 0;
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                if (!MAtemperaturas[h][i].equals(MAtemperaturasSomadas[h][i])) {
                    MAfinalcomparacao[h][i] = MAtemperaturasSomadas[h][i];
                    contadorMAalterados++;
                } else {                                                                      //escrita dos valores de temperatura na tela//
                    MAfinalcomparacao[h][i] = MAtemperaturas[h][i];
                }
            }
        }
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                System.out.printf("%s", MAfinalcomparacao[h][i]);
            }
            System.out.println();
        }
        System.out.println();
        double percentagemdetemperaturasalteradas = ((double) contadorMAalterados / contadortotal) * 100;
        System.out.printf("Alert Levels changes due to temperature variations by 10ºC : %.2f%%\n\n", percentagemdetemperaturasalteradas);
        return MAfinalcomparacao;
    }

    private static void MAafetadopelovento(String[][] MAalteradopor10C, int L, int C) {
        String[][] MAalteradopelosalertas = MAalteradopor10C;
        for (int h = L - 1; h > 0; h--) {
            for (int i = C - 1; i >= 0; i--) {
                if (MAalteradopor10C[h - 1][i].equals("C")) {
                    MAalteradopelosalertas[h][i] = "C";
                }
            }
        }
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                System.out.printf("%s", MAalteradopelosalertas[h][i]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] temperaturasSomadas(int[][] Temperaturas, int L, int C) {
        int[][] temperaturaSomada = new int[L][C];
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                temperaturaSomada[h][i] = Temperaturas[h][i] + 10;
            }
        }
        return temperaturaSomada;
    }


    public static void mostrarCoordenadas(int[][] temperaturas, int L, int C) {
        int temperaturaMax=50;
        int contadorFogo=0;
        int c1=10,c2=10;
        for (int h=0;h<L;h++) {
            for (int i = 0; i < C; i++) {
                if (temperaturas[h][i] > temperaturaMax) {
                    contadorFogo++;
                    if (i < c2) {
                        c1 = h;
                        c2 = i;
                    }
                }
            }
        }
        if (c1==0){
            c1++;

        } else if (c1>0&&c1<L-1) {
            c1=c1;
        } else if (c1==L-1) {
            c1--;
        }
        if (c2==0){
            c2++;

        } else if (c2>0&&c2<C) {
            c2=c2-1;
        }
        for (int h=0;h<L;h++) {
            for (int i = 0; i < C; i++) {
                System.out.printf("%4d", temperaturas[h][i]);
            }
            System.out.println();
        }
        System.out.println();
        if (contadorFogo==0){
            System.out.println("no fire\n\n");
        }else {
            System.out.println("drop water at (" + c1 + " , " + c2 + ")\n\n");
        }
    }
}


