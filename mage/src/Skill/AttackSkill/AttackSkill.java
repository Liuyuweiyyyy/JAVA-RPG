package Skill.AttackSkill;
import Skill.Skill;

abstract public class AttackSkill extends Skill{
    public int playerAbility = 10;
    public AttackSkill(String name) {
        super(name);
    }
    public int calculateAmount(int playerAbility){
        this.playerAbility = playerAbility;
        return this.playerAbility;
    }

    public double getAbility(){
        if(attackbuff_status()) {
            double buff = getBuff();
            get_attackbuff(1.0, false);
            return this.playerAbility * buff;
        }
        return this.playerAbility;
    }

    @Override
    public void apply(){}
}
