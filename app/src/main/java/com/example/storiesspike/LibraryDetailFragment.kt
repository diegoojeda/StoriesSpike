package com.example.storiesspike

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.storiesspike.databinding.FragmentLibraryDetailBinding
import com.example.storiesspike.views.BolawareStoriesView
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class LibraryDetailFragment : Fragment(R.layout.fragment_library_detail) {

    private val args: LibraryDetailFragmentArgs by navArgs()
    private val binding: FragmentLibraryDetailBinding by viewBinding(FragmentLibraryDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startBtn.setOnClickListener {
            when (args.libraryName) {
                "OMARIHAMZA/StoryView" -> {
                    binding.OmarihamzaStoriesView.start(parentFragmentManager)
                    binding.OmarihamzaStoriesView.isVisible = true
                    binding.BolawareStoriesView.isVisible = false
                }
                "bolaware/momentz" -> {
                    binding.OmarihamzaStoriesView.isVisible = false
                    binding.BolawareStoriesView.isVisible = true
                    binding.BolawareStoriesView.start()
                }
            }
        }
    }

}