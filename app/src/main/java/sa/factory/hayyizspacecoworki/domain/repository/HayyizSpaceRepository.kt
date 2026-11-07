package sa.factory.hayyizspacecoworki.domain.repository

import sa.factory.hayyizspacecoworki.model.HayyizSpaceItem
import sa.factory.hayyizspacecoworki.model.HayyizSpaceOrder
import sa.factory.hayyizspacecoworki.model.HayyizSpaceTelemetry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface HayyizSpaceRepository {
    val catalogFlow: Flow<List<HayyizSpaceItem>>
    val activeCart: StateFlow<List<HayyizSpaceItem>>
    val telemetryFlow: Flow<HayyizSpaceTelemetry>
    
    fun addToCart(item: HayyizSpaceItem)
    fun removeFromCart(item: HayyizSpaceItem)
    fun clearCart()
    suspend fun checkout(paymentMethod: String): HayyizSpaceOrder
    suspend fun refreshCatalog()
}
