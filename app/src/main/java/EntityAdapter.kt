import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.logindashboardapp.R


class EntityAdapter(private val entityList: List<Entity>, private val onItemClick: (Entity) -> Unit) :
    RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    class EntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val property1TextView: TextView = itemView.findViewById(R.id.property1)
        val property2TextView: TextView = itemView.findViewById(R.id.property2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        val entity = entityList[position]
        holder.property1TextView.text = entity.property1
        holder.property2TextView.text = entity.property2

        holder.itemView.setOnClickListener {
            onItemClick(entity)
        }
    }

    override fun getItemCount() = entityList.size
}
