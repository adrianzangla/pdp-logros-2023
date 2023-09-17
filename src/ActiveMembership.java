public class ActiveMembership {
    private Membership membership;
    private int hoursLeft;

    public Membership getMembership() {
        return membership;
    }

    public int getHoursLeft() {
        return hoursLeft;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public void setHoursLeft(int hoursLeft) {
        this.hoursLeft = hoursLeft;
    }

    public void decreaseHoursLeft() {
        if (hoursLeft >= 1) {
            hoursLeft--;
        }
        if (hoursLeft < 1) {
            membership = Membership.getDefaultMembership();
            hoursLeft = -1;
        }
    }

}
