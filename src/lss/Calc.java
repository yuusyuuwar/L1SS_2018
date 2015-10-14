/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lss;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import static lss.Common.CHA;
import static lss.Common.CON;
import static lss.Common.D;
import static lss.Common.DEX;
import static lss.Common.E;
import static lss.Common.F;
import static lss.Common.I;
import static lss.Common.INT;
import static lss.Common.K;
import static lss.Common.P;
import static lss.Common.R;
import static lss.Common.STR;
import static lss.Common.W;
import static lss.Common.WIS;

/**
 *
 * @author user
 */
public class Calc implements Common {

    private final int BASE = 0;
    private final int REM = 1;
    private final int LEVEL = 2;
    private final int ENCHANT = 3;
    private final int ELIXIR = 4;
    private final int[][] _ST = new int[5][6];
    private final int[][][] _C = new int[5][st_list.length][class_list.length];

    private final int D_SHORT = 0;
    private final int H_SHORT = 1;
    private final int C_SHORT = 2;

    private final int D_LONG = 0;
    private final int H_LONG = 1;
    private final int C_LONG = 2;
    private final int AC = 3;
    private final int ER = 4;

    private final int HP = 0;
    private final int HPR = 1;
    private final int HP_POT = 2;

    private final int D_MAGIC = 0;
    private final int H_MAGIC = 1;
    private final int C_MAGIC = 2;
    private final int MB = 3;
    private final int RED_MP = 4;

    private int red_mp;

    private final int MP = 0;
    private final int MPR = 1;
    private final int MP_POT = 2;

    private final int MR = 3;

    int level = 1;
    private int _rem = 0;
    private final int[][][] st_data = new int[class_list.length][2][6];
    private final int[] rem_data = new int[class_list.length];
    private int base_dmg_short;
    private int base_dmg_long;
    private int base_dmg_magic;
    private int base_hit_short;
    private int base_hit_long;
    private int base_hit_magic;
    int hit_c;
    int hit_f;
    private int dmg_fire;
    private int dmg_wind;
    private int dmg_earth;
    private int dmg_water;

    private int dmg_fire2;
    private int dmg_wind2;
    private int dmg_earth2;
    private int dmg_water2;

    private int mb;
    private int sp;
    private int ml;
    private int int_beta;

    int dmg_element;
    int dmg_element2;
    private int dmg_enchant;

    private int cri_short;
    private int cri_long;
    private int cri_magic;

    final Buki buki = new Buki();
    final Buki buki2 = new Buki();

    final Bougu bougu[] = new Bougu[equip_list.length - 2];
    private int base_ac;
    private int equip_ac;
    private int base_er;
    Buff buff;
    boolean md_dmg = false;
    int equip_pattern = 0;
    int ac;
    int dg;
    double enemy_hit_rate;
    int cbdmg;

    int _hp;
    int _mp;

    int mr;

    int cls = P;

    {
        for (int i = 0; i < bougu.length; i++) {
            bougu[i] = new Bougu();
        }
    }

