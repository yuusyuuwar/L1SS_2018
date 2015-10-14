/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lss;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import static lss.Common.st_list;

/**
 *
 * @author user
 */
public class UI extends JFrame implements Common, ActionListener, ChangeListener {

    final String version = "2.0.0";
    JTabbedPane tabpane;
    JPanel panels[] = new JPanel[4];

    //UIパーツ
    //共通
    JLabel[] lab_st = new JLabel[st_list.length];
    JLabel[] lab_st_base = new JLabel[st_list.length];
    JLabel[] lab_st_lev = new JLabel[st_list.length];
    JLabel[] lab_st_add = new JLabel[st_list.length];
    JLabel lab_rem;

    JButton[] bt_down = new JButton[st_list.length];
    JButton[] bt_up = new JButton[st_list.length];

    JComboBox cb_level;
    JComboBox cb_class;

    JLabel lab_phi_atk;
    JLabel lab_mag_atk;
    JLabel lab_phi_def;
    JLabel lab_mag_def;
    JLabel lab_mag_const;
    
    //共通パーツ入れ
    ArrayList<JComponent> commons = new ArrayList<>();

    //パネル１
    WideComboBox[] cb_eq = new WideComboBox[equip_list.length];
    JComboBox[] cb_eq_enchant = new JComboBox[equip_list.length];
    JComboBox cb_elem_1;
    JComboBox cb_elem_2;
    JComboBox cb_ts_elemt;
    JToggleButton tb_ts_tokusei;
    JToggleButton tb_blessed1;
    JToggleButton tb_blessed2;

    WideComboBox cb_pattern_l;
    WideComboBox cb_pattern_r;
    WideComboBox cb_pattern_c;
    WideComboBox cb_pattern_l2;
    WideComboBox cb_pattern_r2;

    JLabel lab_dr;
    JLabel lab_hp;
    JLabel lab_mp;
    JLabel lab_hpr;
    JLabel lab_mpr;
    JLabel lab_sp;
    JLabel lab_ml;
    JLabel lab_mb;
    JLabel[] lab_elem = new JLabel[elem_list.length];
    JLabel[] lab_ailment = new JLabel[ailment_list.length];

    JLabel lab_mag_dmg;
    JLabel lab_dmg_short, lab_dmg_long;
    JLabel lab_dmg_normal;
    JLabel lab_dmg_cursedt;
    JLabel lab_dmg_undeadt;
    JLabel lab_mahou_1;
    JLabel lab_mahou_2;
    JLabel lab_hit_rate;
    JLabel lab_hit_short, lab_hit_long;
    JLabel lab_mp_syouhi;
    JLabel lab_weight;

    JComboBox cb_polymorph_type;
    JComboBox cb_polymorph_level;

    JLabel lab_speed;
    JTextField tf_sp_rate;
    JLabel lab_sp_sub;
    JTextField tf_mag_rate;
    JTextField tf_mag_delay;
    JTextField tf_mag_power;
    JLabel lab_sp_rate;
    JLabel lab_mag_rate;
    JLabel lab_mag_delay;
    JLabel lab_mag_power;
    JComboBox lab_eq_channel;
    JButton bt_copy;
    JButton bt_paste;
    JButton bt_reset;
    JButton bt_save;
    JButton bt_load;
    JComboBox cb_magic;

    JToggleButton tb_sonsyou;
    JComboBox cb_weight;

    //パネル２
    JLabel[][] pure_status_bonus = new JLabel[2][25];

    JComboBox[] elixir = new JComboBox[5];
    JComboBox[] elixir_level = new JComboBox[5];
    JLabel[] elixir_txt = new JLabel[5];
    LEV lev = new LEV();

    //パネル３
    MyToggleButton[] enchant_bt = new MyToggleButton[77];
    JComboBox[] enchant_group = new JComboBox[77];

    //パネル４
    JComboBox cb_npc_level;
    JSlider r_fire_slider, r_water_slider, r_wind_slider, r_earth_slider;
    JLabel r_fire_txt, r_water_txt, r_wind_txt, r_earth_txt;
    JComboBox dr_list;
    JSlider mr_slider;
    JLabel target_mr_txt;
    JComboBox target_ac_list;
    JToggleButton ud_bt;
    JToggleButton fear_bt;
    JToggleButton pc_bt;

    JTextField tf_acc1;
    JTextField tf_acc2;
    JTextField tf_acc3;
    JTextField acc_ew;
    JTextField tf_bs;
    JTextField tf_db;
    JTextField tf_ef;
    JTextField tf_key_delay;

