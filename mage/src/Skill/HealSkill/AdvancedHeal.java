package Skill.HealSkill;
import java.lang.Math;

public class AdvancedHeal extends HealSkill{
    int heal;
    public AdvancedHeal(String name){
        super(name);
    }
    public AdvancedHeal(){
        super("進階治療術");
    }
    @Override
    public void apply(){
        this.heal = (int)(calculateAmount() * ((Math.random() * 21) + 40));
        System.out.println("使出了" + getName() + "\n恢復了" + this.heal + "點生命\n增加了0點防禦");
    }
    @Override
    public void apply(int eff){
        this.heal = (int)(calculateAmount() * ((Math.random() * 21) + 40));
        System.out.println("使出了" + getName() + "\n恢復了" + this.heal + "點生命\n增加了" + eff + "點防禦");
    }
}
