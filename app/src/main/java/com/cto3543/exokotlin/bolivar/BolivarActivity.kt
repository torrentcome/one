package com.cto3543.exokotlin.bolivar

import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.cto3543.exokotlin.BaseActivity
import com.cto3543.exokotlin.R
import com.cto3543.exokotlin.action.Action
import com.cto3543.exokotlin.web.BolivarWebApi
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class BolivarActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        scrollView {
            lparams(width = matchParent, height = matchParent)
            relativeLayout {
                id = R.id.container
                backgroundColor = resources.getColor(R.color.blue_primary)

                lparams(width = matchParent, height = matchParent)
                padding = dip(24)

                verticalLayout {
                    lparams(width = matchParent, height = matchParent)

                    textView {
                        id = R.id.bolivar_date
                        textColor = resources.getColor(R.color.white)
                    }

                    cardView {
                        lparams(width = matchParent, height = wrapContent) {
                            margin = dip(10)
                        }
                        backgroundColor = resources.getColor(R.color.blue_light)

                        verticalLayout {
                            padding = dip(10)
                            lparams(width = matchParent, height = matchParent)

                            linearLayout {
                                imageView {
                                    lparams(width = wrapContent, height = wrapContent)
                                    imageResource = R.drawable.ic_attach_money_black_24dp
                                    scaleType = ImageView.ScaleType.CENTER
                                }
                                textView {
                                    id = R.id.bolivar_usd_transferencia
                                    textSize = 26f
                                    textColor = resources.getColor(R.color.colorPrimaryDark)
                                    gravity = Gravity.CENTER
                                }
                            }
                            textView {
                                id = R.id.bolivar_usd_transferencia_cucuta
                                textColor = resources.getColor(R.color.white)
                            }
                            textView {
                                id = R.id.bolivar_usd_efectivo
                                textColor = resources.getColor(R.color.white)
                            }
                            textView {
                                id = R.id.bolivar_usd_efectivo_real
                                textColor = resources.getColor(R.color.white)
                            }
                            textView {
                                id = R.id.bolivar_usd_efectivo_cucuta
                                textColor = resources.getColor(R.color.white)
                            }
                            textView {
                                id = R.id.bolivar_usd_promedio
                                textColor = resources.getColor(R.color.white)
                            }
                            textView {
                                id = R.id.bolivar_usd_promedio_real
                                textColor = resources.getColor(R.color.white)
                            }
                            textView {
                                id = R.id.bolivar_usd_bolivares
                                textColor = resources.getColor(R.color.white)
                            }
                        }
                    }

                    cardView {
                        backgroundColor = resources.getColor(R.color.blue_light)
                        lparams(width = matchParent, height = wrapContent) {
                            margin = dip(10)
                        }


                        verticalLayout {
                            padding = dip(10)
                            lparams(width = matchParent, height = matchParent)
                            linearLayout {
                                imageView {
                                    lparams(width = wrapContent, height = matchParent)
                                    imageResource = R.drawable.ic_euro_symbol_black_24dp
                                    scaleType = ImageView.ScaleType.CENTER
                                }
                                textView {
                                    id = R.id.bolivar_eur_transferencia
                                    textColor = resources.getColor(R.color.colorPrimaryDark)
                                    textSize = 26f
                                    gravity = Gravity.CENTER
                                }
                            }
                            textView {
                                id = R.id.bolivar_eur_transferencia_cucuta
                                textColor = resources.getColor(R.color.white)
                            }
                            textView {
                                id = R.id.bolivar_eur_efectivo
                                textColor = resources.getColor(R.color.white)
                            }
                            textView {
                                id = R.id.bolivar_eur_efectivo_real
                                textColor = resources.getColor(R.color.white)
                            }
                            textView {
                                id = R.id.bolivar_eur_efectivo_cucuta
                                textColor = resources.getColor(R.color.white)
                            }
                            textView {
                                id = R.id.bolivar_eur_promedio
                                textColor = resources.getColor(R.color.white)
                            }
                            textView {
                                id = R.id.bolivar_eur_promedio_real
                                textColor = resources.getColor(R.color.white)
                            }
                            textView {
                                id = R.id.bolivar_eur_bolivares
                                textColor = resources.getColor(R.color.white)
                            }
                        }
                    }


                    cardView {
                        backgroundColor = resources.getColor(R.color.red_light)
                        lparams(width = matchParent, height = wrapContent) {
                            margin = dip(10)
                        }


                        verticalLayout {
                            padding = dip(10)
                            lparams(width = matchParent, height = matchParent)
                            linearLayout {

                                imageView {
                                    lparams(width = wrapContent, height = wrapContent)
                                    imageResource = R.drawable.ic_local_gas_station_black_24dp
                                    scaleType = ImageView.ScaleType.CENTER
                                }
                                textView {
                                    id = R.id.bolivar_misc_petroleo
                                    textColor = resources.getColor(R.color.white)
                                    textSize = 26f
                                    gravity = Gravity.CENTER
                                }
                            }
                            textView {
                                id = R.id.bolivar_misc_reservas
                                textColor = resources.getColor(R.color.white)
                            }
                        }
                    }
                }
            }
        }

        doAsync {
            val (dolarToday, error) = BolivarWebApi.getDolartoday()
            println("getApiDolarToday = " + dolarToday)
            println("error = " + error)
            // send stuff
            uiThread {
                if (error != null) {
                    toast("$error")
                }
                storeDolarToday?.dispatch(Action.getApiDolarToday(dolarToday))
            }
        }

        // receive stuff
        subscriber = storeDolarToday?.subscribe {
            if (storeDolarToday?.state != null) {

                (findViewById(R.id.bolivar_date) as TextView).setText("Fecha " + storeDolarToday?.state?._timestamp?.fecha.toString())

                (findViewById(R.id.bolivar_usd_transferencia) as TextView).setText(storeDolarToday?.state?.USD?.transferencia.toString())
                (findViewById(R.id.bolivar_usd_transferencia_cucuta) as TextView).setText("Transferencia_cucuta " + storeDolarToday?.state?.USD?.transfer_cucuta.toString())
                (findViewById(R.id.bolivar_usd_efectivo) as TextView).setText("Efectivo " + storeDolarToday?.state?.USD?.efectivo.toString())
                (findViewById(R.id.bolivar_usd_efectivo_real) as TextView).setText("Efectivo_real " + storeDolarToday?.state?.USD?.efectivo_real.toString())
                (findViewById(R.id.bolivar_usd_efectivo_cucuta) as TextView).setText("Efectivo_cucuta " + storeDolarToday?.state?.USD?.efectivo_cucuta.toString())
                (findViewById(R.id.bolivar_usd_promedio) as TextView).setText("Promedio " + storeDolarToday?.state?.USD?.promedio.toString())
                (findViewById(R.id.bolivar_usd_promedio_real) as TextView).setText("Promedio_real " + storeDolarToday?.state?.USD?.promedio_real.toString())
                (findViewById(R.id.bolivar_usd_bolivares) as TextView).setText("Bolivares " + storeDolarToday?.state?.USD?.dolartoday.toString())

                (findViewById(R.id.bolivar_eur_transferencia) as TextView).setText(storeDolarToday?.state?.EUR?.transferencia.toString())
                (findViewById(R.id.bolivar_eur_transferencia_cucuta) as TextView).setText("Transferencia_cucuta " + storeDolarToday?.state?.EUR?.transfer_cucuta.toString())
                (findViewById(R.id.bolivar_eur_efectivo) as TextView).setText("Efectivo " + storeDolarToday?.state?.EUR?.efectivo.toString())
                (findViewById(R.id.bolivar_eur_efectivo_real) as TextView).setText("Efectivo_real " + storeDolarToday?.state?.EUR?.efectivo_real.toString())
                (findViewById(R.id.bolivar_eur_efectivo_cucuta) as TextView).setText("Efectivo_cucuta " + storeDolarToday?.state?.EUR?.efectivo_cucuta.toString())
                (findViewById(R.id.bolivar_eur_promedio) as TextView).setText("Promedio " + storeDolarToday?.state?.EUR?.promedio.toString())
                (findViewById(R.id.bolivar_eur_promedio_real) as TextView).setText("Promedio_real " + storeDolarToday?.state?.EUR?.promedio_real.toString())
                (findViewById(R.id.bolivar_eur_bolivares) as TextView).setText("Bolivares " + storeDolarToday?.state?.EUR?.dolartoday.toString())

                (findViewById(R.id.bolivar_misc_petroleo) as TextView).setText(storeDolarToday?.state?.MISC?.petroleo.toString())
                (findViewById(R.id.bolivar_misc_reservas) as TextView).setText("Reservas " + storeDolarToday?.state?.MISC?.reservas.toString() + "MM")
            }
        }
    }

    override fun onPause() {
        super.onPause()
        subscriber?.unsubscribe()
    }
}
