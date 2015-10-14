package lss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Polymorph implements Common{

    int speed[] = new int[buki_type_list.length];
    int magic_main = 0;
    int magic_sub = 0;

    void load(File file) {
        for (int i = 0; i < speed.length; i++) {
            speed[i] = 0;
        }
        try {
            FileReader in = new FileReader(file);
            try (BufferedReader br = new BufferedReader(in)) {
                String line;
                while ((line = br.readLine()) != null) {
                    for (int i = 0; i < buki_type_list.length; i++) {
                        if (line.startsWith(buki_type_list[i])) {
                            speed[i] = Integer.parseInt(line.split("=")[1]
                                    .split("/")[0]);
                        }
                    }
                    if (line.startsWith("—L–‚–@")) {
                        magic_main = Integer.parseInt(line.split("=")[1]);
                    }
                    if (line.startsWith("–³–‚–@")) {
                        magic_sub = Integer.parseInt(line.split("=")[1]);
                    }
                }
            }

        } catch (IOException | NumberFormatException e) {
        }

    }

    int getSpeed(String type) {
        for (int i = 0; i < buki_type_list.length; i++) {
            if (type.equals(buki_type_list[i])) {
                return speed[i];
            }
        }
        return 0;
    }
}