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
        mostrarNovoMA(temperaturas, L, C);
        System.out.println("e)");
        mostrarAreaAfetada(temperaturas, L, C);
        System.out.println("f)");
        mostrarTemperaturamenor(temperaturas, L, C);
        System.out.println("g)");
        percentagemAlteracao(mostrarNovoMA(temperaturas, L, C), L, C);
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
        double contardorTemperaturas= L* C;
        int contadorModerate=0;
        int contadorHight=0;
        int contadorExtreme=0;
        int contadorCatastrophic=0;
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
        System.out.printf("Moderate      :%8.2f%%%n",media(contadorModerate,contardorTemperaturas));
        System.out.printf("Hight         :%8.2f%%%n",media(contadorHight,contardorTemperaturas));
        System.out.printf("Extreme       :%8.2f%%%n",media(contadorExtreme,contardorTemperaturas));
        System.out.printf("Catastrophic  :%8.2f%%%n\n",media(contadorCatastrophic,contardorTemperaturas));

    }

    private static double media(int contadores, double contardorTemperaturas) {
        double media= contadores/contardorTemperaturas*100;
        return media;
    }
    private static void mostrarTemperaturamenor(int[][] temperaturas, int L, int C) {
        int menor=10000;                   //? perguntar
        int diferencaCatastrophic;
        for (int h=0;h<L;h++){
            for (int i=0;i<C;i++){
                if (temperaturas[h][i]<menor){
                    menor=temperaturas[h][i];
                }
            }
        }
        diferencaCatastrophic=40-menor;
        System.out.println("To get all terrain on CATASTROPHIC alert, the temperature has to rise : " + diferencaCatastrophic + " ºC");
        System.out.println();
    }
    private static void percentagemAlteracao(int[][] Temperaturas,int L,int C) {     // //int [][] Temperaturas = int [][] mostrarNovoMA
        int[][] temperaturaSomada=new int[L][C];
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                temperaturaSomada[h][i]=Temperaturas[h][i]+10;
            }
        }
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                if (temperaturaSomada[h][i] < 20) {
                    System.out.print("M");
                } else if (temperaturaSomada[h][i] >= 20 && temperaturaSomada[h][i] < 30) {
                    System.out.print("H");
                } else if (temperaturaSomada[h][i] >= 30 && temperaturaSomada[h][i] < 40) {
                    System.out.print("E");
                } else if (temperaturaSomada[h][i] >= 40) {
                    System.out.print("C");
                }
            }
        }
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                if (temperaturaSomada[h][i] < 20) {
                    System.out.print("M");
                } else if (temperaturaSomada[h][i] >= 20 && temperaturaSomada[h][i] < 30) {
                    System.out.print("H");
                } else if (temperaturaSomada[h][i] >= 30 && temperaturaSomada[h][i] < 40) {
                    System.out.print("E");
                } else if (temperaturaSomada[h][i] >= 40) {
                    System.out.print("C");
                }
            }
        }
    }
}
