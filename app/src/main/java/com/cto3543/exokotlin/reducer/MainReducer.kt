package com.cto3543.exokotlin.reducer

import com.cto3543.exokotlin.action.Action
import com.cto3543.exokotlin.block.BlockChain
import com.cto3543.exokotlin.bolivar.DolarToday
import com.cto3543.exokotlin.model.State
import redux.api.Reducer

/**
 * Created by cto3543 on 30/03/2017.
 */
val mainReducer = Reducer { state: State, action: Any ->
    when (action) {
        is Action.getSummary -> State(action.summary, state.groupMarkets)
        is Action.getMarkets -> State(state.summary, action.groupMarkets)
        is Action.setCurrentList -> State(state.summary, state.groupMarkets, action.exchange, action.currency)
        is Action.setCurrentSummary -> State(state.summary, state.groupMarkets, state.exchange, action.currency, action.currencyPair)
        else -> state
    }
}

val blockReducer = Reducer { stateblock: BlockChain, action: Any ->
    when (action) {
        is Action.setCurrentBlock -> BlockChain(action.currentblock, stateblock.listBlock)
        is Action.setCurrentListBlock -> BlockChain(stateblock.currentBlock, action.listBlock)
        else -> stateblock
    }
}

val dolarTodayReducer = Reducer { stateDolarToday: DolarToday, action: Any ->
    when (action) {
        is Action.getApiDolarToday -> action.dolarToday
        else -> stateDolarToday
    }
}