    {
        st_data[P][BASE][STR] = 13;
        st_data[P][BASE][DEX] = 9;
        st_data[P][BASE][CON] = 11;
        st_data[P][BASE][INT] = 9;
        st_data[P][BASE][WIS] = 11;
        st_data[P][BASE][CHA] = 13;
        st_data[P][REM][STR] = 7;
        st_data[P][REM][DEX] = 9;
        st_data[P][REM][CON] = 9;
        st_data[P][REM][INT] = 9;
        st_data[P][REM][WIS] = 9;
        st_data[P][REM][CHA] = 7;
        rem_data[P] = 9;

        st_data[K][BASE][STR] = 16;
        st_data[K][BASE][DEX] = 12;
        st_data[K][BASE][CON] = 16;
        st_data[K][BASE][INT] = 8;
        st_data[K][BASE][WIS] = 9;
        st_data[K][BASE][CHA] = 10;
        st_data[K][REM][STR] = 4;
        st_data[K][REM][DEX] = 4;
        st_data[K][REM][CON] = 4;
        st_data[K][REM][INT] = 4;
        st_data[K][REM][WIS] = 4;
        st_data[K][REM][CHA] = 4;
        rem_data[K] = 4;

        st_data[E][BASE][STR] = 10;
        st_data[E][BASE][DEX] = 12;
        st_data[E][BASE][CON] = 12;
        st_data[E][BASE][INT] = 12;
        st_data[E][BASE][WIS] = 12;
        st_data[E][BASE][CHA] = 9;
        st_data[E][REM][STR] = 8;
        st_data[E][REM][DEX] = 8;
        st_data[E][REM][CON] = 8;
        st_data[E][REM][INT] = 8;
        st_data[E][REM][WIS] = 8;
        st_data[E][REM][CHA] = 8;
        rem_data[E] = 8;

        st_data[W][BASE][STR] = 8;
        st_data[W][BASE][DEX] = 7;
        st_data[W][BASE][CON] = 12;
        st_data[W][BASE][INT] = 14;
        st_data[W][BASE][WIS] = 14;
        st_data[W][BASE][CHA] = 8;
        st_data[W][REM][STR] = 12;
        st_data[W][REM][DEX] = 12;
        st_data[W][REM][CON] = 8;
        st_data[W][REM][INT] = 6;
        st_data[W][REM][WIS] = 6;
        st_data[W][REM][CHA] = 12;
        rem_data[W] = 12;

        st_data[D][BASE][STR] = 15;
        st_data[D][BASE][DEX] = 12;
        st_data[D][BASE][CON] = 12;
        st_data[D][BASE][INT] = 11;
        st_data[D][BASE][WIS] = 10;
        st_data[D][BASE][CHA] = 8;
        st_data[D][REM][STR] = 5;
        st_data[D][REM][DEX] = 7;
        st_data[D][REM][CON] = 7;
        st_data[D][REM][INT] = 7;
        st_data[D][REM][WIS] = 7;
        st_data[D][REM][CHA] = 7;
        rem_data[D] = 7;

        st_data[R][BASE][STR] = 13;
        st_data[R][BASE][DEX] = 11;
        st_data[R][BASE][CON] = 14;
        st_data[R][BASE][INT] = 10;
        st_data[R][BASE][WIS] = 10;
        st_data[R][BASE][CHA] = 8;
        st_data[R][REM][STR] = 7;
        st_data[R][REM][DEX] = 9;
        st_data[R][REM][CON] = 6;
        st_data[R][REM][INT] = 9;
        st_data[R][REM][WIS] = 9;
        st_data[R][REM][CHA] = 9;
        rem_data[R] = 9;

        st_data[I][BASE][STR] = 9;
        st_data[I][BASE][DEX] = 10;
        st_data[I][BASE][CON] = 12;
        st_data[I][BASE][INT] = 12;
        st_data[I][BASE][WIS] = 14;
        st_data[I][BASE][CHA] = 8;
        st_data[I][REM][STR] = 10;
        st_data[I][REM][DEX] = 10;
        st_data[I][REM][CON] = 8;
        st_data[I][REM][INT] = 8;
        st_data[I][REM][WIS] = 6;
        st_data[I][REM][CHA] = 10;
        rem_data[I] = 10;

        st_data[F][BASE][STR] = 16;
        st_data[F][BASE][DEX] = 13;
        st_data[F][BASE][CON] = 16;
        st_data[F][BASE][INT] = 10;
        st_data[F][BASE][WIS] = 7;
        st_data[F][BASE][CHA] = 9;
        st_data[F][REM][STR] = 4;
        st_data[F][REM][DEX] = 4;
        st_data[F][REM][CON] = 4;
        st_data[F][REM][INT] = 4;
        st_data[F][REM][WIS] = 4;
        st_data[F][REM][CHA] = 4;
        rem_data[F] = 4;

        //ステータスボーナス
        _C[D_SHORT][STR][P] = 30;
        _C[D_SHORT][STR][K] = 10;
        _C[D_SHORT][STR][E] = 30;
        _C[D_SHORT][STR][W] = 40;
        _C[D_SHORT][STR][D] = 10;
        _C[D_SHORT][STR][R] = 10;
        _C[D_SHORT][STR][I] = 10;
        _C[D_SHORT][STR][F] = 10;

        _C[H_SHORT][STR][P] = 4;
        _C[H_SHORT][STR][K] = 3;
        _C[H_SHORT][STR][E] = 5;
        _C[H_SHORT][STR][W] = 6;
        _C[H_SHORT][STR][D] = 3;
        _C[H_SHORT][STR][R] = 4;
        _C[H_SHORT][STR][I] = 5;
        _C[H_SHORT][STR][F] = 3;

        _C[C_SHORT][STR][P] = 20;
        _C[C_SHORT][STR][K] = 20;
        _C[C_SHORT][STR][E] = 24;
        _C[C_SHORT][STR][W] = 30;
        _C[C_SHORT][STR][D] = 10;
        _C[C_SHORT][STR][R] = 20;
        _C[C_SHORT][STR][I] = 30;
        _C[C_SHORT][STR][F] = 20;

        _C[D_LONG][DEX][P] = 40;
        _C[D_LONG][DEX][K] = 40;
        _C[D_LONG][DEX][E] = 10;
        _C[D_LONG][DEX][W] = 80;
        _C[D_LONG][DEX][D] = 20;
        _C[D_LONG][DEX][R] = 40;
        _C[D_LONG][DEX][I] = 80;
        _C[D_LONG][DEX][F] = 40;

        _C[H_LONG][DEX][P] = 6;
        _C[H_LONG][DEX][K] = 6;
        _C[H_LONG][DEX][E] = 3;
        _C[H_LONG][DEX][W] = 8;
        _C[H_LONG][DEX][D] = 4;
        _C[H_LONG][DEX][R] = 7;
        _C[H_LONG][DEX][I] = 8;
        _C[H_LONG][DEX][F] = 6;

        _C[C_LONG][DEX][P] = 30;
        _C[C_LONG][DEX][K] = 40;
        _C[C_LONG][DEX][E] = 16;
        _C[C_LONG][DEX][W] = 50;
        _C[C_LONG][DEX][D] = 20;
        _C[C_LONG][DEX][R] = 40;
        _C[C_LONG][DEX][I] = 50;
        _C[C_LONG][DEX][F] = 40;

        _C[ER][DEX][P] = 6;
        _C[ER][DEX][K] = 4;
        _C[ER][DEX][E] = 6;
        _C[ER][DEX][W] = 10;
        _C[ER][DEX][D] = 4;
        _C[ER][DEX][R] = 5;
        _C[ER][DEX][I] = 9;
        _C[ER][DEX][F] = 4;

        _C[D_MAGIC][INT][P] = 40;
        _C[D_MAGIC][INT][K] = 40;
        _C[D_MAGIC][INT][E] = 30;
        _C[D_MAGIC][INT][W] = 10;
        _C[D_MAGIC][INT][D] = 40;
        _C[D_MAGIC][INT][R] = 40;
        _C[D_MAGIC][INT][I] = 25;
        _C[D_MAGIC][INT][F] = 40;

        _C[H_MAGIC][INT][P] = 20;
        _C[H_MAGIC][INT][K] = 100;
        _C[H_MAGIC][INT][E] = 16;
        _C[H_MAGIC][INT][W] = 8;
        _C[H_MAGIC][INT][D] = 24;
        _C[H_MAGIC][INT][R] = 18;
        _C[H_MAGIC][INT][I] = 12;
        _C[H_MAGIC][INT][F] = 100;

        _C[C_MAGIC][INT][P] = 80;
        _C[C_MAGIC][INT][K] = 100;
        _C[C_MAGIC][INT][E] = 30;
        _C[C_MAGIC][INT][W] = 2;
        _C[C_MAGIC][INT][D] = 30;
        _C[C_MAGIC][INT][R] = 70;
        _C[C_MAGIC][INT][I] = 20;
        _C[C_MAGIC][INT][F] = 100;

        _C[MB][INT][P] = 0;
        _C[MB][INT][K] = 0;
        _C[MB][INT][E] = 0;
        _C[MB][INT][W] = 1;
        _C[MB][INT][D] = 0;
        _C[MB][INT][R] = 0;
        _C[MB][INT][I] = 1;
        _C[MB][INT][F] = 0;

        _C[HP][CON][P] = 11;
        _C[HP][CON][K] = 16;
        _C[HP][CON][E] = 9;
        _C[HP][CON][W] = 6;
        _C[HP][CON][D] = 10;
        _C[HP][CON][R] = 12;
        _C[HP][CON][I] = 8;
        _C[HP][CON][F] = 16;

        _C[MR][WIS][P] = 10;
        _C[MR][WIS][K] = 0;
        _C[MR][WIS][E] = 25;
        _C[MR][WIS][W] = 15;
        _C[MR][WIS][D] = 10;
        _C[MR][WIS][R] = 18;
        _C[MR][WIS][I] = 20;
        _C[MR][WIS][F] = 0;
    }

    private final UI ui;
    Polymorph polymorph = new Polymorph();
    private double acc = 1.0;
    // 一段加速(ヘイスト、GP
    double acc_1 = 1.3333;
    // 二段加速(BP、ブラッドラスト、イビル
    double acc_2 = 1.3333;
    // 二段加速(ワッフル
    double acc_ew = 1.1547;
    // 三段加速(ドラゴンブラッド、酒
    double acc_3 = 1.125;
    double key_delay = 0.1815;

    double db_rate = 0.3333;
    double ef_rate = 0.4000;
    double bs_rate = 0.3333;

    public Calc(UI ui) {
        this.ui = ui;
    }

    void update() {
        read();
        calc();
        write();
    }

