package Skill.HealSkill;
import java.lang.Math;

public class BasicHeal extends HealSkill{
    public BasicHeal(String name){
        super(name);
    }
    public BasicHeal(){
        super("基礎治療術");
    }
    @Override
    public void apply(){
        int heal = (int)(calculateAmount() * ((Math.random() * 16) + 15));
        System.out.println("使出了" + getName() + "\n恢復了" + heal + "點生命");
    }
}
