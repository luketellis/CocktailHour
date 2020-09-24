package com.example.cocktailhour

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


// Annotates class to be a Room Database with a table (entity) of the Drink class
@Database(entities = arrayOf(Drink::class), version = 1, exportSchema = false)
public abstract class DrinkRoomDatabase : RoomDatabase() {

    abstract fun drinkDao(): DrinkDao


    private class DrinkDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.drinkDao())
                }
            }
        }

        suspend fun populateDatabase(drinkDao: DrinkDao) {
            // Delete all content here.
            //drinkDao.deleteAll()

            // Add sample drinks.
            var drink = Drink("Tequila", "Mexican")
            drinkDao.insert(drink)
            drink = Drink("Coffee", "Morning")
            drinkDao.insert(drink)

            // TODO: Add your own drinks!
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: DrinkRoomDatabase? = null

        fun getDatabase(context: Context,
                        scope: CoroutineScope
        ): DrinkRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DrinkRoomDatabase::class.java,
                    "cocktails"
                ).addCallback(DrinkDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}