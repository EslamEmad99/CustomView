package eslam.emad.itemview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class ItemView(context: Context, private val attrs: AttributeSet?): FrameLayout(context, attrs) {

    private lateinit var containerView: ConstraintLayout
    private lateinit var textView: TextView
    lateinit var imageView: ImageView

    init {
        initViews()
    }

    private fun initViews() {
        val view = View.inflate(context, R.layout.custom_item, this)
        containerView = view.findViewById(R.id.containerView)
        imageView = view.findViewById(R.id.imageView)
        textView = view.findViewById(R.id.textView)

        val typedArray= context.obtainStyledAttributes(attrs, R.styleable.ItemView)

        val title = typedArray.getString(R.styleable.ItemView_itemText) ?: "empty"
        val image = typedArray.getDrawable(R.styleable.ItemView_itemImage) ?: ContextCompat.getDrawable(
            context, R.drawable.ic_launcher_background
        )
        val color = typedArray.getColor(R.styleable.ItemView_itemColor, ContextCompat.getColor(context, android.R.color.black))
        val textColor = typedArray.getColor(R.styleable.ItemView_itemTextColor, ContextCompat.getColor(context, android.R.color.black))

        textView.text = title
        textView.setTextColor(textColor)
        imageView.setImageDrawable(image)
        containerView.setBackgroundColor(color)
    }

    fun setData(title: String, img: Int){
        this.imageView.setImageDrawable(ContextCompat.getDrawable(context, img))
        this.textView.text = title
    }
}