import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val dashboardRepository: DashboardRepository
) : ViewModel() {

    // Backing property for encapsulation
    private val _dashboardData: MutableLiveData<List<Entity>> = MutableLiveData()
    val dashboardData: LiveData<List<Entity>> = _dashboardData

    // Function to get dashboard data
    fun getDashboardData(keypass: String) {
        viewModelScope.launch {
            val response = dashboardRepository.getDashboardData(keypass)
            if (response.isSuccessful) {
                response.body()?.let {
                    _dashboardData.postValue(it.entities)
                }
            }
        }
    }
}
