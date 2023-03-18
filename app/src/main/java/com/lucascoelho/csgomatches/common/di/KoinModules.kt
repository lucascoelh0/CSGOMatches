package com.lucascoelho.csgomatches.common.di

import com.lucascoelho.csgomatches.datasource.common.di.DataSourceDI

// App scope
fun getKoinModules() = DataSourceDI.module
