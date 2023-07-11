package ru.gustavo.astonhomework42

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ru.gustavo.astonhomework42.Const.FRAGMENT_USER_DETAIL
import ru.gustavo.astonhomework42.Const.USER_ID_KEY
import ru.gustavo.astonhomework42.databinding.FragmentUserListBinding

class UserListFragment : Fragment() {
    private val users = UserRepository.users
    private val adapter: AsyncListDifferDelegationAdapter<User> by lazy {
        AsyncListDifferDelegationAdapter(
            UserDiffCallback(),
            AdapterDelegatesManager(
                adapterDelegate { user ->
                    targetId = user.id
                    moveToUser(targetId)
                }
            )
        )
    }
    private lateinit var binding: FragmentUserListBinding
    private var targetId = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.users.adapter = adapter
        adapter.items = users
    }

    private fun moveToUser(id: Int) {
        val bundle = Bundle()
        bundle.putInt(USER_ID_KEY, id)
        with(requireActivity().supportFragmentManager) {
            commit {
                replace(
                    R.id.container, UserDetailFragment.newInstance(bundle),
                    FRAGMENT_USER_DETAIL
                )
                addToBackStack(FRAGMENT_USER_DETAIL)
                popBackStack(
                    null,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE
                )
            }
        }
    }

    companion object {
        fun newInstance() = UserListFragment()
    }
}