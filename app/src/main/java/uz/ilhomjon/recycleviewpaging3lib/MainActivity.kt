package uz.ilhomjon.recycleviewpaging3lib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import uz.ilhomjon.recycleviewpaging3lib.adapters.Paging3Adapter
import uz.ilhomjon.recycleviewpaging3lib.databinding.ActivityMainBinding
import uz.ilhomjon.recycleviewpaging3lib.viewmodels.UserViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var userViewModel: UserViewModel
    lateinit var paging3Adapter: Paging3Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        paging3Adapter = Paging3Adapter()
        binding.rv.adapter = paging3Adapter

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        userViewModel.liveData.observe(this, Observer {
            GlobalScope.launch(Dispatchers.Main) {
                paging3Adapter.submitData(it)
            }
        })
    }
}