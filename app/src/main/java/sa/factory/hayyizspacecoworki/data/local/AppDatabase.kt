package sa.factory.hayyizspacecoworki.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HayyizSpaceEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun coworkingDao(): HayyizSpaceDao
}
