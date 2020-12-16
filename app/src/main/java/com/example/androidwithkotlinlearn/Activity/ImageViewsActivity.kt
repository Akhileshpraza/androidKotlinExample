package com.example.androidwithkotlinlearn.Activity

import android.app.Activity
import android.app.ProgressDialog
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidwithkotlinlearn.Modals.ItemData
import com.example.androidwithkotlinlearn.R
import com.example.androidwithkotlinlearn.RecyclerViewAdapter
import java.io.File


class ImageViewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_views)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        //        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //recyclerView.setLayoutManager(layoutManager);
        recyclerView.layoutManager = LinearLayoutManager(this)

        val BtnViewImage = findViewById<Button>(R.id.btnview);
        BtnViewImage.setOnClickListener {
            recyclerView.adapter = RecyclerViewAdapter(this@ImageViewsActivity, getData())
        }
    }
    fun getData(): ArrayList<ItemData>? {
        val itemData: ArrayList<ItemData> = ArrayList<ItemData>()
        //TARGET FOLDER
        val fileget = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + "/Pictures/")
        println("==============================================")
        println(fileget)
        var s: ItemData

        if (fileget.isDirectory) {

            val files = fileget.listFiles()

            for (i in files.indices) {
                val file = files[i]
                s = ItemData()
                s.setUri(Uri.fromFile(file))
                itemData.add(s)
            }
        }
        return itemData
    }


    fun getListFiles(parentDir: File, fileIdStartsWith: String): List<File> {
        val inFiles: ArrayList<File> = ArrayList<File>()
        val files: Array<File> = parentDir.listFiles()
        for (file in files) {
            if (file.isDirectory) {
                inFiles.addAll(getListFiles(file, fileIdStartsWith))
            } else {
                if (file.name.contains(fileIdStartsWith)) {
                    Log.d(
                            "File starts with", " : "
                            + fileIdStartsWith + " : URI :"
                            + file.toURI().toString()
                            + " Added to the list >>>>>>>>> "
                            + file.name
                    )
                    inFiles.add(file)
                }

            }
        }
        return inFiles
    }

    fun  getFilePath(): File{
        return  File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + "/Pictures/")
    }
}