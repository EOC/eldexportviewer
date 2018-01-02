package eld.eoinoc.com.model

/**
 * Created by eoinoc on 02/01/2018.
 */
class CommentListLine (val userName: String, val comment: String, val commentDate: String, val commentTime: String, val commentLocation: String) : ListLine {
    override fun formatLine(): String {
        val sb = StringBuilder()
        sb.append(userName).append(", ").append(comment).append(", ")
        sb.append(commentDate).append(", ").append(commentTime).append(", ").append(commentLocation)
        return sb.toString()
    }
}