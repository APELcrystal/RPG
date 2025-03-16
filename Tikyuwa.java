public class Tikyuwa extends Enemy {
    public Tikyuwa(){
        super("キュアビューティ",210, 50, 999, 44, 44,650);
    }

    @Override
    public int attack(){
        int damege = ran.nextInt(attack)+1;
        System.out.printf("%sの浄化技！\n",this.name);
        System.out.printf("%sはあなたに%dのダメージを与えた！\n",this.name,damege);
        Disp.dis();
        return damege;
    }
    @Override
    public int skil(){
        int damege = ran.nextInt(skil)+5;
        this.mp -= 10;
        System.out.printf("%sがアイスソードを投げてきた！\n",this.name);
        System.out.printf("あなたは%dのダメージを受けた！\n",damege);
        Disp.dis();
        return damege;
    }

    @Override
    public int ougi(){
        System.out.printf("%sのウルトラハッピー！！\n", this.name);
        int damege = ran.nextInt(attack)+99;
        System.out.printf("あなたは、%dのダメージ！\n",damege);
        Disp.dis();
        return damege;
    }
}
