package ysf.awd.newapplication_finalproject.Model.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ysf.awd.newapplication_finalproject.Model.AppDataBase;
import ysf.awd.newapplication_finalproject.Model.MyTaskTable.MyTask;
import ysf.awd.newapplication_finalproject.Model.MyTaskTable.MyTaskQuery;

public class TaskRepository {
    public TaskRepository(Application application) {
    }

    /**
            * مستودع المهام (MyTask) يعمل كطبقة وسيطة ومنظمة للوصول إلى بيانات المهام (TaskRepository).
            * يقوم بفصل قاعدة بيانات
* Room  و {@link MyTaskQuery}
 * عن بقية أجزاء التطبيق (ViewModels).
            */
    public class taskRepository {
        private final MyTaskQuery taskQuery;//و
        // اجهة الاستعلامات
        private final LiveData<List<MyTask>> allTasks;//مبنى معطيات يحوي جميع المهلام المستخرجة

        /**
         * منشئ الكلاس (Constructor).
         * يقوم بتهيئة قاعدة البيانات واسترجاع كائن الـ DAO الخاص بالمهام.
         *
         * @param application سياق التطبيق (Application Context) المستخدم لإنشاء قاعدة البيانات.
         */
        public taskRepository(Application application) {
            AppDataBase db = AppDataBase.getDB(application);
            taskQuery = db.getMyTaskQuery();
            allTasks = taskQuery.getAllTasks();
        }
        /**
         *LiveData جلب جميع المهام الموجودة في قاعدة البيانات كـ.
         *
         * @return قائمة بجميع المهام المحدثة تلقائياً.
         */
        public LiveData<List<MyTask>> getAllTasks()
        {
            return allTasks;
        }

        /**
         * جلب المهام المرتبطة بمعرف مستخدم معين (User ID).
         *
         * @param userId معرف المستخدم المراد جلب مهامه.
         * @return قائمة المهام الخاصة بالمستخدم المحدد.
         */
        public List<MyTask> getTasksByUserId(long userId) {
            return taskQuery.getTasksBySubjId(userId);
        }

        /**
         * جلب مهمة معينة بناءً على معرفها الفريد (Task ID).
         *
         * @param taskId معرف المهمة الفريد.
         * @return كائن المهمة المطلوب.
         */
        public LiveData<List<MyTask>> getTaskById(long taskId) {
            return taskQuery.getAllTaskOrederBy(taskId);
        }

        /**
         * البحث عن المهام التي تتطابق عناوينها مع النص المدخل.
         *
         * @param title النص أو الكلمة المراد البحث عنها في العنوان.
         * @return قائمة المهام المطابقة.
         */
        public LiveData<List<MyTask>> getTasksByTitle(String title) {
            return taskQuery.getTasksByTitle(title);
        }
        /**
                * البحث عن المهام التي تتطابق أوصافها مع النص المدخل.
    *
            * @param description النص أو الكلمة المراد البحث عنها في الوصف.
    * @return قائمة المهام المطابقة.
    */
        public LiveData<List<MyTask>> getTasksByDescription(String description) {
            return taskQuery.getTasksByDescription(description);
        }
        /**
         * جلب المهام المفلترة حسب مستوى الأولوية.
         *
         * @param importance مستوى الأولوية المطلوب.
         * @return قائمة المهام ذات الأولوية المحددة.
         */
        public LiveData<List<MyTask>> getTasksByPriority(int importance) {
            return taskQuery.getTasksByimportance(importance);
        }
        /**
         * جلب المهام الخاصة بمستخدم معين والتي تتطابق مع عنوان معين.
         *
         * @param userId معرف المستخدم.
         * @param title  عنوان المهمة للبحث.
         * @return قائمة المهام المطابقة.
         */
        public LiveData<List<MyTask>> getTasksByUserIdAndTitle(long userId, String title) {
            return taskQuery.getTasksByUserIdAndTitle(userId, title);
        }
        /**
         * إدراج مهمة أو عدة مهمات جديدة في قاعدة البيانات.
         *
         * @param tasks المهام المراد إضافتها.
         */
        public void insert (MyTask... tasks) {
            taskQuery.insertTask(tasks);
        }
        /**
         * تحديث مهمة أو عدة مهمات في قاعدة البيانات.
         *
         * @param tasks المهام المراد تحديثها.
         */
        public void update(MyTask... tasks) {
            taskQuery.updateTask(tasks);
        }
        /**
         * تحديث بيانات مهمة محددة (العنوان، الوصف، والأولوية) باستخدام معرف المهمة.
         *
         * @param keyId      معرف المهمة المراد تعديلها.
         * @param shortTitle       العنوان الجديد.
         * @param description الوصف الجديد.
         * @param importance    الأولوية الجديدة.
         */
        public void updateTask(long keyId, String shortTitle, String description, int importance) {
            taskQuery.updateTask(keyId, shortTitle, description, importance);
        }
        /**
         * حذف مهمة أو عدة مهمات من قاعدة البيانات.
         *
         * @param tasks المهام المراد حذفها.
         */
        public void delete(MyTask... tasks) {
            taskQuery.deleteTask(tasks);
        }
        /**
         * حذف مهمة محددة باستخدام معرفها الفريد (Task ID).
         *
         * @param taskId معرف المهمة المراد حذفها.
         */
        public void deleteTaskById(long taskId) {
            taskQuery.deleteTaskById(taskId);
        }
    }
}














