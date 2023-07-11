package ru.gustavo.astonhomework42

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import ru.gustavo.astonhomework42.Const.USER_ID_KEY
import ru.gustavo.astonhomework42.databinding.DialogEditBinding
import ru.gustavo.astonhomework42.databinding.FragmentUserDetailBinding

class UserDetailFragment : Fragment() {
    private val editDialog: AlertDialog by lazy {
        AlertDialog.Builder(requireContext())
            .setView(dialogBinding.root)
            .setPositiveButton(getString(R.string.save)) { _, _ ->
                dialogBinding.apply {
                    user.firstName = editFirstName.text.toString()
                    user.lastName = editLastName.text.toString()
                    user.phoneNumber = editPhone.text.toString()
                }
                binding.apply {
                    firstName.text = user.firstName
                    lastName.text = user.lastName
                    phoneNumber.text = user.phoneNumber
                }
            }
            .setNegativeButton(getString(R.string.cancel)) { cancel, _ ->
                cancel.cancel()
            }
            .create()
    }
    private var id = 0
    private lateinit var user: User
    private lateinit var binding: FragmentUserDetailBinding
    private lateinit var dialogBinding: DialogEditBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        dialogBinding = DialogEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        id = requireArguments().getInt(USER_ID_KEY)
        user = UserRepository.users[id]
        binding.apply {
            user.photo?.let { photo.setImageResource(it) }
            firstName.text = user.firstName
            lastName.text = user.lastName
            phoneNumber.text = user.phoneNumber
            editButton.setOnClickListener {
                showEditDialog(user)
            }
            editAvatar.setOnClickListener {
                user.photo = UserRepository().photos.random().photo
                user.photo?.let { photo.setImageResource(it) }
            }
        }
    }

    private fun showEditDialog(user: User) {
        dialogBinding.apply {
            editFirstName.setText(user.firstName)
            editLastName.setText(user.lastName)
            editPhone.setText(user.phoneNumber)
        }
        editDialog.show()
    }

    companion object {
        fun newInstance(bundle: Bundle): UserDetailFragment {
            val fragment = UserDetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}