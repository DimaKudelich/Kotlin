package com.kudelich.bsu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kudelich.bsu.R
import com.kudelich.bsu.entities.ProfileRow
import kotlinx.android.synthetic.main.card_profile.view.*

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.ProfileHolder>() {
    private val profileRows = listOf<ProfileRow>(
        ProfileRow("Name", "Dmitry"),
        ProfileRow("Surname", "Kudelich"),
        ProfileRow("Faculty", "MMF"),
        ProfileRow("Course", "3"),
        ProfileRow("Group", "9"),
        ProfileRow("Name", "Dmitry"),
        ProfileRow("Surname", "Kudelich"),
        ProfileRow("Faculty", "MMF"),
        ProfileRow("Course", "3"),
        ProfileRow("Group", "9"),
        ProfileRow("Name", "Dmitry"),
        ProfileRow("Surname", "Kudelich"),
        ProfileRow("Faculty", "MMF"),
        ProfileRow("Course", "3"),
        ProfileRow("Group", "9")
    )

    class ProfileHolder(item: View) : RecyclerView.ViewHolder(item) {
        fun bind(profileRow: ProfileRow) {
            itemView.title.text = profileRow.title
            itemView.data.text = profileRow.data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_profile, parent, false)
        return ProfileHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileHolder, position: Int) {
        holder.bind(profileRows[position])
    }

    override fun getItemCount(): Int {
        return profileRows.size
    }
}