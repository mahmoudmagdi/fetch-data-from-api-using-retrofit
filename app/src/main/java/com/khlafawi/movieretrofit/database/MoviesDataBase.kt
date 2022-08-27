package com.khlafawi.movieretrofit.database

import android.content.Context
import androidx.room.*
import com.khlafawi.movieretrofit.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MoviesDataBase : RoomDatabase() {

    abstract val moviesDatabaseDao: MoviesDataBaseDao

    companion object {

        @Volatile
        private var INSTANCE: MoviesDataBase? = null

        fun getInstance(context: Context): MoviesDataBase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MoviesDataBase::class.java,
                        "movies_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}