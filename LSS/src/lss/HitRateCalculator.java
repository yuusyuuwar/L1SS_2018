/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lss;

/**
 *
 * @author user
 */
public class HitRateCalculator {

    static double calc(boolean isNPC, int HIT, int AC, boolean UD, boolean FEAR) {
        double val;
        if (isNPC) {
            val = (HIT + AC) * 0.05;
            if (val > 0.95) {
                val = 0.95;
            }
            if (UD) {
                val -= 0.2;
            }
            if(FEAR) {
                val += 0.2;
            }
            if(val > 1) {
                val = 1.0;
            }
            if (val < 0.05) {
                val = 0.05;
            }
        } else {
            if (AC < 0) {
                int avoid = 0;
                int hit = 0;
                for (int i = HIT - 9; i <= HIT + 10; i++) {//攻撃側ダイス
                    for (int j = 10; j < 10 - (int) (1.5 * AC); j++) {//防御側ダイス
                        int dice_attack = i;
                        int dice_defence = j;

                        if (UD) {
                            dice_attack -= 5;
                        }
                        if (FEAR) {
                            dice_attack += 5;
                        }

                        if (dice_attack <= HIT - 9) {//ファンブル
                            avoid++;
                            continue;
                        }
                        if (dice_attack >= HIT + 10) {//クリティカル
                            hit++;
                            continue;
                        }
                        if (dice_attack > dice_defence) {//命中
                            hit++;
                            continue;
                        }
                        if (dice_attack <= dice_defence) {//回避
                            avoid++;
                        }
                    }
                }
                return (double) hit / (double) (hit + avoid);
            } else {
                int avoid = 0;
                int hit = 0;
                for (int i = HIT - 9; i <= HIT + 10; i++) {//攻撃側ダイス
                    int dice_attack = i;
                    int dice_defence = 10 - AC;

                    if (UD) {
                        dice_attack -= 5;
                    }
                    if (FEAR) {
                        dice_attack += 5;
                    }

                    if (dice_attack <= HIT - 9) {//ファンブル
                        avoid++;
                        continue;
                    }
                    if (dice_attack >= HIT + 10) {//クリティカル
                        hit++;
                        continue;
                    }
                    if (dice_attack > dice_defence) {//命中
                        hit++;
                        continue;
                    }
                    if (dice_attack <= dice_defence) {//回避
                        avoid++;
                    }
                }
                return (double) hit / (double) (hit + avoid);
            }
        }
        return val;
    }
}
