public class Sponge extends Enemy{
    public Sponge(){
        super("スポンジ",120, 10, 30, 50, 5,500);
    }

    @Override
    public int attack(){
        int damege = ran.nextInt(attack)+1;
        System.out.printf("%sの攻撃！\n",this.name);
        System.out.printf("%sはあなたに%dのダメージを与えた！\n",this.name,damege);
        Disp.dis();
        return damege;
    }
    @Override
    public int skil(){
        int damege = ran.nextInt(skil)+50;
        this.mp -= 10;
        System.out.printf("%sがシュワシュワした！\n",this.name);
        System.out.printf("あなたは%dのダメージを受けた！\n",damege);
        Disp.dis();
        return damege;
    }

    @Override
    public int ougi(){
        System.out.printf("%sのスマッシュ！！\n", this.name);
        int damege = ran.nextInt(attack)+80;
        System.out.printf("あなたは、%dのダメージ！\n",damege);
        Disp.dis();
        return damege;
    }
}
