package ru.kest.traffic

import kotlinx.html.div
import react.dom.ReactDOM
import react.dom.render
import kotlin.browser.document

//arrayOf('⬆','⬇','⬅','⮕','⬈','⬊','⬉','⬋'),

val ROAD_MAP = arrayOf(
        arrayOf(' ',' ','⮕','⮕','⮕','⮕','⮕','⬊',' ' , ' '),
        arrayOf(' ','⮕','⮕','⮕','⮕','⮕','⮕','⬊','⬇',' '),
        arrayOf('⬈','⬈',' ', ' ', ' ', ' ',' ', ' ', '⬇','⬇'),
        arrayOf('⬆','⬆',' ' , ' ', ' ', ' ',' ', ' ', '⬇','⬇'),
        arrayOf('⬆','⬆',' ' , ' ', ' ', ' ',' ', ' ', '⬇','⬇'),
        arrayOf('⬆','⬆',' ' , ' ', ' ', ' ',' ', ' ', '⬇','⬇'),
        arrayOf('⬆','⬆',' ' , ' ', ' ', ' ',' ', ' ', '⬇','⬇'),
        arrayOf('⬆','⬆',' ' , ' ', ' ', ' ',' ', ' ', '⬋','⬋'),
        arrayOf(' ','⬆','⬉','⬅','⬅','⬅','⬅','⬅','⬅',' '),
        arrayOf(' ',' ','⬉','⬅','⬅','⬅','⬅','⬅',' ', ' ')
)

val MAP_HEIGHT = ROAD_MAP.size
val MAP_WEIGHT = ROAD_MAP[0].size


fun main(args: Array<String>) {
    runtime.wrappers.require("main.css")

    ReactDOM.render(document.getElementById("content")) {
        div {
            Application {}
        }
    }
}
