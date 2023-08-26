public class Achievement {
    private final String name;
    private final Float target;
    private Float progress;
    private Boolean complete;

    public Achievement(String name, Float target) {
        this.name = name;
        this.target = target;
        progress = 0f;
        complete = Boolean.FALSE;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getComplete(){
        return this.complete;
    }

    public void incrementProgress(Float times) {
        if (!complete) {
            progress += times;
            complete = target <= progress;
        }
    }
}
