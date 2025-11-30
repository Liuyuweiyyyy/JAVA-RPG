package Skill.AttackSkill;
import java.lang.Math;

public class FireBall extends AttackSkill{
    public FireBall(String name){
        super(name);
    };
    public FireBall(){
        super("火球術");
    };

    @Override
    public void apply(){
        double x = ((int)(Math.random() * 3) + 8) / 10.0;
        int damage = (int)(getAbility() * 10 * x);
        System.out.println("使出了" + this.getName() + "\n造成了" + damage + "點傷害");
    }
    public String applyReturn(){
        double x = ((int)(Math.random() * 3) + 8) / 10.0;
        int damage = (int)(getAbility() * 10 * x);
        return ("使出了" + this.getName() + "\n造成了" + damage + "點傷害");
    }
}
