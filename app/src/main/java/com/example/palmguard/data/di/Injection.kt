package com.example.palmguard.data.di

import android.content.Context
import com.example.palmguard.data.local.room.HistoryDatabase
import com.example.palmguard.data.repository.HistoryDiagnoseRepository

object Injection {
    fun provideDiagnoseRepository(context: Context) : HistoryDiagnoseRepository {
        val database = HistoryDatabase.getDatabase(context)
        val dao = database.historyDao()

        return HistoryDiagnoseRepository.getInstance(dao)
    }
}