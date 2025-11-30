package Skill.HealSkill;
import Skill.Skill;

abstract public class HealSkill extends Skill{
    public HealSkill(String name){
        super(name);
    }

    @Override
    public void apply(){}

    public double calculateAmount(){
        if(healbuff_status()) {
            double buff = getHealBuff();
            get_healbuff(1.0, false);
            return buff;
        }
        return 1.0;
    }

    public void set(int heal_low, int heal_high, int shield_low, int shield_high, int eff){
        return;
    }
    public String applyReturn(){
        return "";
    }
}
