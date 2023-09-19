import java.util.*;

public class Main {
    public static void main(String[] args) {


        User u0 = new User("Adrian");
        AchievementSystem.initialize();
        AchievementSystem.getGames().get(0).play(u0, 4);
        System.out.println(u0);

        GameItem gi0 = new GameItem("game item 0", null, null, 0d);
        GameItem gi1 = new GameItem("game item 1", null, null, 0d);

        Map<GameItem, Integer> gm = new HashMap<>();

        gm.put(gi0, 1);
        gm.put(gi1, 2);
        Scanner sc=new Scanner(System.in);
        boolean resp=false;


        while (resp){
            //loop para que realice las operaciones que desee mientras la opcion elegida no sea salir
            System.out.println(gm);
            System.out.println("elije tu operacion a realizar");
            System.out.println("menu: "+ '\n' +
                            "1)Crear Usuarios"+'\n' +
                            "2)Utilizar usuarios ya creados"+'\n'+

                    //En cualquiera de las 2 primeras opciones se tienen que generar los movimientos
                    //pensaba en sacar la opcion salir ya que si ponemos la porcion de crear un usuario en un loop
                    //crea muchos usuarios entonces luego de haberlos creado o no,realiza los mov,muestra el estado
                    //de los usuarios y finaliza,no hay necesidad de volver a entrar
                            "3)Salir");

            int option=sc.nextInt();
            switch (option){
                case 1:
                    //crea el usuario y vuelva a ofrecerle el menu de opciones
                    System.out.println("Ingresa el nombre de usuario a crear");
                    String username=sc.nextLine();
                    User user=new User(username);
                    System.out.println("¿cuantos methodos de pago desea utilizar?");
                    int numofmethod=sc.nextInt();
                    for(int i=0;i<=numofmethod;i++){
                        System.out.println("Ingrese su metodo de pago");
                        System.out.println("1)Tarjeta de Credito"+'\n' +
                                "2)Tarjeta de Debito");
                        option=sc.nextInt();
                        if (option==1){
                            System.out.println("Ingrese el limite de su tarjeta");
                            double limit=sc.nextDouble();
                            CreditCard credit=new CreditCard(limit);
                            user.getPaymentMethods().add(credit);

                        }
                        if (option==2){
                            System.out.println("Ingrese el monto que conserva en esta tarjeta");
                            double balance=sc.nextDouble();
                            DebitCard debit=new DebitCard(balance);
                            user.getPaymentMethods().add(debit);
                        }
                    }
                    AchievementSystem.getUsers().add(user);
                    System.out.println("su usuario fue creado con exito!");
                case 2:
                    //se le ofrecen opciones que solo puede realizar si su usuario esta creado
                case 4:
                    //sale del sistema de logros
                    resp=true;
        }

        }
    }
}
