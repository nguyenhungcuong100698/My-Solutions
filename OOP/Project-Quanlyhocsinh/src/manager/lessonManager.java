/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import dao.lessonDAO;
import entity.Lesson;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class lessonManager {

    private ArrayList<Lesson> lessonList;
    private lessonDAO myDAO;

    public lessonManager() {
        myDAO = new lessonDAO();
        this.lessonList = myDAO.readListCDasByte();
    }

    public void changeLesson(int a, String date, String unit, String name) {
        this.lessonList.get(a).setDate(date);
        this.lessonList.get(a).setUnit(unit);
        this.lessonList.get(a).setName(name);
    }

    public void saveList() {
        
        this.myDAO.saveListCDasByte(lessonList);
    }

    public boolean addLesson(Lesson a) {
        if(findLessonByName(a.getName())==-1)
        {
            this.lessonList.add(a);
            return true;
        }
        return false;
    }

    public ArrayList<Lesson> getListlesson() {
        return this.lessonList;
    }

    public int findLessonByName(String name) {
        for (int i = 0; i < lessonList.size(); i++) {
            if (lessonList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void deleteLessonByName(String name) {
        this.lessonList.remove(this.findLessonByName(name));
    }
}
