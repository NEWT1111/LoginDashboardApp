import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import com.example.logindashboardapp.R


@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val keypass = intent.getStringExtra("keypass") ?: return

        dashboardViewModel.getDashboardData(keypass)

        dashboardViewModel.dashboardData.observe(this, Observer { entityList ->
            recyclerView.adapter = EntityAdapter(entityList) { selectedEntity ->
                val intent = Intent(this, DetailsActivity::class.java)
                intent.putExtra("entity",selectedEntity as Entity1)
                startActivity(intent)
            }
        })
    }
}
