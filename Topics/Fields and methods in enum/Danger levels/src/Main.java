enum DangerLevel {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private final int dangerLevel;
    DangerLevel(int level){
        this.dangerLevel = level;
    }
    public int getLevel(){
        return this.dangerLevel;
    }
}