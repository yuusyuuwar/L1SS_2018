package lss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Buff implements Common{

    int AC;
    int ST[] = new int[st_list.length];
    int element_resisit[] = new int[elem_list.length];
    int element_coefficient[] = new int[elem_list.length];
    int element_dmg_c[] = new int[elem_list.length];
    int element_dmg_f[] = new int[elem_list.length];
    int HP;
    int MP;
    int HPR;
    int MPR;
    int d_short;
    int d_long;
    int HIT_CLOSE;
    int HIT_FAR;
    int DMG_MAGIC;
    int HIT_MAGIC;
    int SP;
    int DR;
    int MR;
    int ER;
    double weight;
    String effect = "";
    
    int[] ailment = new int[ailment_list.length];
    

    public void loadOption(File file) throws IOException {
        FileReader in = new FileReader(file);
        try (BufferedReader br = new BufferedReader(in)) {
            String line;
            while ((line = br.readLine()) != null) {
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
                    element_resisit[FIRE] = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("EARTH=")) {
                    element_resisit[EARTH] = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("WIND=")) {
                    element_resisit[WIND] = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("WATER=")) {
                    element_resisit[WATER] = Integer.parseInt(line.split("=")[1]);
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
                if (line.startsWith("í«â¡ë≈åÇ=")) {
                    d_short = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("ã|ë≈åÇíl=")) {
                    d_long = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("çUåÇê¨å˜=")) {
                    HIT_CLOSE = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("ã|ñΩíÜó¶=")) {
                    HIT_FAR = Integer.parseInt(line.split("=")[1]);
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
                if (line.startsWith("èdó åyå∏=")) {
                    weight = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("ì¡éÍ=")) {
                    effect = line.split("=")[1];
                }
                if (line.startsWith("ÉXÉ^Éì=")) {
                    ailment[STUN] = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("à√à≈=")) {
                    ailment[DARKNESS] = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("ÉzÅ[ÉãÉh=")) {
                    ailment[HOLD] = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("ìÄåã=")) {
                    ailment[FREEZE] = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("êŒâª=")) {
                    ailment[STONE] = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("êáñ∞=")) {
                    ailment[SLEEP] = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("ã∞ï|=")) {
                    ailment[TERROR] = Integer.parseInt(line.split("=")[1]);
                }
                
            }
            br.close();
        }
    }
}
