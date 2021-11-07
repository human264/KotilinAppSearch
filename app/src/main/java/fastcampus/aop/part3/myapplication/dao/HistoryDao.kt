package fastcampus.aop.part3.myapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import fastcampus.aop.part3.myapplication.model.History


@Dao
interface HistoryDao {


    @Query("Select * from history")
    fun getAll(): List<History>

    @Insert
    fun insertHistory(history: History)

    @Query("DELETE FROM history where keyword == :keyword")
    fun delete(keyword: String)




}