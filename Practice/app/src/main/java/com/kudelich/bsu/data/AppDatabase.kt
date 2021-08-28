package com.kudelich.bsu.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kudelich.bsu.data.dao.ClassDao
import com.kudelich.bsu.data.dao.CourseDao
import com.kudelich.bsu.data.dao.FacultyDao
import com.kudelich.bsu.data.dao.GroupDao
import com.kudelich.bsu.classes.entities.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [
    Faculty::class,
    Course::class,
    Group::class,
    Class::class,
    User::class
                     ],
    version = 1,
    exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun classDao(): ClassDao
    abstract fun facultyDao(): FacultyDao
    abstract fun courseDao():CourseDao
    abstract fun groupDao():GroupDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context, scope: CoroutineScope): AppDatabase{
            val tempInstance = INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "bsu_database")
                    .addCallback(DatabaseCallback(scope))
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }

    private class DatabaseCallback(
        private val scope: CoroutineScope
    ): RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {database->
                scope.launch(Dispatchers.IO) {
                    addClasses(database.classDao())
                    addFaculties(database.facultyDao())
                    addCourses(database.courseDao())
                    addGroups(database.groupDao())
                }
            }
        }

        suspend fun addGroups(groupDao: GroupDao){
            val initGroups = listOf<Group>(
                Group(0,1,"pervaya",1),
                Group(0,2,"vtoraya",1),
                Group(0,3,"tretya",1)
            )

            for(element in initGroups){
                groupDao.addGroup(element)
            }
        }

        suspend fun addCourses(courseDao: CourseDao){
            val initCourses = listOf<Course>(
                Course(0,1,1),
                Course(0,2,1),
                Course(0,3,1),
                Course(0,4,1)
            )

            for(element in initCourses){
                courseDao.addCourse(element)
            }
        }

        suspend fun addClasses(classDao: ClassDao){
            val initClasses = listOf<Class>(
                Class(0,"16:00-17:20","UMF","606",1),
                Class(0,"16:00-17:20","UMF","607",1),
                Class(0,"16:00-17:20","UMF","608",1)
            )

            for(element in initClasses){
                classDao.addClass(element)
            }
        }

        suspend fun addFaculties(facultyDao: FacultyDao){
            val initFaculties = listOf<Faculty>(
                Faculty(0,"Механико-математический факультет"),
                Faculty(0,"Факультет прикладной математики и информатики"),
                Faculty(0,"Юридический факультет"),
                Faculty(0,"Географический факультет")
            )

            for(element in initFaculties){
                facultyDao.addFaculty(element)
            }
        }
    }
}
