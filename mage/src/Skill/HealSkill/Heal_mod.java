package Skill.HealSkill;
import java.lang.Math;

public class Heal_mod extends HealSkill{
    int heal, shield, effect, heal_low, heal_high;
    public Heal_mod(String name){
        super(name);
    }
    public Heal_mod(){
        super("自創治療術");
    }

    public void set(int heal_low, int heal_high, int shield_low, int shield_high, int eff){
        this.heal_low = heal_low;
        this.heal_high = heal_high;
        if(shield_low < shield_high)
            this.shield = (int)((Math.random() * (shield_high - shield_low + 1)) + shield_low);
        else
            this.shield = (int)((Math.random() * (shield_low - shield_high + 1)) + shield_high);

        this.effect = eff;
    }

    @Override
    public void apply(){
        System.out.println("使出了" + getName());
        if(this.heal == 0 && this.shield == 0 && this.effect == 0)
            System.out.println("虛晃了對手一招");
        else{
            if(this.heal > 0) {
                if (heal_low < heal_high)
                    this.heal = (int) (calculateAmount() * ((Math.random() * (heal_high - heal_low + 1)) + heal_low));
                else
                    this.heal = (int) (calculateAmount() * ((Math.random() * (heal_low - heal_high + 1)) + heal_high));
                System.out.println("恢復了" + this.heal + "點生命");
            }
            if(this.shield > 0)
                System.out.println("增加了" + this.shield + "點護盾");
            if(this.effect > 0)
                System.out.println("增加了" + this.effect + "點防禦");
        }
    }
    public String applyReturn(){
        String result = "";
        result = ("使出了" + getName());
        if(this.heal == 0 && this.shield == 0 && this.effect == 0)
            result += ("\n虛晃了對手一招");
        else{
            if (heal_low < heal_high)
                this.heal = (int) (calculateAmount() * ((Math.random() * (heal_high - heal_low + 1)) + heal_low));
            else
                this.heal = (int) (calculateAmount() * ((Math.random() * (heal_low - heal_high + 1)) + heal_high));
            if(this.heal > 0) {
               result += ("\n恢復了" + this.heal + "點生命");
            }
            if(this.shield > 0)
                result += ("\n增加了" + this.shield + "點護盾");
            if(this.effect > 0)
                result += ("\n增加了" + this.effect + "點防禦");
        }
        return result;
    }
}
