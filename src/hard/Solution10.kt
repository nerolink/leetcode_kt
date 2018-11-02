package hard

class Solution10 {
    var chars = Array<Char>(26, { i -> 'a' + i })

    fun isMatch(s: String, p: String): Boolean {
        if (p.isEmpty()) return s.isEmpty()
        val isFirstMatch = (!s.isEmpty()) && (p[0] == s[0] || p[0] == '.')
        return if (p.length >= 2 && p[1] == '*') {
            (isMatch(s, p.substring(2))) || (isFirstMatch && isMatch(s.substring(1), p))
        } else {
            isFirstMatch && isMatch(s.substring(1), p.substring(1))
        }
    }


}