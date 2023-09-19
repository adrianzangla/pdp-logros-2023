public class ActiveMembership {
    //Atributos: membresia,duracion de la membresia
    private Membership membership;
    private int hoursLeft;
    //constructor de "ActiveMembership"
    public ActiveMembership(Membership membership, int hoursLeft) {
        this.membership = membership;
        this.hoursLeft = hoursLeft;
    }
    //metodo "get" que devuelve la membresia del usuario
    public Membership getMembership() {
        return membership;
    }
    //metodo "get" que devuelve las horas de vida que le quedan a la membresia
    public int getHoursLeft() {
        return hoursLeft;
    }
    //metodo "set" que actualiza la membresia del usuario
    public void setMembership(Membership membership) {
        this.membership = membership;
    }
    //metodo "set" que actualiza las horas de vida que le quedan a la membresia
    public void setHoursLeft(int hoursLeft) {
        this.hoursLeft = hoursLeft;
    }
    //metodo "decreaseHoursLeft" que le resta a las horas de vida de la membresia las horas que jugo el usuario.
    public void decreaseHoursLeft() {
        if (membership == Membership.getDefaultMembership()) {
            return;
        }
        hoursLeft--;
        if (hoursLeft < 1) {
            membership = Membership.getDefaultMembership();
            hoursLeft = -1;
        }
    }

}
