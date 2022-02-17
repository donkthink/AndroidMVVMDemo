package com.example.mvvmdemo.player

import com.example.mvvmdemo.player.domain.Music

class PlayerModel {
    fun getMusicById(s: String): Music {
        return Music(
            "卡农...",
            "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202003%2F04%2F20200304095349_JnkMf.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1647703194&t=de6465b627b8092502dcaf31a6e9aa81",
            "https:www.sunofbeach.net"
        )
    }
}
