import java.util.Scanner;

public class Projeto {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String informacoes = verificarLocalHoraData();
        int L = sc.nextInt(); //?
        int C = sc.nextInt();//?
        int[][] temperaturas = new int[L][C];
        mostrarMT(temperaturas, L, C);
        mostrarMA(temperaturas,L,C);
        mostrarNovoMA(temperaturas,L,C);
        mostrarArea(temperaturas,L,C);
        mostrarTemperatura(temperaturas,L,C);
        percentagemAlteracao(mostrarNovoMA(temperaturas,L,C),L,C);
    }

    private static void percentagemAlteracao(int[][] Temperaturas,int L,int C) {      //int [][] Temperaturas = int [][] mostrarNovoMA
        int[][] temperaturaSomada=new int[L][C];
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                temperaturaSomada[h][i]=Temperaturas[h][i]+10;
            }
        }
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                if (temperaturaSomada[L][C] < 20) {
                    System.out.print("M");
                } else if (temperaturaSomada[L][C] >= 20 && temperaturaSomada[L][C] < 30) {
                    System.out.print("H");
                } else if (temperaturaSomada[L][C] >= 30 && temperaturaSomada[L][C] < 40) {
                    System.out.print("E");
                } else if (temperaturaSomada[L][C] >= 40) {
                    System.out.print("C");
                }
            }
        }
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                if (temperaturaSomada[L][C] < 20) {
                    System.out.print("M");
                } else if (temperaturaSomada[L][C] >= 20 && temperaturaSomada[L][C] < 30) {
                    System.out.print("H");
                } else if (temperaturaSomada[L][C] >= 30 && temperaturaSomada[L][C] < 40) {
                    System.out.print("E");
                } else if (temperaturaSomada[L][C] >= 40) {
                    System.out.print("C");
                }
            }
        }
    }

    private static void mostrarTemperatura(int[][] temperaturas, int L, int C) {
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
        System.out.println("To get all terrain on CATASTROPHIC alert, the temperature has to rise :" + diferencaCatastrophic + "ÂºC");
    }

    private static void mostrarArea(int[][] temperaturas, int L, int C) {
        double contardorTemperaturas= L* C;
        int contadorModerate=0;
        int contadorHight=0;
        int contadorExtreme=0;
        int contadorCatastrophic=0;
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                if (temperaturas[L][C] < 20) {
                    contadorModerate++;
                } else if (temperaturas[L][C] >= 20 && temperaturas[L][C] < 30) {
                    contadorHight++;
                } else if (temperaturas[L][C] >= 30 && temperaturas[L][C] < 40) {
                    contadorExtreme++;
                } else if (temperaturas[L][C] >= 40) {
                    contadorCatastrophic++;
                }
            }
        }
        System.out.printf("Moderate      :%8.2f%%%n",media(contadorModerate,contardorTemperaturas));
        System.out.printf("Hight         :%8.2f%%%n",media(contadorHight,contardorTemperaturas));
        System.out.printf("Extreme       :%8.2f%%%n",media(contadorExtreme,contardorTemperaturas));
        System.out.printf("Catastrophic  :%8.2f%%%n",media(contadorCatastrophic,contardorTemperaturas));

    }

    private static double media(int contadores, double contardorTemperaturas) {
        double media= contadores/contardorTemperaturas*100;
        return media;
    }

    private static int[][] mostrarNovoMA(int[][] temperaturas, int L, int C) {
        for (int h=0;h<L;h++){
            for (int i=0;i<C;i++){
                temperaturas[h][i]-=10;
            }
        }
        if (temperaturas[L][C] < 20) {
            System.out.print("M");
        } else if (temperaturas[L][C] >= 20 && temperaturas[L][C] < 30) {
            System.out.print("H");
        } else if (temperaturas[L][C] >= 30 && temperaturas[L][C] < 40) {
            System.out.print("E");
        } else if (temperaturas[L][C] >= 40) {
            System.out.print("C");
        }
        return temperaturas;
    }

    private static void mostrarMA(int[][] temperaturas, int L, int C) {
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                if (temperaturas[L][C] < 20) {
                    System.out.print("M");
                } else if (temperaturas[L][C] >= 20 && temperaturas[L][C] < 30) {
                    System.out.print("H");
                } else if (temperaturas[L][C] >= 30 && temperaturas[L][C] < 40) {
                    System.out.print("E");
                } else if (temperaturas[L][C] >= 40) {
                    System.out.print("C");
                }
            }
        }
    }

    private static String verificarLocalHoraData() {           //verificarLocalHoraData//
        String informacoes = sc.nextLine();
        return informacoes;
    }

    private static void mostrarMT(int[][] temperaturas, int L, int C) {
        for (int h = 0; h < L; h++) {
            for (int i = 0; i < C; i++) {
                System.out.printf("%d4d", temperaturas[h][i]);                  //escrita dos valores de temperatura na tela//
            }
            System.out.println();
        }
    }
}