    private void write() {
        ui.lab_sp.setText("SP " + sp);
        ui.lab_ml.setText("ML " + ml);
        ui.lab_mb.setText("MB " + mb);
        ui.lab_mag_dmg.setText("魔法ダメージ " + base_dmg_magic);
        
        ui.pure_status_bonus[1][0].setText(Integer.toString(base_dmg_short));
        ui.pure_status_bonus[1][5].setText(Integer.toString(base_dmg_long));
        ui.pure_status_bonus[1][15].setText(Integer.toString(base_dmg_magic));
        ui.pure_status_bonus[1][1].setText(Integer.toString(base_hit_short));
        ui.pure_status_bonus[1][6].setText(Integer.toString(base_hit_long));
        ui.pure_status_bonus[1][16].setText(Integer.toString(base_hit_magic));
        ui.pure_status_bonus[1][2].setText(Integer.toString(cri_short));
        ui.pure_status_bonus[1][7].setText(Integer.toString(cri_long));
        ui.pure_status_bonus[1][17].setText(Integer.toString(cri_magic));
        ui.pure_status_bonus[1][19].setText((Integer.toString(red_mp)));

    }

    private void calc() {

        int str = _ST[BASE][STR] + _ST[REM][STR] + _ST[LEVEL][STR]
                + _ST[ENCHANT][STR] + _ST[ELIXIR][STR];
        int pure_str = _ST[BASE][STR] + _ST[REM][STR]
                + _ST[LEVEL][STR] + _ST[ELIXIR][STR];

        int dex = _ST[BASE][DEX] + _ST[REM][DEX] + _ST[LEVEL][DEX]
                + _ST[ENCHANT][DEX] + _ST[ELIXIR][DEX];
        int pure_dex = _ST[BASE][DEX] + _ST[REM][DEX]
                + _ST[LEVEL][DEX] + _ST[ELIXIR][DEX];

        int _int = _ST[BASE][INT] + _ST[REM][INT] + _ST[LEVEL][INT]
                + _ST[ENCHANT][INT] + _ST[ELIXIR][INT];
        int pure_int = _ST[BASE][INT] + _ST[REM][INT]
                + _ST[LEVEL][INT] + _ST[ELIXIR][INT];

        //追加ダメージ
        base_dmg_short = (int) (str / 2 - 2) + (int) (level / _C[D_SHORT][STR][cls]);
        base_dmg_long = (int) (dex / 3) + (int) (level / _C[D_LONG][DEX][cls]);
        base_dmg_magic = (int) (_int / 5 - 2) + (int) (level / _C[D_MAGIC][INT][cls]);

        base_hit_short = (int) (str * 2 / 3) + level + (int) (level / _C[H_SHORT][STR][cls]);
        base_hit_long = (int) (dex - 10) + level + (int) (level / _C[H_LONG][DEX][cls]);
        base_hit_magic = (int) ((_int - 20) / 3) + (int) (level / _C[H_MAGIC][INT][cls]);

        cri_short = (int) (minasToZero(str - 30) / 10) + (int) (minasToZero(level - 50) / _C[C_SHORT][STR][cls]);
        cri_long = (int) (minasToZero(dex - 30) / 10) + (int) (minasToZero(level - 50) / _C[C_LONG][DEX][cls]);
        cri_magic = (int) (minasToZero(_int - 30) / 10) + (int) (minasToZero(level - 50) / _C[C_MAGIC][INT][cls]);

        red_mp = Math.min(30, (int) (_int * 2 / 3));

        if (pure_str >= 25) {
            base_dmg_short += 1;
            base_hit_short += 1;
        }
        if (pure_str >= 35) {
            base_dmg_short += 1;
            base_hit_short += 1;
        }
        if (pure_str >= 45) {
            base_dmg_short += 3;
            base_hit_short += 3;
            cri_short += 1;
        }

        if (pure_dex >= 25) {
            base_dmg_long += 1;
            base_hit_long += 1;
        }
        if (pure_dex >= 35) {
            base_dmg_long += 1;
            base_hit_long += 1;
        }
        if (pure_dex >= 45) {
            base_dmg_long += 3;
            base_hit_long += 3;
            cri_long += 1;
        }

        if (pure_int >= 25) {
            base_dmg_magic += 1;
            base_hit_magic += 1;
        }
        if (pure_int >= 35) {
            base_dmg_magic += 1;
            base_hit_magic += 1;
        }
        if (pure_int >= 45) {
            base_dmg_magic += 3;
            base_hit_magic += 3;
        }

        int d_short = base_dmg_short + buff.d_short;
        int d_long = base_dmg_long + buff.d_long;
        sp = buff.SP + buki.op.SP;

        for (Bougu bougu1 : bougu) {
            d_short += bougu1.op.d_short + bougu1.op2.d_short;
            d_long += bougu1.op.d_long + bougu1.op2.d_long;
            sp += bougu1.op.SP + bougu1.op2.SP;
        }

        int st_int = _ST[BASE][INT] + _ST[REM][INT] + _ST[LEVEL][INT]
                + _ST[ENCHANT][INT] + _ST[ELIXIR][INT];

        //スペルパワー更新
        int_beta = sp + st_int;

        
        //マジックレベル更新
        switch (cls) {
            case P:
                ml = level / 10;
                if (ml > 2) {
                    ml = 2;
                }
                break;
            case K:
                ml = level / 50;
                if (ml > 1) {
                    ml = 1;
                }
                break;
            case E:
                ml = level / 8;
                if (ml > 6) {
                    ml = 6;
                }
                break;
            case W:
                ml = level / 4;
                if (ml > 13) {
                    ml = 13;
                }
                break;
            case D:
                ml = level / 12;
                if (ml > 2) {
                    ml = 2;
                }
                break;
            case R:
                ml = level / 9;
                if (ml > 4) {
                    ml = 4;
                }
                break;
            case I:
                ml = level / 6;
                if (ml > 10) {
                    ml = 10;
                }
                break;
            case F:
                ml = level / 50;
                if (ml > 1) {
                    ml = 1;
                }
                break;
        }
        
        mb = (int) (st_int / 4) + _C[MB][INT][cls];
        ui.pure_status_bonus[1][18].setText(Integer.toString(mb));
        
        if (buki.type.equals("キーリンク")) {
            d_short = 0;
            for (int i = 0; i < 4; i++) {
                buff.element_dmg_c[i] = 0;
            }
        }
    }

