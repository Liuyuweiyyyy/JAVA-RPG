package Skill.HealSkill;
import Skill.Skill;

abstract public class HealSkill extends Skill{
    public HealSkill(String name){
        super(name);
    }

    @Override
    public void apply(){}
    public void apply(int eff){}

    public double calculateAmount(){
        if(healbuff_status()) {
            double buff = getBuff();
            get_healbuff(1.0, false);
            return buff;
        }
        return 1.0;
    }
}
