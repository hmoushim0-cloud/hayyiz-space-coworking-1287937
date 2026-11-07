package sa.factory.hayyizspacecoworki.di

import sa.factory.hayyizspacecoworki.data.repository.HayyizSpaceRepositoryImpl
import sa.factory.hayyizspacecoworki.domain.repository.HayyizSpaceRepository
import sa.factory.hayyizspacecoworki.domain.usecase.*
import sa.factory.hayyizspacecoworki.hardware.HardwareSensorDriver
import sa.factory.hayyizspacecoworki.ui.viewmodel.HayyizSpaceViewModel

class DiContainer {
    val sensorDriver = HardwareSensorDriver()
    val repository: HayyizSpaceRepository = HayyizSpaceRepositoryImpl(sensorDriver)

    val getCatalogUseCase = GetCatalogUseCase(repository)
    val manageCartUseCase = ManageCartUseCase(repository)
    val processCheckoutUseCase = ProcessCheckoutUseCase(repository)
    val observeHardwareTelemetryUseCase = ObserveHardwareTelemetryUseCase(repository)

    fun provideViewModel(): HayyizSpaceViewModel = HayyizSpaceViewModel(
        getCatalogUseCase,
        manageCartUseCase,
        processCheckoutUseCase,
        observeHardwareTelemetryUseCase
    )
}
