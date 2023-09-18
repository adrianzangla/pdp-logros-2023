public class ActiveMembership {
    private Membership membership;
    private int hoursLeft;

    public ActiveMembership(Membership membership, int hoursLeft) {
        this.membership = membership;
        this.hoursLeft = hoursLeft;
    }

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