    private void read() {

        buff = new Buff();

        cls = ui.cb_class.getSelectedIndex();
        level = ui.cb_level.getSelectedIndex() + 1;

        // セット効果
        int set1 = 0, set2 = 0, set3 = 0;// 王家セット
        int set4 = 0, set5 = 0, set6 = 0;// 浄化セット
        int set7 = 0, set8 = 0;// 極寒、アイスクイーンセット
        int set9 = 0;// 修練者セット
        int set10 = 0, set11 = 0, set12 = 0;//釣りセット

        for (Bougu bougu1 : bougu) {
            if (bougu1.name.equals("シャイニングイアリング")) {
                set10++;
                set11++;
                set12++;
            }
            if (bougu1.name.equals("レッドムーンネックレス")) {
                set10 += 2;
            }
            if (bougu1.name.equals("ホワイトムーンネックレス")) {
                set11 += 2;
            }
            if (bougu1.name.equals("ブラックムーンネックレス")) {
                set12 += 2;
            }

            if (bougu1.name.equals("王家のイアリング")) {
                set1++;
                set2++;
                set3++;
            }
            if (bougu1.name.equals("浄化のイアリング")) {
                set4++;
                set5++;
                set6++;
            }
            if (bougu1.name.equals("王家の猛きアミュレット")) {
                set1 += 2;
            }
            if (bougu1.name.equals("王家の賢きアミュレット")) {
                set2 += 2;
            }
            if (bougu1.name.equals("王家の強きアミュレット")) {
                set3 += 2;
            }
            if (bougu1.name.equals("青呪のアミュレット")) {
                set4 += 2;
            }
            if (bougu1.name.equals("赤呪のアミュレット")) {
                set5 += 2;
            }
            if (bougu1.name.equals("緑呪のアミュレット")) {
                set6 += 2;
            }
            if (bougu1.name.contains("極寒")) {
                set7++;
            }
            if (bougu1.name.contains("アイスクイーン")) {
                set8++;
            }
            if (bougu1.name.contains("修練者")) {
                set9++;
            }
        }

        if (set10 >= 3) {
            buff.d_short += 2;
            buff.d_long += 2;
            buff.HIT_CLOSE += 2;
            buff.HIT_FAR += 2;
        }
        if (set11 >= 3) {
            buff.MP += 33;
            buff.MPR += 2;
            buff.SP++;
        }
        if (set12 >= 3) {
            buff.HP += 55;
            buff.HPR += 5;
        }

        if (set1 >= 3) {
            buff.d_short += 2;
            buff.d_long += 2;
            buff.HIT_CLOSE += 2;
            buff.HIT_FAR += 2;
        }
        if (set2 >= 3) {
            buff.MP += 33;
            buff.MPR += 2;
            buff.SP++;
        }
        if (set3 >= 3) {
            buff.HP += 55;
            buff.MR += 4;
            buff.HPR += 5;
        }
        if (set4 >= 3) {
            buff.ST[INT] += 2;
            buff.ST[WIS] -= 2;
        }
        if (set5 >= 3) {
            buff.ST[STR] += 2;
            buff.ST[CON] -= 2;
        }
        if (set6 >= 3) {
            buff.ST[DEX] += 2;
            buff.ST[CHA] -= 2;
        }
        if (set7 == 3) {
            buff.AC -= 5;
            buff.ST[CON] += 3;
            buff.HP += 100;
            buff.HPR += 8;
            buff.MPR += 4;
            buff.MR += 15;
            buff.element_resisit[WATER] += 20;
            buff.element_coefficient[WATER] += (int) (20 / 3.125);
        }
        if (set8 == 3) {
            buff.AC -= 5;
            buff.ST[STR] += 2;
            buff.ST[CHA] += 2;
            buff.HP += 100;
            buff.MPR += 4;
            buff.element_resisit[WATER] += 20;
            buff.element_coefficient[WATER] += (int) (20 / 3.125);
        }
        if (set9 == 3) {
            buff.HPR += 4;
            buff.MPR += 1;
        }

        if (ui.enchant_bt[ITEM_WIZP].isSelected()) {
            if (cls == W) {
                buff.SP += 2;
                buff.MPR += 2;
            } else {
                ui.enchant_bt[ITEM_WIZP].setSelected(false);
            }
        }

        // マジックドール
        if (ui.enchant_bt[ITEM_MD].isSelected()) {
            switch (ui.enchant_group[ITEM_MD].getSelectedIndex()) {
                case 0:
                    buff.effect += "特殊攻撃(クラスタシアン/ウェアウルフ)";
                    break;
                case 1:
                    buff.weight += 0.2;
                    break;
                case 2:
                    buff.effect += "MP回復+15 ";
                    break;
                case 3:
                    buff.effect += "MP回復+15 ";
                    break;
                case 4:
                    buff.DR += 1;
                    break;
                case 5:
                    buff.effect += "特殊攻撃(クラスタシアン/ウェアウルフ)";
                case 6:
                    buff.AC -= 3;
                    buff.ailment[FREEZE] += 7;
                    break;
                case 7:
                    buff.d_long++;
                    buff.HIT_FAR++;
                    break;
                case 8:
                    buff.effect += "HP回復+40 ";
                    break;
                case 9:
                    buff.effect += "回避 ";
                    break;
                case 10:
                    buff.d_short += 2;
                    buff.d_long += 2;
                    buff.MPR += 2;
                    break;
                case 11:
                    buff.MPR += 4;
                    break;
                case 17:// ブルート
                    buff.weight += 0.02;
                case 16:
                    buff.weight += 0.02;
                case 15:
                    buff.weight += 0.02;
                    buff.d_short++;
                case 14:
                    buff.weight += 0.02;
                case 13:
                    buff.weight += 0.02;
                    buff.HPR += 15;
                case 12:
                    buff.weight += 0.10;
                    ui.enchant_bt[ACC1].setSelected(true);
                    break;
                case 23:// ジャイアント
                    buff.weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "ダメージ軽減+20 ヴァンパイアリックタッチ ";
                    break;
                case 22:
                    buff.weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "ダメージ軽減+17 ";
                    break;
                case 21:
                    buff.weight += 0.10;
                    buff.AC--;
                    buff.MR += 5;
                    buff.effect += "ダメージ軽減+14 ";
                    break;
                case 20:
                    buff.weight += 0.10;
                    buff.AC--;
                    buff.effect += "ダメージ軽減+11 ";
                    break;
                case 19:
                    buff.weight += 0.10;
                    buff.AC--;
                    buff.effect += "ダメージ軽減+8 ";
                    break;
                case 18:
                    buff.weight += 0.10;
                    buff.effect += "ダメージ軽減+5 ";
                    break;
                case 24:
                    buff.d_short += 1;
                    break;
                case 25:
                    buff.d_short += 1;
                    buff.d_long += 1;
                    break;
                case 26:
                    buff.d_short += 1;
                    buff.d_long += 1;
                    buff.SP += 1;
                    break;
                case 27:
                    buff.d_short += 2;
                    buff.d_long += 2;
                    buff.SP += 1;
                    buff.effect += "特殊攻撃(パック/パオ) ";
                    break;
            }
        }

        if (ui.enchant_bt[ITEM_MD_OP].isSelected()) {
            switch (ui.enchant_group[ITEM_MD_OP].getSelectedIndex()) {
                case 0:
                    buff.AC -= 2;
                    break;
                case 1:
                    buff.AC -= 4;
                    break;
                case 2:
                    buff.AC -= 5;
                    buff.DR += 2;
                    break;
                case 3:
                    buff.AC -= 1;
                    buff.MR += 1;
                    break;
                case 4:
                    buff.AC -= 3;
                    buff.MR += 5;
                    break;
                case 5:
                    buff.AC -= 3;
                    buff.MR += 10;
                    break;
                case 6:
                    buff.MPR += 1;
                    break;
                case 7:
                    buff.MPR += 3;
                    break;
                case 8:
                    buff.MPR += 7;
                    break;
                case 9:
                    buff.effect += "MP回復+1 ";
                    break;
                case 10:
                    buff.effect += "MP回復+3 ";
                    break;
                case 11:
                    buff.effect += "MP回復+7 ";
                    break;
                case 12:
                    buff.HP += 10;
                    buff.MP += 10;
                    break;
                case 13:
                    buff.HP += 35;
                    buff.MP += 35;
                    break;
                case 14:
                    buff.HP += 60;
                    buff.MP += 60;
                    break;
                case 15:
                    buff.HIT_CLOSE += 1;
                    buff.HIT_FAR += 1;
                    break;
                case 16:
                    buff.HIT_CLOSE += 2;
                    buff.HIT_FAR += 2;
                    break;
                case 17:
                    buff.HIT_CLOSE += 4;
                    buff.HIT_FAR += 4;
                    break;
            }
        }

        // 課金POT
        if (ui.enchant_bt[ITEM_SEA].isSelected()) {
            switch (ui.enchant_group[ITEM_SEA].getSelectedIndex()) {
                case 0:
                    buff.d_short += 3;
                    buff.d_long += 3;
                    buff.HIT_CLOSE += 3;
                    buff.HIT_FAR += 3;
                    buff.SP += 3;
                case 1:
                    buff.d_short += 2;
                    buff.d_long += 2;
                    buff.HIT_CLOSE += 2;
                    buff.HIT_FAR += 2;
                    break;
                case 2:
                    buff.SP += 3;
                    break;
                case 3:
                    buff.ST[STR] += 2;
                    break;
                case 4:
                    buff.ST[DEX] += 2;
                    break;
                case 5:
                    buff.ST[CON] += 2;
                    break;
                case 6:
                    buff.ST[INT] += 2;
                    break;
                case 7:
                    buff.ST[WIS] += 2;
                    break;
            }
        }
        if (ui.enchant_bt[ITEM_BREEZE].isSelected()) {
            switch (ui.enchant_group[ITEM_BREEZE].getSelectedIndex()) {
                case 0:
                    buff.HPR += 10;
                    break;
                case 1:
                    buff.MPR += 10;
                    break;
                case 2:
                    buff.HP += 120;
                    break;
                case 3:
                    buff.MP += 80;
                    break;
                case 4:
                    buff.MR += 10;
                    break;
                case 5:
                    buff.MP += 60;
                    buff.MPR += 4;
                    break;
                case 6:
                    buff.HP += 100;
                    buff.HPR += 8;
                    break;
            }
        }

        // 料理
        if (ui.enchant_bt[ITEM_COOKING].isSelected()) {
            switch (ui.enchant_group[ITEM_COOKING].getSelectedIndex()) {
                case 2:
                    buff.DR += 2;
                    buff.SP += 2;
                    buff.MPR += 3;
                    buff.HPR += 2;
                    buff.MR += 10;
                    buff.element_resisit[FIRE] += 10;
                    buff.element_coefficient[FIRE] += (int) (10 / 3.125);
                    buff.element_resisit[WATER] += 10;
                    buff.element_coefficient[WATER] += (int) (10 / 3.125);
                    buff.element_resisit[WIND] += 10;
                    buff.element_coefficient[WIND] += (int) (10 / 3.125);
                    buff.element_resisit[EARTH] += 10;
                    buff.element_coefficient[EARTH] += (int) (10 / 3.125);
                    break;
                case 1:
                    buff.DR += 2;
                    buff.d_long += 2;
                    buff.HIT_FAR += 1;
                    buff.HPR += 2;
                    buff.MPR += 2;
                    buff.MR += 10;
                    buff.element_resisit[FIRE] += 10;
                    buff.element_coefficient[FIRE] += (int) (10 / 3.125);
                    buff.element_resisit[WATER] += 10;
                    buff.element_coefficient[WATER] += (int) (10 / 3.125);
                    buff.element_resisit[WIND] += 10;
                    buff.element_coefficient[WIND] += (int) (10 / 3.125);
                    buff.element_resisit[EARTH] += 10;
                    buff.element_coefficient[EARTH] += (int) (10 / 3.125);
                    break;
                case 0:
                    buff.DR += 2;
                    buff.d_short += 2;
                    buff.HIT_CLOSE += 1;
                    buff.HPR += 2;
                    buff.MPR += 2;
                    buff.MR += 10;
                    buff.element_resisit[FIRE] += 10;
                    buff.element_coefficient[FIRE] += (int) (10 / 3.125);
                    buff.element_resisit[WATER] += 10;
                    buff.element_coefficient[WATER] += (int) (10 / 3.125);
                    buff.element_resisit[WIND] += 10;
                    buff.element_coefficient[WIND] += (int) (10 / 3.125);
                    buff.element_resisit[EARTH] += 10;
                    buff.element_coefficient[EARTH] += (int) (10 / 3.125);
                    break;

            }
        }
        if (ui.enchant_bt[ITEM_DESSERT].isSelected()) {
            switch (ui.enchant_group[ITEM_DESSERT].getSelectedIndex()) {
                case 0:
                    buff.DR += 2;
                    break;
                case 1:
                    buff.DR += 5;
                    break;
                case 2:
                    buff.DR += 3;
                    break;
            }
        }

        if (ui.enchant_bt[DRAGON].isSelected()) {
            switch (ui.enchant_group[DRAGON].getSelectedIndex()) {
                case 0:
                    buff.HP += 100;
                    buff.MP += 50;
                    buff.HPR += 3;
                    buff.MPR += 3;
                    buff.d_short += 1;
                    buff.d_long += 1;
                    buff.HIT_CLOSE += 5;
                    buff.element_resisit[EARTH] += 30;
                    buff.element_coefficient[EARTH] += (int) (30 / 3.125);
                    ui.enchant_bt[W_DW].setSelected(true);
                    break;
                case 1:
                    buff.HP += 100;
                    buff.MP += 50;
                    buff.HPR += 3;
                    buff.MPR += 3;
                    buff.d_short += 1;
                    buff.d_long += 1;
                    buff.HIT_CLOSE += 5;
                    buff.element_resisit[WATER] += 30;
                    buff.element_coefficient[WATER] += (int) (30 / 3.125);
                    ui.enchant_bt[W_DW].setSelected(true);
                    break;
                case 2:
                    buff.HP += 100;
                    buff.MP += 50;
                    buff.HPR += 3;
                    buff.MPR += 3;
                    buff.d_short += 1;
                    buff.d_long += 1;
                    buff.HIT_CLOSE += 5;
                    buff.element_resisit[WIND] += 30;
                    buff.element_coefficient[WIND] += (int) (30 / 3.125);
                    ui.enchant_bt[W_DW].setSelected(true);

            }
        }

        if (ui.enchant_bt[KOMA].isSelected()) {
            switch (ui.enchant_group[KOMA].getSelectedIndex()) {
                case 0:
                    buff.ST[STR] += 5;
                    buff.ST[DEX] += 5;
                    buff.ST[CON] += 1;
                    buff.HIT_CLOSE += 3;
                    buff.AC -= 3;
                    break;
                case 1:
                    buff.ST[STR] += 5;
                    buff.ST[DEX] += 5;
                    buff.ST[CON] += 3;
                    buff.HIT_CLOSE += 5;
                    buff.AC -= 8;
                    buff.SP += 1;
            }
        }

        if (ui.enchant_bt[K_RA].isSelected()) {
            if (level >= 50 && cls == K) {
                buff.DR += (level - 50) / 5 + 1;
            } else {
                ui.enchant_bt[K_RA].setSelected(false);
            }
        }

        if (ui.enchant_bt[K_SC].isSelected()) {
            if (level >= 50 && cls == K
                    && bougu[0].type.equals("シールド")) {
                buff.ER += 15;
            } else {
                ui.enchant_bt[K_SC].setSelected(false);
            }
        }
        if (ui.enchant_bt[K_CB].isSelected()) {
            if (level >= 50 && cls == K
                    && buki.type.equals("両手剣")) {
                // CB効果未実装
            } else {
                ui.enchant_bt[K_CB].setSelected(false);
            }
        }
        if (ui.enchant_bt[K_BA].isSelected()) {
            if (level >= 60 && cls == K) {
                buff.HIT_CLOSE += 6;
            } else {
                ui.enchant_bt[K_BA].setSelected(false);
            }
        }
        // レジストマジック
        if (ui.enchant_bt[E_RM].isSelected()) {
            if (cls == E) {
                buff.MR += 10;
            } else {
                ui.enchant_bt[E_RM].setSelected(false);
            }
        }
        // レジストエレメント
        if (ui.enchant_bt[E_RE].isSelected()) {
            if (cls == E) {
                buff.element_resisit[FIRE] += 10;
                buff.element_coefficient[FIRE] += (int) (10 / 3.125);
                buff.element_resisit[WATER] += 10;
                buff.element_coefficient[WATER] += (int) (10 / 3.125);
                buff.element_resisit[WIND] += 10;
                buff.element_coefficient[WIND] += (int) (10 / 3.125);
                buff.element_resisit[EARTH] += 10;
                buff.element_coefficient[EARTH] += (int) (10 / 3.125);
            } else {
                ui.enchant_bt[E_RE].setSelected(false);
            }
        }
        // クリアーマインド
        if (ui.enchant_bt[E_CM].isSelected()) {
            if (cls == E) {
                buff.ST[WIS] += 3;
            } else {
                ui.enchant_bt[E_CM].setSelected(false);
            }
        }
        if (ui.enchant_bt[E_BW].isSelected()) {
            if (cls == E) {
                buff.element_dmg_c[FIRE] += 6;
                buff.HIT_CLOSE += 6;
            } else {
                ui.enchant_bt[E_BW].setSelected(false);
            }
        }
        if (ui.enchant_bt[E_FW].isSelected()) {
            if (ui.enchant_bt[E_BW].isSelected()) {
                ui.enchant_bt[E_FW].setSelected(false);
            } else {
                buff.element_dmg_c[FIRE] += 4;
            }
        }
        // ネイチャーズタッチ
        if (ui.enchant_bt[E_NT].isSelected()) {
            if (level > 9) {
                if (level < 24) {
                    buff.HPR += level - 9;
                } else {
                    buff.HPR += 15;
                }
            }
        }
        if (ui.enchant_bt[D_DE].isSelected()) {
            if (cls == D) {
                buff.ER += 12;
            } else {
                ui.enchant_bt[D_DE].setSelected(false);
            }
        }
        if (ui.enchant_bt[D_SA].isSelected()) {
            if (cls == D) {
                buff.MR += 5;
            } else {
                ui.enchant_bt[D_SA].setSelected(false);
            }
        }
        if (ui.enchant_bt[E_AP].isSelected()) {
            if (ui.enchant_bt[D_DE].isSelected()) {
                ui.enchant_bt[E_AP].setSelected(false);
            } else {
                buff.ER += 5;
            }
        }
        if (ui.enchant_bt[E_SS].isSelected()) {
            buff.element_dmg_f[WIND] += 6;
            buff.HIT_FAR += 3;
        }
        if (ui.enchant_bt[E_SE].isSelected()) {
            if (ui.enchant_bt[E_SS].isSelected()) {
                ui.enchant_bt[E_SE].setSelected(false);
            } else {
                buff.element_dmg_f[WIND] += 3;
                buff.HIT_FAR += 2;
            }
        }
        if (ui.enchant_bt[E_WS].isSelected()) {
            if (ui.enchant_bt[E_SS].isSelected()
                    || ui.enchant_bt[E_SE].isSelected()) {
                ui.enchant_bt[E_WS].setSelected(false);
            } else {
                buff.HIT_FAR += 6;
            }
        }
        if (ui.enchant_bt[E_EG].isSelected()) {
            buff.DR += 2;
        }
        if (ui.enchant_bt[W_BSK].isSelected()) {
            buff.d_short += 5;
            buff.HPR -= 255;
            buff.AC += 10;
        }
        if (ui.enchant_bt[W_BA].isSelected()) {
            buff.AC -= 3;
        }
        if (ui.enchant_bt[R_DS].isSelected()) {
            buff.DR += 5;
        }
        if (ui.enchant_bt[R_ANTHARAS].isSelected()) {
            if (ui.enchant_bt[R_FAFURION].isSelected()
                    || ui.enchant_bt[R_VALAKAS].isSelected()) {
                ui.enchant_bt[R_ANTHARAS].setSelected(false);
            } else {
                buff.AC -= 3;
                buff.ailment[HOLD] += 10;
            }
        }
        if (ui.enchant_bt[R_FAFURION].isSelected()) {
            if (ui.enchant_bt[R_ANTHARAS].isSelected()
                    || ui.enchant_bt[R_VALAKAS].isSelected()) {
                ui.enchant_bt[R_FAFURION].setSelected(false);
            } else {
                buff.ailment[FREEZE] += 10;
            }
        }
        if (ui.enchant_bt[R_VALAKAS].isSelected()) {
            if (ui.enchant_bt[R_ANTHARAS].isSelected()
                    || ui.enchant_bt[R_FAFURION].isSelected()) {
                ui.enchant_bt[R_VALAKAS].setSelected(false);
            } else {
                buff.HIT_CLOSE += 5;
                buff.ailment[STUN] += 10;
            }
        }
        if (ui.enchant_bt[I_CON].isSelected()) {
            buff.MPR += 2;
        }
        if (ui.enchant_bt[I_PAT].isSelected()) {
            buff.DR += 2;
        }
        if (ui.enchant_bt[I_INS].isSelected()) {
            buff.ST[STR]++;
            buff.ST[DEX]++;
            buff.ST[CON]++;
            buff.ST[INT]++;
            buff.ST[WIS]++;
        }
        if (ui.enchant_bt[I_IO].isSelected()) {
            buff.d_short += 4;
            buff.d_long += 4;
            buff.HIT_CLOSE += 4;
        }
        if (ui.enchant_bt[I_IR].isSelected()) {
            buff.SP += 2;
        }
        if (ui.enchant_bt[I_ID].isSelected()) {
            buff.AC -= 8;
        }

        switch (ui.cb_pattern_l.getSelectedIndex()) {
            case 1:
                buff.ST[STR]++;
                break;
            case 2:
                buff.ST[DEX]++;
                break;
            case 3:
                buff.ST[CON]++;
                break;
            case 4:
                buff.ST[INT]++;
                break;
            case 5:
                buff.ST[WIS]++;
                break;
            case 6:
                buff.ST[CHA]++;
                break;
            case 7:
                buff.ST[STR] += 2;
                break;
            case 8:
                buff.ST[DEX] += 2;
                break;
            case 9:
                buff.ST[INT] += 2;
                break;
            case 10:
                buff.ST[STR]++;
                buff.HP += 80;
                buff.HPR += 5;
                break;
            case 11:
                buff.ST[INT]++;
                buff.MP += 50;
                buff.MPR += 3;
                break;
            case 12:
                buff.ST[STR]++;
                buff.HP += 100;
                buff.d_short++;
                buff.HPR += 8;
                break;
            case 13:
                buff.ST[INT]++;
                buff.MP += 70;
                buff.SP++;
                buff.MPR += 5;
                break;
            case 14:
                buff.ST[DEX]++;
                buff.HP += 80;
                buff.MP += 50;
                buff.d_long++;
                buff.HPR += 5;
                buff.MPR += 3;
                break;
        }
        switch (ui.cb_pattern_r.getSelectedIndex()) {
            case 1:
                buff.HP += 120;
                break;
            case 2:
                buff.MP += 80;
                break;
            case 3:
                buff.AC -= 5;
                break;
            case 4:
                buff.AC -= 9;
                break;
            case 5:
                buff.element_resisit[FIRE] += 30;
                buff.element_coefficient[FIRE] += (int) (30 / 3.125);
                break;
            case 6:
                buff.element_resisit[WATER] += 30;
                buff.element_coefficient[WATER] += (int) (30 / 3.125);
                break;
            case 7:
                buff.element_resisit[WIND] += 30;
                buff.element_coefficient[WIND] += (int) (30 / 3.125);
                break;
            case 8:
                buff.element_resisit[EARTH] += 30;
                buff.element_coefficient[EARTH] += (int) (30 / 3.125);
                break;
            case 9:
                buff.element_resisit[FIRE] += 30;
                buff.element_coefficient[FIRE] += (int) (30 / 3.125);
                buff.element_resisit[WATER] += 30;
                buff.element_coefficient[WATER] += (int) (30 / 3.125);
                buff.element_resisit[WIND] += 30;
                buff.element_coefficient[WIND] += (int) (30 / 3.125);
                buff.element_resisit[EARTH] += 30;
                buff.element_coefficient[EARTH] += (int) (30 / 3.125);
                break;
            case 10:
                buff.AC -= 9;
                buff.HP += 120;
                break;
            case 11:
                buff.AC -= 9;
                buff.MP += 80;
                break;
            case 12:
                buff.AC -= 9;
                buff.HP += 80;
                buff.MP += 50;
                break;

        }

        if (ui.cb_pattern_l2.getSelectedIndex() > 0) {
            buff.ST[ui.cb_pattern_l2.getSelectedIndex()]++;

            switch (ui.cb_pattern_l2.getSelectedIndex()) {
                //エリクサールーン
                case 1:
                    buff.ST[STR]++;
                    switch (cls) {
                        case P:
                            buff.DR += 3;
                            break;
                        case K:
                            buff.HP += 50;
                            break;
                        case E:
                            buff.MP += 50;
                            break;
                        case W:
                            buff.MPR += 3;
                            break;
                        case D:
                            buff.AC -= 3;
                            break;
                        case R:
                            buff.HIT_CLOSE += 3;
                            break;
                        case I:
                            buff.weight += 0.10;
                            break;
                        case F:
                            buff.MR += 5;
                            break;
                    }
                    break;
            }

            switch (ui.cb_pattern_r2.getSelectedIndex()) {
                case 1:
                    buff.HPR += 2;
                    break;
                case 2:
                    buff.MPR++;
                    break;
                case 3:
                    buff.d_short++;
                    buff.HIT_CLOSE += 2;
                    buff.MR += 5;
                    break;
                case 4:
                    buff.d_long++;
                    buff.HIT_FAR += 2;
                    buff.MR += 5;
                    break;
                case 5:
                    buff.SP++;
                    buff.MR += 5;
                    break;
            }

            if (ui.enchant_bt[B_STR].isSelected()) {
                if (ui.enchant_group[B_STR].getSelectedItem().equals("ドレスマイティー")) {
                    buff.ST[STR] += 3;
                }
                if (ui.enchant_group[B_STR].getSelectedItem().equals("フィジカルエンチャント:STR")) {
                    buff.ST[STR] += 5;
                }
                if (ui.enchant_group[B_STR].getSelectedItem().equals("四季ポーション")) {
                    buff.ST[STR] += 6;
                }
                if (ui.enchant_group[B_STR].getSelectedItem().equals("勇者スクロール")) {
                    buff.ST[STR] += 7;
                }
            }
            if (ui.enchant_bt[B_DEX].isSelected()) {
                if (ui.enchant_group[B_DEX].getSelectedItem().equals("ドレスデクスタリティー")) {
                    buff.ST[DEX] += 3;
                }
                if (ui.enchant_group[B_DEX].getSelectedItem().equals("フィジカルエンチャント:DEX")) {
                    buff.ST[DEX] += 5;
                }
                if (ui.enchant_group[B_DEX].getSelectedItem().equals("四季ポーション")) {
                    buff.ST[DEX] += 6;
                }
                if (ui.enchant_group[B_DEX].getSelectedItem().equals("名弓スクロール")) {
                    buff.ST[DEX] += 7;
                }
            }

            for (int i = 0; i < 6; i++) {
                buff.ST[i] += buki.op.ST[i];
                for (Bougu bougu1 : bougu) {
                    buff.ST[i] += bougu1.op.ST[i] + bougu1.op2.ST[i];
                }
                _ST[ENCHANT][i] = buff.ST[i];
            }

            acc = 1.0;

            //装備による強制ヘイスト効果
            if (buki.op.effect.contains("ヘイスト")) {
                ui.enchant_bt[ACC1].setSelected(true);
            }
            for (Bougu bougu1 : bougu) {
                if (bougu1.op.effect.contains("ヘイスト")) {
                    ui.enchant_bt[ACC1].setSelected(true);
                    break;
                }
            }

            if (ui.enchant_bt[ACC1].isSelected()) {
                acc *= acc_1;
            }
            if (ui.enchant_bt[ACC2].isSelected()) {
                switch (cls) {
                    case P:
                        acc *= acc_2;
                        break;
                    case K:
                        acc *= acc_2;
                        break;
                    case W:
                        ui.enchant_bt[ACC2].setSelected(false);
                        break;
                    case E:
                        if (ui.enchant_bt[E_DB].isSelected()) {
                            ui.enchant_bt[ACC2].setSelected(false);
                        } else {
                            acc *= acc_ew;
                        }
                        break;
                    case D:
                        ui.enchant_bt[ACC2].setSelected(false);
                        break;
                    case R:
                        acc *= acc_2;
                        break;
                    case I:
                        break;
                    case F:
                        acc *= acc_2;
                }
            }
            if (ui.enchant_bt[E_DB].isSelected()) {
                acc *= acc_2;
            }
            if (ui.enchant_bt[ACC3].isSelected()) {
                acc *= acc_3;
            }
            buki.magic_enchant = 0;
            buki2.magic_enchant = 0;
            if (ui.enchant_bt[BUKI].isSelected()) {
                switch (ui.enchant_group[BUKI].getSelectedIndex()) {
                    case 0:
                        buki.magic_enchant = 1;
                        buki2.magic_enchant = 1;
                        buff.HIT_CLOSE += 1;
                        break;
                    case 1:
                        buki.magic_enchant = 2;
                        buki2.magic_enchant = 2;
                        break;
                    case 2:
                        buki.magic_enchant = 2;
                        buki2.magic_enchant = 2;
                        buff.HIT_CLOSE += 2;
                        break;
                    case 3:
                        buki.magic_enchant = 5;
                        buki2.magic_enchant = 5;
                        break;
                }
            }

            if (ui.enchant_bt[P_S].isSelected()) {
                buff.AC -= 8;
            }

            if (ui.enchant_bt[P_BA].isSelected()) {
                switch (ui.enchant_group[P_BA].getSelectedIndex()) {
                    case 0:
                        buff.MR += 8;
                        buff.ST[STR] += 1;
                        buff.ST[DEX] += 1;
                        buff.ST[INT] += 1;
                        break;
                    case 1:
                        buff.MR += 9;
                        buff.ailment[STUN] += 2;
                        buff.ST[STR] += 1;
                        buff.ST[DEX] += 1;
                        buff.ST[INT] += 1;
                        break;
                    case 2:
                        buff.MR += 10;
                        buff.ailment[STUN] += 2;
                        buff.ailment[HOLD] += 2;
                        buff.ST[STR] += 1;
                        buff.ST[DEX] += 1;
                        buff.ST[INT] += 1;
                        break;
                }
            }
            if (ui.enchant_bt[P_G].isSelected()) {
                buff.HIT_CLOSE += 5;
                buff.d_short += 5;
            }

            if (ui.enchant_bt[B_AC].isSelected()) {
                switch (ui.enchant_group[B_AC].getSelectedIndex()) {
                    case 0://シールド
                        buff.AC += -2;
                        break;
                    case 1://四季P
                        buff.AC += -5;
                        break;
                    case 2://アーススキン
                        buff.AC += -6;
                        break;
                    case 3://アースブレス
                        buff.AC += -7;
                        break;
                    case 4://アイアンスキン
                        buff.AC += -10;
                        break;
                }

            }
            try {
                if (ui.enchant_group[B_AC].getSelectedIndex() == 2) {
                    ui.enchant_bt[B_AC].setIcon(ImageIO.read(new File(
                            "./icon/精霊魔法/アーススキン.png")));
                } else if (ui.enchant_group[B_AC].getSelectedIndex() == 3) {
                    ui.enchant_bt[B_AC].setIcon(ImageIO.read(new File(
                            "./icon/精霊魔法/アースブレス.png")));
                } else if (ui.enchant_group[B_AC].getSelectedIndex() == 4) {
                    ui.enchant_bt[B_AC]
                            .setIcon(ImageIO.read(new File("./icon/精霊魔法/アイアンスキン.png")));
                } else {
                    ui.enchant_bt[B_AC]
                            .setIcon(ImageIO.read(new File("./icon/一般魔法/シールド.png")));
                }

                switch (ui.enchant_group[BUKI].getSelectedIndex()) {
                    case 4:
                    case 3:
                        ui.enchant_bt[BUKI].setIcon(ImageIO.read(new File(
                                "./icon/闇の精霊魔法/シャドウファング.png")));
                        break;
                    case 2:
                        ui.enchant_bt[BUKI].setIcon(ImageIO.read(new File(
                                "./icon/一般魔法/ブレスウエポン.png")));
                        break;
                    case 0:
                        ui.enchant_bt[BUKI].setIcon(ImageIO.read(new File(
                                "./icon/一般魔法/ホーリーウエポン.png")));
                        break;
                    case 1:
                        ui.enchant_bt[BUKI].setIcon(ImageIO.read(new File(
                                "./icon/一般魔法/エンチャントウエポン.png")));
                        break;
                }

                if (ui.enchant_group[B_STR].getSelectedIndex() == 0) {
                    ui.enchant_bt[B_STR].setIcon(ImageIO.read(new File(
                            "./icon/闇の精霊魔法/ドレスマイティー.png")));
                } else {
                    ui.enchant_bt[B_STR]
                            .setIcon(ImageIO.read(new File("./icon/一般魔法/STR.png")));
                }

                if (ui.enchant_group[B_DEX].getSelectedIndex() == 0) {
                    ui.enchant_bt[B_DEX].setIcon(ImageIO.read(new File(
                            "./icon/闇の精霊魔法/ドレスデクスタリティー.png")));
                } else {
                    ui.enchant_bt[B_DEX]
                            .setIcon(ImageIO.read(new File("./icon/一般魔法/DEX.png")));
                }
            } catch (IOException ex) {
            }

            if (ui.enchant_bt[WAR].isSelected()) {
                if (ui.enchant_group[WAR].getSelectedIndex() == 0) {
                    buff.d_long += 30;
                    buff.d_short += 30;
                }

                if (ui.enchant_group[WAR].getSelectedIndex() == 1) {
                    if (level >= 80) {
                        buff.HIT_CLOSE += 5;
                        buff.d_short += 5;
                        buff.d_long += 5;
                    } else if (level >= 70) {
                        buff.HIT_CLOSE += 10;
                        buff.d_short += 8;
                        buff.d_long += 8;
                        buff.MR += 3;
                        buff.AC -= 2;
                    } else if (level >= 60) {
                        buff.HIT_CLOSE += 25;
                        buff.d_short += 12;
                        buff.d_long += 12;
                        buff.SP += 5;
                        buff.MR += 5;
                        buff.AC -= 5;
                    } else if (level >= 52) {
                        buff.HIT_CLOSE += 40;
                        buff.d_short += 15;
                        buff.d_long += 15;
                        buff.SP += 10;
                        buff.MR += 10;
                        buff.AC -= 10;
                    }
                }
            }

            if (ui.enchant_bt[VIP].isSelected()) {
                buff.HP += 120;
                buff.MP += 120;
                buff.MR += 10;
                buff.AC -= 5;
                buff.weight += 0.1;
            }

            if (ui.enchant_bt[SEC].isSelected()) {
                buff.AC -= 1;
            }
        }
    }

    private int minasToZero(int x) {
        if (x >= 0) {
            return x;
        } else {
            return 0;
        }
    }
}
