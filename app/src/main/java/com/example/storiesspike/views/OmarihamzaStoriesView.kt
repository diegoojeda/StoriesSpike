package com.example.storiesspike.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import omari.hamza.storyview.StoryView
import omari.hamza.storyview.callback.StoryClickListeners
import omari.hamza.storyview.model.MyStory
import omari.hamza.storyview.utils.StoryViewHeaderInfo


class OmarihamzaStoriesView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    val stories = arrayListOf(
        MyStory("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"),
        MyStory("https://st.mngbcn.com/rcs/pics/static/T8/fotos/S20/87095655_08_D4.jpg?ts=1612525104420&imwidth=909&imdensity=1"),
        MyStory("https://st.mngbcn.com/rcs/pics/static/T8/fotos/S20/87095655_08_D5.jpg?ts=1612525104420&imwidth=909&imdensity=1"),
        MyStory("https://st.mngbcn.com/rcs/pics/static/T8/fotos/S20/87095655_08_D3.jpg?ts=1612521833613&imwidth=909&imdensity=1"),
        MyStory("https://st.mngbcn.com/rcs/pics/static/T8/fotos/S20/87095655_08_R.jpg?ts=1612525104420&imwidth=909&imdensity=1"),
        MyStory("https://st.mngbcn.com/rcs/pics/static/T8/fotos/outfit/S20/87095655_08-99999999_01.jpg?ts=1612525104420&imwidth=909&imdensity=1")
    )

    fun start(fragmentManager: FragmentManager) {

        StoryView.Builder(fragmentManager)
            .setStoriesList(stories)
            .setTitleText("Title")
            .setTitleLogoUrl("https://thispersondoesnotexist.com/image")
            .setSubtitleText("Subtitle")
            .setStoryDuration(5000)
            .setStoryClickListeners(object : StoryClickListeners {
                override fun onDescriptionClickListener(position: Int) {
                    //your action
                }

                override fun onTitleIconClickListener(position: Int) {
                    //your action
                }
            })
            .build()
            .show()
    }
}