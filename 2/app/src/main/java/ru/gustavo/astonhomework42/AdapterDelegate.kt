package ru.gustavo.astonhomework42

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.gustavo.astonhomework42.databinding.ItemUserBinding

fun adapterDelegate(itemClickListener: (User) -> Unit) =
    adapterDelegateViewBinding<User, User, ItemUserBinding>(
        { layoutInflater, root -> ItemUserBinding.inflate(layoutInflater, root, false) }
    ) {
        binding.root.setOnClickListener {
            itemClickListener.invoke(item)
        }
        bind {
            binding.apply {
                item.photo?.let { photo.setImageResource(it) }
                firstName.text = item.firstName
                lastName.text = item.lastName
                phoneNumber.text = item.phoneNumber
            }
        }
    }