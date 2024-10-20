import javax.inject.Inject
import retrofit2.Response

class DashboardRepository @Inject constructor(private val apiService: ApiService) {
    // Function to get dashboard data using keypass
    suspend fun getDashboardData(keypass: String): Response<DashboardResponse> {
        return apiService.getDashboardData(keypass)
    }
}
