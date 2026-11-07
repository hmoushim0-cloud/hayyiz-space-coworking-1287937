package sa.factory.hayyizspacecoworki.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HayyizSpaceDao {
    @Query("SELECT * FROM coworking_items_cache ORDER BY id ASC")
    fun observeAllItems(): Flow<List<HayyizSpaceEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<HayyizSpaceEntity>)

    @Query("DELETE FROM coworking_items_cache")
    suspend fun clearAll()
}
