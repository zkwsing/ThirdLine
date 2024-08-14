package com.example.test2

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.test2.databinding.ActivityMainTwoBinding
import com.example.test2.kotlin.Dao.BookDao
import com.example.test2.kotlin.DataBase.AppDatabase
import com.example.test2.kotlin.bean.Book
import com.example.test2.kotlin.bean.SimWorker
import com.example.test2.kotlin.bean.User
import com.example.test2.kotlin.lifecycle.MyObserver
import com.example.test2.kotlin.model.MainViewModel
import com.example.test2.kotlin.model.factory.MainViewModelFactory
import com.example.test2.kotlin.service.AppService
import com.example.test2.kotlin.service.ServiceCreator
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class MainTwoActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainTwoBinding;
    private lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)
        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(countReserved)
        ).get(MainViewModel::class.java)
        binding.plusOneBtn.setOnClickListener {
            //viewModel.counter++
            //refreshCounter()
            viewModel.plusOne()
        }
        binding.clearBtn.setOnClickListener {
            //viewModel.counter = 0
            //refreshCounter()
            viewModel.clear()
        }
        lifecycle.addObserver(MyObserver(lifecycle))
        println("=================${lifecycle.currentState}")
        viewModel.counter.observe(this, Observer {
            binding.infoText.text = it.toString()
        })
        viewModel.counter.observe(this) {
            binding.infoText.text = it.toString()
        }
        //refreshCounter()
//        val retrofit = Retrofit.Builder()
//            .baseUrl("")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//         val  appService = retrofit.create(AppService::class.java)
//         val  appServiceNew = ServiceCreator.create(AppService::class.java)
//         val  appServiceNew2 = ServiceCreator.create<AppService>()

        binding.getUserBtn.setOnClickListener {
            val userId = (0..10000).random().toString()
            viewModel.getUser(userId)
        }
        viewModel.user.observe(this, Observer {
            binding.infoText.text = it.firstName
        })

        roomInfo()
    }

    fun roomInfo() {
        val userDao = AppDatabase.getDatabase(this).userDao()
        val bookDao = AppDatabase.getDatabase(this).bookDao()
        val user1 = User("Tom", "小明", 12)
        val user2 = User("Tom", "小黄", 30)
        repeat(10) {
            thread {
                var book = Book("京瓶$it", it)
                book.id = bookDao.inserBook(book)
            }
        }
        for (i in 0..9 step 2) {
            println(i)
        }
        for (i in 0 until 9) {
            println(i)
        }
        (0..9).forEach { println(it) }
        binding.addDataBtn.setOnClickListener {
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }
        binding.updateDataBtn.setOnClickListener {
            thread {
                user1.age = 44
                userDao.updateUser(user1)
            }
        }
        binding.delDataBtn.setOnClickListener {
            thread {
                userDao.deleteUserByLastName("小黄")
            }
        }
        binding.queryDataBtn.setOnClickListener {
            thread {
                for (user in userDao.loadAllUsers()) {
                    Log.e("RoomInfo", user.toString())
                }

                for (book in bookDao.loadAllBooks()) {
                    Log.e("BookInfo", book.toString())
                }
            }
        }


        binding.doWorkBtn.setOnClickListener {
            val request = OneTimeWorkRequest.Builder(SimWorker::class.java)
                .setInitialDelay(1,TimeUnit.MINUTES)
                .addTag("test")
                .build()
            val request2 = PeriodicWorkRequest.Builder(SimWorker::class.java,15,TimeUnit.MINUTES).build()
            WorkManager.getInstance(this).enqueue(request)
        }

    }

    override fun onPause() {
        super.onPause()
        sp.edit { putInt("count_reserved", viewModel.counter.value ?: 0) }
    }

    private fun refreshCounter() {
        binding.infoText.text = viewModel.counter.toString()
    }
    //ViewModelProvider("你的Activity或Fragment实例").get("你的ViewModel"::class.java)
}