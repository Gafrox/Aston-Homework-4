package ru.gustavo.astonhomework42

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import ru.gustavo.astonhomework42.Const.FRAGMENT_USER_LIST

class MainActivity : FragmentActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportFragmentManager.findFragmentByTag(FRAGMENT_USER_LIST) == null) {
            supportFragmentManager.beginTransaction().run {
                val fragment = UserListFragment.newInstance()
                setReorderingAllowed(true)
                add(R.id.container, fragment, FRAGMENT_USER_LIST)
                commit()
            }
        }
    }
}