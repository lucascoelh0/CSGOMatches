package com.lucascoelho.csgomatches.common.di

import com.lucascoelho.csgomatches.datasource.common.di.DataSourceDI
import com.lucascoelho.csgomatches.matches.common.di.MatchesDI

// App scope
fun getKoinModules() = DataSourceDI.module +
        MatchesDI.module
