package fastcampus.aop.part3.myapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fastcampus.aop.part3.myapplication.model.History
import fastcampus.aop.part3.myapplication.model.Review


@Dao
interface ReviewDao {

    @Query("Select * from review where id == :id")
    fun getOneReview(id: Int): Review

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveReview(review: Review)



}