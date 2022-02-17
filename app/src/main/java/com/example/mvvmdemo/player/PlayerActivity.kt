package com.example.mvvmdemo.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmdemo.R
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity(), IPlayerCallback {

    //持有Presenetet的引用
    private val playerPresenter by lazy{
        PlayerPresenter.instance
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        //注册监听，通知UI
        playerPresenter.registerCallback(this)
        initListener()
        initDataListener()
    }

    /**
     * 对数据进行监听
     */
    private fun initDataListener() {
        TODO("Not yet implemented")
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
        songTitle?.text=title
    }

    override fun onProgressChange(current: Int) {

    }

    override fun onPlaying() {
        //播放中--->显示暂停
        playerOrPauseBtn.text="暂停"
    }

    override fun onPlayerPause() {
        //暂停--->显示播放
        playerOrPauseBtn.text="播放"
    }

    override fun onCoverChange(cover: String) {
        println("封面改变了...$cover")
    }
}