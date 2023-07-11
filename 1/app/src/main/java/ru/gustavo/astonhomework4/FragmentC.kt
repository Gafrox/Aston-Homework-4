package ru.gustavo.astonhomework4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.gustavo.astonhomework4.Const.FRAGMENT_A_TAG
import ru.gustavo.astonhomework4.Const.FRAGMENT_D_TAG
import ru.gustavo.astonhomework4.Const.TEXT_FROM_B
import ru.gustavo.astonhomework4.databinding.FragmentCBinding

class FragmentC : Fragment() {
    private lateinit var binding: FragmentCBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = arguments?.getString(TEXT_FROM_B)
        binding.apply {
            buttonD.setOnClickListener {
                (requireActivity() as? NextClickListener)?.onNextClicked(
                    FRAGMENT_D_TAG
                )
            }
            buttonA.setOnClickListener {
                (requireActivity() as? NextClickListener)?.onNextClicked(
                    FRAGMENT_A_TAG,
                    clearBackStack = true,
                    isFirsFragment = true
                )
            }
            textView.text = text
        }
    }

    companion object {
        fun newInstance(bundle: Bundle?): FragmentC {
            val fragment = FragmentC()
            fragment.arguments = bundle
            return fragment
        }
    }
}