/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.util.HashMap;

/**
 *
 * @author Duong
 */
public class schoolstageManager {

    HashMap<Integer, String> schoolstageList;

    public schoolstageManager() {
        schoolstageList = new HashMap<>();
        
        schoolstageList.put(1, "Chiên Non");
        schoolstageList.put(2, "Ấu Nhi");
        schoolstageList.put(3, "Thiếu Nhi");
        schoolstageList.put(4, "Nghĩa Sĩ");
        schoolstageList.put(5, "Tông Đồ");
        schoolstageList.put(6, "Dự Trưởng");
        schoolstageList.put(7, "Huynh Trưởng");
    }

    public HashMap getListSchoolstage() {
        return schoolstageList;
    }

    public String[] getListSchoolstageName() {
        String[] temp = new String[schoolstageList.size()];
        for (int i = 1; i <= 7; i++) {
            temp[i - 1] = schoolstageList.get(i);
        }
        return temp;
    }
}
