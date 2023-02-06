package com.lucascoelho.baseproject.common.di

import com.lucascoelho.baseproject.datasource.common.di.DatasourceDI

// App scope
fun getKoinModules() = DatasourceDI.module
