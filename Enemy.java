import java.util.*;

public abstract class Enemy {
    protected String name ;
    protected int hp, maxhp, mp, maxmp, sp, attack,skil,ex;
    Random ran = new Random();

    public  Enemy(String name,int hp, int mp, int sp, int attack, int skil,int ex) {
        this.name = name;
        this.hp =hp;this.mp =mp;this.sp =sp;
        this.maxhp =hp; this.maxmp =mp;
        this.attack =attack;this.skil =skil;
        this.ex = ex;
    }

    //コマンド選択
    public int command(){
        System.out.printf("[敵のターン]\n");
        Random ran = new Random();
        int coma = ran.nextInt(10)+1;
        return coma;
    }

    //攻撃 スキル
    public abstract int attack();
    public abstract int skil();
    public abstract int ougi();

    //ダメージ
    public void damegi(int damegi){
        hp -= damegi;
    }

    //名前ゲッター
    public String getName() {
        return this.name;
    }

    //hpゲッター
    public int getHp(){
        return this.hp;
    }

    //mpゲッター
    public int getMp(){
        return this.mp;

    }

    //生存確認
    public boolean alive(){
        return hp > 0;
    }

    //ステータス
    public void status(){
        System.out.printf("敵のHP:%d\n",hp);
    }
}