    ArrayList<File> equip_files[] = new ArrayList[elem_list.length];
    File[] arrow_files;
    File[] sting_files;

    void init() {
        setTitle("LSS ver " + version);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);

        tabpane = new JTabbedPane();

        panels[0] = new JPanel();
        panels[1] = new JPanel();
        panels[2] = new JPanel();
        panels[3] = new JPanel();

        panels[0].setLayout(null);
        panels[1].setLayout(null);
        panels[2].setLayout(null);
        panels[3].setLayout(null);

        tabpane.add("装備/ステータス", panels[0]);
        tabpane.add("レベル/エリクサー", panels[1]);
        tabpane.add("エンチャント", panels[2]);
        tabpane.add("耐性設定", panels[3]);

        add(tabpane);

        
        //----------
        //共通
        //----------
        
        JLabel lab_tmp;

        cb_class = new WideComboBox(class_list2);
        cb_class.setBounds(0, 0, 100, 25);
        cb_class.addActionListener(this);
        panels[0].add(cb_class);
        commons.add(cb_class);

        lab_tmp = new JLabel("Lev.");
        lab_tmp.setBounds(130, 0, 30, 25);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);

        lab_hp = new JLabel();
        lab_hp.setBounds(250, 0, 70, 25);
        lab_mp = new JLabel();
        lab_mp.setBounds(320, 0, 70, 25);
        panels[0].add(lab_hp);
        panels[0].add(lab_mp);
        commons.add(lab_hp);
        commons.add(lab_mp);

        lab_tmp = new JLabel("-");
        lab_tmp.setBounds(55, 30, 20, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        
        lab_tmp = new JLabel("+");
        lab_tmp.setBounds(75, 30, 20, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);

        String lev_list[] = new String[88];
        for (int i = 0; i < lev_list.length; i++) {
            lev_list[i] = Integer.toString(i + 1);
        }
        cb_level = new WideComboBox(lev_list);
        cb_level.addActionListener(this);
        cb_level.setBounds(180, 0, 50, 25);
        panels[0].add(cb_level);
        commons.add(cb_level);

        for (int i = 0; i < st_list.length; i++) {
            
            lab_st[i] = new JLabel(st_list[i]);
            lab_st[i].setBounds(0, 50 + i * 20, 30, 20);
            panels[0].add(lab_st[i]);
            commons.add(lab_st[i]);

            bt_down[i] = new JButton();
            bt_down[i].setBounds(50, 50 + i * 20, 20, 20);
            bt_down[i].setActionCommand(st_list[i] + "down");
            panels[0].add(bt_down[i]);
            commons.add(bt_down[i]);

            bt_up[i] = new JButton();
            bt_up[i].setBounds(70, 50 + i * 20, 20, 20);
            bt_up[i].setActionCommand(st_list[i] + "up");
            panels[0].add(bt_up[i]);
            commons.add(bt_up[i]);

            lab_st_base[i] = new JLabel("0", JLabel.CENTER);
            lab_st_base[i].setHorizontalTextPosition(JLabel.CENTER);
            lab_st_base[i].setBounds(100, 50 + 20 * i, 30, 25);
            lab_st_add[i] = new JLabel("0", JLabel.CENTER);
            lab_st_add[i].setHorizontalTextPosition(JLabel.CENTER);
            lab_st_add[i].setBounds(160, 50 + 20 * i, 30, 25);
            lab_st_lev[i] = new JLabel("0", JLabel.CENTER);
            lab_st_lev[i].setHorizontalTextPosition(JLabel.CENTER);
            lab_st_lev[i].setBounds(130, 50 + 20 * i, 30, 25);

            panels[0].add(lab_st_base[i]);
            panels[0].add(lab_st_add[i]);
            panels[0].add(lab_st_lev[i]);
            commons.add(lab_st_base[i]);
            commons.add(lab_st_add[i]);
            commons.add(lab_st_lev[i]);
        }

        lab_tmp = new JLabel("REM");
        lab_tmp.setBounds(0, 50 + 120, 30, 20);
        panels[0].add(lab_tmp);
        lab_tmp = new JLabel("REM");
        lab_tmp.setBounds(0, 50 + 120, 30, 20);
        panels[1].add(lab_tmp);

        lab_rem = new JLabel("");
        lab_rem.setBounds(30, 50 + 120, 20, 20);
        panels[0].add(lab_rem);

        lab_tmp = new JLabel("初期", JLabel.CENTER);
        lab_tmp.setBounds(100, 25, 30, 25);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("LV", JLabel.CENTER);
        lab_tmp.setBounds(130, 25, 30, 25);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("追加", JLabel.CENTER);
        lab_tmp.setBounds(160, 25, 30, 25);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("合計", JLabel.CENTER);
        lab_tmp.setBounds(20, 25, 30, 25);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);


        lab_mag_const = new JLabel("魔法系数");

        lab_phi_atk = new JLabel("物理攻撃");
        lab_mag_atk = new JLabel("魔法攻撃");
        lab_phi_def = new JLabel("物理防御");
        lab_mag_def = new JLabel("魔法防御");
        lab_phi_atk.setBounds(220, 50, 200, 25);
        lab_mag_atk.setBounds(220, 75, 200, 25);
        lab_phi_def.setBounds(220, 100, 200, 25);
        lab_mag_def.setBounds(220, 125, 200, 25);
        lab_mag_const.setBounds(220, 150, 200, 25);

        panels[0].add(lab_phi_atk);
        commons.add(lab_phi_atk);
        panels[0].add(lab_phi_def);
        commons.add(lab_phi_def);
        panels[0].add(lab_mag_atk);
        commons.add(lab_mag_atk);
        panels[0].add(lab_mag_def);
        commons.add(lab_mag_def);
        panels[0].add(lab_mag_const);
        commons.add(lab_mag_const);

        //----------
        //パネル１
        //----------
        
        
        
        
        
        
        //----------
        //パネル２
        //----------
        
        for (int i = 0; i < st_list.length; i++) {
            JLabel lab4 = new JLabel(st_list[i], SwingConstants.CENTER);
            lab4.setBounds(30 + 150 * i, 195, 100, 25);
            panels[1].add(lab4);
        }
        
        pure_status_bonus[0][0] = new JLabel("近距離ダメージ");
        pure_status_bonus[0][1] = new JLabel("近距離命中");
        pure_status_bonus[0][2] = new JLabel("近距離クリティカル");
        pure_status_bonus[0][3] = new JLabel("最大所持重量");
        pure_status_bonus[0][4] = new JLabel("");
        pure_status_bonus[0][5] = new JLabel("遠距離ダメージ");
        pure_status_bonus[0][6] = new JLabel("遠距離命中");
        pure_status_bonus[0][7] = new JLabel("遠距離クリティカル");
        pure_status_bonus[0][8] = new JLabel("AC");
        pure_status_bonus[0][9] = new JLabel("ER");
        pure_status_bonus[0][10] = new JLabel("HP増加");
        pure_status_bonus[0][11] = new JLabel("HPR");
        pure_status_bonus[0][12] = new JLabel("HPポーション");
        pure_status_bonus[0][13] = new JLabel("最大重量");
        pure_status_bonus[0][14] = new JLabel("");
        pure_status_bonus[0][15] = new JLabel("魔法ダメージ");
        pure_status_bonus[0][16] = new JLabel("魔法命中");
        pure_status_bonus[0][17] = new JLabel("魔法クリティカル");
        pure_status_bonus[0][18] = new JLabel("MB");
        pure_status_bonus[0][19] = new JLabel("MP消費減少");
        pure_status_bonus[0][20] = new JLabel("MP増加");
        pure_status_bonus[0][21] = new JLabel("MPR");
        pure_status_bonus[0][22] = new JLabel("MPポーション");
        pure_status_bonus[0][23] = new JLabel("MR");
        pure_status_bonus[0][24] = new JLabel("");

        for (int i = 0; i < pure_status_bonus[0].length; i++) {

            pure_status_bonus[1][i] = new JLabel("0");
            pure_status_bonus[0][i].setBounds(30 + 150 * (i / 5), 220 + 25 * (i % 5), 100, 25);
            pure_status_bonus[1][i].setBounds(130 + 150 * (i / 5), 220 + 25 * (i % 5), 50, 25);
            if (pure_status_bonus[0][i].getText().equals("")) {
                continue;
            }
            panels[1].add(pure_status_bonus[0][i]);
            panels[1].add(pure_status_bonus[1][i]);
        }
        
        
        tabpane.addChangeListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource().equals(tabpane)) {
            int tab_id = tabpane.getSelectedIndex();

            if (tab_id == 0 || tab_id == 1) {
                JPanel p = panels[tab_id];
                commons.stream().forEach((c) -> {
                    p.add(c);
                });
            }
        }
    }
}
