public class Tiikawa extends Enemy{
    public Tiikawa(){
        super("ちいかわ",20, 10, 30, 10, 20,150);
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
        int damege = ran.nextInt(skil)+10;
        this.mp -= 10;
        System.out.printf("%s　かわいい！\n",this.name);
        System.out.printf("あなたは%dのダメージを受けた！\n",damege);
        Disp.dis();
        return damege;
    }

    @Override
    public int ougi(){
        System.out.printf("%sの体当たり！！\n", this.name);
        int damege = ran.nextInt(attack)+30;
        System.out.printf("あなたは、%dのダメージ！\n",damege);
        Disp.dis();
        return damege;
    }
}
