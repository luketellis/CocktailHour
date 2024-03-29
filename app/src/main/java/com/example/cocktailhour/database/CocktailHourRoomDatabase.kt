package com.example.cocktailhour.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.cocktailhour.entitiy.Drink
import com.example.cocktailhour.entitiy.DrinkLocation
import com.example.cocktailhour.entitiy.Ingredient
import com.example.cocktailhour.entitiy.ShoppingList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


// Annotates class to be a Room Database with a tables (entities) as specified
@Database(entities = arrayOf(Drink::class, Ingredient::class, DrinkLocation::class, ShoppingList::class), version = 1, exportSchema = false)
public abstract class CocktailHourRoomDatabase : RoomDatabase() {

    abstract fun drinkDao(): DrinkDao
    abstract fun ingredientDao(): IngredientDao
    abstract fun drinkLocationDao(): DrinkLocationDao
    abstract fun shoppingListDao(): ShoppingListDao


    private class DrinkDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
        }

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabaseOnInstall(database.drinkDao())
                }
            }
        }

        fun populateDatabaseOnInstall(drinkDao: DrinkDao) {

        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
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