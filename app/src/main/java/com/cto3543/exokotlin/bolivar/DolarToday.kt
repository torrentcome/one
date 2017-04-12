package com.cto3543.exokotlin.bolivar

/**
 * Created by cto3543 on 10/04/2017.
 */
data class DolarToday(val _antibloqueo: _antibloqueo? = null, val _labels: _labels? = null, val _timestamp: _timestamp? = null, val USD: USD? = null, val EUR: EUR? = null, val COL: COL? = null, val GOLD: GOLD? = null, val USDVEF: USDVEF? = null, val USDCOL: USDCOL? = null, val EURUSD: EURUSD? = null, val BCV: BCV? = null, val MISC: MISC? = null)

data class _antibloqueo(val mobile: String, val video: String, val orto_alternativo: String, val enable_iads: String, val enable_admobbanners: String)

data class _labels(val a: String, val a1: String, val b: String, val c: String, val d: String, val e: String)

data class _timestamp(val epoch: String, val fecha: String, val fecha_corta: String, val fecha_corta2: String, val fecha_nice: String, val dia: String, val dia_corta: String)

data class USD(val transferencia: Float, val transfer_cucuta: Float, val efectivo: Float, val efectivo_real: Float, val efectivo_cucuta: Float, val promedio: Float, val promedio_real: Float, val cencoex: Float, val sicad1: Float, val sicad2: Float, val dolartoday: Float)

data class EUR(val transferencia: Float, val transfer_cucuta: Float, val efectivo: Float, val efectivo_real: Float, val efectivo_cucuta: Float, val promedio: Float, val promedio_real: Float, val cencoex: Float, val sicad1: Float, val sicad2: Float, val dolartoday: Float)

data class COL(val efectivo: Float, val transfer: Float, val compra: Float, val venta: Float)

data class GOLD(val rate: Float)

data class USDVEF(val rate: Float)

data class USDCOL(val setfxsell: Float, val setfxbuy: Float, val rate: Float, val ratecash: Float, val ratetrm: Float, val trmfactor: Float, val trmfactorcash: Float)

data class EURUSD(val rate: Float)

data class BCV(val fecha: String, val fecha_nice: String, val liquidez: String, val reservas: String)

data class MISC(val petroleo: String, val reservas: String)
