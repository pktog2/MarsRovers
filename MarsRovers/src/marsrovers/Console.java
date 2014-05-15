/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package marsrovers;

import java.util.Scanner;
/**
 *
 * @author cristianomichel
 */
public class Console {
    public static Scanner teclado=new Scanner(System.in);
    public static int num1, num2, num3 ,num4, num5;
    public static String cad1, cad2, opcion;
    private static char[] puntos = {'N', 'E', 'S', 'O'}; //"Norte", "Este", "Sur", "Oeste"
    private static Object[][] destino, origen;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido ");
    	System.out.print("Ingrese las coordenadas superiores: ");
    	num1 = teclado.nextInt();
        num2 = teclado.nextInt();
        
        System.out.println("**************");
        System.out.print("Numero de ROVERS : ");
        num5 = teclado.nextInt();
        origen =  new Object[num5][4];
        destino =  new Object[num5][4];
        int x = 1;
        for (int i = 0; i < num5; i++) {
            System.out.println("**************");
            System.out.print("Ingrese la primera linea: ");
            num3 = teclado.nextInt();
            num4 = teclado.nextInt();
            cad1 = teclado.next();
            System.out.print("Ingrese la segunda linea: ");
            cad2 = teclado.next();
            origen[i][0] = num3;
            origen[i][1] = num4;
            origen[i][2] = cad1;
            origen[i][3] = cad2;
            x++;
        }
        ejecutar(origen);
        System.out.println("**************");
        System.out.println("Respuesta:");
        mostrarRes();
        opcion = teclado.next();
    }
    
    public static void mostrarRes(){
        for (int i = 0; i < num5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(destino[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int buscarPos(char car){
        int pos = -1;
        for (int i = 0; i < puntos.length; i++) {
            if(puntos[i] == car){
                pos = i;
            }
        }
        return pos;
    }
    
    public static int siguiente(int p){
        if(p<puntos.length-1)
            return p+1;
        if(p==puntos.length-1)
            return 0;
        return -1;
    }
    
    public static int anterior(int p){
        if(p>0)
            return p-1;
        if(p==0)
            return puntos.length-1;
        return -1;
    }  
    
    public static void ejecutar(Object[][] origen){
        char caracter=' ';
        int pos=-1;
        
        for(int i = 0; i < num5; i++){
            int x = Integer.valueOf(origen[i][0].toString());
            int y = Integer.valueOf(origen[i][1].toString());
            String direccion = origen[i][2].toString();
            String instruccion = origen[i][3].toString();
            
            for (int j = 0; j < instruccion.length(); j++) {
                caracter = instruccion.charAt(j);
                switch (caracter) {
                    case 'L':    // 90° a la izquierda misma posicion
                    //codigo aqui anterior
                        pos = buscarPos(direccion.charAt(0));
                        direccion = String.valueOf(puntos[anterior(pos)]);
                        destino[i][0] = x;
                        destino[i][1] = y;
                        destino[i][2] = direccion;
                        destino[i][3] = "";
                    //
                    break;
                    case 'R':    // 90° a la derecha misma 
                    //codigo aqui
                        pos = buscarPos(direccion.charAt(0));
                        direccion = String.valueOf(puntos[siguiente(pos)]);
                        destino[i][0] = x;
                        destino[i][1] = y;
                        destino[i][2] = direccion;
                        destino[i][3] = "";               //
                    break;
                    case 'M':    // Avanzar
                    //codigo aqui
                        if(direccion.charAt(0)=='N'){
                            y++;
                            destino[i][0] = x;
                            destino[i][1] = y;
                            destino[i][2] = direccion;
                            destino[i][3] = "";
                        }
                        if(direccion.charAt(0)=='E'){
                            x++;
                            destino[i][0] = x;
                            destino[i][1] = y;
                            destino[i][2] = direccion;
                            destino[i][3] = "";
                        }
                        if(direccion.charAt(0)=='S'){
                            y--;
                            destino[i][0] = x;
                            destino[i][1] = y;
                            destino[i][2] = direccion;
                            destino[i][3] = "";
                        }
                        if(direccion.charAt(0)=='O'){
                            x--;
                            destino[i][0] = x;
                            destino[i][1] = y;
                            destino[i][2] = direccion;
                            destino[i][3] = "";
                        }
                    break;
                }
            }
        }  
    }
    
}
