package lss;

import java.io.BufferedReader;
import java.io.IOException;

public class Buff implements Common {

    int AC;
    int ST[] = new int[st_list.length];
    int[] element_resist = new int[elem_list.length];
    int element_coefficient[] = new int[elem_list.length];
    int element_dmg_c[] = new int[elem_list.length];
    int element_dmg_f[] = new int[elem_list.length];
    int HP;
    int MP;
    int HPR;
    int MPR;
    int d_short;
    int d_long;
    int HIT_SHORT;
    int HIT_LONG;
    int d_magic;
    int HIT_MAGIC;
    int SP;
    int DR;
    int MR;
    int ER;
    double weight;
    String effect = "";

    int[] ailment = new int[ailment_list.length];

    public void loadOption(BufferedReader reader) throws IOException {
        reader.reset();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("AC=")) {
                AC = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("STR=")) {
                ST[STR] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("DEX=")) {
                ST[DEX] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("CON=")) {
                ST[CON] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("INT=")) {
                ST[INT] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("WIS=")) {
                ST[WIS] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("CHA=")) {
                ST[CHA] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("FIRE=")) {
                element_resist[FIRE] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("EARTH=")) {
                element_resist[EARTH] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("WIND=")) {
                element_resist[WIND] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("WATER=")) {
                element_resist[WATER] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("HP=")) {
                HP = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("MP=")) {
                MP = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("HPR=")) {
                HPR = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("MPR=")) {
                MPR = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("’Ç‰Á‘ÅŒ‚=")) {
                d_short = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("‹|‘ÅŒ‚’l=")) {
                d_long = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("UŒ‚¬Œ÷=")) {
                HIT_SHORT = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("‹|–½’†—¦=")) {
                HIT_LONG = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("–‚–@–½’†=")) {
                HIT_MAGIC = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("SP=")) {
                SP = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("DR=")) {
                DR = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("MR=")) {
                MR = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("d—ÊŒyŒ¸=")) {
                weight = Double.parseDouble(line.split("=")[1]);
            }
            if (line.startsWith("“Áê=")) {
                effect = line.split("=")[1];
            }
            if (line.startsWith("ƒXƒ^ƒ“=")) {
                ailment[STUN] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("ˆÃˆÅ=")) {
                ailment[DARKNESS] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("ƒz[ƒ‹ƒh=")) {
                ailment[HOLD] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("“€Œ‹=")) {
                ailment[FREEZE] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("Î‰»=")) {
                ailment[STONE] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("‡–°=")) {
                ailment[SLEEP] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("‹°•|=")) {
                ailment[TERROR] = Integer.parseInt(line.split("=")[1]);
            }

        }
    }
}
