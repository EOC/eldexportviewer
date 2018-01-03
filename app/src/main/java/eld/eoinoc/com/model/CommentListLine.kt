package eld.eoinoc.com.model

import eld.eoinoc.com.helper.formatEventDateTime

/**
 * Created by eoinoc on 02/01/2018.
 */
class CommentListLine (val userName: String, val comment: String, val commentDate: String, val commentTime: String, val commentLocation: String) : ListLine {
    override fun formatLine(): String {
        val sb = StringBuilder()
        sb.append(userName).append(", ")
        if(comment.isBlank()) {
            sb.append("No comment").append(", ")
        } else {
            sb.append(comment).append(", ")
        }
        sb.append(formatEventDateTime(commentDate, commentTime)).append("\n").append(commentLocation)
        return sb.toString()
    }
}