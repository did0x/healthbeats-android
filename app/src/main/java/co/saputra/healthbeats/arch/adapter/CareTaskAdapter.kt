package co.saputra.healthbeats.arch.adapter

import android.view.LayoutInflater
import androidx.recyclerview.widget.DiffUtil
import co.saputra.healthbeats.arch.model.Task
import co.saputra.healthbeats.databinding.ItemTaskBinding
import com.bumptech.glide.RequestManager
import com.putra.githubuser.base.BaseListAdapter
import com.putra.githubuser.base.BaseViewHolder

class CareTaskAdapter(
    layoutInflater: LayoutInflater,
    private val glide: RequestManager,
    private val onClickListener: (Task) -> Unit,
    ): BaseListAdapter<Task, ItemTaskBinding, CareTaskAdapter.CareTaskViewHolder>(
    layoutInflater,
    ItemTaskBinding::inflate,
    TaskDiffCallback
) {

    override fun itemViewHolder(viewBinding: ItemTaskBinding, viewType: Int) = CareTaskViewHolder(viewBinding)

    override fun onBindViewHolder(holder: CareTaskViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class CareTaskViewHolder(private val binding: ItemTaskBinding) : BaseViewHolder<Task>(binding.root) {
        override fun onBind(item: Task) {
            binding.apply {
                root.setOnClickListener { onClickListener(item) }
                tvName.text = item.name
                tvTitle.text = item.title
                tvDescription.text = item.description
                tvRule.text = item.rule
                tvAmount.text = "Taken ${item.currentAmount}/${item.amount}"
                btnAction.text = item.action
                glide.load(item.image)
                    .into(binding.ivBackground)
            }
        }
    }

    object TaskDiffCallback : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task) = oldItem == newItem
        override fun areContentsTheSame(oldItem: Task, newItem: Task) = oldItem.name == newItem.name
    }
}