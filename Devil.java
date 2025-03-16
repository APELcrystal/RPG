public class Devil extends Enemy{

    public Devil(){
        super("悪魔",1000, 800, 100, 5, 10,0);
    }

    @Override
    public int attack(){
        int damege = ran.nextInt(attack)+40;
        System.out.printf("%sの攻撃！\n",this.name);
        System.out.printf("%sはあなたに%dのダメージを与えた！\n",this.name,damege);
        Disp.dis();
        return damege;
    }
    @Override
    public int skil(){
        int damege = ran.nextInt(skil)+50;
        this.mp -= 10;
        System.out.printf("%sは変な踊りを踊った！\n",this.name);
        System.out.printf("あなたは%dのダメージを受けた！\n",damege);
        Disp.dis();
        return damege;
    }

    public int ougi(){
        System.out.printf("%sは極大魔法を唱えた。\n", this.name);
        if(this.mp <= 0){
            System.out.printf("MPが足りず発動しません\n");
            Disp.dis();
            return 0;
        }else {
            System.out.printf("%sのMPがすべて消費された！！\n", this.name);
            int damege = this.mp + 10;
            System.out.printf("あなたは、%dのダメージ！\n", damege);
            Disp.dis();
            this.mp = 0;
            return damege;
        }
    }
}
