import java.util.Scanner;

public class Superplayer extends Player{
   int player_level = 0;

    public Superplayer(int level){
        // 親クラスのコンストラクターを最初に呼び出す
        super(1000 + (100 * level), 100 + (10 * level), 1000 + (10 + level), 10+level, 10+level);
        super.setlevel(level);
        player_level = level;
        // ここで他の初期化処理を行うことができます
    }

    @Override
    public int attack(){
        int damege = ran.nextInt(attack)+(80+(1*player_level));
        System.out.printf("あなたは%dのダメージを与えた！\n",damege);
        Disp.dis();
        return damege;
    }
    @Override
    public int command(){
        System.out.printf("[あなたのターン]\n1.攻撃 2.魔法攻撃(MP10消費)　3.回復(全回復)　4.スキル（MP50消費）\n");
        System.out.printf("コマンド選択:");
        Scanner sc = new Scanner(System.in);
        int coma = sc.nextInt();
        System.out.println();
        return coma;
    }
    @Override
    //魔法攻撃
    public int magic(){
        int damege = ran.nextInt(magic)+(150+(1*player_level));
        this.mp -= 10;
        System.out.printf("あなたはMPを10消費して魔法を発動！\n");
        System.out.printf("%dのダメージを与えた！\n",damege);
        Disp.dis();
        return damege;
    }
    @Override
    public void healing(){
        hp = maxhp;
        mp = maxmp;
        System.out.printf("全回復！！\nあなたのHPとMPが全回復した\n");
        Disp.dis();

    }

    public int skil(){
        int damege = ran.nextInt(magic)+(500*(20*player_level));
        this.mp -= 50;
        System.out.printf("あなたはMPを50消費して「ギガデイン」を発動！\n");
        System.out.printf("%dのダメージを与えた！\n",damege);
        Disp.dis();
        return damege;
    }

}
