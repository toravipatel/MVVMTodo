package com.codinginflow.mvvmtodo.ui.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codinginflow.mvvmtodo.data.Task
import com.codinginflow.mvvmtodo.databinding.ItemTaskBinding

class TaskAdapter: ListAdapter<Task, TaskAdapter.TasksViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TasksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class TasksViewHolder(private val binding: ItemTaskBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(task: Task){
            binding.apply {
                this.taskCheckbox.text = task.name

                if(task.important)
                    this.imgImportant.visibility = View.VISIBLE
                else
                    this.imgImportant.visibility = View.INVISIBLE

            }
        }

    }

    class DiffCallBack() : DiffUtil.ItemCallback<Task>(){

        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
    }
}