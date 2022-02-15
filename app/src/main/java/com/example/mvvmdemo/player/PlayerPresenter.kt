package com.example.mvvmdemo.player

/**
 *on 2022/2/15
 *com.example.mvvmdemo.player
 *播放音乐
 *暂停音乐
 * 上一首
 * 下一首
 *
 * 播放的状态：
 * -通知UI改变成播放状态
 * -通知UI进度的变化
 * 上一首，下一首
 * -通知UI歌曲标题变化
 * -通知UI歌曲封面变化
 * 暂停音乐
 * -更新UI状态为暂停
 */
class PlayerPresenter {
    private val callbacksList= arrayListOf<IPlayerCallback>()
    fun registerCallback(callback: IPlayerCallback){
        if(!callbacksList.contains(callback)){
            callbacksList.add(callback)
        }
    }
    //解除绑定
    fun unregisterCallbck(callback: IPlayerCallback){
        callbacksList.remove(callback)
    }

    /**
     * 根据状态控制音乐播放还是暂停
     */

    fun doPlayOrPause(){

    }

    /**
     * 下一首
     */
    fun playNext() {

    }

    /**
     * 上一首
     */
    fun playPre() {
        TODO("Not yet implemented")
    }
}