require.config({
    paths:{
        data:"./js/data",
        getEl:"./js/getEl",
        app:"./js/app",
    }
})

require(["getEl","app"],function(getEl,app){
    new app({
        ulf:getEl.get(".ulf"),
        olf:getEl.get(".olf"),
        sele:getEl.get("#ele"),
        left:getEl.get(".left"),
        right:getEl.get(".right"),
        zuoyou:getEl.get(".zuoyou"),
        boxbot:getEl.get(".boxbot"),
        index:0,
    })
})