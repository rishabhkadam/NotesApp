 package com.rishabh.pdf

import android.app.DownloadManager
import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class fileAdapter(val list_of_files : ArrayList<files>,
                    val context: Context) : RecyclerView.Adapter<fileAdapter.ViewHolder>() {

    class ViewHolder(view : View): RecyclerView.ViewHolder(view) {
        val file_image : ImageView
        val file_name : TextView
        var container : CardView
        init {
            file_image = view.findViewById(R.id.file_image)
            file_name = view.findViewById(R.id.file_name)
            container = view.findViewById(R.id.container)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflator = LayoutInflater.from(context).inflate(R.layout.files_items,parent,false)
        return ViewHolder(inflator)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.file_name.text = list_of_files[position].file_name
        holder.file_image.setImageResource(list_of_files[position].file_image)
        holder.itemView.setOnClickListener{
            val download = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            val fileUri = Uri.parse(list_of_files[position].url)
            val getfile = DownloadManager.Request(fileUri)
            getfile.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            download.enqueue(getfile)
            Toast.makeText(context,"Downloading...",Toast.LENGTH_LONG).show()
        }


        var color = "#CCCCCC"
        if(position % 2==0){
            color = "#EEEEEE"
        }
        holder.container.setBackgroundColor(Color.parseColor(color))
    }

    override fun getItemCount(): Int {
        return list_of_files.size
    }
}