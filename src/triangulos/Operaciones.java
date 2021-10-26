
package triangulos;

import java.io.*;
import java.io.*;
import java.util.*;


public class Operaciones {

    public static int Cant_Reg() throws IOException {
        int cant_resgis = 0;
        Scanner leo = new Scanner(new File("Triangulos.txt"));
        while (leo.hasNextLine()) {
            leo.nextLine();
            cant_resgis++;
        }
        leo.close();
        return cant_resgis;
    }

    public static double[][] leo_Regist(double m[][]) throws IOException {
        Scanner leo = new Scanner(new File("Triangulos.txt"));
        int cont = 0;
        while (leo.hasNextLine()) {
            for (int i = 0; i < m[0].length; i++) {
                m[cont][i] = leo.nextDouble();
            }
            cont++;
        }
        leo.close();
        return m;
    }

    public static void Mostrar_Puntos(double m[][]) {

        System.out.println("      Coordenadas tres puntos del triangulo");
        System.out.println("");
        System.out.println("Tri     x1     y1      x2      y2      x3      y3");
        for (int j = 0; j < m.length; j++) {
            System.out.printf("%-3d", (j + 1));
            for (int k = 0; k < m[0].length; k++) {

                System.out.printf("%8.2f", m[j][k]);
            }
            System.out.println();
        }
    }

    private static double longitud_puntos(double x1, double y1, double x2, double y2) {
        double longi, ope;
        ope = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
        longi = Math.sqrt(ope);
        return longi;
    }

    private static double hipo_calculada(double Cate_1, double Cate_2) {
        double hipot, ope_hipo;
        ope_hipo = Math.pow(Cate_1, 2) + Math.pow(Cate_2, 2);
        hipot = Math.sqrt(ope_hipo);
        return hipot;
    }

    private static String tipo_de_triangulo(double hipo_calc, double hipo_real, double cate_1, double cate_2) {
        String clase_triang = null;
        if (hipo_calc != hipo_real) {
            clase_triang = "Triangulo No es Rectangulo";
        }
        else if (hipo_calc == hipo_real) {
            if ((hipo_real != cate_1) && (hipo_real != cate_2) && (cate_1 != cate_2)) {
                clase_triang = "Triangulo Rectangulo escaleno";
            } else if ((hipo_real == cate_1) || (hipo_real == cate_2) || (cate_1 == cate_2)) {
                clase_triang = "Triangulo Recatangulo isosceles";
            }
        } 

        return clase_triang;
    }

    public static void fin_mostrar(double m[][]) {
        double cd_1, cd_2, cd_3, hipo_real = 0, cate_1 = 0, cate_2 = 0, hipo = 0;
        String tipo_triangulo;
        System.out.println("======================================================");
        System.out.println("Tri     Estatus");
        
        for (int k = 0; k < m.length; k++) {
            System.out.printf("%-6d", (k + 1));
            cd_1 = longitud_puntos(m[k][0], m[k][1], m[k][2], m[k][3]);
            cd_2 = longitud_puntos(m[k][0], m[k][1], m[k][4], m[k][5]);
            cd_3 = longitud_puntos(m[k][4], m[k][5], m[k][2], m[k][3]);
            if ((cd_3 >= cd_2) && (cd_3 >= cd_1)) {
                hipo_real = cd_3;
                cate_1 = cd_1;
                cate_2 = cd_2;
            }
            else if ((cd_2 >= cd_1) && (cd_2 >= cd_3)) {
                hipo_real = cd_2;
                cate_1 = cd_1;
                cate_2 = cd_3;
            }
            else if ((cd_1 >= cd_2) && (cd_1 >= cd_3)) {
                hipo_real = cd_1;
                cate_1 = cd_2;
                cate_2 = cd_3;
            } 
            
            hipo = hipo_calculada(cate_1, cate_2);
            tipo_triangulo = tipo_de_triangulo(hipo, hipo_real, cate_1, cate_2);
            System.out.printf("%-25s", tipo_triangulo);
            System.out.println();
        }
    }

}
