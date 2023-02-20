package com.ramil.images

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

class ExoPlayerFragment : Fragment() {

    private final val VIDEO_URL = "https://playst.ru/images/minivideo_2/stuk_kopyt.mp4"

    private lateinit var player : ExoPlayer
    private lateinit var exoPlayerView : StyledPlayerView
    private val mediaItem = MediaItem.fromUri(VIDEO_URL)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        player = ExoPlayer.Builder(context).build()
        player.setMediaItem(mediaItem)
        player.prepare()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.exo_player_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exoPlayerView = view.findViewById(R.id.exoPlayerView)

        exoPlayerView.player = player
    }

    override fun onStart() {
        super.onStart()
        player.play()
    }

    override fun onPause() {
        super.onPause()
        player.pause()
    }

}