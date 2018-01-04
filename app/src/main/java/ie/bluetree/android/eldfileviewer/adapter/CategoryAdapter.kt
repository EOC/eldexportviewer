package ie.bluetree.android.eldfileviewer.adapter

import android.app.Activity
import android.databinding.DataBindingUtil
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import ie.bluetree.android.R
import ie.bluetree.android.databinding.ItemCategoryBinding
import ie.bluetree.android.eldfileviewer.helper.CategoryHelper
import ie.bluetree.android.eldfileviewer.model.Category

/**
 * Created by eoinoc on 30/12/2017.
 */
class CategoryAdapter(
        private val activity: Activity,
        private val onItemClickListener: AdapterView.OnItemClickListener
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private val resources = activity.resources
    private val layoutInflater = LayoutInflater.from(activity)
    private var categories = CategoryHelper().getCategories()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(DataBindingUtil.inflate<ItemCategoryBinding>(layoutInflater,
                    R.layout.item_category,
                    parent,
                    false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            category = categories[position]
            executePendingBindings()
            setCategoryIcon(category, categoryIcon)
            kotlin.with(categoryTitle) {
                setTextColor(getColor(category.theme.textPrimaryColor))
                setBackgroundColor(getColor(category.theme.primaryColor))
            }
        }
        with(holder.itemView) {
            setBackgroundColor(getColor(categories[position].theme.windowBackgroundColor))
            setOnClickListener {
                onItemClickListener.onItemClick(null, it, holder.adapterPosition, holder.itemId)
            }
        }
    }

    private fun setCategoryIcon(category: Category, icon: ImageView) {
        val imageRes = resources.getIdentifier("icon_category_${category.id}",
                "drawable", activity.packageName)
        icon.setImageResource(imageRes)
    }

    override fun getItemId(position: Int) = categories[position].id.hashCode().toLong()

    override fun getItemCount() = categories.size

    fun getItem(position: Int): Category = categories[position]

    /**
     * @see android.support.v7.widget.RecyclerView.Adapter.notifyItemChanged
     * @param id Id of changed category.
     */
    fun notifyItemChanged(id: String) {
        //updateCategories(activity)
        //notifyItemChanged(getItemPositionById(id))
    }

    private fun getItemPositionById(id: String): Int =
            categories.indices.firstOrNull { categories[it].id == id } ?: -1

    /**
     * Convenience method for color loading.

     * @param colorRes The resource id of the color to load.
     *
     * @return The loaded color.
     */
    private fun getColor(@ColorRes colorRes: Int) = ContextCompat.getColor(activity, colorRes)

    class ViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)
}