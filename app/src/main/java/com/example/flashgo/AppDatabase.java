package com.example.flashgo;


import androidx.room.RoomDatabase;
import androidx.room.Database;


@Database(entities = {Flashcard.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FlashcardDao flashcardDao();
}
