package sa.factory.hayyizspacecoworki.domain.usecase

import sa.factory.hayyizspacecoworki.domain.repository.HayyizSpaceRepository
import sa.factory.hayyizspacecoworki.model.HayyizSpaceItem
import sa.factory.hayyizspacecoworki.model.HayyizSpaceOrder
import sa.factory.hayyizspacecoworki.model.HayyizSpaceTelemetry
import kotlinx.coroutines.flow.Flow

class GetCatalogUseCase(private val repository: HayyizSpaceRepository) {
    operator fun invoke(): Flow<List<HayyizSpaceItem>> = repository.catalogFlow
}

class ManageCartUseCase(private val repository: HayyizSpaceRepository) {
    val cart = repository.activeCart
    fun add(item: HayyizSpaceItem) = repository.addToCart(item)
    fun remove(item: HayyizSpaceItem) = repository.removeFromCart(item)
    fun clear() = repository.clearCart()
}

class ProcessCheckoutUseCase(private val repository: HayyizSpaceRepository) {
    suspend operator fun invoke(paymentMethod: String = "Mada Contactless EMV"): HayyizSpaceOrder =
        repository.checkout(paymentMethod)
}

class ObserveHardwareTelemetryUseCase(private val repository: HayyizSpaceRepository) {
    operator fun invoke(): Flow<HayyizSpaceTelemetry> = repository.telemetryFlow
}
