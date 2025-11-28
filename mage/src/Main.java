import Skill.Skill;
import Skill.AttackSkill.AttackSkill;
import Skill.AttackSkill.FireBall;
import Skill.AttackSkill.Flash;
import Skill.HealSkill.HealSkill;
import Skill.HealSkill.BasicHeal;
import Skill.HealSkill.AdvancedHeal;
import Skill.HealSkill.TopHeal;
import Skill.BuffSkill.AttackBuff;
import Skill.BuffSkill.BuffSkill;
import Skill.BuffSkill.HealBuff;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Skill> skills = new ArrayList<>();
        AttackSkill fireBall = new FireBall();
        HealSkill basic = new BasicHeal();
        HealSkill advance = new AdvancedHeal();
        BuffSkill attack = new AttackBuff();
        BuffSkill heal = new HealBuff();

        

        /*
        AttackSkill waterBall = new FireBall("水球術");
        AttackSkill flash = new Flash();
        HealSkill waterheal = new AdvancedHeal("水療術");
        HealSkill top = new TopHeal();

        attack.apply();
        skills.add(attack);
        System.out.println("---------------");
        fireBall.apply();
        skills.add(fireBall);
        System.out.println("---------------");
        waterBall.calculateAmount(50);
        waterBall.apply();
        skills.add(waterBall);
        System.out.println("---------------");
        flash.apply();
        skills.add(flash);
        System.out.println("---------------");
        heal.apply();
        skills.add(heal);
        System.out.println("---------------");
        basic.apply();
        skills.add(basic);
        System.out.println("---------------");
        advance.apply();
        skills.add(advance);
        System.out.println("---------------");
        waterheal.apply(5);
        skills.add(waterheal);
        System.out.println("---------------");
        top.apply();
        skills.add(top);
        System.out.println("---------------");

        //Skill[] skills = {attack, fireBall, waterBall, flash, heal, basic, advance, waterheal, top};
        for(Skill skill : skills){
            System.out.println(skill.getName());
        }*/
    }
}