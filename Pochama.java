
public class Pochama extends Enemy {
    public Pochama(){
        super("ポチャエモン",3500, 150, 500, 9, 10,10);
    }

    @Override
    public int attack(){
        int damege = (ran.nextInt(attack)+1)*10;
        System.out.printf("%sの攻撃！\n",this.name);
        System.out.printf("%sはあなたに%dのダメージを与えた！\n",this.name,damege);
        Disp.dis();
        return damege;
    }
    @Override
    public int skil(){
        int damegee=1;
        int damege = ran.nextInt(skil)+1;
        //階乗攻撃
        for(int i=2;i <= damege;i++){
            damegee *= i;
        }
        this.mp -= 30;
        System.out.printf("%sが波乗りを使用した！\n",this.name);
        System.out.printf("あなたは%dのダメージを受けた！\n",damegee);
        Disp.dis();
        return damegee;
    }

    @Override
    public int ougi(){
        int damege = ran.nextInt(attack)+1;
        int damegee = 1;
        //５のn乗攻撃
        for(int i =0;i<damege;i++){
            damegee *= 5;
        }
        System.out.printf("%sはハイドロポンプの一撃！！\n", this.name);
        System.out.printf("あなたは、%dのダメージ！\n",damegee);
        Disp.dis();
        return damegee;
    }
}
