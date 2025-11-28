package Skill.AttackSkill;

public class Flash extends AttackSkill{
    public Flash(String name){
        super(name);
    }
    public Flash(){
        super("閃光術");
    }

    @Override
    public void apply(){
        double x = ((int)(Math.random() * 3) + 6) / 10.0;
        int damage = (int)(getAbility() * 15 * x);
        System.out.println("使出了" + this.getName() + "\n造成了" + damage + "點傷害");
    }
}
