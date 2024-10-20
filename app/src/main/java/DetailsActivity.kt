import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.example.logindashboardapp.R // Ensure you import the correct R




class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val entity: Entity1? = intent.getParcelableExtra("entity")

        val property1TextView = findViewById<TextView>(R.id.tvProperty1)
        val property2TextView = findViewById<TextView>(R.id.tvProperty2)
        val descriptionTextView = findViewById<TextView>(R.id.tvDescription)

        entity?.let {
            property1TextView.text = it.property1
            property2TextView.text = it.property2
            descriptionTextView.text = it.description
        }
    }
}
