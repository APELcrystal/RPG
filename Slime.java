public class Slime extends Enemy {
    public Slime(){
        super("スライム",30, 20, 30, 10, 3,50);
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
        System.out.printf("%sが石をなげてきた！\n",this.name);
        System.out.printf("あなたは%dのダメージを受けた！\n",damege);
        Disp.dis();
        return damege;
    }

    @Override
    public int ougi(){
        System.out.printf("%sは会心の一撃！！\n", this.name);
        int damege = ran.nextInt(attack)+25;
        System.out.printf("あなたは、%dのダメージ！\n",damege);
        Disp.dis();
        return damege;
    }
}
