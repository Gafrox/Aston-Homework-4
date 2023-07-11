package ru.gustavo.astonhomework4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.gustavo.astonhomework4.Const.FRAGMENT_C_TAG
import ru.gustavo.astonhomework4.Const.TEXT_FROM_B
import ru.gustavo.astonhomework4.databinding.FragmentBBinding

class FragmentB : Fragment() {
    private lateinit var binding: FragmentBBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = Bundle()
        bundle.putString(TEXT_FROM_B, getString(R.string.text_to_fragment_c))
        binding.apply {
            buttonC.setOnClickListener {
                (requireActivity() as? NextClickListener)?.onNextClicked(
                    FRAGMENT_C_TAG,
                    bundle = bundle
                )
            }
            buttonBack.setOnClickListener {
                (requireActivity() as? BackPressedListener)?.onBackPressedClicked()
            }
        }
    }

    companion object {
        fun newInstance() = FragmentB()
    }
}