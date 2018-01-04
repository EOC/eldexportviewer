package ie.bluetree.android.eldfileviewer.model

/**
 * Created by eoinoc on 30/12/2017.
 */
data class Category(
        val name: String,
        val id: String,
        val theme: Theme) {

    init {
    }


    override fun toString() = "Category{name='$name', id='$id', theme=$theme}"

    companion object {
        const val TAG = "Category"
    }
}
