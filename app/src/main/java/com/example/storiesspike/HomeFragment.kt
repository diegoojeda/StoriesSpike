package com.example.storiesspike

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
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

        binding.internalEt.onFocusChangeListener = View.OnFocusChangeListener { _, focusGained ->
            if (focusGained) {
                binding.textField.hint = "E-MAIL"
                binding.internalEt.hint = "Type your email here"
                binding.internalEt.background = ContextCompat.getDrawable(requireContext(), R.drawable.text_field_background_out_focus)
            } else {
                binding.textField.hint = "E-mail"
                binding.internalEt.hint = null
                binding.internalEt.background = ContextCompat.getDrawable(requireContext(), R.drawable.text_field_background)
            }
        }

        binding.internalEt2.onFocusChangeListener = View.OnFocusChangeListener { _, focusGained ->
            if (focusGained) {
                binding.textField2.hint = "PASSWORD"
                binding.internalEt2.hint = "Type your password here"
            } else {
                binding.textField2.hint = "Password"
                binding.internalEt2.hint = null
            }
        }

        binding.internalEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.let {
                    if (it.length > 10) {
                        binding.textField.error = "Mensaje muy largo"
                        binding.internalEt.background = ContextCompat.getDrawable(requireContext(), R.drawable.text_field_background_red)
                    } else {
                        binding.textField.error = null
                        binding.internalEt.background = ContextCompat.getDrawable(requireContext(), R.drawable.text_field_background)
                    }
//                    binding.textField.setErrorTextAppearance(R.style.TextFloatLabelAppearance)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }
}

class StoriesListAdapter(private val items: List<String>, private val onClickListener: (String) -> Unit) : RecyclerView.Adapter<StoriesListAdapter.StoriesListVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesListVH =
        StoriesListVH(LibraryNameRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: StoriesListVH, position: Int) = holder.bind(items[position], onClickListener)

    override fun getItemCount(): Int = items.size

    class StoriesListVH(private val binding: LibraryNameRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(libraryName: String, onClickListener: (String) -> Unit) {
            binding.libraryNameTv.text = libraryName
            binding.root.setOnClickListener { onClickListener(libraryName) }
        }
    }
}