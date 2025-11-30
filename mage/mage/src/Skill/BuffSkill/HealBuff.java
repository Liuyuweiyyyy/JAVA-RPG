package Skill.BuffSkill;

public class HealBuff extends BuffSkill{
    public HealBuff(String name){
        super(name);
    }
    public HealBuff(){
        super("治療增幅");
    }

    @Override
    public void apply(){
        get_healbuff(1.5, true);
        System.out.println("使出了" + getName() + "\n提升了下次恢復1.5倍恢復力");
    }
    @Override
    public void apply(double multiplier){
        get_healbuff(multiplier, true);
        System.out.println("使出了" + getName() + "\n提升了下次恢復" + multiplier + "倍恢復力");
    }

    public String applyReturn(){
        get_healbuff(1.5, true);
        return ("使出了" + getName() + "\n提升了下次恢復" + getHealBuff() + "倍恢復力");
    }
}
