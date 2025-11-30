package Skill.BuffSkill;

public class AttackBuff extends BuffSkill{
    public AttackBuff(String name){
        super(name);
    }
    public AttackBuff(){
        super("力量增幅");
    }

    @Override
    public void apply(){
        get_attackbuff(1.5, true);
        System.out.println("使出了" + getName() + "\n提升了下次攻擊1.5倍攻擊力");
    }
    @Override
    public void apply(double multiplier){
        get_attackbuff(multiplier, true);
        System.out.println("使出了" + getName() + "\n提升了下次攻擊" + multiplier + "倍攻擊力");
    }

    public String applyReturn(){
        get_attackbuff(1.5, true);
        return ("使出了" + getName() + "\n提升了下次攻擊" + getAttackBuff() + "倍攻擊力");
    }
}
