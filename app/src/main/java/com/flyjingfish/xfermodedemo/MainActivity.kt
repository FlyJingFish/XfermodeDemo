package com.flyjingfish.xfermodedemo

import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.flyjingfish.xfermodedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = XfermodeAdapter()
        binding.rvMode.adapter = adapter
        binding.rvMode.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        adapter.onItemClickListener = object : XfermodeAdapter.OnItemClickListener{
            override fun onClick(position:Int) {
                binding.tvMode.text = PorterDuff.Mode.values()[position].name
                binding.xfermodeView1.xfermode = PorterDuffXfermode(PorterDuff.Mode.values()[position])
                binding.xfermodeView2.xfermode = PorterDuffXfermode(PorterDuff.Mode.values()[position])
            }

        }
    }


}