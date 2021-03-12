package com.example.storiesspike

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.storiesspike.databinding.FragmentHomeBinding
import com.example.storiesspike.databinding.LibraryNameRowBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)

    private val librariesList = listOf(
        "OMARIHAMZA/StoryView",
        "bolaware/momentz"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.storiesRv.adapter = StoriesListAdapter(librariesList) {
            findNavController().navigate(HomeFragmentDirections.toLibraryDetail(it))
        }
    }
}

class StoriesListAdapter(private val items: List<String>, private val onClickListener: (String) -> Unit) : RecyclerView.Adapter<StoriesListAdapter.StoriesListVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesListVH =
        StoriesListVH(LibraryNameRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: StoriesListVH, position: Int) = holder.bind(items[position], onClickListener)

    override fun getItemCount(): Int = items.size

    class StoriesListVH(private val binding: LibraryNameRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(libraryName: String, onClickListener: (String)-> Unit) {
            binding.libraryNameTv.text = libraryName
            binding.root.setOnClickListener { onClickListener(libraryName) }
        }
    }
}