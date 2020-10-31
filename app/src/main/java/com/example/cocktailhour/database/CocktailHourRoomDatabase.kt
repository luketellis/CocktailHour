package com.example.cocktailhour.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.cocktailhour.entitiy.Drink
import com.example.cocktailhour.entitiy.DrinkLocation
import com.example.cocktailhour.entitiy.Ingredient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


// Annotates class to be a Room Database with a table (entity) of the Drink class
@Database(entities = arrayOf(Drink::class, Ingredient::class, DrinkLocation::class), version = 1, exportSchema = false)
public abstract class CocktailHourRoomDatabase : RoomDatabase() {

    abstract fun drinkDao(): DrinkDao
    abstract fun ingredientDao(): IngredientDao
    abstract fun drinkLocationDao(): DrinkLocationDao


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

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabaseOnInstall(database.drinkDao())
                }
            }
        }

        suspend fun populateDatabaseOnInstall(drinkDao: DrinkDao) {

        }

        suspend fun populateDatabase(drinkDao: DrinkDao) {
            // Delete all content here.
            //drinkDao.deleteAll()
                // Add sample drinks.
                //var drink = Drink("Tequila", "Mexican", "Mug", "instructions", "thumbnail")
                //drinkDao.insert(drink)
                //drink = Drink("Coffee", "Morning", "Mug", "instructions", "thumbnail")
                //drinkDao.insert(drink)
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CocktailHourRoomDatabase? = null

        fun getDatabase(context: Context,
                        scope: CoroutineScope
        ): CocktailHourRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CocktailHourRoomDatabase::class.java,
                    "Cocktails"
                ).createFromAsset("data.db")
                    .addCallback(DrinkDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}