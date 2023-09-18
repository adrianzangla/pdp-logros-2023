import java.util.Scanner;

public class Menu {
    public static void menuOptions(){

        Scanner sc=new Scanner(System.in);
        int option;
        System.out.println("elija una opcion");
        System.out.println("menu: "+ '\n' +
                //este menu iria si se pidiera que se muestre el estado de un usuario en particular
                //en este caso pide el estado de todos los usuarios asique sacaria las opc 3,4,6(que sean parte de los movimientos generados)
                "1)Jugar"+'\n' +
                "2)Mostrar Inventario"+'\n'+
                "3)Consumir item"+'\n'+
                "4)Comprar item"+'\n'+
                "5)Mostrar logros"+'\n'+
                "6)Realizar transaccion"+'\n'+
                "7)Mostrar gasto promedio"+'\n'+
                "8)Mostrar item mas comprado");
        option=sc.nextInt();
        switch (option){
            case 1:

            case 2:
                System.out.println("elija una opcion");
            case 3:
            case 4:
        }

    }
}
