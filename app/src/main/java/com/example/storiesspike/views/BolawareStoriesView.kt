package com.example.storiesspike.views

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.VideoView
import com.bolaware.viewstimerstory.Momentz
import com.bolaware.viewstimerstory.MomentzCallback
import com.bolaware.viewstimerstory.MomentzView
import com.squareup.picasso.Picasso
import omari.hamza.storyview.model.MyStory

class BolawareStoriesView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val videoView = VideoView(context).apply {
        setVideoURI(Uri.parse("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"))
        requestFocus()
        start()
    }

    val stories = arrayListOf(
        MomentzView(videoView, 5),
        MomentzView(ImageView(context).load("https://st.mngbcn.com/rcs/pics/static/T8/fotos/S20/87095655_08_D4.jpg?ts=1612525104420&imwidth=909&imdensity=1"), 5),
        MomentzView(ImageView(context).load("https://st.mngbcn.com/rcs/pics/static/T8/fotos/S20/87095655_08_D5.jpg?ts=1612525104420&imwidth=909&imdensity=1"), 5),
        MomentzView(ImageView(context).load("https://st.mngbcn.com/rcs/pics/static/T8/fotos/S20/87095655_08_D3.jpg?ts=1612521833613&imwidth=909&imdensity=1"), 5),
        MomentzView(ImageView(context).load("https://st.mngbcn.com/rcs/pics/static/T8/fotos/S20/87095655_08_R.jpg?ts=1612525104420&imwidth=909&imdensity=1"), 5),
        MomentzView(ImageView(context).load("https://st.mngbcn.com/rcs/pics/static/T8/fotos/outfit/S20/87095655_08-99999999_01.jpg?ts=1612525104420&imwidth=909&imdensity=1"), 5)
    )


    fun start() {
        Momentz(context, stories, this, object : MomentzCallback {
            override fun done() {

            }

            override fun onNextCalled(view: View, momentz: Momentz, index: Int) {

            }

        }).start()
    }
}

fun ImageView.load(uri: String): ImageView {
    Picasso.get().load(uri).into(this)
    return this
}