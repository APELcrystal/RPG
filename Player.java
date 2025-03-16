
import java.util.*;
public class Player {
    int hp,maxhp,mp,maxmp,sp,attack,magic;
    int level = 1;
    double levelup = 50;
    Random ran = new Random();

    public Player(int x,int y,int z,int a,int s) {
        hp = x;
        mp = y;
        sp = z;
        this.maxhp = hp;
        this.maxmp = mp;
        attack = a;
        magic = s;

    }

    //コマンド選択
    public int command(){
        System.out.printf("[あなたのターン]\n1.攻撃 2.魔法攻撃(MP10消費)　3.回復(MP10消費 30回復)\n");
        System.out.printf("コマンド選択:");
        Scanner sc = new Scanner(System.in);
        int coma = sc.nextInt();
        System.out.println();
        return coma;
    }

    //攻撃
    public int attack(){
        int damege = ran.nextInt(attack)+10;
        if(damege == 17 || damege ==14){
            damege += 100;
            System.out.printf("会心の一撃！！\nあなたは%dのダメージを与えた！\n",damege);
            Disp.dis();
            return damege;
        }
        System.out.printf("あなたは%dのダメージを与えた！\n",damege);
        Disp.dis();
        return damege;
    }

    //魔法攻撃
    public int magic(){
        int damege = ran.nextInt(magic)+15;
        this.mp -= 10;
        System.out.printf("あなたはMPを10消費して魔法を発動！\n");
        System.out.printf("%dのダメージを与えた！\n",damege);
        Disp.dis();
        return damege;

    }

    //ダメージ
    public void damegi(int damegi){
        hp -= damegi;
    }

    //回復
    public void healing(){
        mp -= 10;
        System.out.printf("あなたのMPを10消費した！\n");
        hp += 30;
        if(hp > maxhp){
            hp = maxhp;
        }
        System.out.printf("あなたHPが30回復！HP%d\n",this.hp);
        Disp.dis();

    }

    public void level(int ex){
        levelup -= ex;
        while(levelup <= 0){
                System.out.printf("レベルアップした！！\n");
                level += 1;
                hp += 20;
                this.maxhp += 20;
                mp += 20;
                this.maxmp += 20;
                sp += 10;
                attack += 8;
                magic += 8;
                levelup += 50 * (1+(level*0.1));//* (1+(level-1)/10);


            }
        }

    public int getlevel() {
        return this.level;
    }
    public void setlevel(int no){this.level = no;}

    /*hpゲッター
    public int getHp(){

    }

    //mpゲッター
    public int getMp(){

    }
    */

    //生存確認
    public boolean alive(){
        return hp > 0;
    }

    //ステータス
    public void status(){
        System.out.printf("あなたのHP:%d　MP:%d レベル:%d\n",hp,mp,level);
    }
}
