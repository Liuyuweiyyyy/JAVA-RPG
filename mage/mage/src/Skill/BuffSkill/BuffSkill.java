package Skill.BuffSkill;
import Skill.Skill;

abstract public class BuffSkill extends Skill{
    public BuffSkill(String name){
        super(name);
    }

    @Override
    public void apply(){}
    public void apply(double multiplier){}
    public String applyReturn(){
        return "";
    }
}
