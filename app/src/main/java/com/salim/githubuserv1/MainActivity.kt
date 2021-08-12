package com.salim.githubuserv1

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter
    private lateinit var userName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataPhoto: TypedArray

    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>


    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        this!!.title = "Githu User"


        val listView: ListView = findViewById(R.id.lv_list)
        adapter = UserAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()



        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, users[position].name, Toast.LENGTH_SHORT).show()

            val detail = Detail (
                users[position].name,
                users[position].username,
                users[position].photo,
                users[position].locaton,
                users[position].repository,
                users[position].company,
                users[position].followers,
                users[position].following
            )

            val moveWithObjectIntent = Intent(this@MainActivity, DetailActivity::class.java)
            moveWithObjectIntent.putExtra(DetailActivity.EXTRA_DETAIL, detail)
            startActivity(moveWithObjectIntent)

        }
    }

    private fun prepare() {
        userName = resources.getStringArray(R.array.name)
        dataUsername = resources.getStringArray(R.array.username)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
    }

    private fun addItem() {
        for (position in userName.indices) {
            val user = User(
                userName[position],
                dataUsername[position],
                dataPhoto.getResourceId(position, -1),
                dataLocation[position],
                dataRepository[position],
                dataCompany[position],
                dataFollowers[position],
                dataFollowing[position]
            )
            users.add(user)
        }
        adapter.user = users
    }

}