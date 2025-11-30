package Skill.AttackSkill;
import java.lang.Math;

public class Attack_mod extends AttackSkill{
    int low, high, multi;
    public Attack_mod(String name){
        super(name);
    };
    public Attack_mod(){
        super("自創法術");
    };

    public void set(int att_low, int att_high, int multi){
        if(att_low < att_high) {
            this.low = att_low;
            this.high = att_high;
            this.multi = multi;
        }else{
            this.low = att_high;
            this.high = att_low;
            this.multi = multi;
        }
    }

    @Override
    public void apply(){
        double x = ((int)(Math.random() * (this.high - this.low + 1)) + this.low) / 10.0;
        int damage = (int)(getAbility() * this.multi * x);
        System.out.println("使出了" + this.getName() + "\n造成了" + damage + "點傷害");
    }

    public String applyReturn(){
        double x = ((int)(Math.random() * (this.high - this.low + 1)) + this.low) / 10.0;
        int damage = (int)(getAbility() * this.multi * x);
        return ("使出了" + this.getName() + "\n造成了" + damage + "點傷害");
    }
}
