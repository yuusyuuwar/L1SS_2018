package lss;

import java.io.BufferedReader;
import java.io.IOException;

public class Buki implements Common {

    int small = 0;
    int big = 0;
    String name = "";
    String type = "";
    double critical_rate = 0;// クロウ クリティカル
    double double_hit_rate = 0;// デュアルブレード ダブルヒット
    double week_point_exposure = 0;// チェーンソード 弱点露出
    boolean two_hands = false;
    String equip = "";
    String material = "";
    Buff op = new Buff();
    Buff op2 = new Buff();
    int enchant = 0;
    int magic_enchant = 0;
    int max_enchant = 0;
    String arrow_name = "";
    String arrow_material = "";
    String arrow_type = "";
    int arrow_small = 0;
    int arrow_big = 0;
    int safety = 0;
    boolean element_enchant = false;
    // キーリンク用
    int x, y, z;
    // 魔法武器用
    String magic_name = "";
    boolean magic_motion = false;
    double magic_rate = 0;
    double magic_rate_plus = 0;
    String magic_element = "";
    double magic_power = 0;
    double magic_delay = 0;

    int hit_stun = 0;

    private void reset() {
        small = 0;
        big = 0;
        name = "";
        type = "";
        critical_rate = 0;
        double_hit_rate = 0;
        week_point_exposure = 0;
        two_hands = false;
        material = "";
        op = new Buff();
        op2 = new Buff();
        enchant = 0;
        magic_enchant = 0;
        arrow_name = "";
        arrow_material = "";
        arrow_type = "";
        arrow_small = 0;
        arrow_big = 0;

        safety = 0;
        element_enchant = false;

        magic_name = "";
        magic_motion = false;
        magic_rate = 0;
        magic_element = "";
        magic_power = 0;
        magic_delay = 0;
        magic_rate_plus = 0;

        hit_stun = 0;
    }

    void load(BufferedReader reader) {
        reset();
        if (reader == null) {
            return;
        }
        try {
            reader.mark(1000000);
            reader.reset();
            op.loadOption(reader);
            reader.reset();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("small=")) {
                    small = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("big=")) {
                    big = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("type=")) {
                    type = line.split("=")[1];
                }
                if (line.startsWith("ダメージダイス=")) {
                    x = Integer.parseInt(line.split("=")[1].split("d")[0]);
                    y = Integer.parseInt(line.split("=")[1].split("d")[1]
                            .split("\\+")[0]);
                    z = Integer.parseInt(line.split("=")[1].split("d")[1]
                            .split("\\+")[1]);
                }
                if (line.startsWith("equip=")) {
                    equip = line.split("=")[1];
                }
                if (line.startsWith("name=")) {
                    name = line.split("=")[1];
                }
                if (line.startsWith("クリティカル=")) {
                    critical_rate = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("ダブルヒット=")) {
                    double_hit_rate = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("安全=")) {
                    safety = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("強化限界=")) {
                    max_enchant = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("材質=")) {
                    material = line.split("=")[1];
                }
                if (line.startsWith("両手武器=")) {
                    two_hands = Boolean.parseBoolean(line.split("=")[1]);
                }
                if (line.startsWith("属性強化=")) {
                    element_enchant = Boolean.parseBoolean(line.split("=")[1]);
                }
                if (line.startsWith("魔法ダメージ=")) {
                    magic_power = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("魔法発動率=")) {
                    magic_rate = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("魔法モーション")) {
                    magic_motion = Boolean.parseBoolean(line.split("=")[1]);
                }
                if (line.startsWith("魔法属性=")) {
                    magic_element = line.split("=")[1];
                }
                if (line.startsWith("魔法発動率強化=")) {
                    magic_rate_plus = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("魔法=")) {
                    magic_name = line.split("=")[1];
                }
                if (line.startsWith("魔法ディレイ=")) {
                    magic_delay = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("弱点露出=")) {
                    week_point_exposure = Double
                            .parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("スタン成功=")) {
                    hit_stun = Integer.parseInt(line.split("=")[1]);
                }
            }
        } catch (IOException | NullPointerException e) {
            System.err.println(e);

        }
    }

    public void loadArrow(BufferedReader reader) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("small")) {
                    arrow_small = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("big")) {
                    arrow_big = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("name")) {
                    arrow_name = line.split("=")[1];
                }
                if (line.startsWith("材質")) {
                    arrow_material = line.split("=")[1];
                }
            }

        } catch (IOException | NullPointerException e) {
        }
    }

    public void checkEnchant() {
        if (name.equals("瞑想のスタッフ")) {
            op2 = new Buff();
            op2.MPR += enchant;
        }
        if (enchant >= 10) {
            op2.DMG_SHORT = enchant - 9;
            op2.DMG_LONG = enchant - 9;
            op2.DMG_MAGIC = enchant - 9;
        }
    }
}
