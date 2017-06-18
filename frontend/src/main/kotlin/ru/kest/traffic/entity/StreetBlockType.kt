package ru.kest.traffic.entity

/**
 * All states of street block
 * Created by KKharitonov on 16.06.2017.
 */
enum class StreetBlockType(val c : Char) {

    EMPTY(' '),
    UP('⬆'),
    DOWN('⬇'),
    RIGHT('⮕'),
    LEFT('⬅'),
    UPRIGHT('⬈'),
    UPLEFT('⬉'),
    DOWNRIGHT('⬊'),
    DOWNLEFT('⬋')

}

fun getStreetBlockTypeByChar(c: Char) : StreetBlockType {
    enumValues<StreetBlockType>().forEach {
        if (it.c == c) return it
    }
    throw IllegalArgumentException("StreetBlockType for $c not found")
}
