package ysf.awd.newapplication_finalproject.Model.MyTaskTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * فئة تُمثل مهمة
 */
@Entity
public class MyTask {

    @PrimaryKey(autoGenerate = true)
    /** رقم المهمة */
    public long keyId;

    /** درجة الاهمية 1-5 */
    public int importance;

    /** عنوان قصير */
    public String shortTitle;

    /** نص المهمة */
    public String text;

    /** زمن بناء المهمة */
    public long time;

    /** هل تمت المهمة */
    public boolean isCompleted;

    /** رقم موضوع المهمة */
    public long subjId;

    /** رقم المستعمل الذي اضاف المهمة */
    public long userId;

    public MyTask() {
    }

    // Getters and Setters
    public long getKeyId() {
        return keyId;
    }

    public void setKeyId(long keyId) {
        this.keyId = keyId;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public long getSubjId() {
        return subjId;
    }

    public void setSubjId(long subjId) {
        this.subjId = subjId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "keyId=" + keyId +
                ", importance=" + importance +
                ", shortTitle='" + shortTitle + '\'' +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", isCompleted=" + isCompleted +
                ", subjId=" + subjId +
                ", userId=" + userId +
                '}';
    }
}