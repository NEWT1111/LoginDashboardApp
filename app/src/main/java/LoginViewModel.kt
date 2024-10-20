import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

    val loginResult = MutableLiveData<String?>()  // Holds keypass on successful login

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val response = authRepository.login(username, password)
            if (response.isSuccessful) {
                response.body()?.let {
                    loginResult.postValue(it.keypass)  // Successful login returns keypass
                }
            } else {
                loginResult.postValue(null)  // Login failed
            }
        }
    }
}
