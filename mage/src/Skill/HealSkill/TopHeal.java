package Skill.HealSkill;

public class TopHeal extends HealSkill{
    int heal, shield, effect;
    public TopHeal(String name){
        super(name);
    }
    public TopHeal(){
        super("頂級治療術");
    }
    @Override
    public void apply(){
        this.heal = (int)(calculateAmount() * ((Math.random() * 51) + 100));
        this.shield = (int)(Math.random() * 11) + 10;
        this.effect = 5;
        this.shield *= this.effect;
        System.out.println("使出了" + getName() + "\n恢復了" + this.heal + "點生命\n添加了" + this.shield + "點護盾\n增加了" + this.effect + "點防禦");
    }
    @Override
    public void apply(int eff){
        this.heal = (int)(calculateAmount() * ((Math.random() * 51) + 100));
        this.shield = (int)(Math.random() * 11) + 10;
        this.effect = eff;
        System.out.println("使出了" + getName() + "\n恢復了" + this.heal + "點生命\n添加了" + this.shield + "點護盾\n增加了" + this.effect + "點防禦");
    }
}
