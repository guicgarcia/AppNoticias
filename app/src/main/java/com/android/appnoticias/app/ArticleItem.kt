package com.android.appnoticias.app

import androidx.appcompat.view.menu.MenuView
import com.android.appnoticias.R
import com.android.appnoticias.entities.Article
import com.squareup.picasso.Picasso
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_article_item.view.*


class ArticleItem(val article: Article) : Item<ViewHolder>() {

    override fun getLayout(): Int {
        return R.layout.activity_article_item
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.txtTitle.text = article.title
        viewHolder.itemView.textDescription.text = article.description
        viewHolder.itemView.txtUrl.text = article.url
        viewHolder.itemView.txtUrlImage.text = article.urlToImage
        val image = viewHolder.itemView.imageView
        Picasso.get().load(article.urlToImage).into(image)
    }
}
