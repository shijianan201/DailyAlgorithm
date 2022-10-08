package com.sja.algorithm.jzoffer

class JzOffer_12 : Sword2OfferAlgorithm {

    override fun execute() {
        val res = exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'E', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ), "ABCESEEEFS"
        )
        println(res)
    }

    fun exist(board: Array<CharArray>, word: String): Boolean {
        val rowCount = board.size
        val columnCount = board[0].size
        for (i in 0 until rowCount) {
            for (j in 0 until columnCount) {
                if (board[i][j] == word.get(0)) {
                    val res = backTrack(board, word, i, j, "", hashSetOf())
                    if (res) {
                        return true
                    }
                }
            }
        }
        return false
    }

    fun backTrack(
        board: Array<CharArray>,
        word: String,
        row: Int,
        column: Int,
        tempStr: String,
        paths: HashSet<Path>
    ): Boolean {
        if (tempStr == word) {
            return true
        }
        if (!word.startsWith(tempStr)) {
            return false
        }
        if (paths.contains(Path(row, column))) {
            return false
        }
        val rowCount = board.size
        val columnCount = board[0].size
        if (row >= rowCount || column >= columnCount || row < 0 || column < 0) {
            return false
        }
        if (word.startsWith("$tempStr${board[row][column]}")) {
            paths.add(Path(row, column))
        }
        println("$row $column $tempStr${board[row][column]}")
        val top = backTrack(board, word, row - 1, column, "${tempStr}${board[row][column]}", paths)
        val bottom = backTrack(
            board,
            word,
            row + 1,
            column,
            "${tempStr}${board[row][column]}",
            paths
        )
        val left = backTrack(board, word, row, column - 1, "${tempStr}${board[row][column]}", paths)
        val right = backTrack(
            board,
            word,
            row,
            column + 1,
            "${tempStr}${board[row][column]}",
            paths
        )
        return top || bottom || left || right
    }

    inner class Path(val row: Int, val column: Int) {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Path

            if (row != other.row) return false
            if (column != other.column) return false

            return true
        }

        override fun hashCode(): Int {
            var result = row
            result = 31 * result + column
            return result
        }
    }
}