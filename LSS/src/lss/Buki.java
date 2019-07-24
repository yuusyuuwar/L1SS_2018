package lss;

import java.io.BufferedReader;
import java.io.IOException;

public class Buki implements Common {

    int small = 0;
    int big = 0;
    String name = "";
    String type = "";
    double critical_rate = 0;// �N���E �N���e�B�J��
    double double_hit_rate = 0;// �f���A���u���[�h �_�u���q�b�g
    double week_point_exposure = 0;// �`�F�[���\�[�h ��_�I�o
    boolean two_hands = false;
//    String equip = "";
    String material = "";
    Buff op = new Buff();
    Buff op2 = new Buff();
    int enchant = 0;
    int magic_enchant = 0;
    int max_enchant = 0;
    String arrow_name = "";
    String arrow_material = "";
//    String arrow_type = "";
//    int arrow_small = 0;
//    int arrow_big = 0;
    int arrow_dmg = 0;
    int arrow_elementdmg = 0; 
    int arrow_hit = 0;
    
    int safety = 0;
    boolean element_enchant = false;
    // �L�[�����N�p
    int x, y, z;
    // ���@����p
    String magic_name = "";
//    boolean magic_motion = false;
    double magic_rate = 0;
    double magic_rate_plus = 0;
    String magic_element = "";
    double magic_power = 0;
    double magic_delay = 0;
//    int weight = 0;

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
//        arrow_type = "";
        arrow_dmg = 0;
        arrow_elementdmg = 0;
        arrow_hit = 0;

        safety = 0;
        element_enchant = false;

