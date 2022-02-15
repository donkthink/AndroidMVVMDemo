package com.example.mvvmdemo.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmdemo.R
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity(), IPlayerCallback {

    //持有Presenetet的引用
    private val playerPresenter by lazy{
        PlayerPresenter();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        //注册监听，通知UI
        playerPresenter.registerCallback(this)
        initListener()
    }

    //给控件设置点击事件
    private fun initListener() {
        playerOrPauseBtn.setOnClickListener{
            //调用presenter层的播放或者暂停方法
            playerPresenter.doPlayOrPause()
        }
        playNextBtn.setOnClickListener{
            playerPresenter.playNext()
        }
        playPreBtn.setOnClickListener{
            playerPresenter.playPre()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        playerPresenter.unregisterCallbck(this)
    }

    override fun onTitleChange(title: String) {

    }

    override fun onProgressChange(current: Int) {

    }

    override fun onPlaying() {

    }

    override fun onPlayerPause() {

    }

    override fun onCoverChange(cover: String) {

    }
}