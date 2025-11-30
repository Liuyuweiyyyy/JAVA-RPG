package Skill;

abstract public class Skill {
    private String name;
    private static double att_buff;
    private static double he_buff;
    private static boolean have_attackbuff;
    private static boolean have_healbuff;

    public Skill(String name){
        this.name = name;
    }
    protected void apply(){}

    public String getName(){
        return this.name;
    }

    public void get_attackbuff(double multiplier, boolean status){
        att_buff = multiplier;
        have_attackbuff = status;
    }
    public void get_healbuff(double multiplier, boolean status){
        he_buff = multiplier;
        have_healbuff = status;
    }
    public boolean attackbuff_status(){
        return have_attackbuff;
    }
    public boolean healbuff_status(){
        return have_healbuff;
    }
    public double getAttackBuff(){
        return att_buff;
    }
    public double getHealBuff(){
        return he_buff;
    }
}
