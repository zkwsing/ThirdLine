package com.example.test2.kotlin.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.test2.kotlin.bean.Book

@Dao
interface BookDao {
    @Insert
    fun inserBook(book:Book):Long
    @Query("select * from Book")
    fun loadAllBooks():List<Book>
}