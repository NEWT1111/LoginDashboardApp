import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET
import retrofit2.http.Path

// Define the request body for login
data class LoginRequest(val username: String, val password: String)

// Define the response for login
data class LoginResponse(val keypass: String)

// Define the response for dashboard
data class Entity(val property1: String, val property2: String, val description: String)
data class DashboardResponse(val entities: List<Entity>, val entityTotal: Int)

interface ApiService {
    // Login API
    @POST("/footscray/auth")  // Use the appropriate endpoint for your class location
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    // Dashboard API
    @GET("/dashboard/{keypass}")
    suspend fun getDashboardData(@Path("keypass") keypass: String): Response<DashboardResponse>
}
