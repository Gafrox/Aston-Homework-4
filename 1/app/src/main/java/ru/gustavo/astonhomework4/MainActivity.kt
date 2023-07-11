package ru.gustavo.astonhomework4

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import ru.gustavo.astonhomework4.Const.FRAGMENT_A_TAG
import ru.gustavo.astonhomework4.Const.FRAGMENT_B_TAG
import ru.gustavo.astonhomework4.Const.FRAGMENT_C_TAG
import ru.gustavo.astonhomework4.Const.FRAGMENT_D_TAG

class MainActivity : FragmentActivity(R.layout.activity_main), BackPressedListener,
    NextClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportFragmentManager.findFragmentByTag(FRAGMENT_A_TAG) == null) {
            supportFragmentManager.beginTransaction().run {
                val fragment = FragmentA.newInstance()
                setReorderingAllowed(true)
                add(R.id.container, fragment, FRAGMENT_A_TAG)
                commit()
            }
        }
    }

    override fun onBackPressedClicked() {
        supportFragmentManager.popBackStack()
    }

    override fun onNextClicked(
        target: String,
        clearBackStack: Boolean,
        isFirsFragment: Boolean,
        bundle: Bundle?
    ) {
        fun moveTo(fragment: Fragment) {
            with(supportFragmentManager) {
                commit {
                    replace(
                        R.id.container, fragment,
                        target
                    )
                    if (!isFirsFragment) {
                        addToBackStack(target)
                    }
                    if (clearBackStack) {
                        popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                    }
                }
            }
        }
        when (target) {
            FRAGMENT_A_TAG -> moveTo(FragmentA.newInstance())
            FRAGMENT_B_TAG -> moveTo(FragmentB.newInstance())
            FRAGMENT_C_TAG -> moveTo(FragmentC.newInstance(bundle))
            FRAGMENT_D_TAG -> moveTo(FragmentD.newInstance())
        }
    }
}