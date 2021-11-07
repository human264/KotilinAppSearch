package fastcampus.aop.part3.myapplication

import androidx.room.Database
import androidx.room.RoomDatabase
import fastcampus.aop.part3.myapplication.dao.HistoryDao
import fastcampus.aop.part3.myapplication.dao.ReviewDao
import fastcampus.aop.part3.myapplication.model.History
import fastcampus.aop.part3.myapplication.model.Review


@Database(entities = [History::class, Review::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun historyDao(): HistoryDao
    abstract fun reviewDao(): ReviewDao

}