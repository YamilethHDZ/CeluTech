package com.example.celutech2

import android.content.Intent
import android.content.res.Resources
import android.graphics.Rect
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.celutech2.adapter.AllCategoryAdapter
import com.example.celutech2.model.AllCategoryModel
import com.example.celutech2.model.Category

class AllCategory : AppCompatActivity() {

    private lateinit var allCategoryRecycler:RecyclerView

    private lateinit var back:ImageView

    private lateinit var allCategoryAdapter: AllCategoryAdapter

    private val allCategoryModelList = ArrayList<AllCategoryModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_category)

        allCategoryRecycler = findViewById(R.id.all_category)
        back = findViewById(R.id.back)

        back.setOnClickListener(View.OnClickListener {
            val back = Intent(this@AllCategory, Productos_list::class.java)
            startActivity(back)
            finish()
        })

        // adding data to model
        allCategoryModelList.add(AllCategoryModel(1, R.drawable.ic_androi))
        allCategoryModelList.add(AllCategoryModel(2, R.drawable.ic_honor))
        allCategoryModelList.add(AllCategoryModel(3, R.drawable.ic_huawei))
        allCategoryModelList.add(AllCategoryModel(4, R.drawable.ic_iphone))
        allCategoryModelList.add(AllCategoryModel(5, R.drawable.ic_motorola))
        allCategoryModelList.add(AllCategoryModel(6, R.drawable.ic_oppo))
        allCategoryModelList.add(AllCategoryModel(7, R.drawable.ic_realme))
        allCategoryModelList.add(AllCategoryModel(8, R.drawable.ic_xiaomi))

        setCategoryRecycler(allCategoryModelList)
    }

    private fun setCategoryRecycler(allcategoryModelList: List<AllCategoryModel>) {
        val layoutManager = GridLayoutManager(this, 3)
        allCategoryRecycler.layoutManager = layoutManager
        allCategoryRecycler.addItemDecoration(
            GridSpacingItemDecoration(
                3,
                dpToPx(16),
                true
            )
        )
        allCategoryRecycler.itemAnimator = DefaultItemAnimator()
        allCategoryAdapter = AllCategoryAdapter(this, allcategoryModelList)
        allCategoryRecycler.adapter = allCategoryAdapter
    }

    inner class GridSpacingItemDecoration(private val spanCount: Int, private val spacing: Int, private val includeEdge: Boolean) :
        RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            val position = parent.getChildAdapterPosition(view) // item position
            val column = position % spanCount // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing
                }
                outRect.bottom = spacing // item bottom
            } else {
                outRect.left = column * spacing / spanCount // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount // spacing - (column + 1) * ((1f / spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private fun dpToPx(dp: Int): Int {
        val r: Resources = resources
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))

    }
}