package com.example.mvvmdemo.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmdemo.R
import kotlinx.android.synthetic.main.activity_flow_player_controller.*
import kotlinx.android.synthetic.main.activity_player.*

class FlowPlayerControllerActivity : AppCompatActivity(){

    private val playerPresenter by lazy{
        PlayerPresenter.instance
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow_player_controller)
//        playerPresenter.registerCallback(this)
        initListener();
        initDataListener()
    }

    private fun initDataListener() {
        playerPresenter.currentPlayState.addListener {
            if(it===PlayerPresenter.PlayState.PLAYING){
                playOrePauseBtn.text=if (it===PlayerPresenter.PlayState.PLAYING){
                    "暂停"
                }else{
                    "播放"
                }
            }
        }
    }

//    override fun onDestroy() {
//        super.onDestroy()
////        playerPresenter.unregisterCallbck(this)
//    }

    private fun initListener() {
        playerOrPauseBtn.setOnClickListener{
            playerPresenter.doPlayOrPause()
        }
    }

//    override fun onTitleChange(title: String) {
//
//    }
//
//    override fun onProgressChange(current: Int) {
//
//    }
//
//    override fun onPlaying() {
//        playerOrPauseBtn.text="暂停"
//    }
//
//    override fun onPlayerPause() {
//        playerOrPauseBtn.text="播放"
//    }
//
//    override fun onCoverChange(cover: String) {
//
//    }
}