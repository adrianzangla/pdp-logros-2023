public class Rank {
    private String name;
    private Float experienceRequired;

    public Boolean isRank(User user) {
        return user.getExperience() >= experienceRequired;
    }
}
