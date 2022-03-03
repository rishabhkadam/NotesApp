package com.rishabh.pdf

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "NOTES"


        val item = ArrayList<files>()
        val img = R.drawable.pdficon
        item.add(files(img, "DBMS Question paper 2020","https://firebasestorage.googleapis.com/v0/b/personal-pdf00001.appspot.com/o/dbms_2020.pdf?alt=media&token=9986a3a6-4d3c-4280-b008-9fe000af9090"))
        item.add(files(img, "DBMS Question paper 2019","https://firebasestorage.googleapis.com/v0/b/personal-pdf00001.appspot.com/o/dbms_2019.pdf?alt=media&token=7d25ae4d-fa39-492f-8a78-3a62419950b8"))
        item.add(files(img, "DBMS Question paper 2018","https://firebasestorage.googleapis.com/v0/b/personal-pdf00001.appspot.com/o/dbms_2018.pdf?alt=media&token=64af519d-0bc5-4262-95f3-b12472b21f98"))
        item.add(files(img, "DBMS Question paper 2017","https://firebasestorage.googleapis.com/v0/b/personal-pdf00001.appspot.com/o/dbms_2017.pdf?alt=media&token=06cd00cf-39b8-49c4-af26-4e1aae61f3ec"))

        item.add(files(img, "JAVA Question Paper 2020","https://firebasestorage.googleapis.com/v0/b/personal-pdf00001.appspot.com/o/bca-5-sem-java-programming-and-dynamic-webpage-design-18022-dec-2020.pdf?alt=media&token=6912094a-f90e-4e6a-becd-72eea42ddd8d"))
        item.add(files(img, "JAVA Question Paper 2019","https://firebasestorage.googleapis.com/v0/b/personal-pdf00001.appspot.com/o/bca-5-sem-java-programming-and-dynamic-webpage-design-18022-nov-2019.pdf?alt=media&token=e45138da-8d79-4805-aee7-dbbe70442e68"))
        item.add(files(img, "JAVA Question Paper 2018","https://firebasestorage.googleapis.com/v0/b/personal-pdf00001.appspot.com/o/bca-5-sem-java-programming-and-dynamic-webpage-design-18022-dec-2018.pdf?alt=media&token=e612d856-5a04-4853-87f0-dc5a92856567"))
        item.add(files(img, "JAVA Question Paper 2017","https://firebasestorage.googleapis.com/v0/b/personal-pdf00001.appspot.com/o/bca-5-sem-java-programming-and-dynamic-webpage-design-18022-dec-2017.pdf?alt=media&token=08d1262a-9934-4c37-b812-b55f4a50a8ff"))

        item.add(files(img, "CN Question Paper 2020","https://firebasestorage.googleapis.com/v0/b/personal-pdf00001.appspot.com/o/bca-5-sem-computer-networks-18023-dec-2020.pdf?alt=media&token=86333e4d-ef84-400f-9b21-10f68d98ded0"))
        item.add(files(img, "CN Question Paper 2019","https://firebasestorage.googleapis.com/v0/b/personal-pdf00001.appspot.com/o/bca-5-sem-computer-networks-18023-nov-2019.pdf?alt=media&token=21b7cd4a-0128-4655-a208-42c2d4424c1a"))
        item.add(files(img, "CN Question Paper 2018","https://firebasestorage.googleapis.com/v0/b/personal-pdf00001.appspot.com/o/bca-5-sem-computer-networks-18023-dec-2018.pdf?alt=media&token=fe71d716-a9c2-433e-a224-8a152647b160"))
        item.add(files(img, "CN Question Paper 2017","https://firebasestorage.googleapis.com/v0/b/personal-pdf00001.appspot.com/o/bca-5-sem-computer-networks-18023-dec-2017.pdf?alt=media&token=76868a49-8326-4bfa-bfab-e3b7731dbea2"))

        item.add(files(img,"MATHS Question Paper 2017","https://firebasestorage.googleapis.com/v0/b/personal-pdf00001.appspot.com/o/Numerical%20methods%202017%20Paper%20Bca%205th%20sem.pdf?alt=media&token=e603c033-4620-42ed-a10f-0ec65fb53b37"))
        item.add(files(img,"MATHS Question Paper 2016","https://firebasestorage.googleapis.com/v0/b/personal-pdf00001.appspot.com/o/Numerical%20method%202016%20BCA%205th%20Sem.pdf?alt=media&token=8c22b9a1-d75d-4216-94dc-c2777313504d"))

        val adapter = fileAdapter(item, this)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = adapter
    }
}

