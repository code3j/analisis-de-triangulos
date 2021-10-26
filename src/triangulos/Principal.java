package triangulos;
import java.io.*;
import java.io.*;

public class Principal {

    public static void main(String[] args)throws IOException {
       int cant_registros;
       int colu=6;
       cant_registros=Operaciones.Cant_Reg();
       double[][] matriz_trian=new double [cant_registros][colu];
       Operaciones.leo_Regist(matriz_trian);
       Operaciones.Mostrar_Puntos(matriz_trian);
       Operaciones.fin_mostrar(matriz_trian);
    }
    
}