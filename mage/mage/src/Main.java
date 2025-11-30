import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Skill.Skill;
import Skill.AttackSkill.AttackSkill;
import Skill.AttackSkill.FireBall;
import Skill.AttackSkill.Attack_mod;
import Skill.HealSkill.HealSkill;
import Skill.HealSkill.BasicHeal;
import Skill.HealSkill.AdvancedHeal;
import Skill.HealSkill.Heal_mod;
import Skill.BuffSkill.AttackBuff;
import Skill.BuffSkill.BuffSkill;
import Skill.BuffSkill.HealBuff;

public class Main {

    static int row = 0;
    static int col = 0;
    static ArrayList<ArrayList<Skill>> skills = new ArrayList<>();

    static JTextArea menuArea;
    static JTextArea outputArea;

    public static void main(String[] args) {

        AttackSkill fireBall = new FireBall();
        AttackSkill attack = new Attack_mod();
        HealSkill basic = new BasicHeal();
        HealSkill advance = new AdvancedHeal();
        HealSkill heal = new Heal_mod();
        BuffSkill attack_buff = new AttackBuff();
        BuffSkill heal_buff = new HealBuff();

        skills.add(new ArrayList<>(Arrays.asList(fireBall, attack)));
        skills.add(new ArrayList<>(Arrays.asList(basic, advance, heal)));
        skills.add(new ArrayList<>(Arrays.asList(attack_buff, heal_buff)));

        // ====== GUI 視窗 =======
        JFrame frame = new JFrame("Skill Menu");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        menuArea = new JTextArea();
        menuArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
        menuArea.setEditable(false);

        outputArea = new JTextArea();
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        outputArea.setEditable(false);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(menuArea),
                new JScrollPane(outputArea));
        splitPane.setResizeWeight(0.5); // 各占一半
        splitPane.setDividerSize(5);     // 分割線寬度

        frame.add(splitPane);
        frame.setVisible(true);

        frame.add(panel);
        frame.setVisible(true);

        panel.setFocusable(true);
        panel.requestFocusInWindow();

        //禁止點擊
        frame.setGlassPane(new JPanel() {
            {
                setOpaque(false);
                addMouseListener(new java.awt.event.MouseAdapter() {}); // 吃掉所有點擊
                addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {});
            }
        });
        frame.getGlassPane().setVisible(true);

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:    if (row > 0) row--; break;
                    case KeyEvent.VK_DOWN:  if (row < skills.size()-1) row++; break;
                    case KeyEvent.VK_LEFT:  if (col > 0) col--; break;
                    case KeyEvent.VK_RIGHT: if (col < skills.get(row).size()-1) col++; break;

                    case KeyEvent.VK_ENTER:
                        Skill s = skills.get(row).get(col);

                        if(row != 2 && col == (skills.get(row).size()-1)){
                            addNewSkill(row);
                        } else {
                            applySkill(s);
                        }
                        break;
                }

                printMenuToGUI();
                panel.requestFocusInWindow();
            }
        });

        printMenuToGUI();
    }

    // 顯示選單 (改成顯示在 GUI)
    static void printMenuToGUI() {
        StringBuilder sb = new StringBuilder();

        // 取得最大名稱長度
        int maxLen = skills.stream()
                .flatMap(ArrayList::stream)
                .mapToInt(s -> s.getName().length())
                .max().orElse(10);
        int width = maxLen + 4; // 給選中 [ ] 和間距

        for (int r = 0; r < skills.size(); r++) {
            for (int c = 0; c < skills.get(r).size(); c++) {
                String name = skills.get(r).get(c).getName();
                if (r == row && c == col) {
                    name = "[ " + name + " ]";
                }

                int len = name.length();
                int paddingLeft = (width - len) / 2;
                int paddingRight = width - len - paddingLeft;

                sb.append(" ".repeat(Math.max(0, paddingLeft)));
                sb.append(name);
                sb.append(" ".repeat(Math.max(0, paddingRight)));
            }
            sb.append("\n");
        }

        menuArea.setText(sb.toString());
    }

    // 使出技能（GUI顯示）
    static void applySkill(Skill s) {
        String result;

        if (s instanceof AttackSkill)
            result = ((AttackSkill) s).applyReturn();
        else if (s instanceof HealSkill)
            result = ((HealSkill) s).applyReturn();
        else
            result = ((BuffSkill) s).applyReturn();

        outputArea.append(result + "\n");
    }

    // 新增技能（改成 GUI 版）
    static void addNewSkill(int row) {

        String name = JOptionPane.showInputDialog("請輸入法術名稱:");
        if (name == null) return;

        if(row == 0){       // 攻擊
            AttackSkill a = new Attack_mod(name);

            String base = JOptionPane.showInputDialog("請輸入基礎傷害:");
            int baseDamage = Integer.parseInt(base);
            a.calculateAmount(baseDamage);

            String multi = JOptionPane.showInputDialog("請輸入基礎倍率:");
            int m = Integer.parseInt(multi);

            String xy = JOptionPane.showInputDialog("輸入隨機波動 x y (用空白分開)");
            String[] part = xy.split(" ");
            int x = Integer.parseInt(part[0]);
            int y = Integer.parseInt(part[1]);

            a.set(x, y, m);
            skills.get(row).add(skills.get(row).size() - 1, a);
        } else if(row == 1){  // 治癒
            HealSkill h = new Heal_mod(name);

            String hxhy = JOptionPane.showInputDialog("治癒隨機波動 hx hy:");
            String[] A = hxhy.split(" ");

            String sxsy = JOptionPane.showInputDialog("護盾隨機波動 sx sy:");
            String[] B = sxsy.split(" ");

            String def = JOptionPane.showInputDialog("防禦力:");
            int df = Integer.parseInt(def);

            h.set(Integer.parseInt(A[0]), Integer.parseInt(A[1]),
                    Integer.parseInt(B[0]), Integer.parseInt(B[1]),
                    df);

            skills.get(row).add(skills.get(row).size() - 1, h);
        }
    }
}