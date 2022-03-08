/*
 * Copyright 2020-2022 thunderbiscuit and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the ./LICENSE file.
 */

package com.goldenraven.padawanwallet.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.goldenraven.padawanwallet.R
import com.goldenraven.padawanwallet.databinding.FragmentIntroBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class IntroFragment : Fragment() {

    private lateinit var binding: FragmentIntroBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        val testnetDialog = MaterialAlertDialogBuilder(this@IntroFragment.requireContext(), R.style.MyCustomDialogTheme)
                                .setTitle(getString(R.string.intro_dialog_title))
                                .setMessage(getString(R.string.intro_dialog_message))
                                .setPositiveButton(getString(R.string.intro_dialog_positive)) { _, _ ->
                                    navController.navigate(R.id.action_introFragment_to_walletChoice)
                                }
                                .setNegativeButton(getString(R.string.intro_dialog_negative)) { _, _ ->
                                }

        binding.letsGoButton.setOnClickListener {
            testnetDialog.show()
        }
    }
}
