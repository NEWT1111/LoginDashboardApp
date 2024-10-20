import javax.inject.Inject
import retrofit2.Response

class AuthRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun login(username: String, password: String): Response<LoginResponse> {
        return apiService.login(LoginRequest(username, password))
    }
}
