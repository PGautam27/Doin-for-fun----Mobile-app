package com.example.doinforfun.presentation

import androidx.lifecycle.ViewModel
import com.example.doinforfun.data.repository.DoInForFunRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DoinViewModel @Inject constructor(
    private val repoImpl: DoInForFunRepoImpl
) : ViewModel() {

}