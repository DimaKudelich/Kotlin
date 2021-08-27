package com.kudelich.bsu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kudelich.bsu.R
import com.kudelich.bsu.entities.database.Class
import kotlinx.android.synthetic.main.card_classes.view.*

class ClassesAdapter : RecyclerView.Adapter<ClassesAdapter.ClassesHolder>() {
    private var classesList = emptyList<Class>()

    class ClassesHolder(item: View) : RecyclerView.ViewHolder(item) {
        fun bind(classes: Class) {
            itemView.time.text = classes.time
            itemView.subject.text = classes.subject
            itemView.place.text = classes.place
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_classes, parent, false)
        return ClassesHolder(view)
    }

    override fun onBindViewHolder(holder: ClassesHolder, position: Int) {
        holder.bind(classesList[position])
    }

    override fun getItemCount(): Int {
        return classesList.size
    }

    fun setData(classes: List<Class>) {
        this.classesList = classes
        notifyDataSetChanged()
    }
}