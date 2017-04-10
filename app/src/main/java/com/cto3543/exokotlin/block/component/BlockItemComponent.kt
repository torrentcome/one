package com.cto3543.exokotlin.block.component

import android.view.View
import android.view.ViewGroup
import com.cto3543.exokotlin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by cto3543 on 10/04/2017.
 */
class BlockItemComponent : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            relativeLayout {
                cardView {
                    lparams(width = matchParent, height = wrapContent) {
                        margin = dip(10)
                    }
                    verticalLayout {
                        lparams(width = matchParent, height = wrapContent)
                        padding = dip(5)

                        textView {
                            id = R.id.block_item_id
                        }
                        textView {
                            id = R.id.block_item_previous_hash
                        }
                        textView {
                            id = R.id.block_item_timestamp
                        }
                        textView {
                            id = R.id.block_item_data
                        }
                        textView {
                            id = R.id.block_item_hash
                        }
                    }
                }
            }
        }
    }
}