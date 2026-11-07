package sa.factory.hayyizspacecoworki.data.remote

import sa.factory.hayyizspacecoworki.model.HayyizSpaceItem
import sa.factory.hayyizspacecoworki.model.HayyizSpaceOrder

interface HayyizSpaceApiService {
    suspend fun fetchCatalog(): List<HayyizSpaceItem>
    suspend fun submitOrder(order: HayyizSpaceOrder): Boolean
}
