package co.saputra.healthbeats.arch.adapter

import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import co.saputra.healthbeats.R
import co.saputra.healthbeats.arch.model.Plan
import co.saputra.healthbeats.databinding.ItemPlanBinding
import com.bumptech.glide.RequestManager
import com.putra.githubuser.base.BaseListAdapter
import com.putra.githubuser.base.BaseViewHolder

class CarePlanAdapter(
    layoutInflater: LayoutInflater,
    private val glide: RequestManager,
    private val onClickListener: (Plan) -> Unit,
): BaseListAdapter<Plan, ItemPlanBinding, CarePlanAdapter.CarePlanViewHolder>(
    layoutInflater,
    ItemPlanBinding::inflate,
    PlanDiffCallback
) {

    override fun itemViewHolder(viewBinding: ItemPlanBinding, viewType: Int) = CarePlanViewHolder(viewBinding)

    override fun onBindViewHolder(holder: CarePlanViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class CarePlanViewHolder(private val binding: ItemPlanBinding) : BaseViewHolder<Plan>(binding.root) {
        override fun onBind(item: Plan) {
            binding.apply {
                root.setOnClickListener { onClickListener(item) }
                tvName.text = item.name
                tvLocation.text = item.location
                val icon = if (item.type == "type-hospital") ContextCompat.getDrawable(root.context, R.drawable.ic_icon_hospital)
                else ContextCompat.getDrawable(root.context, R.drawable.ic_icon_clinic)
                glide.load(icon)
                    .into(binding.ivIcon)
                glide.load(item.image)
                    .centerCrop()
                    .into(binding.ivBackground)
            }
        }
    }

    object PlanDiffCallback : DiffUtil.ItemCallback<Plan>() {
        override fun areItemsTheSame(oldItem: Plan, newItem: Plan) = oldItem == newItem
        override fun areContentsTheSame(oldItem: Plan, newItem: Plan) = oldItem.name == newItem.name
    }
}