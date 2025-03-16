import java.util.*;
public class
Main {
    /*
    変更箇所　①Enemyを使って、継承して作る。
            ②自分のステータスを変えるなら、下のキャラステータスを変更。
            ③敵が増えれば、Enemy[] enemies = {?};　に追加
            ④技を増やすなら、Player（モンスタ）クラスの変更
            　→　下のPlayeraa(Enemyaa)のswichに追加

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int i = 0;
        int j = 0;

        //キャラステータス（インスタンス）
        Player player = new Player(100, 30, 50, 10, 5);//hp,mp,sp,攻撃,魔法(+10)
        //タイトル
        System.out.println("");
        System.out.printf("「ドラクエもどき」の世界へようこそ!!\nモンスターを倒し、レベルを上げ「ボス」を倒してください!!\n");
        Disp.d();

        //冒頭
        while (player.alive()) {
            Enemy[] enemies = {new Slime(), new Dragon(), new Sponge(), new Tiikawa(),new Tikyuwa(), new Pochama(), new Devil()};
            j += 1;

            //敵の選択　敵の召喚 　<抽象化クラス参照>
            Enemy enemy = enemies[ran.nextInt(enemies.length - 2)];
            //数回の戦闘を行う
            System.out.printf("[%d]敵が現れた！「%s」だ！\n敵を倒してください。\n", i + 1, enemy.getName());
            i++;
            Disp.dis();
            sentou(player, enemy);
            if(!player.alive()){
                break;
            }

            System.out.printf("[コマンド選択]\n1.ボス戦に挑む 2.レベルアップを行う :");
            int c = sc.nextInt();
            System.out.println();
            if (c == 1) {
                //最終戦
                Enemy enemy1 = new Devil();
                Enemy enemy2 = new Pochama();
                System.out.printf("最終戦！");
                Disp.dis();
                System.out.printf("「%s」が現れた！\n敵を倒してください。\n\n", enemy1.getName());
                Disp.dis();
                sentou(player, enemy1);


                //敵に負けて覚醒する。
                if (!player.alive()) {
                    Disp.dis();
                    System.out.printf("あなたは目覚め　覚醒した。superclass\n");
                    Disp.dis();
                    Superplayer superplay = new Superplayer(player.getlevel());
                    //戦闘を行う（スーパークラス）
                    sentou2(superplay, enemy1);

                    //通常HP500以上もしくは覚醒後HP900以上かつ、3回目にボスに挑む
                    if (player.hp >= 500 || superplay.hp >= 1000 && j <= 3) {
                        Disp.dis();
                        System.out.printf("裏ボス戦！");
                        Disp.dis();
                        System.out.printf("「%s」が現れた！\n敵を倒してください。\n\n", enemy2.getName());
                        Disp.dis();
                        //戦闘を行う（スーパークラス）
                        sentou2(superplay, enemy2);
                    }else if(player.hp > 0 || superplay.hp > 0){
                        System.out.printf("ゲームクリア");
                        return;
                    }
                    //プレイヤーが生きていなかったら
                    if(superplay.hp <= 0){
                        System.out.printf("ゲームオーバー");
                        return;
                    //プレイヤーが生きていたら
                    }else{
                        System.out.printf("ゲームクリア");
                        return;
                    }
                    //覚醒せずにボスを倒した時
                }else {
                    System.out.printf("ゲームクリア");
                    return;
                }
            } else if (c == 2) {
                continue;
            }
        }
            System.out.printf("ゲームオーバー");
    }




    public static void sentou(Player player,Enemy enemy) {
       //戦闘
        while (player.alive() && enemy.alive()) {
            player.status();
            enemy.status();
            //スピードがプレイヤーの方が早い
            if (player.sp >= enemy.sp) {
                playeraa(player,enemy);
                if (enemy.hp <= 0) {
                    System.out.printf("敵を倒しました！\n%dの経験値を獲得した\n",enemy.ex);
                    Disp.dis();
                    //経験値を獲得
                    player.level(enemy.ex);
                    Disp.dis();
                    break;
                }
                enemyaa(player,enemy);
                if (player.hp <= 0) {
                    System.out.printf("あなたは倒されてしまった。\n\n");
                    break;
                }
            } else {
                enemyaa(player,enemy);
                if (player.hp <= 0) {
                    System.out.printf("あなたは倒されてしまった。\n\n");
                    break;

                }
                playeraa(player,enemy);
                if (enemy.hp <= 0) {
                    System.out.printf("敵を倒しました！\n%dの経験値を獲得した\n",enemy.ex);
                    Disp.dis();
                    //経験値を獲得
                    player.level(enemy.ex);
                    Disp.dis();
                    break;
                }
            }
        }
    }

    public static void sentou2(Superplayer superplayer,Enemy enemy){
        while (superplayer.alive() && enemy.alive()) {
            superplayer.status();
            enemy.status();
            //スピードがプレイヤーの方が早い
            playersinka(superplayer,enemy);
            if (enemy.hp <= 0) {
                System.out.printf("敵を倒しました！\n\n");
                break;
                }
            enemyaa(superplayer,enemy);
            if (superplayer.hp <= 0) {
                System.out.printf("あなたは倒されてしまった。\n\n");
                break;
                }
            }
        }
    //プレイヤーの攻撃　モンスターのHPを減らす
    public static void playeraa(Player player,Enemy enemy){
        int coma = player.command();
        switch (coma) {
            case 1 -> {
                int damege = player.attack();
                enemy.damegi(damege);
            }
            case 2 -> {
                if(player.mp < 10){
                    System.out.printf("MPが足りません\n");
                    break;
                }
                int damege = player.magic();
                enemy.damegi(damege);
            }
            case 3 -> {
                if(player.mp < 10){
                    System.out.printf("MPが足りません\n");
                    break;
                }
                player.healing();
            }
            default -> {
                System.out.printf("正しく入力してください。\n");
                playeraa(player, enemy);
            }
        }
    }

    //覚醒時の行動
    public static void playersinka(Superplayer superplayer,Enemy enemy){
        int coma = superplayer.command();
        switch (coma) {
            case 1 -> {
                int damege = superplayer.attack();
                enemy.damegi(damege);
            }
            case 2 -> {
                if(superplayer.mp < 10){
                    System.out.printf("MPが足りません\n");
                    break;
                }
                int damege = superplayer.magic();
                enemy.damegi(damege);

            }
            case 3 -> {
                superplayer.healing();
            }
            case 4 ->{
                if(superplayer.mp < 50){
                    System.out.printf("MPが足りません\n");
                    break;
                }
                int damege = superplayer.skil();
                enemy.damegi(damege);
            }
            default -> {
                System.out.printf("正しく入力してください。\n");
                playersinka(superplayer, enemy);
            }
        }
    }

    public static void enemyaa(Player player,Enemy enemy){
        int mcoma = enemy.command();
        switch (mcoma) {
            case 1, 3, 4, 6, 8, 9 -> {
                int damege = enemy.attack();
                player.damegi(damege);
            }
            case 2, 5, 10 -> {
                if(player.hp < 10){
                    System.out.printf("MPが足りません\n");
                    break;
                }
                int damege = enemy.skil();
                player.damegi(damege);
            }
            case 7 -> {
                if(player.hp < 10){
                    System.out.printf("MPが足りません\n");
                    break;
                }
                int damege = enemy.ougi();
                player.damegi(damege);
            }
        }
    }
}