        magic_name = "";
//        magic_motion = false;
        magic_rate = 0;
        magic_element = "";
        magic_power = 0;
        magic_delay = 0;
        magic_rate_plus = 0;

//        weight = 0;
    }

    void load(BufferedReader reader) {
        reset();
        if (reader == null) {
            return;
        }
        try {
            reader.mark(1_000_000);
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
                if (line.startsWith("�_���[�W�_�C�X=")) {
                    x = Integer.parseInt(line.split("=")[1].split("d")[0]);
                    y = Integer.parseInt(line.split("=")[1].split("d")[1]
                            .split("\\+")[0]);
                    z = Integer.parseInt(line.split("=")[1].split("d")[1]
                            .split("\\+")[1]);
                }
//                if (line.startsWith("equip=")) {
//                    equip = line.split("=")[1];
//                }
                if (line.startsWith("name=")) {
                    name = line.split("=")[1];
                }
                if (line.startsWith("�N���e�B�J��=")) {
                    critical_rate = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("�_�u���q�b�g=")) {
                    double_hit_rate = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("���S=")) {
                    safety = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("�������E=")) {
                    max_enchant = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("�ގ�=")) {
                    material = line.split("=")[1];
                }
                if (line.startsWith("���蕐��=")) {
                    two_hands = Boolean.parseBoolean(line.split("=")[1]);
                }
                if (line.startsWith("��������=")) {
                    element_enchant = Boolean.parseBoolean(line.split("=")[1]);
                }
                if (line.startsWith("���@�_���[�W=")) {
                    magic_power = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("���@������=")) {
                    magic_rate = Double.parseDouble(line.split("=")[1]);
                }
//                if (line.startsWith("���@���[�V����=")) {
//                    magic_motion = Boolean.parseBoolean(line.split("=")[1]);
//                }
                if (line.startsWith("���@����=")) {
                    magic_element = line.split("=")[1];
                }
                if (line.startsWith("���@����������=")) {
                    magic_rate_plus = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("���@=")) {
                    magic_name = line.split("=")[1];
                }
                if (line.startsWith("���@�f�B���C=")) {
                    magic_delay = Double.parseDouble(line.split("=")[1]);
                }
                if (line.startsWith("��_�I�o=")) {
                    week_point_exposure = Double
                            .parseDouble(line.split("=")[1]);
                }
//                if (line.startsWith("�d��=")) {
//                    weight = Integer.parseInt(line.split("=")[1]);
//                }
            }
        } catch (IOException | NullPointerException e) {
//            System.err.println(e);

        }
    }

    public void loadArrow(BufferedReader reader) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("name")) {
                    arrow_name = line.split("=")[1];
                }
                if (line.startsWith("�ǉ��_���[�W")) {
                    arrow_dmg = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("�����_���[�W")) {
                    arrow_elementdmg = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("����������")) {
                    arrow_hit = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("�ގ�")) {
                    arrow_material = line.split("=")[1];
                }
            }

        } catch (IOException | NullPointerException e) {
        }
    }

    public void checkEnchant() {
        op2 = new Buff();
        //�ґz�̃X�^�b�t
        if (name.equals("�ґz�̃X�^�b�t")) {
            op2.MPR += enchant;
        }
        if (name.equals("�����̐�����")) {
            if (enchant >= 9) {
                op2.ST[CHA] += 1;
            }
        }
        //�n���E�B������*8���      ����1����PVP�_���[�W+1
        if (name.equals("�n���E�B���\�[�h") || name.equals("�n���E�B���c�[�n���h�\�[�h") || name.equals("�n���E�B���A�b�N�X") || name.equals("�n���E�B���X�^�b�t") || name.equals("�n���E�B���f���A���u���[�h") || name.equals("�n���E�B���`�F�[���\�[�h") || name.equals("�n���E�B���L�[�����N") || name.equals("�n���E�B���{�E")) {
            op2.PVP += enchant;                         //PVP�_���[�W+������
        }
        //�o�t�H���b�g�X�^�b�t      +7�ȍ~����1����SP+1(+9�܂œK�p)
        if (name.equals("�o�t�H���b�g�X�^�b�t")) {
            if (enchant >= 9) {
            op2.SP += 3;                                //SP+3
            } else if (enchant >= 8) {
            op2.SP += 2;                                //SP+2
            } else if (enchant >= 7) {
            op2.SP += 1;                                //SP+1
            }
        }
        //�e���y�X�g�A�b�N�X        +8�ȍ~����1���ɋ��|�I��+1(+10�����܂œK�p)
        if (name.equals("�e���y�X�g�A�b�N�X") || name.equals("�e���y�X�g�A�b�N�X(�ޗ�����)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_TERROR] += 3;               //���|�I��+3
            } else if (enchant >= 9) {
            op2.ailment[HIT_TERROR] += 2;               //���|�I��+2
            } else if (enchant >= 8) {
            op2.ailment[HIT_TERROR] += 1;               //���|�I��+1
            }
        }
        //�r�Ŏ҂̃`�F�[���\�[�h      +7�ȍ~����1���ɔ�Z����+1(+10�����܂œK�p)
        if (name.equals("�r�Ŏ҂̃`�F�[���\�[�h") || name.equals("�r�Ŏ҂̃`�F�[���\�[�h(�r�Ŕ���)")) {
            if (enchant >= 10) {
            op2.ailment[HIT_SECRET] += 4;               //��Z����+4
            } else if (enchant >= 9) {
            op2.ailment[HIT_SECRET] += 3;               //��Z����+3
            } else if (enchant >= 8) {
            op2.ailment[HIT_SECRET] += 2;               //��Z����+2
            } else if (enchant >= 7) {
            op2.ailment[HIT_SECRET] += 1;               //��Z����+1
            }
        }
        //�E�ӂ̃L�[�����N          +7�ȍ~����1���ɔ�Z����+1���@�N���e�B�J��+1(+10�����܂œK�p)
        if (name.equals("�E�ӂ̃L�[�����N")) {
            if (enchant >= 10) {
            op2.ailment[HIT_SECRET] += 4;               //��Z����+4
            op2.CRI_MAGIC += 4;                         //���@�N���e�B�J��+4
            } else if (enchant >= 9) {
            op2.ailment[HIT_SECRET] += 3;               //��Z����+3
            op2.CRI_MAGIC += 3;                         //���@�N���e�B�J��+3
            } else if (enchant >= 8) {
            op2.ailment[HIT_SECRET] += 2;               //��Z����+2
            op2.CRI_MAGIC += 2;                         //���@�N���e�B�J��+2
            } else if (enchant >= 7) {
            op2.ailment[HIT_SECRET] += 1;               //��Z����+1
            op2.CRI_MAGIC += 1;                         //���@�N���e�B�J��+1
            }
        }
        //�^�����̎��s��            +1��������[�ߋ����ǉ��_���[�W+2(��������+1)][�ߋ����N���e�B�J��+1][�Z�p����+1]����
        if (name.equals("�^�����̎��s��")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //�ߋ����ǉ��_���[�W
            op2.CRI_SHORT += enchant;                   //�ߋ����N���e�B�J��
            op2.ailment[HIT_STUN] += enchant;           //�Z�p����
            }
        }
        //�E�B���h�u���[�h�\�[�h    +1��������[�ߋ����ǉ��_���[�W+2(��������+1)]����
        if (name.equals("�E�B���h�u���[�h�\�[�h")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //�ߋ����ǉ��_���[�W
            }
        } 
        //���b�h�V���h�E�f���A���u���[�h    +1��������[�ߋ����ǉ��_���[�W+2(��������+1)][���얽��+1]����
        if (name.equals("���b�h�V���h�E�f���A���u���[�h")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //�ߋ����ǉ��_���[�W
            op2.ailment[HIT_SPIRIT] += enchant;         //���얽��
            }
        }
        //�z�[���[�w�h�����X�^�b�t  +1��������[�ߋ����ǉ��_���[�W+2(��������+1)][SP+1][���@����+1]����
        if (name.equals("�z�[���[�w�h�����X�^�b�t")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //�ߋ����ǉ��_���[�W
            op2.SP += enchant;                          //SP 
            op2.HIT_MAGIC += enchant;                   //���@����   
            }
        }
        //�N���m�X�̋��|            +1��������[�ߋ����ǉ��_���[�W+2(��������+1)][�ߋ����N���e�B�J��+1%][��Z����+1]����
        if (name.equals("�N���m�X�̋��|")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //�ߋ����ǉ��_���[�W
            op2.CRI_SHORT += enchant;                   //�ߋ����N���e�B�J��
            op2.ailment[HIT_SECRET] += enchant;         //��Z����
            }
        }
        //�q���y���I���̐�]        +1��������[�ߋ����ǉ��_���[�W+2(��������+1)][SP][���@�N���e�B�J��+1%][��Z����+1]����
        if (name.equals("�q���y���I���̐�]")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //�ߋ����ǉ��_���[�W
            op2.SP += enchant;                          //SP 
            op2.CRI_MAGIC += enchant;                   //���@�N���e�B�J��
            op2.ailment[HIT_SECRET] += enchant;         //��Z����
            }
        }
        //�^�C�^���̕��{            +1��������[�ߋ����ǉ��_���[�W+2(��������+1)][�ߋ����N���e�B�J��+1%][���|����+1]���� 
        if (name.equals("�^�C�^���̕��{")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //�ߋ����ǉ��_���[�W
            op2.CRI_SHORT += enchant;                   //�ߋ����N���e�B�J��
            op2.ailment[HIT_TERROR] += enchant;         //���|����
            }
        }
        //�K�C�A�̌��{              +1��������[�������ǉ��_���[�W+2(��������+1)][�������N���e�B�J��+1%][�_���[�W�y������][���얽��+1]���� 
        if (name.equals("�K�C�A�̌��{")) {
            if (enchant >= 0) {
            op2.DMG_LONG += enchant;                    //�������ǉ��_���[�W
            op2.CRI_LONG += enchant;                    //�������N���e�B�J��
            op2.DR_IGNORED += enchant;                  //�_���[�W���_�N�V��������
            op2.ailment[HIT_SPIRIT] += enchant;         //���얽��
            }
        }
        //���_�̌�(REMASTERED)      +1��������[�ߋ����ǉ��_���[�W+2(��������+1)][�ߋ����N���e�B�J��+1%][�Z�p����+1][���얽��+1][���|����+1]���� 
        if (name.equals("���_�̌�(REMASTERED)")) {
            if (enchant >= 0) {
            op2.DMG_SHORT += enchant;                   //�ߋ����ǉ��_���[�W
            op2.CRI_SHORT += enchant;                   //�ߋ����N���e�B�J��
            op2.ailment[HIT_STUN] += enchant;           //�Z�p����
            op2.ailment[HIT_SPIRIT] += enchant;         //���얽��
            op2.ailment[HIT_TERROR] += enchant;         //���|����
            }
        }
        //����+10�ȏ�̓G���`�����g�ɂ��ǉ��_���[�W��+2(���������ɒǉ���+1)
        if (enchant >= 10) {
            op2.DMG_SHORT += enchant - 9;               //�ߋ����ǉ��_���[�W
            op2.DMG_LONG += enchant - 9;                //�������ǉ��_���[�W
            op2.DMG_MAGIC += enchant - 9;               //���@�ǉ��_���[�W
        }
    }
}
