package ru.gustavo.astonhomework4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.gustavo.astonhomework4.Const.FRAGMENT_B_TAG
import ru.gustavo.astonhomework4.databinding.FragmentDBinding

class FragmentD : Fragment() {
    private lateinit var binding: FragmentDBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonB.setOnClickListener {
            (requireActivity() as? NextClickListener)?.onNextClicked(
                FRAGMENT_B_TAG,
                clearBackStack = true
            )
        }
    }

    companion object {
        fun newInstance() = FragmentD()
    }
}