package com.cto3543.exokotlin.block

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.cto3543.exokotlin.BaseActivity
import com.cto3543.exokotlin.R
import com.cto3543.exokotlin.action.Action
import com.cto3543.exokotlin.groupmarket.BlockAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView


class BlockActivity : BaseActivity() {
    lateinit var recyclerView: RecyclerView

    var currency: String? = null
    var exchange: String? = null

    var block: Block? = null
    var listBlock: ArrayList<Block>? = ArrayList<Block>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            lparams(width = matchParent, height = wrapContent)
            textView {
                text = "Blockchain generated"
                textSize = 26f
            }
            button {
                text = "generate block"
                id = R.id.bt_block_generate
                onClick {
                    generateBlock()
                }
            }

            recyclerView = recyclerView {
                layoutManager = GridLayoutManager(context, 1) as RecyclerView.LayoutManager?
            }.lparams {
                width = matchParent
            }

        }

        // receive stuff
        subscriber = storeBlock?.subscribe {
            recyclerView.adapter = BlockAdapter(storeBlock?.state?.listBlock)
        }
    }

    fun generateBlock() {
        val block: Block
        if (listBlock?.size == 0)
            block = generateFirstBlock()
        else
            block = generateNextBlock(listBlock, "data numero" + listBlock?.size)
        listBlock?.add(block)
        storeBlock?.dispatch(Action.setCurrentListBlock(listBlock))
    }
}
