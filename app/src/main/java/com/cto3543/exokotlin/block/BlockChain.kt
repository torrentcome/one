package com.cto3543.exokotlin.block

/**
 * Created by cto3543 on 03/04/2017.
 */
// state
data class BlockChain(val currentBlock: Block? = null, val listBlock: ArrayList<Block>? = null)

data class Block(val index: Int, val previousHash: String, val timestamp: String, val data: String, val hash: String)

fun calculateHash(index: Int, previousHash: String, timestamp: String, data: String): String {
    return ("" + index + previousHash + timestamp + data).hashCode().toString()
}

fun calculateHashFromBlock(block: Block): String {
    return calculateHash(block.index, block.previousHash, block.timestamp, block.data)
}

fun generateNextBlock(blockList: List<Block>, data: String): Block {
    val lastBlock: Block = blockList.last()
    val nextIndex = lastBlock.index + 1
    val nextTimeStamp = (System.currentTimeMillis() / 1000).toString()
    val nextHash = calculateHash(nextIndex, lastBlock.hash, nextTimeStamp, data)

    return Block(nextIndex, lastBlock.hash, nextTimeStamp, data, nextHash)
}

fun generateFirstBlock(): Block {
    val s = "first block"
    return Block(0, "0", (System.currentTimeMillis() / 1000).toString(), s, s.hashCode().toString())
}

fun isValidNewBlock(newBlock: Block, previousBlock: Block): Boolean {
    if (previousBlock.index + 1 != newBlock.index) {
        println("invalid index")
        return false
    } else if (previousBlock.hash != newBlock.previousHash) {
        println("invalid previousHash")
        return false
    } else if (calculateHashFromBlock(newBlock) != newBlock.hash) {
        println("invalid hash")
        return false
    }
    return true
}

fun isValidChain(blockList: List<Block>): Boolean {
    for (i in 0..blockList.size - 1) {

        println(blockList[i])
    }
    return true
}

fun replaceChain(blockList: List<Block>) {
}